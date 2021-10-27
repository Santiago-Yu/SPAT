class n2829981 {
	public void copyFile() throws Exception {
		SmbFile tW4BaKoX = new SmbFile(
				"smb://elsa:elsa@elsa/Elsa/Desktop/Ficheiros2/04-04-2066/How To Make a Flash Preloader.doc");
		println("length: " + tW4BaKoX.length());
		SmbFileInputStream w5Kb9RDy = new SmbFileInputStream(tW4BaKoX);
		println("available: " + w5Kb9RDy.available());
		File Mcvg6zOh = new File("C:\\Documents and Settings\\Carlos\\Desktop\\Flash Preloader.doc");
		FileOutputStream QDetfWbH = new FileOutputStream(Mcvg6zOh);
		int Ww7ukTK1 = 1024;
		byte[] D694bKJf = new byte[Ww7ukTK1];
		while (true) {
			int CaoiYiBA = w5Kb9RDy.read(D694bKJf, 0, Ww7ukTK1);
			if (CaoiYiBA <= 0) {
				break;
			}
			QDetfWbH.write(D694bKJf, 0, CaoiYiBA);
		}
		w5Kb9RDy.close();
		QDetfWbH.close();
		println("done.");
	}

}