package tonyx.Tools.Utilities;

final public class PropertyName {
	public static String getSetterName(String val) {
		return "setEdi" + val;
	}

	public static String getGetterName(String val) {
		return "getEdi" + val;
	}

	public static String getConfigSetterName(String val) {
		return "setCFG" + val;
	}

	public static String getConfigGetterName(String val) {
		return "getCFG" + val;
	}
}
