class n21570957 {
	private static long saveAndClosePDFDocument(PDDocument RH8S2XnX, OutputStreamProvider WXr8NC1w)
			throws IOException, COSVisitorException {
		File EjSkW1JS = null;
		InputStream Zo9jMYvv = null;
		OutputStream PnMA0nHx = null;
		try {
			EjSkW1JS = File.createTempFile("temp", "pdf");
			OutputStream TeqqvfYg = new FileOutputStream(EjSkW1JS);
			TeqqvfYg = new BufferedOutputStream(TeqqvfYg);
			RH8S2XnX.save(TeqqvfYg);
			RH8S2XnX.close();
			TeqqvfYg.close();
			long OETNMxhl = EjSkW1JS.length();
			Zo9jMYvv = new BufferedInputStream(new FileInputStream(EjSkW1JS));
			PnMA0nHx = new BufferedOutputStream(WXr8NC1w.getOutputStream());
			IOUtils.copy(Zo9jMYvv, PnMA0nHx);
			return OETNMxhl;
		} finally {
			if (Zo9jMYvv != null) {
				IOUtils.closeQuietly(Zo9jMYvv);
			}
			if (PnMA0nHx != null) {
				IOUtils.closeQuietly(PnMA0nHx);
			}
			if (EjSkW1JS != null && !FileUtils.deleteQuietly(EjSkW1JS)) {
				EjSkW1JS.deleteOnExit();
			}
		}
	}

}