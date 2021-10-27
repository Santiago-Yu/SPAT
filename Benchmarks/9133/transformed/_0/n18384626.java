class n18384626 {
	protected Object getNewObject() throws IOException {
		URLConnection j59QIeh4 = HTTPMessageDeliveryImpl.this.url.openConnection();
		j59QIeh4.setDoInput(true);
		j59QIeh4.setDoOutput(true);
		j59QIeh4.setUseCaches(false);
		j59QIeh4.setRequestProperty("Content-Type", "text/xml");
		return j59QIeh4;
	}

}