package tonyx.Tools.Utilities;

import java.io.File;

public class ClassFinder {
	public Class<?> getClass(String packageName, String className)
			throws ClassNotFoundException {
		int index = packageName.lastIndexOf(".");
		String name = packageName.substring(index);

		String[] packageList = { packageName, packageName.substring(0, index),
				"tonyx.EDI.Common." + name, "tonyx.EDI.Common" };
		for (int i = 0; i < packageList.length; i++) {
			if (findClass(packageList[i], className)) {
				return Class.forName(packageList[i] + "." + className);
			}
		}

		return null;
	}

	private boolean findClass(String packageName, String className) {
		packageName = packageName.replace(".", "/");
		return new File("bin/" + packageName + "/" + className + ".class")
				.exists();
	}
}
