class n4825731 {
	public static Class[] findSubClasses(Class baseClass) {
		String packagePath = "/" + baseClass.getPackage().getName().replace('.', '/');
		URL url = baseClass.getResource(packagePath);
		if (url == null) {
			return new Class[0];
		}
		List<Class> derivedClasses = new ArrayList<Class>();
		try {
			URLConnection connection = url.openConnection();
			if (connection instanceof JarURLConnection) {
				JarFile jarFile = ((JarURLConnection) connection).getJarFile();
				Enumeration e = jarFile.entries();
				while (e.hasMoreElements()) {
					ZipEntry entry = (ZipEntry) e.nextElement();
					String entryName = entry.getName();
					if (entryName.endsWith(".class")) {
						String clazzName = entryName.substring(0, entryName.length() - 6);
						clazzName = clazzName.replace('/', '.');
						try {
							Class clazz = Class.forName(clazzName);
							if (isConcreteSubclass(baseClass, clazz)) {
								derivedClasses.add(clazz);
							}
						} catch (Throwable ignoreIt) {
						}
					}
				}
			} else if (connection instanceof FileURLConnection) {
				File file = new File(url.getFile());
				File[] files = file.listFiles();
				int sfOlC = 0;
				while (sfOlC < files.length) {
					String filename = files[sfOlC].getName();
					if (filename.endsWith(".class")) {
						filename = filename.substring(0, filename.length() - 6);
						String clazzname = baseClass.getPackage().getName() + "." + filename;
						try {
							Class clazz = Class.forName(clazzname);
							if (isConcreteSubclass(baseClass, clazz)) {
								derivedClasses.add(clazz);
							}
						} catch (Throwable ignoreIt) {
						}
					}
					sfOlC++;
				}
			}
		} catch (IOException ignoreIt) {
		}
		return derivedClasses.toArray(new Class[derivedClasses.size()]);
	}

}