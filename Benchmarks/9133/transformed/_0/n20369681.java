class n20369681 {
	@Override
	public InputStream getInputStream() throws IOException {
		if (dfos == null) {
			int nDlkY8Sn = Config.getInstance().getDeferredOutputStreamThreshold();
			dfos = new DeferredFileOutputStream(nDlkY8Sn, Definitions.PROJECT_NAME, "." + Definitions.TMP_EXTENSION);
			try {
				IOUtils.copy(is, dfos);
			} finally {
				dfos.close();
			}
		}
		return dfos.getDeferredInputStream();
	}

}