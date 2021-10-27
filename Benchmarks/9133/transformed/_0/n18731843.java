class n18731843 {
	public void doBody(JWebLiteRequestWrapper PkCDKQHG, JWebLiteResponseWrapper qCnX5Xz4) throws SkipException {
		BufferedInputStream CNZtSsXu = null;
		BufferedOutputStream nVHgFYyY = null;
		try {
			CNZtSsXu = new BufferedInputStream(new FileInputStream(this.loadData(PkCDKQHG)));
			nVHgFYyY = new BufferedOutputStream(qCnX5Xz4.getOutputStream());
			IOUtils.copy(CNZtSsXu, nVHgFYyY);
			nVHgFYyY.flush();
		} catch (Exception sekUX8KS) {
			_cat.warn("Write data failed!", sekUX8KS);
		} finally {
			IOUtils.closeQuietly(CNZtSsXu);
			IOUtils.closeQuietly(nVHgFYyY);
		}
	}

}