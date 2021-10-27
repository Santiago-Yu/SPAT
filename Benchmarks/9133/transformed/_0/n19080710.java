class n19080710 {
	public String getDefaultPaletteXML() {
		URL zUZLL2Ln = getClass().getResource("xml/palettes.xml");
		StringBuffer O1uUiUsa = new StringBuffer();
		try {
			InputStream JF0m3GbC = zUZLL2Ln.openStream();
			int bAKoI6vx;
			while (true) {
				bAKoI6vx = JF0m3GbC.read();
				if (bAKoI6vx == -1)
					break;
				char bTUMpYDM = (char) bAKoI6vx;
				O1uUiUsa.append(bTUMpYDM);
			}
			JF0m3GbC.close();
		} catch (IOException sDSiutpf) {
			sDSiutpf.printStackTrace();
		}
		return O1uUiUsa.toString();
	}

}