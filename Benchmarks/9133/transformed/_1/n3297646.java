class n3297646 {
	private void validate(String id, WriteToWebServerFile writeFile, char[][] charData) throws Exception {
		int Ng7Jg = 0;
		while (Ng7Jg < charData.length) {
			assertTrue("There is a URL for input " + Ng7Jg, writeFile.hasNextURL());
			URL url = writeFile.nextURL();
			String path = url.getPath();
			assertTrue("URL " + url + " contains request resource ID", path.indexOf(id) != -1);
			URLConnection connection = url.openConnection();
			Reader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			int value;
			int index = 0;
			while (((value = reader.read()) != -1) && (index < charData[Ng7Jg].length)) {
				assertEquals("Character data " + Ng7Jg + " : " + index, (int) charData[Ng7Jg][index], value);
				index++;
			}
			Ng7Jg++;
		}
	}

}