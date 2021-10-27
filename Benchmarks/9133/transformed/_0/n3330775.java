class n3330775 {
	public static JSONObject getJSONData(String rkFQJhdO) throws JSONException {
		JSONObject gRmOUDY4 = null;
		InputStream scJDN1Ta = null;
		DefaultHttpClient z5Mn9N55 = new DefaultHttpClient();
		URI QUMS3pxM;
		try {
			QUMS3pxM = new URI(rkFQJhdO);
			HttpGet Tco2StA6 = new HttpGet(QUMS3pxM);
			HttpResponse VIB1e37W = z5Mn9N55.execute(Tco2StA6);
			scJDN1Ta = VIB1e37W.getEntity().getContent();
			String RW5lbRWn;
			StringBuilder jFkB7dKi = new StringBuilder();
			BufferedReader etPbLOnr;
			etPbLOnr = new BufferedReader(new InputStreamReader(scJDN1Ta), 8192);
			while ((RW5lbRWn = etPbLOnr.readLine()) != null)
				jFkB7dKi.append(RW5lbRWn);
			etPbLOnr.close();
			gRmOUDY4 = (JSONObject) new JSONTokener(jFkB7dKi.toString()).nextValue();
		} catch (Exception U4nuiKwN) {
			U4nuiKwN.printStackTrace();
		}
		return gRmOUDY4;
	}

}