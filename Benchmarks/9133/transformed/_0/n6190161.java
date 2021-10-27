class n6190161 {
	public void xtest2() throws Exception {
		InputStream ahf6buJx = new FileInputStream("C:/Documentos/j931_01.pdf");
		InputStream lqE3Qsqg = new FileInputStream("C:/Documentos/j931_02.pdf");
		InputStream QqIW5QO6 = new ITextManager().merge(new InputStream[] { ahf6buJx, lqE3Qsqg });
		FileOutputStream hnGV02R7 = new FileOutputStream("C:/temp/split.pdf");
		IOUtils.copy(QqIW5QO6, hnGV02R7);
		ahf6buJx.close();
		lqE3Qsqg.close();
		QqIW5QO6.close();
		hnGV02R7.close();
	}

}