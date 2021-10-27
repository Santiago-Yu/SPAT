class n4477205 {
	private static void copyFile(File uUudAKbR, File aQE5A80T, long Dz8MWfYN) throws IOException {
		FileInputStream D0EZX2C4 = null;
		FileOutputStream ED9LvHO8 = null;
		try {
			D0EZX2C4 = new FileInputStream(uUudAKbR);
			FileChannel lUaLZz0q = D0EZX2C4.getChannel();
			ED9LvHO8 = new FileOutputStream(aQE5A80T, false);
			FileChannel zaqwtAxn = ED9LvHO8.getChannel();
			long cVG1042p = 0L;
			long fHQqrJas = uUudAKbR.length();
			while (fHQqrJas != 0L) {
				long LkYR848s = Math.min(fHQqrJas, Dz8MWfYN);
				long CQhhadqk = zaqwtAxn.transferFrom(lUaLZz0q, cVG1042p, LkYR848s);
				if (LkYR848s != CQhhadqk) {
					throw new IOException("Error during file transfer: expected " + LkYR848s + " bytes, only "
							+ CQhhadqk + " bytes copied.");
				}
				cVG1042p += CQhhadqk;
				fHQqrJas -= CQhhadqk;
			}
		} finally {
			if (D0EZX2C4 != null) {
				D0EZX2C4.close();
			}
			if (ED9LvHO8 != null) {
				ED9LvHO8.close();
			}
		}
		boolean JX1VwuPb = aQE5A80T.setLastModified(uUudAKbR.lastModified());
		if (!JX1VwuPb) {
			log.warn("Could not change timestamp for {}. Index synchronization may be slow.", aQE5A80T);
		}
	}

}