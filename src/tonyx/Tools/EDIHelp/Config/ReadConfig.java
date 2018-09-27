package tonyx.Tools.EDIHelp.Config;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import tonyx.Tools.Config.Config;
import tonyx.Tools.Config.ConfigChoice;
import tonyx.Tools.Config.ConfigElement;
import tonyx.Tools.Config.ConfigItem;
import tonyx.Tools.Config.ConfigSequence;

public class ReadConfig {
	private Document doc;
	private Element root;
	private Config conf;

	public Config getConf() {
		return conf;
	}

	public void setConf(Config conf) {
		this.conf = conf;
	}

	public ReadConfig() {
		SAXBuilder builder = new SAXBuilder();
		try {
			doc = builder.build("config/Mapper.xml");
			root = doc.getRootElement();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		process();
		setRefElement();

		// test
		// printElement();
	}

	private void process() {
		List<Element> mList = root.getChildren();
		for (Element ele : mList) {
			ConfigElement cnfEle = new ConfigElement();
			conf.setCFGElement(cnfEle);
			cnfEle.setCFGname(ele.getName());
			cnfEle.setCFGclass(ele.getAttributeValue("class"));
			ConfigSequence cs = new ConfigSequence();
			cnfEle.setCFGsequence(cs);
			processSequence(cs, ele.getChild("sequence"));
		}
	}

	private void processSequence(ConfigSequence cs, Element ele) {
		cs.setCFGminOccurs(ele.getAttributeValue("minOccurs"));
		cs.setCFGmaxOccurs(ele.getAttributeValue("maxOccurs"));
		List<Element> childList = ele.getChildren();

		ConfigItem item;
		for (Element subEle : childList) {
			if (subEle.getName().equals("choice")) {
				ConfigChoice cc = new ConfigChoice();
				cs.setCFGsequence(cc);
				cc.setCFGminOccurs(subEle.getAttributeValue("minOccurs"));
				cc.setCFGmaxOccurs(subEle.getAttributeValue("maxOccurs"));
				List<Element> sList = subEle.getChildren();
				for (Element cEle : sList) {
					item = new ConfigItem();
					cc.setCGFchoice(item);
					item.setCFGname(cEle.getName());
					item.setCFGversion(cEle.getAttributeValue("version"));
					item.setCFGvalueType(cEle.getAttributeValue("valueType"));
					item.setCFGminOccurs(cEle.getAttributeValue("minOccurs"));
					item.setCFGmaxOccurs(cEle.getAttributeValue("maxOccurs"));
					item.setCFGref(cEle.getAttributeValue("ref"));
				}
			} else {
				item = new ConfigItem();
				cs.setCFGsequence(item);
				item.setCFGname(subEle.getName());
				item.setCFGversion(subEle.getAttributeValue("version"));
				item.setCFGvalueType(subEle.getAttributeValue("valueType"));
				item.setCFGminOccurs(subEle.getAttributeValue("minOccurs"));
				item.setCFGmaxOccurs(subEle.getAttributeValue("maxOccurs"));
				item.setCFGref(subEle.getAttributeValue("ref"));
			}
		}
	}

	private void setRefElement() {
		List<ConfigElement> cList = conf.getCFGElement();
		List<Object> seq;
		for (ConfigElement ce : cList) {
			seq = ce.getCFGsequence().getCFGsequence();
			for (Object objItem : seq) {
				if (objItem instanceof ConfigItem) {
					ConfigItem cItem = (ConfigItem) objItem;
					setItemRef(cItem);
				} else if (objItem instanceof ConfigChoice) {
					ConfigChoice ccItem = (ConfigChoice) objItem;
					List<ConfigItem> ccList = ccItem.getCGFchoice();
					for (ConfigItem subItem : ccList) {
						setItemRef(subItem);
					}
				} else {
					System.out.println("对象类型错误！");
				}
			}
		}
	}

	private void setItemRef(ConfigItem item) {
		String type = item.getCFGvalueType();
		if ("String".equals(type)) {
		} else if ("Object".equals(type)) {
			ConfigElement cEle = findConfigElement(item.getCFGref());
			if (cEle != null) {
				item.setCFGElement(cEle);
				item.setCFGclass(cEle.getCFGclass());
			} else {
				System.out.println(item.getCFGname() + "节点  "
						+ item.getCFGref() + " 不存在！");
			}

		} else {
			System.out.println("无该种类型！");
		}
	}

	private ConfigElement findConfigElement(String eleName) {
		List<ConfigElement> cList = conf.getCFGElement();
		for (ConfigElement ce : cList) {
			if (ce.getCFGname().equals(eleName)) {
				return ce;
			}
		}
		return null;
	}

	// use for test
	private void printElement() {
		List<ConfigElement> cList = conf.getCFGElement();
		for (ConfigElement ce : cList) {
			System.out.println("--------------------------");
			System.out.println(ce.getCFGname());
			System.out.println(ce.getCFGclass());

			printSeqence(ce.getCFGsequence());
			System.out.println("--------------------------");
		}
	}

	private void printSeqence(ConfigSequence cseq) {
		System.out.println("---" + cseq.getCFGminOccurs());
		System.out.println("---" + cseq.getCFGminOccurs());
		List<Object> list = cseq.getCFGsequence();
		for (Object item : list) {
			if (item instanceof ConfigItem) {
				ConfigItem im = (ConfigItem) item;
				System.out.println("------" + im.getCFGname());
				System.out.println("------" + im.getCFGvalueType());
				System.out.println("------" + im.getCFGversion());
				System.out.println("------" + im.getCFGminOccurs());
				System.out.println("------" + im.getCFGmaxOccurs());
				System.out.println("------" + im.getCFGref());
				System.out.println("------" + im.getCFGElement());
			} else if (item instanceof ConfigChoice) {
				ConfigChoice cc = (ConfigChoice) item;
				printChoice(cc);
			}
		}
	}

	private void printChoice(ConfigChoice cc) {
		System.out.println("------start choice-------");
		System.out.println("------" + cc.getCFGminOccurs());
		System.out.println("------" + cc.getCFGmaxOccurs());
		List<ConfigItem> list = cc.getCGFchoice();
		for (ConfigItem item : list) {
			System.out.println("--------" + item.getCFGname());
			System.out.println("--------" + item.getCFGvalueType());
			System.out.println("--------" + item.getCFGversion());
			System.out.println("--------" + item.getCFGminOccurs());
			System.out.println("--------" + item.getCFGmaxOccurs());
			System.out.println("--------" + item.getCFGref());
			System.out.println("--------" + item.getCFGElement());
		}
		System.out.println("------end choice-------");
	}
}
