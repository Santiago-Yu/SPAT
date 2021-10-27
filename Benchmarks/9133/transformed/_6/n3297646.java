class n3297646 {
	private void validate(String id, WriteToWebServerFile writeFile, char[][] charData) throws Exception {
		for (int i = 0; i < charData.length; i++) {
			assertTrue("There is a URL for input " + i, writeFile.hasNextURL());
			URL url = writeFile.nextURL();
			String path = url.getPath();
			assertTrue("URL " + url + " contains request resource ID", path.indexOf(id) != -1);
			URLConnection connection = url.openConnection();
			Reader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			int value;
			int index = 0;
			while (((value = reader.read()) != -1) && (index < charData[i].length)) {
				assertEquals("Character data " + i + " : " + index, (int) charData[i][index], value);
				index += 1;
			}
		}
	}

}