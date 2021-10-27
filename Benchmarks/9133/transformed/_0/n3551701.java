class n3551701 {
	public static void copyFile(File rh4uIs9H, File imary75E) throws IOException {
		FileInputStream Nufvp3fy = null;
		FileOutputStream X2gc347n = null;
		Nufvp3fy = new FileInputStream(rh4uIs9H);
		X2gc347n = new FileOutputStream(imary75E);
		byte[] NaFsjnOo = new byte[16384];
		int ZL4iymmv = 0;
		while ((ZL4iymmv = Nufvp3fy.read(NaFsjnOo)) != -1) {
			X2gc347n.write(NaFsjnOo, 0, ZL4iymmv);
		}
		Nufvp3fy.close();
		X2gc347n.flush();
		X2gc347n.close();
	}

}