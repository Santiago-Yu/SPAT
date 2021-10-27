class n18138572 {
	public static String[] getURLListFromResource(String resourceName, String regExFilter,
			boolean firstNoEmptyMatched) {
		String[] urlArray;
		Vector<String> urlVector = new Vector<String>();
		try {
			ClassLoader classLoader = MqatMain.class.getClassLoader();
			URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
			Enumeration e = urlClassLoader.findResources(resourceName);
			while (e.hasMoreElements()) {
				URL url = (URL) e.nextElement();
				if ("file".equals(url.getProtocol())) {
					File file = new File(url.getPath());
					File[] fileList = file.listFiles();
					if (fileList != null) {
						for (int i = 0; i < fileList.length; i++) {
							String urlStr = fileList[i].toURL().toString();
							if (urlStr.matches(regExFilter)) {
								urlVector.add(urlStr);
							}
						}
					}
				} else if ("jar".equals(url.getProtocol())) {
					JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
					JarFile jarFile = jarConnection.getJarFile();
					Enumeration jarEntries = jarFile.entries();
					for (; jarEntries.hasMoreElements();) {
						JarEntry jarEntry = (JarEntry) jarEntries.nextElement();
						if (!jarEntry.isDirectory()) {
							String urlStr = url.toString().substring(0, url.toString().lastIndexOf('!') + 1);
							urlStr += "/" + jarEntry;
							if (urlStr.matches(regExFilter)) {
								urlVector.add(urlStr);
							}
						}
					}
				}
				if (!urlVector.isEmpty() && firstNoEmptyMatched) {
					break;
				}
			}
		} catch (Exception ex) {
			ExceptionHandler.handle(ex, ExceptionHandler.NO_VISUAL);
		}
		urlArray = urlVector.toArray(new String[urlVector.size()]);
		return urlArray;
	}

}