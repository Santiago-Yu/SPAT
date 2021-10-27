class n19718986 {
	public static void concatenateToDestFile(File Dqqyhixk, File w6BUDO7J) throws IOException {
		if (!w6BUDO7J.exists()) {
			if (!w6BUDO7J.createNewFile()) {
				throw new IllegalArgumentException("Could not create destination file:" + w6BUDO7J.getName());
			}
		}
		BufferedOutputStream SnV5Nk2t = null;
		BufferedInputStream KYv9qpyD = null;
		byte[] SGAw6dNK = new byte[1024];
		try {
			SnV5Nk2t = new BufferedOutputStream(new FileOutputStream(w6BUDO7J, true));
			KYv9qpyD = new BufferedInputStream(new FileInputStream(Dqqyhixk));
			while (true) {
				int I2nnKg7T = KYv9qpyD.read(SGAw6dNK, 0, SGAw6dNK.length);
				if (I2nnKg7T == -1) {
					break;
				}
				SnV5Nk2t.write(SGAw6dNK, 0, I2nnKg7T);
			}
		} finally {
			if (SnV5Nk2t != null) {
				SnV5Nk2t.close();
			}
			if (KYv9qpyD != null) {
				KYv9qpyD.close();
			}
		}
	}

}