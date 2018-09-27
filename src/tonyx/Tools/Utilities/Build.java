package tonyx.Tools.Utilities;

import java.util.List;

import org.jdom2.Element;
import org.jdom2.Namespace;

import tonyx.Component.XmlTree.MapTree;
import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.EDI.Common.Mapper;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.ElementCore;
import tonyx.EDI.Common.XMLSyntax.*;
import tonyx.Tools.Config.Config;
import tonyx.Tools.Config.ConfigChoice;
import tonyx.Tools.Config.ConfigElement;
import tonyx.Tools.Config.ConfigItem;
import tonyx.Tools.Config.ConfigOperate;
import tonyx.Tools.Config.ConfigSequence;

final public class Build {
	private static Namespace defaultns = Namespace
			.getNamespace("http://www.stercomm.com/SI/Map");

	public static void buildTree(Mapper mapper, MapTree inputtree,
			MapTree outputtree) {

		MapTreeNode inputroot = (MapTreeNode) inputtree.getModel().getRoot(), outputroot = (MapTreeNode) outputtree
				.getModel().getRoot();
		Object groupObj, synObj;
		synObj = mapper.getEdiINPUT().getActiveSgntax();
		inputtree.setTreeType(synObj.getClass().getSimpleName());
		groupObj = Reflect.invokeGetMethod(synObj.getClass(), synObj,
				PropertyName.getGetterName("Group"));
		buildTree(groupObj, inputroot);

		synObj = mapper.getEdiOUTPUT().getActiveSgntax();
		outputtree.setTreeType(synObj.getClass().getSimpleName());
		groupObj = Reflect.invokeGetMethod(synObj.getClass(), synObj,
				PropertyName.getGetterName("Group"));
		buildTree(groupObj, outputroot);
	}

	private static void buildTree(Object obj, MapTreeNode pNode) {
		MapTreeNode node;
		String objType = obj.getClass().getSimpleName();

		if (objType.equals("XMLRecord")
				&& ((XMLRecord) obj).getEdiRecordType().equals("pcdata")) {
			node = pNode;
		} else {
			ElementCore eleCore = (ElementCore) obj;
			String isActive = eleCore.getEdiActive();

			node = new MapTreeNode(eleCore.toString(), objType);

			if (isActive.equals("1")) {
				node.setActive(true);
			}
			node.setDataObj(obj);
			pNode.add(node);
		}

		@SuppressWarnings("unchecked")
		List<Object> childList = (List<Object>) ((ChildListOperate) obj)
				.getChildList();

		ElementCore t_elcCore;
		MapTreeNode snode;
		for (Object cObj : childList) {
			t_elcCore = (ElementCore) cObj;
			String cObjType = cObj.getClass().getSimpleName();
			if (cObjType.equals("Field")) {
				snode = new MapTreeNode(t_elcCore.toString(), cObjType);
				String isActive = t_elcCore.getEdiActive();				
				if (isActive.equals("1")) {
					snode.setActive(true);
				}
				snode.setDataObj(cObj);
				node.add(snode);
			} else {
				buildTree(cObj, node);
			}
		}
	}

	public static void buildXML(Mapper mapper, Config config, String fileName) {
		Element root = new Element("Mapper", defaultns);
		root.addNamespaceDeclaration(Namespace.getNamespace("xsi",
				"http://www.w3.org/2001/XMLSchema-instance"));
		root.setAttribute("VERSION", "1.0");
		ConfigElement confEle = ConfigOperate.findConfigElement(config,
				"Mapper");

		buildXMLNode(root, mapper, confEle);
		CreateFile.createXMLFile(root, fileName);
	}

	private static void processElement(Element pNode, Object pobj,
			ConfigElement configEle) {
		processSequence(pNode, pobj, configEle.getCFGsequence());
	}

	private static void processSequence(Element pNode, Object pobj,
			ConfigSequence configSeq) {
		String CFGminOccurs = configSeq.getCFGminOccurs();
		String CFGmaxOccurs = configSeq.getCFGmaxOccurs();

		if (CFGminOccurs == null && CFGmaxOccurs == null) {
			List<Object> list = configSeq.getCFGsequence();
			for (Object obj : list) {
				if (obj instanceof ConfigItem) {
					processItem(pNode, pobj, (ConfigItem) obj);
				} else if (obj instanceof ConfigChoice) {
					processChoice(pNode, pobj, (ConfigChoice) obj);
				}
			}
		} else {
			int minOccurs = 1;
			int maxOccurs = 1;
			if (CFGminOccurs != null) {
				minOccurs = Integer.parseInt(CFGminOccurs);
			}
			if (CFGmaxOccurs != null) {
				maxOccurs = CFGmaxOccurs.equals("unbounded") ? -1 : Integer
						.parseInt(CFGmaxOccurs);
			}

			if (minOccurs == maxOccurs) {
				if (minOccurs > 1) {
					List<Object> list = configSeq.getCFGsequence();
					for (int i = 0; i < minOccurs; i++) {
						Reflect.invokeSetMethod(pobj.getClass(), pobj,
								"setIndex", i);
						for (Object obj : list) {
							if (obj instanceof ConfigItem) {
								processItem(pNode, pobj, (ConfigItem) obj);
							} else if (obj instanceof ConfigChoice) {
								// processChoice(pNode, pobj, (ConfigChoice)
								// obj);
							}
						}
					}
				}
			} else {

			}
		}
	}

