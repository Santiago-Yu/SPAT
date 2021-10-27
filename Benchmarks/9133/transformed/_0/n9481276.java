class n9481276 {
	public void save(InputStream PY84VxJH) throws IOException {
		File hBWQQACI = Config.getDataFile(getInternalDate(), getPhysMessageID());
		OutputStream Cg0D4Fye = null;
		try {
			Cg0D4Fye = new FileOutputStream(hBWQQACI);
			IOUtils.copyLarge(PY84VxJH, Cg0D4Fye);
		} finally {
			IOUtils.closeQuietly(Cg0D4Fye);
			IOUtils.closeQuietly(PY84VxJH);
		}
	}

}