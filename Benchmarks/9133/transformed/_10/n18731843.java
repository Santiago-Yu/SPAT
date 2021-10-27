class n18731843 {
	public void doBody(JWebLiteRequestWrapper req, JWebLiteResponseWrapper resp) throws SkipException {
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(this.loadData(req)));
			bos = new BufferedOutputStream(resp.getOutputStream());
			IOUtils.copy(bis, bos);
			bos.flush();
		} catch (Exception e) {
			_cat.warn("Write data failed!", e);
		} finally {
			IOUtils.closeQuietly(bis);
			IOUtils.closeQuietly(bos);
		}
	}

}