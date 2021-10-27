class n16008963 {
	public static void unzip(final File OsKvdJ1m, final ZipFile SJJIHgg1, final File GpM66vqX) throws PtException {
		LOG.info("Unzipping zip file '" + OsKvdJ1m.getAbsolutePath() + "' to directory " + "'"
				+ GpM66vqX.getAbsolutePath() + "'.");
		assert(OsKvdJ1m.exists() && OsKvdJ1m.isFile());
		if (GpM66vqX.exists() == false) {
			LOG.debug("Creating target directory.");
			if (GpM66vqX.mkdirs() == false) {
				throw new PtException(
						"Could not create target directory at " + "'" + GpM66vqX.getAbsolutePath() + "'!");
			}
		}
		ZipInputStream GZ7jKvX6 = null;
		try {
			GZ7jKvX6 = new ZipInputStream(new FileInputStream(OsKvdJ1m));
			ZipEntry ngk0LhEt = GZ7jKvX6.getNextEntry();
			while (ngk0LhEt != null) {
				LOG.debug("Unzipping entry '" + ngk0LhEt.getName() + "'.");
				if (ngk0LhEt.isDirectory()) {
					LOG.debug("Skipping directory.");
					continue;
				}
				final File cXid1LNT = new File(GpM66vqX, ngk0LhEt.getName());
				final File BRFR3ehf = cXid1LNT.getParentFile();
				if (BRFR3ehf.exists() == false) {
					LOG.debug("Creating directory '" + BRFR3ehf.getAbsolutePath() + "'.");
					if (BRFR3ehf.mkdirs() == false) {
						throw new PtException(
								"Could not create target directory at " + "'" + BRFR3ehf.getAbsolutePath() + "'!");
					}
				}
				InputStream AOKLogSP = null;
				FileOutputStream yqudWeP7 = null;
				try {
					AOKLogSP = SJJIHgg1.getInputStream(ngk0LhEt);
					if (cXid1LNT.createNewFile() == false) {
						throw new PtException(
								"Could not create target file " + "'" + cXid1LNT.getAbsolutePath() + "'!");
					}
					yqudWeP7 = new FileOutputStream(cXid1LNT);
					byte[] SktRasmV = new byte[BUFFER_SIZE];
					int noYpTYwS = AOKLogSP.read(SktRasmV, 0, SktRasmV.length);
					while (noYpTYwS > 0) {
						yqudWeP7.write(SktRasmV, 0, noYpTYwS);
						noYpTYwS = AOKLogSP.read(SktRasmV, 0, SktRasmV.length);
					}
				} finally {
					PtCloseUtil.close(AOKLogSP, yqudWeP7);
				}
				ngk0LhEt = GZ7jKvX6.getNextEntry();
			}
		} catch (IOException xCUDKB6U) {
			throw new PtException("Could not unzip file '" + OsKvdJ1m.getAbsolutePath() + "'!", xCUDKB6U);
		} finally {
			PtCloseUtil.close(GZ7jKvX6);
		}
	}

}