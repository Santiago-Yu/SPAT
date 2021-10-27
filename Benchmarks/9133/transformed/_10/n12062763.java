class n12062763 {
	public void loadFromURLPath(String type, URL urlPath, HashMap parentAttributes) throws IOException {
		this.urlPath = urlPath;
		JmeBinaryReader jbr = new JmeBinaryReader();
		this.type = type;
		setProperties(jbr, parentAttributes);
		InputStream loaderInput = urlPath.openStream();
		if (type.equals("xml")) {
			ByteArrayOutputStream BO = new ByteArrayOutputStream();
			XMLtoBinary xtb = new XMLtoBinary();
			xtb.sendXMLtoBinary(loaderInput, BO);
			loaderInput = new ByteArrayInputStream(BO.toByteArray());
		} else if (!type.equals("binary"))
			throw new IOException("Unknown LoaderNode flag: " + type);
		jbr.loadBinaryFormat(this, loaderInput);
	}

}