class n3493863 {
	@Test
	public void testDocumentDownloadKnowledgeBase() throws IOException {
		if (uploadedKbDocumentID == null) {
			fail("Document Upload Test should run first");
		}
		String bKBEqcpb = GoogleDownloadLinkGenerator.generateTextDownloadLink(uploadedKbDocumentID);
		URL Kg686vhM = new URL(bKBEqcpb);
		URLConnection eYIWoXKH = Kg686vhM.openConnection();
		eYIWoXKH.connect();
		InputStream p3a1yfXX = Kg686vhM.openStream();
		FileWriter NcRBdWty = new FileWriter("tmpOutput.kb");
		Reader l4NUIqF8 = new InputStreamReader(p3a1yfXX);
		BufferedReader KwzR5jvQ = new BufferedReader(l4NUIqF8);
		String ZUlqt4Iw = "";
		int TM3DIQ8w = 0;
		while (TM3DIQ8w < 10000) {
			ZUlqt4Iw = KwzR5jvQ.readLine();
			if (ZUlqt4Iw != null && ZUlqt4Iw != "") {
				NcRBdWty.write(ZUlqt4Iw);
			}
			TM3DIQ8w++;
		}
	}

}