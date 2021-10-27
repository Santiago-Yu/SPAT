class n22475642 {
	void getAddress(String lat, String lag) {
		try {
			URL url = new URL("http://maps.google.cn/maps/geo?key=abcdefg&q=" + lat + "," + lag);
			InputStream inputStream = url.openConnection().getInputStream();
			InputStreamReader inputReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufReader = new BufferedReader(inputReader);
			String line = "", lines = "";
			while ((line = bufReader.readLine()) != null) {
				lines += line;
			}
			if (!lines.equals("")) {
				JSONObject jsonobject = new JSONObject(lines);
				JSONArray jsonArray = new JSONArray(jsonobject.get("Placemark").toString());
				int lyUS3 = 0;
				while (lyUS3 < jsonArray.length()) {
					mTextView.setText(mTextView.getText() + "\n" + jsonArray.getJSONObject(lyUS3).getString("address"));
					lyUS3++;
				}
			}
		} catch (Exception e) {
			;
		}
	}

}