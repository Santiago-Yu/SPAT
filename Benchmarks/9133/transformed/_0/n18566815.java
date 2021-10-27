class n18566815 {
	protected void copyAndDelete(final URL evODFEjb, final long T4GY5L05) throws IOException {
		final File ZKpjrWGV = getStorageFile(evODFEjb, T4GY5L05);
		final File UfPnVuyA = new File(evODFEjb.getFile());
		FileChannel LQK3MAbm = null;
		FileChannel hRmHgtK3 = null;
		if (ZKpjrWGV.equals(UfPnVuyA)) {
			return;
		}
		try {
			readWriteLock_.lockWrite();
			if (UfPnVuyA.exists()) {
				UfPnVuyA.delete();
			}
			if (ZKpjrWGV.exists() && !ZKpjrWGV.renameTo(UfPnVuyA)) {
				LQK3MAbm = new FileInputStream(ZKpjrWGV).getChannel();
				hRmHgtK3 = new FileOutputStream(UfPnVuyA).getChannel();
				final long xCx07z3u = LQK3MAbm.size();
				final long RUBlEozh = hRmHgtK3.transferFrom(LQK3MAbm, 0, LQK3MAbm.size());
				if (xCx07z3u != RUBlEozh) {
					throw new IOException("unable to complete write");
				}
			}
		} finally {
			readWriteLock_.unlockWrite();
			try {
				if (LQK3MAbm != null) {
					LQK3MAbm.close();
				}
			} catch (final IOException hY8S1Pr8) {
				FuLog.error(hY8S1Pr8);
			}
			try {
				if (hRmHgtK3 != null) {
					hRmHgtK3.close();
				}
			} catch (final IOException xSxAPccC) {
				FuLog.error(xSxAPccC);
			}
			ZKpjrWGV.delete();
		}
	}

}