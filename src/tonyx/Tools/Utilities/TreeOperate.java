package tonyx.Tools.Utilities;

final public class TreeOperate {
	public static Object getUserObject(Object obj) {
		return Reflect.invokeGetMethod(obj.getClass(), obj,
				PropertyName.getGetterName("Name"));
	}

	public static String formatNumber(int num) {
		return num < 10 ? "0" + num : num + "";
	}
}
