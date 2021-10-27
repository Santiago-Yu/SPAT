class n20296791 {
	public void retrieveChallenge() throws MalformedURLException, IOException, FBConnectionException, FBErrorException {
		URL pmG436gc = new URL(getHost() + getPath());
		HttpURLConnection p3lazqGa = (HttpURLConnection) pmG436gc.openConnection();
		p3lazqGa.setRequestProperty("X-FB-User", getUser());
		p3lazqGa.setRequestProperty("X-FB-Mode", "GetChallenge");
		p3lazqGa.connect();
		Element kXbrLUpm;
		try {
			kXbrLUpm = readXML(p3lazqGa);
		} catch (FBConnectionException Djj6UePA) {
			error = true;
			throw Djj6UePA;
		} catch (FBErrorException IH8zUswd) {
			error = true;
			throw IH8zUswd;
		} catch (Exception sUkAm7tG) {
			error = true;
			FBConnectionException ZPnJg1wW = new FBConnectionException("XML parsing failed");
			ZPnJg1wW.attachSubException(sUkAm7tG);
			throw ZPnJg1wW;
		}
		NodeList lXVYkOXD = kXbrLUpm.getElementsByTagName("GetChallengeResponse");
		for (int Kh1Hv4gR = 0; Kh1Hv4gR < lXVYkOXD.getLength(); Kh1Hv4gR++) {
			if (lXVYkOXD.item(Kh1Hv4gR) instanceof Element && hasError((Element) lXVYkOXD.item(Kh1Hv4gR))) {
				error = true;
				FBErrorException bVBVVDba = new FBErrorException();
				bVBVVDba.setErrorCode(errorcode);
				bVBVVDba.setErrorText(errortext);
				throw bVBVVDba;
			}
		}
		NodeList hoQMwUpP = kXbrLUpm.getElementsByTagName("Challenge");
		for (int oCbZXj85 = 0; oCbZXj85 < hoQMwUpP.getLength(); oCbZXj85++) {
			NodeList mgquuE9y = hoQMwUpP.item(oCbZXj85).getChildNodes();
			for (int k2uDcjoc = 0; k2uDcjoc < mgquuE9y.getLength(); k2uDcjoc++) {
				if (mgquuE9y.item(k2uDcjoc) instanceof Text) {
					challenges.offer(mgquuE9y.item(k2uDcjoc).getNodeValue());
				}
			}
		}
	}

}