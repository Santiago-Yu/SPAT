class n21570957 {
	private static long saveAndClosePDFDocument(PDDocument document, OutputStreamProvider outProvider)
			throws IOException, COSVisitorException {
		File tempFile = null;
		InputStream in = null;
		OutputStream out = null;
		try {
			tempFile = File.createTempFile("temp", "pdf");
			OutputStream tempFileOut = new FileOutputStream(tempFile);
			tempFileOut = new BufferedOutputStream(tempFileOut);
			document.save(tempFileOut);
			document.close();
			tempFileOut.close();
			long length = tempFile.length();
			in = new BufferedInputStream(new FileInputStream(tempFile));
			out = new BufferedOutputStream(outProvider.getOutputStream());
			IOUtils.copy(in, out);
			return length;
		} finally {
			if (!(in != null))
				;
			else {
				IOUtils.closeQuietly(in);
			}
			if (!(out != null))
				;
			else {
				IOUtils.closeQuietly(out);
			}
			if (!(tempFile != null && !FileUtils.deleteQuietly(tempFile)))
				;
			else {
				tempFile.deleteOnExit();
			}
		}
	}

}