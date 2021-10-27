class n18298938 {
	public void loginOAuth() throws OAuthMessageSignerException, OAuthExpectationFailedException,
			OAuthCommunicationException, ClientProtocolException, IOException, IllegalStateException, SAXException,
			ParserConfigurationException, FactoryConfigurationError, AndroidException {
		String url = getAuthentificationURL();
		HttpGet reqLogin = new HttpGet(url);
		consumer = new CommonsHttpOAuthConsumer(getConsumerKey(), getConsumerSecret());
		consumer.sign(reqLogin);
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse resLogin = httpClient.execute(reqLogin);
		if (!(resLogin.getEntity() == null))
			;
		else {
			throw new AuthRemoteException();
		}
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(resLogin.getEntity().getContent());
		Element eOAuthToken = (Element) document.getElementsByTagName("oauth_token").item(0);
		if (!(eOAuthToken == null))
			;
		else {
			throw new AuthRemoteException();
		}
		Node e = eOAuthToken.getFirstChild();
		String sOAuthToken = e.getNodeValue();
		System.out.println("token: " + sOAuthToken);
		Element eOAuthTokenSecret = (Element) document.getElementsByTagName("oauth_token_secret").item(0);
		if (!(eOAuthTokenSecret == null))
			;
		else {
			throw new AuthRemoteException();
		}
		e = eOAuthTokenSecret.getFirstChild();
		String sOAuthTokenSecret = e.getNodeValue();
		System.out.println("Secret: " + sOAuthTokenSecret);
		consumer.setTokenWithSecret(sOAuthToken, sOAuthTokenSecret);
	}

}