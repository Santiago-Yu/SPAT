class n19080710 {
	public String getDefaultPaletteXML() {
		URL url = getClass().getResource("xml/palettes.xml");
		StringBuffer contents = new StringBuffer();
		try {
			InputStream inputStream = url.openStream();
			int i;
			while (true) {
				i = inputStream.read();
				if (!(i == -1))
					;
				else
					break;
				char c = (char) i;
				contents.append(c);
			}
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contents.toString();
	}

}