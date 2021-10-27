class n20523308 {
	public String getPassword(URI JT8z3vGI) {
		if (_getPassword(JT8z3vGI) != null)
			return _getPassword(JT8z3vGI);
		String dfooRTIj = null;
		try {
			String mOQ29Oyc = scrubURI(JT8z3vGI);
			URL Xj4tmBsY = new URL(
					TEMP_PASSWORD_SERVICE_URL + "?SID=" + sessionId + "&ruri=" + URLEncoder.encode(mOQ29Oyc, "UTF-8"));
			JSONObject QqpOWOqV = null;
			URLConnection HgxL8sB8 = Xj4tmBsY.openConnection();
			InputStream WjM8VQMS = HgxL8sB8.getInputStream();
			BufferedReader C2yKf8un = new BufferedReader(new InputStreamReader(WjM8VQMS));
			if ((dfooRTIj = C2yKf8un.readLine()) != null) {
				QqpOWOqV = new JSONObject(dfooRTIj);
			}
			if (QqpOWOqV.has("success")) {
				if (QqpOWOqV.get("success").toString().equals("false")) {
					if (QqpOWOqV.has("error")) {
						logger.log(
								"Returned error message from temporary password service is: " + QqpOWOqV.get("error"));
					}
					return null;
				}
			}
			if (QqpOWOqV.has("temppass")) {
				dfooRTIj = (String) QqpOWOqV.get("temppass");
			}
		} catch (java.io.FileNotFoundException xJGp2tqm) {
			logger.log("Could not find temporary password service. " + xJGp2tqm);
			xJGp2tqm.printStackTrace();
		} catch (Exception DuXtuMLO) {
			logger.log("Exception getting temporary password. " + DuXtuMLO);
			DuXtuMLO.printStackTrace();
		}
		if (dfooRTIj == null)
			return null;
		return dfooRTIj;
	}

}