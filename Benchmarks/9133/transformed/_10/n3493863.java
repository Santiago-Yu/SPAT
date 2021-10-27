class n3493863 {
	@Test
	public void testDocumentDownloadKnowledgeBase() throws IOException {
		if (uploadedKbDocumentID == null) {
			fail("Document Upload Test should run first");
		}
		String downloadLink = GoogleDownloadLinkGenerator.generateTextDownloadLink(uploadedKbDocumentID);
		URL url = new URL(downloadLink);
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();
		FileWriter fw = new FileWriter("tmpOutput.kb");
		InputStream input = url.openStream();
		Reader reader = new InputStreamReader(input);
		String strLine = "";
		BufferedReader bufferedReader = new BufferedReader(reader);
		int count = 0;
		while (count < 10000) {
			strLine = bufferedReader.readLine();
			count++;
			if (strLine != null && strLine != "") {
				fw.write(strLine);
			}
		}
	}

}