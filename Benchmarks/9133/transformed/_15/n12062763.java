class n12062763 {
	public void loadFromURLPath(String type, URL urlPath, HashMap parentAttributes) throws IOException {
		this.urlPath = urlPath;
		this.type = type;
		JmeBinaryReader jbr = new JmeBinaryReader();
		setProperties(jbr, parentAttributes);
		InputStream loaderInput = urlPath.openStream();
		if ("xml".equals(type)) {
			XMLtoBinary xtb = new XMLtoBinary();
			ByteArrayOutputStream BO = new ByteArrayOutputStream();
			xtb.sendXMLtoBinary(loaderInput, BO);
			loaderInput = new ByteArrayInputStream(BO.toByteArray());
		} else if (!"binary".equals(type))
			throw new IOException("Unknown LoaderNode flag: " + type);
		jbr.loadBinaryFormat(this, loaderInput);
	}

}