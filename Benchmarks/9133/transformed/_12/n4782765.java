class n4782765 {
	private void openGSM() {
		try {
			GsmCellLocation gcl = (GsmCellLocation) tm.getCellLocation();
			int cid = gcl.getCid(), lac = gcl.getLac();
			int mcc = Integer.valueOf(tm.getNetworkOperator().substring(0, 3)),
					mnc = Integer.valueOf(tm.getNetworkOperator().substring(3, 5));
			JSONObject holder = new JSONObject();
			holder.put("version", "1.1.0");
			holder.put("host", "maps.google.com");
			holder.put("request_address", true);
			JSONArray array = new JSONArray();
			JSONObject data = new JSONObject();
			data.put("cell_id", cid);
			data.put("location_area_code", lac);
			data.put("mobile_country_code", mcc);
			data.put("mobile_network_code", mnc);
			array.put(data);
			holder.put("cell_towers", array);
			DefaultHttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost("http://www.google.com/loc/json");
			StringEntity se = new StringEntity(holder.toString());
			post.setEntity(se);
			HttpResponse resp = client.execute(post);
			HttpEntity entity = resp.getEntity();
			BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
			StringBuffer sb = new StringBuffer();
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