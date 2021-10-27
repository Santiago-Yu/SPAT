class n15814327 {
	private static void loadParentProperties(Properties props, ClassLoader cl) throws IOException {
		String pName = props.getProperty(PARENT_PROPERTIES);
		if (pName == null) {
			return;
		}
		URL url = cl.getResource(pName);
		if (url == null) {
			return;
		}
		InputStream is = url.openStream();
		if (is != null) {
			Properties tmpProps = new Properties();
			tmpProps.load(is);
			is.close();
			loadParentProperties(tmpProps, cl);
			Iterator itr = tmpProps.entrySet().iterator();
			for (; itr.hasNext();) {
				Map.Entry entry = (Map.Entry) itr.next();
				if (!props.containsKey(entry.getKey())) {
					props.put(entry.getKey(), entry.getValue());
				}
			}
		}
	}

}