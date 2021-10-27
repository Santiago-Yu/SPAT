class n6190167 {
	public void xtest11() throws Exception {
		InputStream pdf = new FileInputStream("/tmp/UML2.pdf");
		PDFManager manager = new ITextManager();
		OutputStream outputStream = new FileOutputStream("/tmp/page.pdf");
		InputStream page1 = manager.cut(pdf, 1, 1);
		IOUtils.copy(page1, outputStream);
		outputStream.close();
		pdf.close();
	}

}