class n14138097 {
	public static void copy(File X78zpCMz, File oEOHmh0M) throws IOException {
		if (oEOHmh0M.exists() && oEOHmh0M.isFile()) {
			logger.fine("cp " + X78zpCMz + " " + oEOHmh0M + " -- Destination file " + oEOHmh0M
					+ " already exists. Deleting...");
			oEOHmh0M.delete();
		}
		final File inNNMeD0 = oEOHmh0M.getParentFile();
		if (!inNNMeD0.exists()) {
			logger.info("Directory to contain destination does not exist. Creating...");
			inNNMeD0.mkdirs();
		}
		final FileInputStream A7ghyR7c = new FileInputStream(X78zpCMz);
		final FileOutputStream Z3MHgOWE = new FileOutputStream(oEOHmh0M);
		final byte[] g9tZEOUt = new byte[2048];
		int U27sciyv;
		while ((U27sciyv = A7ghyR7c.read(g9tZEOUt)) != -1)
			Z3MHgOWE.write(g9tZEOUt, 0, U27sciyv);
		A7ghyR7c.close();
		Z3MHgOWE.close();
	}

}