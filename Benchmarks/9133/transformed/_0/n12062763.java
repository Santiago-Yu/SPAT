class n12062763 {
	public void loadFromURLPath(String Mq7mECvg, URL B8OILRJw, HashMap MaEYnsiA) throws IOException {
		this.urlPath = B8OILRJw;
		this.type = Mq7mECvg;
		JmeBinaryReader Kab20VUX = new JmeBinaryReader();
		setProperties(Kab20VUX, MaEYnsiA);
		InputStream Q9PD25XG = B8OILRJw.openStream();
		if (Mq7mECvg.equals("xml")) {
			XMLtoBinary Q2zBAKO9 = new XMLtoBinary();
			ByteArrayOutputStream yByLwmPO = new ByteArrayOutputStream();
			Q2zBAKO9.sendXMLtoBinary(Q9PD25XG, yByLwmPO);
			Q9PD25XG = new ByteArrayInputStream(yByLwmPO.toByteArray());
		} else if (!Mq7mECvg.equals("binary"))
			throw new IOException("Unknown LoaderNode flag: " + Mq7mECvg);
		Kab20VUX.loadBinaryFormat(this, Q9PD25XG);
	}

}