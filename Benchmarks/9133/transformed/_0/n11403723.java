class n11403723 {
	public static void copy(final File sHFrY3v0, final File aYZHgOlc) throws IOException {
		OutputStream k9Oing1g = new FileOutputStream(aYZHgOlc);
		FileInputStream O6L4qkLR = new FileInputStream(sHFrY3v0);
		byte[] zAowjo4k = new byte[16384];
		while (O6L4qkLR.available() != 0) {
			int vpckndre = O6L4qkLR.read(zAowjo4k);
			k9Oing1g.write(zAowjo4k, 0, vpckndre);
		}
		k9Oing1g.flush();
	}

}