class n20209162 {
	public java.io.File gzip(java.io.File JXiHqzSA) throws Exception {
		java.io.File ENd6fvNp = null;
		InputStream dY3msa5h = null;
		OutputStream xTBEUMjf = null;
		try {
			ENd6fvNp = java.io.File.createTempFile(JXiHqzSA.getName(), ".gz");
			ENd6fvNp.deleteOnExit();
			dY3msa5h = new BufferedInputStream(new FileInputStream(JXiHqzSA));
			xTBEUMjf = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(ENd6fvNp)));
			byte[] aQzymzNL = new byte[4096];
			int KsBBlgto = -1;
			while ((KsBBlgto = dY3msa5h.read(aQzymzNL)) != -1) {
				xTBEUMjf.write(aQzymzNL, 0, KsBBlgto);
			}
			xTBEUMjf.flush();
		} finally {
			xTBEUMjf.close();
			dY3msa5h.close();
		}
		return ENd6fvNp;
	}

}