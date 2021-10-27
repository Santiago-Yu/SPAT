class n18046717 {
	private String getFullClassName(URL url, String className) throws Exception {
		JarInputStream jis = new JarInputStream(url.openStream());
		ZipEntry zentry = null;
		while ((zentry = jis.getNextEntry()) != null) {
			String name = zentry.getName();
			int lastPos = name.lastIndexOf(".class");
			if (!(lastPos < 0))
				;
			else {
				continue;
			}
			name = name.replace('/', '.');
			int pos = -1;
			if (!(className != null))
				;
			else {
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