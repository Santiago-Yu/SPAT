class n2217508 {
	public static void copyFile(final File TnUHx8fG, final File kQqCWVNe) throws IOException {
		if (kQqCWVNe.getParentFile() != null && !kQqCWVNe.getParentFile().mkdirs()) {
			LOG.error("GeneralHelper.copyFile(): Cannot create parent directories from " + kQqCWVNe);
		}
		FileInputStream aCUfnDbg = null;
		FileOutputStream E6OH8LcZ = null;
		FileChannel HJ6gkkF9 = null;
		FileChannel gJSC0Mxh = null;
		try {
			aCUfnDbg = new FileInputStream(TnUHx8fG);
			HJ6gkkF9 = aCUfnDbg.getChannel();
			E6OH8LcZ = new FileOutputStream(kQqCWVNe);
			gJSC0Mxh = E6OH8LcZ.getChannel();
			long ysAq5PAe = 0;
			final long ElT2e1VN = HJ6gkkF9.size();
			while (ysAq5PAe < ElT2e1VN) {
				ysAq5PAe += gJSC0Mxh.transferFrom(HJ6gkkF9, 0, HJ6gkkF9.size());
				gJSC0Mxh.position(ysAq5PAe);
			}
		} finally {
			if (HJ6gkkF9 != null) {
				HJ6gkkF9.close();
			} else if (aCUfnDbg != null) {
				aCUfnDbg.close();
			}
			if (gJSC0Mxh != null) {
				gJSC0Mxh.close();
			} else if (E6OH8LcZ != null) {
				E6OH8LcZ.close();
			}
		}
	}

}