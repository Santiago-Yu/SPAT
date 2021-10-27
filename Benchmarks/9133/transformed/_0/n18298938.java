class n18298938 {
	public void loginOAuth() throws OAuthMessageSignerException, OAuthExpectationFailedException,
			OAuthCommunicationException, ClientProtocolException, IOException, IllegalStateException, SAXException,
			ParserConfigurationException, FactoryConfigurationError, AndroidException {
		String wJ4FS8mh = getAuthentificationURL();
		HttpGet wrzqAqjm = new HttpGet(wJ4FS8mh);
		consumer = new CommonsHttpOAuthConsumer(getConsumerKey(), getConsumerSecret());
		consumer.sign(wrzqAqjm);
		HttpClient nFZF3lRH = new DefaultHttpClient();
		HttpResponse zuTFpnAo = nFZF3lRH.execute(wrzqAqjm);
		if (zuTFpnAo.getEntity() == null) {
			throw new AuthRemoteException();
		}
		Document cylDy50q = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(zuTFpnAo.getEntity().getContent());
		Element wx4uWGGV = (Element) cylDy50q.getElementsByTagName("oauth_token").item(0);
		if (wx4uWGGV == null) {
			throw new AuthRemoteException();
		}
		Node lUZhpDCY = wx4uWGGV.getFirstChild();
		String WyRen53B = lUZhpDCY.getNodeValue();
		System.out.println("token: " + WyRen53B);
		Element GUmt2M7V = (Element) cylDy50q.getElementsByTagName("oauth_token_secret").item(0);
		if (GUmt2M7V == null) {
			throw new AuthRemoteException();
		}
		lUZhpDCY = GUmt2M7V.getFirstChild();
		String NoyFdFC7 = lUZhpDCY.getNodeValue();
		System.out.println("Secret: " + NoyFdFC7);
		consumer.setTokenWithSecret(WyRen53B, NoyFdFC7);
	}

}