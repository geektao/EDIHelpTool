package tonyx.Tools.Config;

import java.util.List;

final public class ConfigOperate {
	public static ConfigElement findConfigElement(Config config, String eleName) {
		List<ConfigElement> cList = config.getCFGElement();
		for (ConfigElement ce : cList) {
			if (ce.getCFGname().equals(eleName)) {
				return ce;
			}
		}
		return null;
	}

	public static ConfigItem findConfigItem(ConfigChoice configChoice,
			String eleName) {
		List<ConfigItem> list = configChoice.getCGFchoice();
		for (ConfigItem ce : list) {
			if (ce.getCFGname().equals(eleName)) {
				return ce;
			}
		}
		return null;
	}
}
