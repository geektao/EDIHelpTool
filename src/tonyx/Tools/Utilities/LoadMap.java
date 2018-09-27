package tonyx.Tools.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import tonyx.EDI.Common.Mapper;
import tonyx.Tools.Config.Config;
import tonyx.Tools.Config.ConfigElement;
import tonyx.Tools.Config.ConfigItem;
import tonyx.Tools.Config.ConfigOperate;
import tonyx.Tools.Config.ConfigSequence;

final public class LoadMap {
	private Mapper mapper;
	private Document doc;
	private Element mapperRoot;
	private Config config;

	public void setConfig(Config config) {
		this.config = config;
	}

	public LoadMap(File file) {
		SAXBuilder builder = new SAXBuilder();
		try {
			doc = builder.build(file);
			mapperRoot = doc.getRootElement();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		ConfigElement confEle = ConfigOperate.findConfigElement(config,
				"Mapper");
		loadData(mapperRoot, mapper, confEle);
	}

	private void loadData(Element node, Object object, ConfigElement confEle) {
		List<Element> nodelist = node.getChildren();
		ConfigSequence confSeq = confEle.getCFGsequence();
		
		ConfigItem confItem;
		for (Element subNode : nodelist) {
			String subNodeName = subNode.getName();
			// System.out.println(subNodeName);
			confItem = confSeq.getConfigItem(subNodeName);
			String valueType = confItem.getCFGvalueType();
			
			if (valueType.equals("String")) {
				// System.out.println(subNodeName+"   "+subNode.getValue());
				Reflect.invokeSetMethod(object.getClass(), object,
						PropertyName.getSetterName(subNodeName),
						subNode.getValue());
			} else if (valueType.equals("Object")) {
				if (!subNode.getChildren().isEmpty()) {

					Object obj = Reflect.getObject(confItem.getCFGclass());
					Reflect.invokeSetMethod(object.getClass(), object,
							PropertyName.getSetterName(subNodeName), obj);

					loadData(subNode, obj, confItem.getCFGElement());

				} else {
					// System.out.println(subNodeName + " 无子节点！");
				}
			} else {
				System.out
						.println("配置文件出错，无对应类型！" + confItem.getCFGvalueType());
			}
		}
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
}
