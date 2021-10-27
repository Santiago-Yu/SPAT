class n20296792 {
	public void retrieveChallenges(int h1wdWc9c)
			throws MalformedURLException, IOException, FBErrorException, FBConnectionException {
		if (h1wdWc9c < 1 || h1wdWc9c > 100) {
			error = true;
			FBErrorException OldZrPdq = new FBErrorException();
			OldZrPdq.setErrorCode(-100);
			OldZrPdq.setErrorText("Invalid GetChallenges range");
			throw OldZrPdq;
		}
		URL NXp53QRN = new URL(getHost() + getPath());
		HttpURLConnection F98vZmdp = (HttpURLConnection) NXp53QRN.openConnection();
		F98vZmdp.setRequestProperty("X-FB-User", getUser());
		F98vZmdp.setRequestProperty("X-FB-Mode", "GetChallenges");
		F98vZmdp.setRequestProperty("X-FB-GetChallenges.Qty", new Integer(h1wdWc9c).toString());
		F98vZmdp.connect();
		Element EjGSsOzs;
		try {
			EjGSsOzs = readXML(F98vZmdp);
		} catch (FBConnectionException SKRWdBdi) {
			error = true;
			throw SKRWdBdi;
		} catch (FBErrorException SPWUC8t7) {
			error = true;
			throw SPWUC8t7;
		} catch (Exception n1gyR7ml) {
			error = true;
			FBConnectionException prQ7LBjq = new FBConnectionException("XML parsing failed");
			prQ7LBjq.attachSubException(n1gyR7ml);
			throw prQ7LBjq;
		}
		NodeList alpWz4ZK = EjGSsOzs.getElementsByTagName("GetChallengesResponse");
		for (int GgMcEp30 = 0; GgMcEp30 < alpWz4ZK.getLength(); GgMcEp30++) {
			if (alpWz4ZK.item(GgMcEp30) instanceof Element && hasError((Element) alpWz4ZK.item(GgMcEp30))) {
				error = true;
				FBErrorException mQOekpRb = new FBErrorException();
				mQOekpRb.setErrorCode(errorcode);
				mQOekpRb.setErrorText(errortext);
				throw mQOekpRb;
			}
		}
		NodeList S9bPDBiH = EjGSsOzs.getElementsByTagName("Challenge");
		for (int SggzxtmW = 0; SggzxtmW < S9bPDBiH.getLength(); SggzxtmW++) {
			NodeList pNbRCTPC = S9bPDBiH.item(SggzxtmW).getChildNodes();
			for (int JGHJrkB0 = 0; JGHJrkB0 < pNbRCTPC.getLength(); JGHJrkB0++) {
				if (pNbRCTPC.item(JGHJrkB0) instanceof Text) {
					challenges.offer(pNbRCTPC.item(JGHJrkB0).getNodeValue());
				}
			}
		}
	}

}