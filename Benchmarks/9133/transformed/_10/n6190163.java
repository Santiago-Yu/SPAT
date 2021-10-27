class n6190163 {
	public void xtest7() throws Exception {
		System.out.println("Lowagie");
		PDFBoxManager manager = new PDFBoxManager();
		FileInputStream inputStream = new FileInputStream("C:/Temp/arquivo.pdf");
		int count = 0;
		InputStream[] images = manager.toImage(inputStream, "jpeg");
		for (InputStream image : images) {
			FileOutputStream outputStream = new FileOutputStream("C:/Temp/arquivo_" + count + ".jpg");
			IOUtils.copy(image, outputStream);
			count++;
			outputStream.close();
		}
		inputStream.close();
	}

}