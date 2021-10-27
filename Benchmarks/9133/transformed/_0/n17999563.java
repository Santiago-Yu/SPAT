class n17999563 {
	public static void compressFile(File E9JpBusN) throws IOException {
		File TrrK4n6K = new File(E9JpBusN.toString() + ".gz");
		System.out.print("Compressing: " + E9JpBusN.getName() + ".. ");
		long RUAH2C3q = E9JpBusN.length();
		FileInputStream i7lbhEgb = new FileInputStream(E9JpBusN);
		GZIPOutputStream sObF5v2g = new GZIPOutputStream(new FileOutputStream(TrrK4n6K));
		byte[] ApPEd3NX = new byte[1024];
		int cIPbhHpj;
		while ((cIPbhHpj = i7lbhEgb.read(ApPEd3NX)) != -1) {
			sObF5v2g.write(ApPEd3NX, 0, cIPbhHpj);
		}
		System.out.println("Done.");
		i7lbhEgb.close();
		sObF5v2g.close();
		long UF0hTYPW = TrrK4n6K.length();
		System.out.println("Initial size: " + RUAH2C3q + "; Compressed size: " + UF0hTYPW);
	}

}