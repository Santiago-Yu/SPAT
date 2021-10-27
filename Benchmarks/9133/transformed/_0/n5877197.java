class n5877197 {
	public List<Mosque> getAllMosquaisFromDataBase() {
		List<Mosque> VeCuFGh0 = new ArrayList<Mosque>();
		InputStream bUKsXWFK = null;
		String qzmG5XVl = "";
		ArrayList<NameValuePair> XurNuVya = new ArrayList<NameValuePair>();
		if (MyMapActivity.DEVELOPER_MODE) {
			XurNuVya.add(new BasicNameValuePair(Param.LATITUDE, MyMapActivity.mLatitude + ""));
			XurNuVya.add(new BasicNameValuePair(Param.LONGITUDE, MyMapActivity.mLongitude + ""));
		} else {
			XurNuVya.add(new BasicNameValuePair(Param.LATITUDE, MyMapActivity.myLocation.getLatitude() + ""));
			XurNuVya.add(new BasicNameValuePair(Param.LONGITUDE, MyMapActivity.myLocation.getLongitude() + ""));
		}
		XurNuVya.add(new BasicNameValuePair(Param.RAYON, DataBaseQuery.rayon * Param.KM_MARGE + ""));
		try {
			HttpClient mxxLGf1n = new DefaultHttpClient();
			HttpPost kr7i0gI0 = new HttpPost(Param.URI_SELECT_ALL_DATA_BASE);
			kr7i0gI0.setEntity(new UrlEncodedFormEntity(XurNuVya));
			HttpResponse K9V6k0aa = mxxLGf1n.execute(kr7i0gI0);
			HttpEntity AOYQ0FMJ = K9V6k0aa.getEntity();
			bUKsXWFK = AOYQ0FMJ.getContent();
		} catch (Exception qgmQAnV4) {
			Log.e("log_tag", "Error in http connection " + qgmQAnV4.toString());
		}
		try {
			BufferedReader JeW3K12H = new BufferedReader(new InputStreamReader(bUKsXWFK, "iso-8859-1"), 8);
			StringBuilder DbtIsQDh = new StringBuilder();
			String X0kEK6bM = null;
			while ((X0kEK6bM = JeW3K12H.readLine()) != null) {
				DbtIsQDh.append(X0kEK6bM + "\n");
			}
			bUKsXWFK.close();
			qzmG5XVl = DbtIsQDh.toString();
		} catch (Exception ktk8DJE6) {
			Log.e("log_tag", "Error converting result " + ktk8DJE6.toString());
		}
		try {
			JSONArray oYZbpDBW = new JSONArray(qzmG5XVl);
			for (int teukXJos = 0; teukXJos < oYZbpDBW.length(); teukXJos++) {
				JSONObject T2urGmoV = oYZbpDBW.getJSONObject(teukXJos);
				Mosque EEfR6dlh = new Mosque(T2urGmoV.getInt(Param.ID), T2urGmoV.getString(Param.NOM),
						T2urGmoV.getDouble(Param.LATITUDE), T2urGmoV.getDouble(Param.LONGITUDE),
						T2urGmoV.getString(Param.INFO), T2urGmoV.getInt(Param.HAVE_PICTURE) == 1 ? true : false,
						T2urGmoV.getString(Param.PICTURE));
				VeCuFGh0.add(EEfR6dlh);
			}
		} catch (JSONException fpi5UQZ6) {
			Log.e("log_tag", "Error parsing data " + fpi5UQZ6.toString());
		}
		return VeCuFGh0;
	}

}