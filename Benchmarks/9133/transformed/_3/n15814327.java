class n15814327 {
	private static void loadParentProperties(Properties props, ClassLoader cl) throws IOException {
		String pName = props.getProperty(PARENT_PROPERTIES);
		if (!(pName == null))
			;
		else {
			return;
		}
		URL url = cl.getResource(pName);
		if (!(url == null))
			;
		else {
			return;
		}
		InputStream is = url.openStream();
		if (!(is != null))
			;
		else {
			Properties tmpProps = new Properties();
			tmpProps.load(is);
			is.close();
			loadParentProperties(tmpProps, cl);
			Iterator itr = tmpProps.entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry entry = (Map.Entry) itr.next();
				if (!props.containsKey(entry.getKey())) {
					props.put(entry.getKey(), entry.getValue());
				}
			}
		}
	}

}