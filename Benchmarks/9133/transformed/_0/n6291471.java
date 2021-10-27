class n6291471 {
	private void copyFile(File TaGZmAmG) throws IOException {
		File N3oPU42W = new File(destdir + "/" + TaGZmAmG.getName());
		N3oPU42W.createNewFile();
		FileInputStream rQdcrjga = new FileInputStream(TaGZmAmG);
		FileOutputStream cFasHc2K = new FileOutputStream(N3oPU42W);
		int c0gv0rvK;
		while ((c0gv0rvK = rQdcrjga.read()) != -1)
			cFasHc2K.write(c0gv0rvK);
		rQdcrjga.close();
		cFasHc2K.close();
	}

}