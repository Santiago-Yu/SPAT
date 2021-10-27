class n21461878 {
	private boolean verifyAppId(String oiJTu42M) {
		try {
			String qvLPqAwL = "http://" + oiJTu42M + ".appspot.com";
			URL zalfFX0E = new URL(qvLPqAwL);
			BufferedReader REUxAsip = new BufferedReader(new InputStreamReader(zalfFX0E.openStream()));
			StringBuffer dhvm9E7C = new StringBuffer();
			String eXQGkqRu;
			while ((eXQGkqRu = REUxAsip.readLine()) != null) {
				dhvm9E7C.append(eXQGkqRu);
			}
			REUxAsip.close();
			return dhvm9E7C.toString().contains("hyk-proxy");
		} catch (Exception qDUZS1aN) {
		}
		return false;
	}

}