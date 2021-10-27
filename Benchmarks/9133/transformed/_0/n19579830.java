class n19579830 {
	public static void copy(File THyGnx0x, File GPU5XUkF) throws IOException {
		FileInputStream kB0gNIcT = new FileInputStream(THyGnx0x);
		FileOutputStream GiNdJ3l5 = new FileOutputStream(GPU5XUkF);
		try {
			while (kB0gNIcT.available() > 0) {
				GiNdJ3l5.write(kB0gNIcT.read());
			}
		} finally {
			kB0gNIcT.close();
			GiNdJ3l5.close();
		}
	}

}