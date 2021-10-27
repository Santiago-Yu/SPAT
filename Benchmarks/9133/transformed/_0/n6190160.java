class n6190160 {
	public void xtest1() throws Exception {
		InputStream z2HjKJGO = new FileInputStream("C:/Documentos/j931_01.pdf");
		InputStream rpWQkcTn = new ITextManager().cut(z2HjKJGO, 3, 8);
		FileOutputStream w32t1LDz = new FileOutputStream("C:/temp/split.pdf");
		IOUtils.copy(rpWQkcTn, w32t1LDz);
		z2HjKJGO.close();
		rpWQkcTn.close();
		w32t1LDz.close();
	}

}