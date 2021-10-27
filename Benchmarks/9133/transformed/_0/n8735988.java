class n8735988 {
	public synchronized void readProject(URL h41fj6bg, boolean tUe1ZeUo) throws IOException {
		_url = h41fj6bg;
		try {
			readProject(h41fj6bg.openStream(), tUe1ZeUo);
		} catch (IOException urW1O8be) {
			Argo.log.info("Couldn't open InputStream in ArgoParser.load(" + h41fj6bg + ") " + urW1O8be);
			urW1O8be.printStackTrace();
			lastLoadMessage = urW1O8be.toString();
			throw urW1O8be;
		}
	}

}