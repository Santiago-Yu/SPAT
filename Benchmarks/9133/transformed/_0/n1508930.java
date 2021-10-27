class n1508930 {
	public String httpRequestByPOST(String VrKR3erg, int jF00jTlZ, List<NameValuePair> UTi0ycPb) {
		String FzxHuokC = "";
		try {
			HttpClient bej0Vl40 = new DefaultHttpClient();
			HttpPost L02QXXAU = new HttpPost(VrKR3erg);
			L02QXXAU.setEntity(new UrlEncodedFormEntity(UTi0ycPb, "UTF-8"));
			HttpResponse iqsfjU4w = bej0Vl40.execute(L02QXXAU);
			StatusLine dt5oXWix = iqsfjU4w.getStatusLine();
			if (dt5oXWix.getStatusCode() < 400) {
				InputStream dIkZVAq6 = iqsfjU4w.getEntity().getContent();
				InputStreamReader QGF7myMe = new InputStreamReader(dIkZVAq6);
				BufferedReader XALrEU0o = new BufferedReader(QGF7myMe);
				StringBuffer tvMeH2UB = new StringBuffer();
				String EsCvl9TW;
				while ((EsCvl9TW = XALrEU0o.readLine()) != null) {
					tvMeH2UB.append(EsCvl9TW);
				}
				FzxHuokC = tvMeH2UB.toString();
				dIkZVAq6.close();
			} else {
				this.lastErrorCode = String.valueOf(dt5oXWix.getStatusCode());
				this.lastErrorMessage = dt5oXWix.getReasonPhrase();
				return null;
			}
		} catch (IOException AMP9kKga) {
			this.lastErrorCode = "-1";
			this.lastErrorMessage = AMP9kKga.getLocalizedMessage();
			return null;
		}
		return FzxHuokC;
	}

}