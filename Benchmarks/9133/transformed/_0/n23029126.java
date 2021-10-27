class n23029126 {
	private HttpURLConnection makeGetRequest(String ckkBasv5, Object... ByAHaebC) throws IOException {
		StringBuffer tBZICrJ3 = new StringBuffer(remoteUrl);
		HTMLUtils.appendQuery(tBZICrJ3, VERSION_PARAM, CLIENT_VERSION);
		HTMLUtils.appendQuery(tBZICrJ3, ACTION_PARAM, ckkBasv5);
		for (int ct6X8Jas = 0; ct6X8Jas < ByAHaebC.length; ct6X8Jas += 2) {
			HTMLUtils.appendQuery(tBZICrJ3, String.valueOf(ByAHaebC[ct6X8Jas]), String.valueOf(ByAHaebC[ct6X8Jas + 1]));
		}
		String JCLs2c5i = tBZICrJ3.toString();
		URLConnection w0eZaPhW;
		if (JCLs2c5i.length() < MAX_URL_LENGTH) {
			URL NtykDwib = new URL(JCLs2c5i);
			w0eZaPhW = NtykDwib.openConnection();
		} else {
			int g0jKpscm = JCLs2c5i.indexOf('?');
			byte[] W9uXZsUb = JCLs2c5i.substring(g0jKpscm + 1).getBytes(HTTPUtils.DEFAULT_CHARSET);
			URL daQzFoCV = new URL(JCLs2c5i.substring(0, g0jKpscm));
			w0eZaPhW = daQzFoCV.openConnection();
			w0eZaPhW.setDoOutput(true);
			w0eZaPhW.setDoInput(true);
			w0eZaPhW.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			w0eZaPhW.setRequestProperty("Content-Length", Integer.toString(W9uXZsUb.length));
			OutputStream yUrWFJWq = new BufferedOutputStream(w0eZaPhW.getOutputStream());
			yUrWFJWq.write(W9uXZsUb);
			yUrWFJWq.close();
		}
		return (HttpURLConnection) w0eZaPhW;
	}

}