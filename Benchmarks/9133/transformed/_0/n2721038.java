class n2721038 {
	public File copyFile(File c8IZymH1) throws IOException {
		File NAy54z3e = createNewFile("fm", "cpy");
		FileOutputStream mHlpBErs = new FileOutputStream(NAy54z3e);
		FileChannel jhCvxomy = mHlpBErs.getChannel();
		FileInputStream j4aKWmTg = new FileInputStream(c8IZymH1);
		FileChannel LPge94mD = j4aKWmTg.getChannel();
		jhCvxomy.transferFrom(LPge94mD, 0, LPge94mD.size());
		jhCvxomy.close();
		LPge94mD.close();
		return NAy54z3e;
	}

}