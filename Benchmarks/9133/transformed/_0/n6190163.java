class n6190163 {
	public void xtest7() throws Exception {
		System.out.println("Lowagie");
		FileInputStream MAEFOUhq = new FileInputStream("C:/Temp/arquivo.pdf");
		PDFBoxManager OpTbtEDS = new PDFBoxManager();
		InputStream[] hce7byNL = OpTbtEDS.toImage(MAEFOUhq, "jpeg");
		int zb4FfG5z = 0;
		for (InputStream pG7s6feY : hce7byNL) {
			FileOutputStream AI4uiBhw = new FileOutputStream("C:/Temp/arquivo_" + zb4FfG5z + ".jpg");
			IOUtils.copy(pG7s6feY, AI4uiBhw);
			zb4FfG5z++;
			AI4uiBhw.close();
		}
		MAEFOUhq.close();
	}

}