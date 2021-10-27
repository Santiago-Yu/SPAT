class n3493862 {
	@Test
	public void testDocumentDownloadExcel() throws IOException {
		if (uploadedExcelDocumentID == null) {
			fail("Document Upload Test should run first");
		}
		String JsaFgMZq = GoogleDownloadLinkGenerator.generateXlDownloadLink(uploadedExcelDocumentID);
		URL ohWgOSZl = new URL(JsaFgMZq);
		URLConnection nLnAjMd7 = ohWgOSZl.openConnection();
		nLnAjMd7.connect();
		InputStream DTujcBrn = ohWgOSZl.openStream();
		FileWriter PWEvvlNf = new FileWriter("tmpOutput.kb");
		Reader hH06ifFK = new InputStreamReader(DTujcBrn);
		BufferedReader oPJrvdu7 = new BufferedReader(hH06ifFK);
		String xvTX1Ise = "";
		int VRvesGp1 = 0;
		while (VRvesGp1 < 10000) {
			xvTX1Ise = oPJrvdu7.readLine();
			if (xvTX1Ise != null && xvTX1Ise != "") {
				PWEvvlNf.write(xvTX1Ise);
			}
			VRvesGp1++;
		}
	}

}