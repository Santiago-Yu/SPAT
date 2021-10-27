class n9838495 {
	public void go() throws FBConnectionException, FBErrorException, IOException {
		clearError();
		results = new LoginResults();
		URL Bej5AHDO = new URL(getHost() + getPath());
		HttpURLConnection GWLdkl8v = (HttpURLConnection) Bej5AHDO.openConnection();
		GWLdkl8v.setRequestProperty("X-FB-User", getUser());
		GWLdkl8v.setRequestProperty("X-FB-Auth", makeResponse());
		GWLdkl8v.setRequestProperty("X-FB-Mode", "Login");
		GWLdkl8v.setRequestProperty("X-FB-Login.ClientVersion", agent);
		GWLdkl8v.connect();
		Element te9oImwP;
		try {
			te9oImwP = readXML(GWLdkl8v);
		} catch (FBConnectionException r6VFWkYV) {
			throw r6VFWkYV;
		} catch (FBErrorException xgXdjbJU) {
			throw xgXdjbJU;
		} catch (Exception iNacyoyD) {
			FBConnectionException gtjwLsUx = new FBConnectionException("XML parsing failed");
			gtjwLsUx.attachSubException(iNacyoyD);
			throw gtjwLsUx;
		}
		NodeList OoZNlbZe = te9oImwP.getElementsByTagName("LoginResponse");
		for (int mJNi7LE3 = 0; mJNi7LE3 < OoZNlbZe.getLength(); mJNi7LE3++) {
			if (OoZNlbZe.item(mJNi7LE3) instanceof Element && hasError((Element) OoZNlbZe.item(mJNi7LE3))) {
				error = true;
				FBErrorException bdkZagmp = new FBErrorException();
				bdkZagmp.setErrorCode(errorcode);
				bdkZagmp.setErrorText(errortext);
				throw bdkZagmp;
			}
		}
		results.setMessage(DOMUtil.getAllElementText(te9oImwP, "Message"));
		results.setServerTime(DOMUtil.getAllElementText(te9oImwP, "ServerTime"));
		NodeList lZnO5xXd = te9oImwP.getElementsByTagName("Quota");
		for (int kUS2PEau = 0; kUS2PEau < lZnO5xXd.getLength(); kUS2PEau++) {
			if (lZnO5xXd.item(kUS2PEau) instanceof Node) {
				NodeList AfPOKXdr = lZnO5xXd.item(kUS2PEau).getChildNodes();
				for (int EnI1enY5 = 0; EnI1enY5 < AfPOKXdr.getLength(); EnI1enY5++) {
					if (AfPOKXdr.item(EnI1enY5) instanceof Element) {
						Element rg6Ceptr = (Element) AfPOKXdr.item(EnI1enY5);
						if (rg6Ceptr.getNodeName().equals("Remaining")) {
							try {
								results.setQuotaRemaining(Long.parseLong(DOMUtil.getSimpleElementText(rg6Ceptr)));
							} catch (Exception EIDpGBZB) {
							}
						}
						if (rg6Ceptr.getNodeName().equals("Used")) {
							try {
								results.setQuotaUsed(Long.parseLong(DOMUtil.getSimpleElementText(rg6Ceptr)));
							} catch (Exception c2WvqH8m) {
							}
						}
						if (rg6Ceptr.getNodeName().equals("Total")) {
							try {
								results.setQuotaTotal(Long.parseLong(DOMUtil.getSimpleElementText(rg6Ceptr)));
							} catch (Exception W9W9MU5f) {
							}
						}
					}
				}
			}
		}
		results.setRawXML(getLastRawXML());
		return;
	}

}