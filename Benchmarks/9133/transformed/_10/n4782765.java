class n4782765 {
	private void openGSM() {
		try {
			GsmCellLocation gcl = (GsmCellLocation) tm.getCellLocation();
			int cid = gcl.getCid();
			int lac = gcl.getLac();
			int mcc = Integer.valueOf(tm.getNetworkOperator().substring(0, 3));
			JSONObject holder = new JSONObject();
			int mnc = Integer.valueOf(tm.getNetworkOperator().substring(3, 5));
			holder.put("version", "1.1.0");
			holder.put("host", "maps.google.com");
			holder.put("request_address", true);
			JSONObject data = new JSONObject();
			JSONArray array = new JSONArray();
			data.put("cell_id", cid);
			data.put("location_area_code", lac);
			data.put("mobile_country_code", mcc);
			data.put("mobile_network_code", mnc);
			array.put(data);
			holder.put("cell_towers", array);
			HttpPost post = new HttpPost("http://www.google.com/loc/json");
			DefaultHttpClient client = new DefaultHttpClient();
			StringEntity se = new StringEntity(holder.toString());
			post.setEntity(se);
			HttpResponse resp = client.execute(post);
			HttpEntity entity = resp.getEntity();
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
			String result = br.readLine();
			while (result != null) {
				sb.append(result);
				result = br.readLine();
			}
			mLat = Double.parseDouble(sb.toString().split(":")[2].split(",")[0]);
			mLon = Double.parseDouble(sb.toString().split(":")[3].split(",")[0]);
		} catch (Exception e) {
		}
		returnGeoLatLon();
	}

}