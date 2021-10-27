class n14879478 {
	public static void copyFile(File xZFpovSZ, File bPA7iIW5) throws IOException {
		BufferedInputStream Jjs845cK = new BufferedInputStream(new FileInputStream(xZFpovSZ));
		BufferedOutputStream NpBMfFOk = new BufferedOutputStream(new FileOutputStream(bPA7iIW5));
		byte[] Kj2RTbAV = new byte[1024];
		int xo1Cvhb9 = 0;
		while ((xo1Cvhb9 = Jjs845cK.read(Kj2RTbAV, 0, 1024)) != -1)
			NpBMfFOk.write(Kj2RTbAV, 0, xo1Cvhb9);
		Jjs845cK.close();
		NpBMfFOk.close();
	}

}