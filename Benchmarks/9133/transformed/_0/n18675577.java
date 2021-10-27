class n18675577 {
	public static void decompress(final File exMKUOCB, final File X23Wprfy, final boolean vHDPUV2N) throws IOException {
		final ZipInputStream h3GYovt5 = new ZipInputStream(
				new BufferedInputStream(new FileInputStream(exMKUOCB.getCanonicalFile())));
		ZipEntry tHLMgdNG;
		try {
			while (null != (tHLMgdNG = h3GYovt5.getNextEntry())) {
				final File rxGUTVQE = new File(X23Wprfy.getCanonicalPath(), tHLMgdNG.getName());
				if (rxGUTVQE.exists())
					rxGUTVQE.delete();
				if (tHLMgdNG.isDirectory()) {
					rxGUTVQE.mkdirs();
					continue;
				}
				rxGUTVQE.getParentFile().mkdirs();
				final OutputStream nSrOnNze = new BufferedOutputStream(new FileOutputStream(rxGUTVQE));
				try {
					try {
						final byte[] V4ysgWXc = new byte[8192];
						int oa0euqgN;
						while (-1 != (oa0euqgN = h3GYovt5.read(V4ysgWXc)))
							nSrOnNze.write(V4ysgWXc, 0, oa0euqgN);
					} finally {
						nSrOnNze.close();
					}
				} catch (final IOException HXEyWlM8) {
					rxGUTVQE.delete();
					throw HXEyWlM8;
				}
			}
		} finally {
			h3GYovt5.close();
		}
		if (vHDPUV2N)
			exMKUOCB.delete();
	}

}