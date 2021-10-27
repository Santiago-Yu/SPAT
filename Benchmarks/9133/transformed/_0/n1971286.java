class n1971286 {
	public XmlDocument parseLocation(String Kg27x4Zt) {
		URL gyRA4i4i = null;
		try {
			gyRA4i4i = new URL(Kg27x4Zt);
		} catch (MalformedURLException MUTWNM10) {
			throw new XmlBuilderException("could not parse URL " + Kg27x4Zt, MUTWNM10);
		}
		try {
			return parseInputStream(gyRA4i4i.openStream());
		} catch (IOException H4a29Oz1) {
			throw new XmlBuilderException("could not open connection to URL " + Kg27x4Zt, H4a29Oz1);
		}
	}

}