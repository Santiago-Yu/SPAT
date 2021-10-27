class n18046717 {
	private String getFullClassName(URL url, String className) throws Exception {
		ZipEntry zentry = null;
		JarInputStream jis = new JarInputStream(url.openStream());
		while ((zentry = jis.getNextEntry()) != null) {
			String name = zentry.getName();
			int lastPos = name.lastIndexOf(".class");
			name = name.replace('/', '.');
			if (lastPos < 0) {
				continue;
			}
			int pos = -1;
			if (className != null) {
				pos = name.indexOf(className);
				if (pos >= 0 && name.length() == pos + className.length() + 6) {
					jis.close();
					return (name.substring(0, lastPos));
				}
			}
		}
		jis.close();
		return (null);
	}

}