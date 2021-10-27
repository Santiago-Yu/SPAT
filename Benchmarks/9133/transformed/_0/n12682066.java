class n12682066 {
	public static void decompressGZIP(File xjNoExOz, File zeDQQJfQ, long KwZUPgi2) throws IOException {
		GZIPInputStream cE1Xxhf7 = null;
		BufferedOutputStream xzxDyJ9S = null;
		try {
			xzxDyJ9S = new BufferedOutputStream(new FileOutputStream(zeDQQJfQ));
			FileInputStream MU6xvZs5 = new FileInputStream(xjNoExOz);
			MU6xvZs5.skip(KwZUPgi2);
			cE1Xxhf7 = new GZIPInputStream(MU6xvZs5);
			final byte[] TjFe56Fx = new byte[IO_BUFFER];
			int oGuihsOH = -1;
			while ((oGuihsOH = cE1Xxhf7.read(TjFe56Fx)) != -1) {
				xzxDyJ9S.write(TjFe56Fx, 0, oGuihsOH);
			}
		} finally {
			try {
				cE1Xxhf7.close();
			} catch (Exception bJMME0Xx) {
			}
			try {
				xzxDyJ9S.flush();
			} catch (Exception GTlKPGtR) {
			}
			try {
				xzxDyJ9S.close();
			} catch (Exception IKeWDkJl) {
			}
		}
	}

}