	private static void processItem(Element pNode, Object pobj, ConfigItem cItem) {
		Element node;
		String name = cItem.getCFGname();
		String valueType = cItem.getCFGvalueType();
		Object obj = Reflect.invokeGetMethod(pobj.getClass(), pobj,
				PropertyName.getGetterName(name));

		String CFGminOccurs = cItem.getCFGminOccurs();
		String CFGmaxOccurs = cItem.getCFGmaxOccurs();

		if (CFGminOccurs == null && CFGmaxOccurs == null) {
			node = new Element(name, defaultns);
			pNode.addContent(node);
			if (obj != null) {
				if (valueType.equals("String")) {
					node.setText(obj.toString());
				} else if (valueType.equals("Object")) {
					// if(obj != null){
					// System.out.println(cItem.getCFGname()+"   "+cItem.getCFGElement());
					processElement(node, obj, cItem.getCFGElement());
					// }
				} else {
					System.out.println(valueType + "无该类型！");
				}
			}
		} else {
			int minOccurs = 1;
			int maxOccurs = 1;

			if (CFGminOccurs != null) {
				minOccurs = Integer.parseInt(CFGminOccurs);
			}

			if (CFGmaxOccurs != null) {
				maxOccurs = CFGmaxOccurs.equals("unbounded") ? -1 : Integer
						.parseInt(CFGmaxOccurs);
			}

			if (minOccurs == 0 && maxOccurs == 1) {
				if (obj != null) {
					node = new Element(name, defaultns);
					pNode.addContent(node);
					if (valueType.equals("String")) {
						node.setText(obj.toString());
					} else if (valueType.equals("Object")) {
						// System.out.println(cItem.getCFGname() + " "
						// + cItem.getCFGElement());
						processElement(node, obj, cItem.getCFGElement());
					} else {
						System.out.println(valueType + "无该类型！");
					}
				}
			} else {
				if (obj != null) {
					@SuppressWarnings("unchecked")
					List<Object> childList = (List<Object>) obj;

					ConfigElement cEle = cItem.getCFGElement();
					for (Object subObj : childList) {
						node = new Element(name, defaultns);
						pNode.addContent(node);
						if (valueType.equals("String")) {
							node.setText(subObj.toString());
						} else if (valueType.equals("Object")) {
							// ConfigItem configItem =
							// ConfigOperate.findConfigItem(cChoice,itemName );
							processElement(node, subObj, cEle);
						} else {
							System.out.println(valueType + "无该类型！");
						}
					}
				}
			}
		}
	}

	private static void processChoice(Element pNode, Object pobj,
			ConfigChoice cChoice) {
		int minOccurs = 1;
		int maxOccurs = 1;

		String CFGminOccurs = cChoice.getCFGminOccurs();
		String CFGmaxOccurs = cChoice.getCFGmaxOccurs();

		if (CFGminOccurs != null) {
			minOccurs = Integer.parseInt(cChoice.getCFGminOccurs());
		}
		if (CFGmaxOccurs != null) {
			maxOccurs = CFGmaxOccurs.equals("unbounded") ? -1 : Integer
					.parseInt(CFGmaxOccurs);
		}

		if (minOccurs == maxOccurs) {
			if (minOccurs == 1) {

				List<ConfigItem> cList = cChoice.getCGFchoice();
				for (ConfigItem item : cList) {
					// System.out.println("--------------------------");
					// System.out.println(item.getCFGname());
					processItem(pNode, pobj, item);
					// System.out.println("--------------------------");
				}
			}
		} else {
			@SuppressWarnings("unchecked")
			List<Object> childList = (List<Object>) Reflect.invokeGetMethod(
					pobj.getClass(), pobj, "getChildList");
			if (childList != null) {
				ConfigItem configItem;
				for (Object obj : childList) {
					String itemName = obj.getClass().getSimpleName();
					Element node = new Element(itemName, defaultns);
					pNode.addContent(node);

					configItem = ConfigOperate
							.findConfigItem(cChoice, itemName);
					if (configItem != null) {
						processElement(node, obj, configItem.getCFGElement());
					} else {
						System.out.println(itemName + "的 ConfigItem");
					}
				}
			} else {
				System.out.println(pobj.getClass().getSimpleName()
						+ "的 childList 为空！");
			}
		}

	}

	private static void buildXMLNode(Element pNode, Object pobj,
			ConfigElement confEle) {
		processElement(pNode, pobj, confEle);
	}
}