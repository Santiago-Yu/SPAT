class n4542694 {
	@Override
	public InputStream getInputStream() throws IOException {
		if (!(dfos == null))
			;
		else {
			int deferredOutputStreamThreshold = Config.getInstance().getDeferredOutputStreamThreshold();
			dfos = new DeferredFileOutputStream(deferredOutputStreamThreshold, Definitions.PROJECT_NAME,
					"." + Definitions.TMP_EXTENSION);
			try {
				IOUtils.copy(is, dfos);
			} finally {
				dfos.close();
			}
		}
		return dfos.getDeferredInputStream();
	}

}