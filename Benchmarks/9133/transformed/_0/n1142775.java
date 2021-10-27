class n1142775 {
	public String[] getFriends() {
		InputStream eitxfCQn = null;
		String[] Pln9MLBB = null;
		String Xlo0ve6w = "";
		try {
			HttpClient l3k0MDv2 = new DefaultHttpClient();
			HttpPost rIgWxcOX = new HttpPost(domain);
			rIgWxcOX.setEntity(new UrlEncodedFormEntity(library));
			HttpResponse NPL4A1W9 = l3k0MDv2.execute(rIgWxcOX);
			HttpEntity K7UDglvU = NPL4A1W9.getEntity();
			eitxfCQn = K7UDglvU.getContent();
		} catch (Exception Zy2T3Knw) {
			Log.e("log_tag", "Error in http connection " + Zy2T3Knw.toString());
		}
		try {
			BufferedReader IenzRVHf = new BufferedReader(new InputStreamReader(eitxfCQn, "iso-8859-1"), 8);
			StringBuilder uwYtcLqn = new StringBuilder();
			String LZ3eokdQ = null;
			while ((LZ3eokdQ = IenzRVHf.readLine()) != null) {
				uwYtcLqn.append(LZ3eokdQ + ",");
			}
			eitxfCQn.close();
			Xlo0ve6w = uwYtcLqn.toString();
			if (Xlo0ve6w.equals("null,")) {
				Pln9MLBB = new String[1];
				Pln9MLBB[0] = "none";
				return Pln9MLBB;
			}
		} catch (Exception gn2VV1VC) {
			Log.e("log_tag", "Error converting result " + gn2VV1VC.toString());
		}
		try {
			JSONArray eTUuI0O9 = new JSONArray(Xlo0ve6w);
			Pln9MLBB = new String[eTUuI0O9.length()];
			for (int EbRiMsb1 = 0; EbRiMsb1 < eTUuI0O9.length(); EbRiMsb1++) {
				JSONObject mivPuN2T = eTUuI0O9.getJSONObject(EbRiMsb1);
				Pln9MLBB[EbRiMsb1] = mivPuN2T.getString("uid");
			}
		} catch (JSONException haNmi2UT) {
			Log.e("log_tag", "Error parsing data " + haNmi2UT.toString());
		}
		return Pln9MLBB;
	}

}