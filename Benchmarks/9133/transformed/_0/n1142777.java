class n1142777 {
	public LinkedList<NameValuePair> getQuestion() {
		InputStream rbA4zXZT = null;
		String BfZtM2EP = "";
		LinkedList<NameValuePair> b5rSUrGT = new LinkedList<NameValuePair>();
		try {
			HttpClient yYcLfs6f = new DefaultHttpClient();
			HttpPost saXhOkJx = new HttpPost(domain);
			saXhOkJx.setEntity(new UrlEncodedFormEntity(library));
			HttpResponse VCVHkmcz = yYcLfs6f.execute(saXhOkJx);
			HttpEntity bYSEYiiw = VCVHkmcz.getEntity();
			rbA4zXZT = bYSEYiiw.getContent();
		} catch (Exception kycmB5Ag) {
			Log.e("log_tag", "Error in http connection " + kycmB5Ag.toString());
		}
		try {
			BufferedReader rluvmUhL = new BufferedReader(new InputStreamReader(rbA4zXZT, "iso-8859-1"), 8);
			StringBuilder jxiZpts3 = new StringBuilder();
			String kul3jqco = null;
			while ((kul3jqco = rluvmUhL.readLine()) != null) {
				jxiZpts3.append(kul3jqco);
			}
			rbA4zXZT.close();
			BfZtM2EP = jxiZpts3.toString();
			if (BfZtM2EP.equals("null,")) {
				return null;
			}
		} catch (Exception i5af0Jim) {
			Log.e("log_tag", "Error converting result " + i5af0Jim.toString());
		}
		try {
			JSONObject M3YWCktu = new JSONObject(BfZtM2EP);
			JSONArray WeRMGagp = M3YWCktu.getJSONArray("data");
			JSONObject j06i1Izf = WeRMGagp.getJSONObject(0);
			b5rSUrGT.add(new BasicNameValuePair("q", j06i1Izf.getString("q")));
			b5rSUrGT.add(new BasicNameValuePair("a", j06i1Izf.getString("a")));
			b5rSUrGT.add(new BasicNameValuePair("b", j06i1Izf.getString("b")));
			b5rSUrGT.add(new BasicNameValuePair("c", j06i1Izf.getString("c")));
			b5rSUrGT.add(new BasicNameValuePair("d", j06i1Izf.getString("d")));
			b5rSUrGT.add(new BasicNameValuePair("correct", j06i1Izf.getString("correct")));
			return b5rSUrGT;
		} catch (JSONException sfPz6sY7) {
			Log.e("log_tag", "Error parsing data " + sfPz6sY7.toString());
		}
		return null;
	}

}