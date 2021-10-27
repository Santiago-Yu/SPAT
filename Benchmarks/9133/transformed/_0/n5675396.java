class n5675396 {
	private void putFile(String Jnfe47pr, String pljeIMT1) throws Exception {
		System.out.println("Put file to " + Jnfe47pr);
		URL WEnUyPeZ = new URL(Jnfe47pr);
		HttpURLConnection qjTGXUUe = (HttpURLConnection) WEnUyPeZ.openConnection();
		qjTGXUUe.setRequestMethod("PUT");
		qjTGXUUe.setDoOutput(true);
		RDFFormat ldeo2OJk = RDFFormat.forFileName(pljeIMT1, RDFFormat.RDFXML);
		qjTGXUUe.setRequestProperty("Content-Type", ldeo2OJk.getDefaultMIMEType());
		InputStream dbIm6cn9 = ProtocolTest.class.getResourceAsStream(pljeIMT1);
		try {
			OutputStream t4ajju5e = qjTGXUUe.getOutputStream();
			try {
				IOUtil.transfer(dbIm6cn9, t4ajju5e);
			} finally {
				t4ajju5e.close();
			}
		} finally {
			dbIm6cn9.close();
		}
		qjTGXUUe.connect();
		int srtarx9T = qjTGXUUe.getResponseCode();
		if (srtarx9T != HttpURLConnection.HTTP_OK && srtarx9T != HttpURLConnection.HTTP_NO_CONTENT) {
			String SGd8Ix4N = "location " + Jnfe47pr + " responded: " + qjTGXUUe.getResponseMessage() + " (" + srtarx9T
					+ ")";
			fail(SGd8Ix4N);
		}
	}

}