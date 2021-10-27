class n6190168 {
	public void xtest12() throws Exception {
		InputStream pdf = new FileInputStream("/tmp/090237098008f637.pdf");
		PDFManager manager = new ITextManager();
		OutputStream outputStream = new FileOutputStream("/tmp/090237098008f637-1.pdf");
		InputStream page1 = manager.cut(pdf, 36, 36);
		IOUtils.copy(page1, outputStream);
		outputStream.close();
		pdf.close();
	}

}