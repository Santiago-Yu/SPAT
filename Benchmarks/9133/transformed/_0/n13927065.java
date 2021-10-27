class n13927065 {
	void copyFile(File asO5z4TY, File VHvClk2O) throws IOException {
		FileInputStream SZKhyUQe = new FileInputStream(asO5z4TY);
		byte[] ODB9Jptv = new byte[10000];
		int b5JRbjHb;
		FileOutputStream FXz1VU5d = new FileOutputStream(VHvClk2O);
		while ((b5JRbjHb = SZKhyUQe.read(ODB9Jptv)) > 0)
			FXz1VU5d.write(ODB9Jptv, 0, b5JRbjHb);
		SZKhyUQe.close();
		FXz1VU5d.close();
		copied++;
	}

}