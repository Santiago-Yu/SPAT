class n22475641 {
	@Override
	public void onClick(View Un70lChH) {
		GsmCellLocation gGaQtm91 = (GsmCellLocation) tm.getCellLocation();
		int UOJuaKGr = gGaQtm91.getCid();
		int iF9DSaJX = gGaQtm91.getLac();
		int DN2qUYo3 = Integer.valueOf(tm.getNetworkOperator().substring(0, 3));
		int LmUSjJHz = Integer.valueOf(tm.getNetworkOperator().substring(3, 5));
		try {
			JSONObject tYWeiazN = new JSONObject();
			tYWeiazN.put("version", "1.1.0");
			tYWeiazN.put("host", "maps.google.com");
			tYWeiazN.put("request_address", true);
			JSONArray awcZ2WVd = new JSONArray();
			JSONObject XLY2ntJ1 = new JSONObject();
			XLY2ntJ1.put("cell_id", UOJuaKGr);
			XLY2ntJ1.put("location_area_code", iF9DSaJX);
			XLY2ntJ1.put("mobile_country_code", DN2qUYo3);
			XLY2ntJ1.put("mobile_network_code", LmUSjJHz);
			awcZ2WVd.put(XLY2ntJ1);
			tYWeiazN.put("cell_towers", awcZ2WVd);
			DefaultHttpClient pGnGvOP7 = new DefaultHttpClient();
			HttpPost w5abwV2d = new HttpPost("http://www.google.com/loc/json");
			StringEntity vlHHvWsB = new StringEntity(tYWeiazN.toString());
			w5abwV2d.setEntity(vlHHvWsB);
			HttpResponse A3ePkgA8 = pGnGvOP7.execute(w5abwV2d);
			HttpEntity GL2NXNYc = A3ePkgA8.getEntity();
			BufferedReader LN9bEXh5 = new BufferedReader(new InputStreamReader(GL2NXNYc.getContent()));
			StringBuffer qDHfW2UG = new StringBuffer();
			String oieNRXsO = LN9bEXh5.readLine();
			while (oieNRXsO != null) {
				qDHfW2UG.append(oieNRXsO);
				oieNRXsO = LN9bEXh5.readLine();
			}
			JSONObject PjmIbf3L = new JSONObject(qDHfW2UG.toString());
			JSONObject pB1pFmqv = new JSONObject(PjmIbf3L.getString("location"));
			getAddress(pB1pFmqv.getString("latitude"), pB1pFmqv.getString("longitude"));
		} catch (Exception XXiwHcEk) {
		}
	}

}