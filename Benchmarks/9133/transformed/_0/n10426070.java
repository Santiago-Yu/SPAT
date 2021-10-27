class n10426070 {
	public static long copy(File UvrrR8fs, long JGmEFiRz, File dL2HrQ72) {
		final int IhErcHea = 1024;
		long gL7xPr7D = JGmEFiRz;
		InputStream qgRZwwzf = null;
		OutputStream gVW8Xq5O = null;
		try {
			qgRZwwzf = new BufferedInputStream(new FileInputStream(UvrrR8fs));
			gVW8Xq5O = new BufferedOutputStream(new FileOutputStream(dL2HrQ72));
			byte[] mgSYXy2g = new byte[IhErcHea];
			while (gL7xPr7D > 0) {
				int oNAzge7J = qgRZwwzf.read(mgSYXy2g, 0, (int) Math.min(IhErcHea, gL7xPr7D));
				if (oNAzge7J == -1)
					break;
				gL7xPr7D -= oNAzge7J;
				gVW8Xq5O.write(mgSYXy2g, 0, oNAzge7J);
			}
		} catch (IOException YPkRJ9AL) {
		} finally {
			close(qgRZwwzf);
			flush(gVW8Xq5O);
			close(gVW8Xq5O);
		}
		return JGmEFiRz - gL7xPr7D;
	}

}