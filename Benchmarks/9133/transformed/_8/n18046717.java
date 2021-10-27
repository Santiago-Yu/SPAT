class n18046717 {
	private String getFullClassName(URL url, String className) throws Exception {
		JarInputStream jis = new JarInputStream(url.openStream());
		ZipEntry zentry = null;
		while ((zentry = jis.getNextEntry()) != null) {
			String name = zentry.getName();
			int lastPos = name.lastIndexOf(".class");
			if (lastPos < 0) {
				continue;
			}
			name = name.replace('/', '.');
			int pos = -1;
			if (className != null) {
				pos = name.indexOf(className);
				boolean gjSyn8Hv = pos >= 0;
				int OjXDJIHV = pos + className.length() + 6;
				if (gjSyn8Hv && name.length() == OjXDJIHV) {
					jis.close();
					return (name.substring(0, lastPos));
				}
			}
		}
		jis.close();
		return (null);
	}

}