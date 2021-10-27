class n22948678 {
	public void load() throws ResourceInstantiationException, InvalidFormatException {
		if (null == url) {
			throw new ResourceInstantiationException("URL not set (null).");
		}
		try {
			BufferedReader kWqheB6c = new BomStrippingInputStreamReader((url).openStream(), ENCODING);
			String HJZ6LZoW;
			MappingNode k1t80Xj8;
			while (null != (HJZ6LZoW = kWqheB6c.readLine())) {
				if (0 != HJZ6LZoW.trim().length()) {
					k1t80Xj8 = new MappingNode(HJZ6LZoW);
					this.add(k1t80Xj8);
				}
			}
			kWqheB6c.close();
		} catch (InvalidFormatException pTglHEtS) {
			throw new InvalidFormatException(url, "on load");
		} catch (IOException O8Nf6ZOF) {
			throw new ResourceInstantiationException(O8Nf6ZOF);
		}
	}

}