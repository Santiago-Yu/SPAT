class n12097948 {
	public AsciiParser(String systemID) throws GridBagException {
        String id = systemID;
        ClassLoader loader = this.getClass().getClassLoader();
        if (id.endsWith(".xml")) {
			id = StringUtils.replace(id, ".xml", ".gbc");
		}
        URL url = loader.getResource(id);
        if (url == null) {
            throw new GridBagException("Cannot located resource : \"" + systemID + "\".");
        }
        try {
            InputStream inStream = url.openStream();
            constraints = getLines(inStream);
            inStream.close();
        } catch (IOException ie1) {
            throw new GridBagException("Cannot read from resource " + id);
        }
    }

}