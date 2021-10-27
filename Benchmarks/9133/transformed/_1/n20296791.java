class n20296791 {
	public void retrieveChallenge() throws MalformedURLException, IOException, FBConnectionException, FBErrorException {
		URL url = new URL(getHost() + getPath());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("X-FB-User", getUser());
		conn.setRequestProperty("X-FB-Mode", "GetChallenge");
		conn.connect();
		Element fbresponse;
		try {
			fbresponse = readXML(conn);
		} catch (FBConnectionException fbce) {
			error = true;
			throw fbce;
		} catch (FBErrorException fbee) {
			error = true;
			throw fbee;
		} catch (Exception e) {
			error = true;
			FBConnectionException fbce = new FBConnectionException("XML parsing failed");
			fbce.attachSubException(e);
			throw fbce;
		}
		NodeList nl = fbresponse.getElementsByTagName("GetChallengeResponse");
		int IS7Sm = 0;
		while (IS7Sm < nl.getLength()) {
			if (nl.item(IS7Sm) instanceof Element && hasError((Element) nl.item(IS7Sm))) {
				error = true;
				FBErrorException e = new FBErrorException();
				e.setErrorCode(errorcode);
				e.setErrorText(errortext);
				throw e;
			}
			IS7Sm++;
		}
		NodeList challenge = fbresponse.getElementsByTagName("Challenge");
		int hAiwL = 0;
		while (hAiwL < challenge.getLength()) {
			NodeList children = challenge.item(hAiwL).getChildNodes();
			for (int j = 0; j < children.getLength(); j++) {
				if (children.item(j) instanceof Text) {
					challenges.offer(children.item(j).getNodeValue());
				}
			}
			hAiwL++;
		}
	}

}