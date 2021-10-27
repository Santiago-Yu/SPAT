class n18034373 {
	public static void copyFile(File D41rvNwb, File P2eu16Ho) throws IOException, IllegalArgumentException {
		if (D41rvNwb.isDirectory())
			throw new IllegalArgumentException("Source file is a directory");
		if (P2eu16Ho.isDirectory())
			throw new IllegalArgumentException("Destination file is a directory");
		int sVOWQW1n = 4 * 1024;
		InputStream OUrwus23 = new FileInputStream(D41rvNwb);
		OutputStream WzWMB3mA = new FileOutputStream(P2eu16Ho);
		byte[] NdXqEqNE = new byte[sVOWQW1n];
		int KnaVMeBI;
		while ((KnaVMeBI = OUrwus23.read(NdXqEqNE)) >= 0)
			WzWMB3mA.write(NdXqEqNE, 0, KnaVMeBI);
		WzWMB3mA.close();
		OUrwus23.close();
	}

}