class n8006559 {
	private final void findSubclasses(URL location, String packageName, Class superClass, Set setOfClasses) {
		synchronized (results) {
			String fqcn = searchClass.getName();
			List knownLocations = new ArrayList();
			knownLocations.add(location);
			for (int loc = 0; loc < knownLocations.size(); loc++) {
				URL url = (URL) knownLocations.get(loc);
				File directory = new File(url.getFile());
				if (directory.exists()) {
					File[] files = directory.listFiles(CLASSES_ONLY);
					for (int i = 0; i < files.length; i++) {
						String filename = files[i].getName();
						String classname = filename.substring(0, filename.length() - 6);
						try {
							if (!(packageName + "." + classname).equals(fqcn)) {
								Class c = callClassForName(packageName + "." + classname);
								manageClass(setOfClasses, superClass, c, url);
							}
						} catch (Throwable t) {
							errors.add(t);
						}
					}
				} else {
					try {
						JarURLConnection conn = (JarURLConnection) url.openConnection();
						JarFile jarFile = conn.getJarFile();
						Enumeration e = jarFile.entries();
						while (e.hasMoreElements()) {
							JarEntry entry = (JarEntry) e.nextElement();
							String entryname = entry.getName();
							if (!entry.isDirectory() && entryname.endsWith(".class")) {
								String classname = entryname.substring(0, entryname.length() - 6);
								if (classname.startsWith("/"))
									classname = classname.substring(1);
								classname = classname.replace('/', '.');
								try {
									if (!(classname != null && classname.equals(fqcn))) {
										Class c = callClassForName(classname);
										manageClass(setOfClasses, superClass, c, url);
									}
								} catch (Throwable t) {
									errors.add(t);
								}
							}
						}
					} catch (IOException ioex) {
						errors.add(ioex);
					}
				}
			}
		}
	}

}