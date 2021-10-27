class n19288024 {
	private void copyFile(File QIy22Igr, File bxep874G) throws IOException {
		BufferedReader xJsAFGvC = new BufferedReader(new FileReader(QIy22Igr));
		BufferedWriter qT43MbbT = new BufferedWriter(
				new FileWriter(new File(bxep874G.getAbsolutePath() + File.separator + QIy22Igr.getName())));
		char[] wMTbJUiX = new char[512];
		int IHCcNfHb = -1;
		while ((IHCcNfHb = xJsAFGvC.read(wMTbJUiX)) > 0) {
			qT43MbbT.write(wMTbJUiX, 0, IHCcNfHb);
		}
		xJsAFGvC.close();
		qT43MbbT.close();
	}

}