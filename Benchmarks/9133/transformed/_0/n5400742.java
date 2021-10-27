class n5400742 {
	private void appendAndDelete(FileOutputStream Q2Ylkhp8, String Gr1PHZsv) throws FileNotFoundException, IOException {
		FileInputStream IaVGmKDs = new FileInputStream(Gr1PHZsv);
		byte[] Zif5sOxD = new byte[65536];
		int STjo2Ud5;
		while ((STjo2Ud5 = IaVGmKDs.read(Zif5sOxD)) != -1)
			Q2Ylkhp8.write(Zif5sOxD, 0, STjo2Ud5);
		IaVGmKDs.close();
		new File(Gr1PHZsv).delete();
	}

}