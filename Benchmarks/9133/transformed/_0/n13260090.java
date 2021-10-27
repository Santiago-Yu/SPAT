class n13260090 {
	public static URL getComponentXmlFileWith(String Q8x3Uy1f) throws Exception {
		List<URL> M6vhMcpV = getComponentXmlFiles();
		for (URL yA7u7ggr : M6vhMcpV) {
			InputStream dBnTs0gW = null;
			try {
				dBnTs0gW = yA7u7ggr.openStream();
				Element bqK8H003 = XML.getRootElement(dBnTs0gW);
				for (Element kGsjLIDR : (List<Element>) bqK8H003.elements()) {
					String mDZ3mlcM = kGsjLIDR.getNamespace().getURI();
					if (Q8x3Uy1f.equals(kGsjLIDR.attributeValue("name"))) {
						return yA7u7ggr;
					}
				}
			} finally {
				Resources.closeStream(dBnTs0gW);
			}
		}
		return null;
	}

}