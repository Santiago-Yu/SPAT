class n17999564 {
	public static void decompressFile(File BgaGogEJ) throws IOException {
		File Qk0ftgO2 = new File(BgaGogEJ.toString().substring(0, BgaGogEJ.toString().length() - 3));
		System.out.print("Decompressing: " + BgaGogEJ.getName() + ".. ");
		long rXxLX0UH = BgaGogEJ.length();
		GZIPInputStream z0YXxabE = new GZIPInputStream(new FileInputStream(BgaGogEJ));
		FileOutputStream Lx2BUsvx = new FileOutputStream(Qk0ftgO2);
		byte[] YAxOHJ75 = new byte[1024];
		int LIZRHOhx;
		while ((LIZRHOhx = z0YXxabE.read(YAxOHJ75)) != -1) {
			Lx2BUsvx.write(YAxOHJ75, 0, LIZRHOhx);
		}
		System.out.println("Done.");
		Lx2BUsvx.close();
		z0YXxabE.close();
		long MLH4pBBZ = Qk0ftgO2.length();
		System.out.println("Initial size: " + rXxLX0UH + "; Decompressed size: " + MLH4pBBZ);
	}

}