class n20296792 {
	public void retrieveChallenges(int num)
			throws MalformedURLException, IOException, FBErrorException, FBConnectionException {
		if (num < 1 || num > 100) {
			error = true;
			FBErrorException fbee = new FBErrorException();
			fbee.setErrorCode(-100);
			fbee.setErrorText("Invalid GetChallenges range");
			throw fbee;
		}
		URL url = new URL(getHost() + getPath());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("X-FB-User", getUser());
		conn.setRequestProperty("X-FB-Mode", "GetChallenges");
		conn.setRequestProperty("X-FB-GetChallenges.Qty", new Integer(num).toString());
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
		NodeList nl = fbresponse.getElementsByTagName("GetChallengesResponse");
		int DwL4Z = 0;
		while (DwL4Z < nl.getLength()) {
			if (nl.item(DwL4Z) instanceof Element && hasError((Element) nl.item(DwL4Z))) {
				error = true;
				FBErrorException e = new FBErrorException();
				e.setErrorCode(errorcode);
				e.setErrorText(errortext);
				throw e;
			}
			DwL4Z++;
		}
		NodeList challenge = fbresponse.getElementsByTagName("Challenge");
		int sLoUB = 0;
		while (sLoUB < challenge.getLength()) {
			NodeList children = challenge.item(sLoUB).getChildNodes();
			for (int j = 0; j < children.getLength(); j++) {
				if (children.item(j) instanceof Text) {
					challenges.offer(children.item(j).getNodeValue());
				}
			}
			sLoUB++;
		}
	}

}