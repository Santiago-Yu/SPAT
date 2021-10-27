class n9096612 {
	public void include(String href) throws ProteuException {
		try {
			if (!(href.toLowerCase().startsWith("http://"))) {
				requestHead.set("JCN_URL_INCLUDE", href);
				Url.build(this);
			} else {
				java.net.URLConnection urlConn = (new java.net.URL(href)).openConnection();
				Download.sendInputStream(this, urlConn.getInputStream());
			}
		} catch (ProteuException pe) {
			throw pe;
		} catch (Throwable t) {
			logger.error("Include", t);
			throw new ProteuException(t.getMessage(), t);
		}
	}

}