class n3493862 {
	@Test
	public void testDocumentDownloadExcel() throws IOException {
		if (uploadedExcelDocumentID == null) {
			fail("Document Upload Test should run first");
		}
		String downloadLink = GoogleDownloadLinkGenerator.generateXlDownloadLink(uploadedExcelDocumentID);
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