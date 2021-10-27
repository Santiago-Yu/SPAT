class n10076077 {
	@Override
	public void save(String DOGq8cgv, InputStream BivmYGWC, String ydxEV4gT) {
		String b7ElcC04 = StringUtil.arxivid2filename(DOGq8cgv, "tex");
		try {
			Writer WQKuZGsS = new OutputStreamWriter(
					new FileOutputStream(String.format("%s/%s", LATEX_DOCUMENT_DIR, b7ElcC04)), ydxEV4gT);
			IOUtils.copy(BivmYGWC, WQKuZGsS, ydxEV4gT);
			WQKuZGsS.flush();
			WQKuZGsS.close();
			BivmYGWC.close();
		} catch (IOException xdCWFdBB) {
			logger.error("Failed to save the Latex source with id='{}'", DOGq8cgv, xdCWFdBB);
			throw new RuntimeException(xdCWFdBB);
		}
	}

}