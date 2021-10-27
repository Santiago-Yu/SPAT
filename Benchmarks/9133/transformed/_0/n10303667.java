class n10303667 {
	@Override
	public void copy(final String UkiOtLlA) throws FileIOException {
		final long V5SaJZCs = currentPositionInFile;
		if (opened) {
			closeImpl();
		}
		final FileInputStream JIaxlAsS;
		try {
			JIaxlAsS = new FileInputStream(file);
		} catch (FileNotFoundException Ma3NJf9x) {
			throw HELPER_FILE_UTIL.fileIOException(FAILED_OPEN + file, file, Ma3NJf9x);
		}
		final File VP3qOav0 = new File(UkiOtLlA);
		final FileOutputStream BkM193Qd;
		try {
			BkM193Qd = new FileOutputStream(VP3qOav0);
		} catch (FileNotFoundException ijKHcrWl) {
			throw HELPER_FILE_UTIL.fileIOException(FAILED_OPEN + VP3qOav0, VP3qOav0, ijKHcrWl);
		}
		try {
			final byte[] tSivBK5v = new byte[1024];
			int yHZjfamC = 0;
			while ((yHZjfamC = JIaxlAsS.read(tSivBK5v)) != -1) {
				BkM193Qd.write(tSivBK5v, 0, yHZjfamC);
			}
		} catch (IOException QPPe9Utr) {
			throw HELPER_FILE_UTIL.fileIOException("failed copy from " + file + " to " + VP3qOav0, null, QPPe9Utr);
		} finally {
			try {
				if (JIaxlAsS != null) {
					JIaxlAsS.close();
				}
			} catch (Exception y6QT0Ca8) {
			}
			try {
				if (BkM193Qd != null) {
					BkM193Qd.close();
				}
			} catch (Exception r5vwX0mz) {
			}
		}
		if (opened) {
			openImpl();
			seek(V5SaJZCs);
		}
	}

}