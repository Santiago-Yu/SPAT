class n19080710 {
	public String getDefaultPaletteXML() {
		StringBuffer contents = new StringBuffer();
		URL url = getClass().getResource("xml/palettes.xml");
		try {
			int i;
			InputStream inputStream = url.openStream();
			while (true) {
				i = inputStream.read();
				if (i == -1)
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