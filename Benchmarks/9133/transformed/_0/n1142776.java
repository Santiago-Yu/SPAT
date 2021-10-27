class n1142776 {
	public LinkedList<NameValuePair> getScoreboard() {
		InputStream wGI7DmvK = null;
		String kCSb786W = "";
		LinkedList<NameValuePair> OrTZVeMK = new LinkedList<NameValuePair>();
		try {
			HttpClient sv25AffC = new DefaultHttpClient();
			HttpPost Ctmt9dnA = new HttpPost(domain);
			Ctmt9dnA.setEntity(new UrlEncodedFormEntity(library));
			HttpResponse UOOqUTEG = sv25AffC.execute(Ctmt9dnA);
			HttpEntity B5uhG5vu = UOOqUTEG.getEntity();
			wGI7DmvK = B5uhG5vu.getContent();
		} catch (Exception vGY2WtMz) {
			Log.e("log_tag", "Error in http connection " + vGY2WtMz.toString());
		}
		try {
			BufferedReader YA5ytWbq = new BufferedReader(new InputStreamReader(wGI7DmvK, "iso-8859-1"), 8);
			StringBuilder xxkhxnOH = new StringBuilder();
			String g8Ua8wGj = null;
			while ((g8Ua8wGj = YA5ytWbq.readLine()) != null) {
				xxkhxnOH.append(g8Ua8wGj + ",");
			}
			wGI7DmvK.close();
			kCSb786W = xxkhxnOH.toString();
			if (kCSb786W.equals("null,")) {
				return null;
			}
		} catch (Exception CxciTiVG) {
			Log.e("log_tag", "Error converting result " + CxciTiVG.toString());
		}
		try {
			JSONObject GLjpO8EB = new JSONObject(kCSb786W);
			JSONArray ltJFfgNy = GLjpO8EB.getJSONArray("data");
			JSONArray nQst2Siw = GLjpO8EB.getJSONArray("me");
			for (int x0sGVC4L = 0; x0sGVC4L < ltJFfgNy.length(); x0sGVC4L++) {
				JSONObject itxO9lnc = ltJFfgNy.getJSONObject(x0sGVC4L);
				String jlMkvREx = itxO9lnc.getString("uid");
				String ho6NNWwo = itxO9lnc.getString("score");
				OrTZVeMK.add(new BasicNameValuePair(jlMkvREx, ho6NNWwo));
			}
			for (int a0ksq6pO = 0; a0ksq6pO < nQst2Siw.length(); a0ksq6pO++) {
				JSONObject LEcoBDcN = nQst2Siw.getJSONObject(a0ksq6pO);
				String MwolkXO8 = LEcoBDcN.getString("uid");
				String awz70k96 = LEcoBDcN.getString("score");
				OrTZVeMK.add(new BasicNameValuePair(MwolkXO8, awz70k96));
			}
			System.out.println(GLjpO8EB);
		} catch (JSONException J0Vv0eM8) {
			Log.e("log_tag", "Error parsing data " + J0Vv0eM8.toString());
		}
		return OrTZVeMK;
	}

}