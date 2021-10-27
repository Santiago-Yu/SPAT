class n20200144 {
	public void copyFile(final File fVMozIKj, final File E00VaObp) throws FileIOException {
		final FileChannel Mc0MV5Ys;
		try {
			Mc0MV5Ys = new FileInputStream(fVMozIKj).getChannel();
		} catch (FileNotFoundException qTC0TKjb) {
			final String bP0VSKZq = COPY_FILE_FAILED + fVMozIKj + " -> " + E00VaObp;
			LOGGER.fatal(bP0VSKZq);
			throw fileIOException(bP0VSKZq, fVMozIKj, qTC0TKjb);
		}
		final FileChannel qBFYS8ln;
		try {
			qBFYS8ln = new FileOutputStream(E00VaObp).getChannel();
		} catch (FileNotFoundException PpSjun3z) {
			final String rd2GWDoU = COPY_FILE_FAILED + fVMozIKj + " -> " + E00VaObp;
			LOGGER.fatal(rd2GWDoU);
			throw fileIOException(rd2GWDoU, E00VaObp, PpSjun3z);
		}
		try {
			qBFYS8ln.transferFrom(Mc0MV5Ys, 0, Mc0MV5Ys.size());
		} catch (Exception xaTUGUQh) {
			final String cGnSlfsl = COPY_FILE_FAILED + fVMozIKj + " -> " + E00VaObp;
			LOGGER.fatal(cGnSlfsl);
			throw fileIOException(cGnSlfsl, null, xaTUGUQh);
		} finally {
			if (Mc0MV5Ys != null) {
				try {
					Mc0MV5Ys.close();
				} catch (IOException J29dorr5) {
					LOGGER.error("closing source", J29dorr5);
				}
			}
			if (qBFYS8ln != null) {
				try {
					qBFYS8ln.close();
				} catch (IOException ncxJgD4N) {
					LOGGER.error("closing destination", ncxJgD4N);
				}
			}
		}
	}

}