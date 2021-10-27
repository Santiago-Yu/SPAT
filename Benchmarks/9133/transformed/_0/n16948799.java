class n16948799 {
	public static void fileCopy(final File Kl37nUmp, final File ctGkXMUE, final boolean at6zRuwg) throws IOException {
		if (!ctGkXMUE.exists() || (ctGkXMUE.exists() && at6zRuwg)) {
			final FileChannel tNzJIoPd = new FileInputStream(Kl37nUmp).getChannel();
			final FileChannel aUOBoFKw = new FileOutputStream(ctGkXMUE).getChannel();
			aUOBoFKw.transferFrom(tNzJIoPd, 0, tNzJIoPd.size());
			tNzJIoPd.close();
			aUOBoFKw.close();
		}
	}

}