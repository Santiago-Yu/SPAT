class n3874060 {
	public static void copyFile(File p5ddk0Ar, File sUzZ71tA) throws IOException {
		if (p5ddk0Ar == null || sUzZ71tA == null) {
			throw new NullPointerException("Source file and target file must not be null");
		}
		File XabGg3KD = sUzZ71tA.getParentFile();
		if (!XabGg3KD.exists() && !XabGg3KD.mkdirs()) {
			throw new IOException("Could not create directory '" + XabGg3KD + "'");
		}
		InputStream NNPjHQrC = null;
		OutputStream IGsaA6QU = null;
		try {
			NNPjHQrC = new BufferedInputStream(new FileInputStream(p5ddk0Ar));
			IGsaA6QU = new BufferedOutputStream(new FileOutputStream(sUzZ71tA));
			try {
				byte[] X50kDbnu = new byte[32768];
				for (int SynF4CDD = NNPjHQrC.read(X50kDbnu); SynF4CDD > 0; SynF4CDD = NNPjHQrC.read(X50kDbnu)) {
					IGsaA6QU.write(X50kDbnu, 0, SynF4CDD);
				}
			} catch (IOException hlHL0087) {
				sUzZ71tA.delete();
				throw hlHL0087;
			}
		} finally {
			if (NNPjHQrC != null) {
				try {
					NNPjHQrC.close();
				} catch (IOException TpL1YDqx) {
				}
			}
			if (IGsaA6QU != null) {
				try {
					IGsaA6QU.close();
				} catch (IOException U7RS64AK) {
				}
			}
		}
	}

}