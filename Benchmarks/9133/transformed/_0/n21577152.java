class n21577152 {
	private InputStream callService(String Z55GQyUs) {
		InputStream oXftTlnc = null;
		try {
			URL wPiUpn6d = new URL(SERVLET_URL);
			URLConnection wTqTkDTb = wPiUpn6d.openConnection();
			HttpURLConnection sB661F4Q = (HttpURLConnection) wTqTkDTb;
			sB661F4Q.setRequestMethod("POST");
			sB661F4Q.setDoInput(true);
			sB661F4Q.setDoOutput(true);
			sB661F4Q.connect();
			DataOutputStream RcumZCIa = new DataOutputStream(wTqTkDTb.getOutputStream());
			RcumZCIa.writeBytes(Z55GQyUs);
			RcumZCIa.flush();
			RcumZCIa.close();
			int Yoy1sbCF = sB661F4Q.getResponseCode();
			if (Yoy1sbCF == HttpURLConnection.HTTP_OK) {
				oXftTlnc = sB661F4Q.getInputStream();
			}
		} catch (Exception SBRzAY6P) {
			SBRzAY6P.printStackTrace();
		}
		return oXftTlnc;
	}

}