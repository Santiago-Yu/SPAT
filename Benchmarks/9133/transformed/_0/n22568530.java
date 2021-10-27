class n22568530 {
	private InputStream callService(String qqcxhGZG) {
		InputStream DIPe3yqH = null;
		try {
			URL OVycVvYU = new URL(SERVLET_URL);
			URLConnection nrl0VeaL = OVycVvYU.openConnection();
			HttpURLConnection As3NtzAe = (HttpURLConnection) nrl0VeaL;
			As3NtzAe.setRequestMethod("POST");
			As3NtzAe.setDoInput(true);
			As3NtzAe.setDoOutput(true);
			As3NtzAe.connect();
			DataOutputStream CzzAvLae = new DataOutputStream(nrl0VeaL.getOutputStream());
			CzzAvLae.writeBytes(qqcxhGZG);
			CzzAvLae.flush();
			CzzAvLae.close();
			int fUOIJdWW = As3NtzAe.getResponseCode();
			if (fUOIJdWW == HttpURLConnection.HTTP_OK) {
				DIPe3yqH = As3NtzAe.getInputStream();
			}
		} catch (Exception aMtr9mdR) {
			aMtr9mdR.printStackTrace();
		}
		return DIPe3yqH;
	}

}