class n3121748 {
	private String clientLogin(AuthInfo uEhnz8sT) throws AuthoricationRequiredException {
		logger.fine("clientLogin.");
		try {
			String EYr4dCrx = "https://www.google.com/accounts/ClientLogin";
			HttpPost s6GAfsNA = new HttpPost(EYr4dCrx);
			ArrayList<NameValuePair> g5TtLn1Z = new ArrayList<NameValuePair>();
			g5TtLn1Z.add(new BasicNameValuePair("accountType", "HOSTED_OR_GOOGLE"));
			g5TtLn1Z.add(new BasicNameValuePair("Email", uEhnz8sT.getEmail()));
			g5TtLn1Z.add(new BasicNameValuePair("Passwd", new String(uEhnz8sT.getPassword())));
			g5TtLn1Z.add(new BasicNameValuePair("service", "ah"));
			g5TtLn1Z.add(new BasicNameValuePair("source", "client.kotan-server.appspot.com"));
			s6GAfsNA.setEntity(new UrlEncodedFormEntity(g5TtLn1Z, "UTF-8"));
			HttpResponse bD4z4wN4 = clientManager.httpClient.execute(s6GAfsNA);
			HttpEntity M6zdnUmQ = bD4z4wN4.getEntity();
			if (bD4z4wN4.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				M6zdnUmQ.consumeContent();
				throw new AuthoricationRequiredException(EntityUtils.toString(M6zdnUmQ));
			}
			BufferedReader SROcR1yt = new BufferedReader(new InputStreamReader(M6zdnUmQ.getContent()));
			while (true) {
				String FMMJTmc8 = SROcR1yt.readLine();
				if (FMMJTmc8 == null)
					break;
				if (FMMJTmc8.startsWith("Auth=")) {
					return FMMJTmc8.substring("Auth=".length());
				}
			}
			SROcR1yt.close();
			throw new AuthoricationRequiredException("Login failure.");
		} catch (IOException qQsMLKNn) {
			throw new AuthoricationRequiredException(qQsMLKNn);
		}
	}

}