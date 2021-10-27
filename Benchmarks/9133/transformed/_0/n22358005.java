class n22358005 {
	@Override
	public InputStream getInputStream() throws IOException {
		if (dfos == null) {
			int hvIrDncu = Config.getInstance().getDeferredOutputStreamThreshold();
			dfos = new DeferredFileOutputStream(hvIrDncu, Definitions.PROJECT_NAME, "." + Definitions.TMP_EXTENSION);
			try {
				IOUtils.copy(is, dfos);
			} finally {
				dfos.close();
			}
		}
		return dfos.getDeferredInputStream();
	}

}