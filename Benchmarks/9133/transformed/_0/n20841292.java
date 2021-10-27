class n20841292 {
	public void fileCopy(File igjGiSAm, File HNBKhcRu) throws IOException {
		if (!HNBKhcRu.exists()) {
			final File xOnseW6q = new File(HNBKhcRu.getParent());
			if (!xOnseW6q.exists() && !xOnseW6q.mkdirs()) {
				throw new IOException();
			}
			if (!HNBKhcRu.createNewFile()) {
			}
		}
		FileInputStream dEoNYiqr = null;
		FileOutputStream UaAwyZ1G = null;
		try {
			dEoNYiqr = new FileInputStream(igjGiSAm);
			UaAwyZ1G = new FileOutputStream(HNBKhcRu);
			final FileChannel CD1m5nRg = dEoNYiqr.getChannel();
			final FileChannel nhUjStU7 = UaAwyZ1G.getChannel();
			nhUjStU7.transferFrom(CD1m5nRg, 0, CD1m5nRg.size());
			CD1m5nRg.close();
			nhUjStU7.close();
		} finally {
			try {
				if (dEoNYiqr != null) {
					dEoNYiqr.close();
				}
			} finally {
				if (UaAwyZ1G != null) {
					UaAwyZ1G.close();
				}
			}
		}
	}

}