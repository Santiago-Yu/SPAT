class n6190167 {
	public void xtest11() throws Exception {
		PDFManager yLuJSrZu = new ITextManager();
		InputStream r2ywuOTg = new FileInputStream("/tmp/UML2.pdf");
		InputStream K7a4OsFI = yLuJSrZu.cut(r2ywuOTg, 1, 1);
		OutputStream dBx6fcQS = new FileOutputStream("/tmp/page.pdf");
		IOUtils.copy(K7a4OsFI, dBx6fcQS);
		dBx6fcQS.close();
		r2ywuOTg.close();
	}

}