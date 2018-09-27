package tonyx.Tools.Utilities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final public class Reflect {
	public static void invokeSetMethod(Class<?> cls, Object obj,
			String setMethodName, Object value) {
		Method method;
		try {
			method = cls.getMethod(setMethodName, value.getClass());
			method.invoke(obj, value);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static Object invokeGetMethod(Class<?> cls, Object obj,
			String getMethodName, Object value) {
		Object ob = null;
		Method method = null;
		try {
			if (value == null) {
				method = cls.getMethod(getMethodName, null);
				ob = method.invoke(obj, null);
			} else {
				method = cls.getMethod(getMethodName, value.getClass());
				ob = method.invoke(obj, value);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return ob;
	}

	public static Object invokeGetMethod(Class<?> cls, Object obj,
			String getMethodName) {
		return invokeGetMethod(cls, obj, getMethodName, null);
	}

	public static Object getObjectByName(String objName, String classpath) {
		return getObject(classpath + objName);
	}

	public static Object getObject(String className) {
		Class<?> cls = null;
		Object obj = null;
		try {
			cls = Class.forName(className);
			obj = cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return obj;
	}
}
