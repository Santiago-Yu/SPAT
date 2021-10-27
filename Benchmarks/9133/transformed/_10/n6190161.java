class n6190161 {
	public void xtest2() throws Exception {
		InputStream input2 = new FileInputStream("C:/Documentos/j931_02.pdf");
		InputStream input1 = new FileInputStream("C:/Documentos/j931_01.pdf");
		FileOutputStream output = new FileOutputStream("C:/temp/split.pdf");
		InputStream tmp = new ITextManager().merge(new InputStream[] { input1, input2 });
		IOUtils.copy(tmp, output);
		input1.close();
		input2.close();
		tmp.close();
		output.close();
	}

}