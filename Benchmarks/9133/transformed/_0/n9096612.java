class n9096612 {
	public void include(String GL5lATxJ) throws ProteuException {
		try {
			if (GL5lATxJ.toLowerCase().startsWith("http://")) {
				java.net.URLConnection Amftjntr = (new java.net.URL(GL5lATxJ)).openConnection();
				Download.sendInputStream(this, Amftjntr.getInputStream());
			} else {
				requestHead.set("JCN_URL_INCLUDE", GL5lATxJ);
				Url.build(this);
			}
		} catch (ProteuException OWLgGxmX) {
			throw OWLgGxmX;
		} catch (Throwable NNP9H1Fb) {
			logger.error("Include", NNP9H1Fb);
			throw new ProteuException(NNP9H1Fb.getMessage(), NNP9H1Fb);
		}
	}

}