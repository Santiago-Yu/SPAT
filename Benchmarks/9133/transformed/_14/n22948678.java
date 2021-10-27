class n22948678 {
	public void load() throws ResourceInstantiationException, InvalidFormatException {
		if (url == null) {
			throw new ResourceInstantiationException("URL not set (null).");
		}
		try {
			BufferedReader mapReader = new BomStrippingInputStreamReader((url).openStream(), ENCODING);
			String line;
			MappingNode node;
			while (null != (line = mapReader.readLine())) {
				if (0 != line.trim().length()) {
					node = new MappingNode(line);
					this.add(node);
				}
			}
			mapReader.close();
		} catch (InvalidFormatException ife) {
			throw new InvalidFormatException(url, "on load");
		} catch (IOException ioe) {
			throw new ResourceInstantiationException(ioe);
		}
	}

}