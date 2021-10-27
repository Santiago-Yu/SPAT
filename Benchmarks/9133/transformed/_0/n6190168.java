class n6190168 {
	public void xtest12() throws Exception {
		PDFManager wQa6hsHW = new ITextManager();
		InputStream fLB5nGnV = new FileInputStream("/tmp/090237098008f637.pdf");
		InputStream nItLIdp9 = wQa6hsHW.cut(fLB5nGnV, 36, 36);
		OutputStream py9mKriA = new FileOutputStream("/tmp/090237098008f637-1.pdf");
		IOUtils.copy(nItLIdp9, py9mKriA);
		py9mKriA.close();
		fLB5nGnV.close();
	}

}