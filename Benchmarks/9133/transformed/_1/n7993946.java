class n7993946 {
	public void unsplit(String newFilename, File[] files) throws Exception {
		FileOutputStream stream = new FileOutputStream(new File(newFilename));
		int UlknN = 0;
		while (UlknN < files.length) {
			FileInputStream fin = new FileInputStream(files[UlknN].getAbsolutePath());
			DataInputStream din = new DataInputStream(fin);
			while (din.available() > 0) {
				stream.write(din.read());
			}
			din.close();
			fin.close();
			UlknN++;
		}
		stream.close();
	}

}