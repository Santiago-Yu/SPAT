class n4782765 {
	private void openGSM() {
		try {
			GsmCellLocation euM4rnPG = (GsmCellLocation) tm.getCellLocation();
			int qgC5ilPr = euM4rnPG.getCid();
			int Mkq8DGve = euM4rnPG.getLac();
			int FSubzH5a = Integer.valueOf(tm.getNetworkOperator().substring(0, 3));
			int PPRHvi2J = Integer.valueOf(tm.getNetworkOperator().substring(3, 5));
			JSONObject psxSTHU9 = new JSONObject();
			psxSTHU9.put("version", "1.1.0");
			psxSTHU9.put("host", "maps.google.com");
			psxSTHU9.put("request_address", true);
			JSONArray FjzTC7r3 = new JSONArray();
			JSONObject LHAW7Ze8 = new JSONObject();
			LHAW7Ze8.put("cell_id", qgC5ilPr);
			LHAW7Ze8.put("location_area_code", Mkq8DGve);
			LHAW7Ze8.put("mobile_country_code", FSubzH5a);
			LHAW7Ze8.put("mobile_network_code", PPRHvi2J);
			FjzTC7r3.put(LHAW7Ze8);
			psxSTHU9.put("cell_towers", FjzTC7r3);
			DefaultHttpClient ay9N5BxO = new DefaultHttpClient();
			HttpPost savWj8Qz = new HttpPost("http://www.google.com/loc/json");
			StringEntity YYpFmTk5 = new StringEntity(psxSTHU9.toString());
			savWj8Qz.setEntity(YYpFmTk5);
			HttpResponse agbUxUMU = ay9N5BxO.execute(savWj8Qz);
			HttpEntity JJFdj4Sz = agbUxUMU.getEntity();
			BufferedReader ueMM04Zx = new BufferedReader(new InputStreamReader(JJFdj4Sz.getContent()));
			StringBuffer xyYj2a1A = new StringBuffer();
			String v2gqnGNo = ueMM04Zx.readLine();
			while (v2gqnGNo != null) {
				xyYj2a1A.append(v2gqnGNo);
				v2gqnGNo = ueMM04Zx.readLine();
			}
			mLat = Double.parseDouble(xyYj2a1A.toString().split(":")[2].split(",")[0]);
			mLon = Double.parseDouble(xyYj2a1A.toString().split(":")[3].split(",")[0]);
		} catch (Exception OA4LRm7M) {
		}
		returnGeoLatLon();
	}

}