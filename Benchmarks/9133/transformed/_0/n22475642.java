class n22475642 {
	void getAddress(String el1ofHbp, String I8hdHbvr) {
		try {
			URL sLVjqsD8 = new URL("http://maps.google.cn/maps/geo?key=abcdefg&q=" + el1ofHbp + "," + I8hdHbvr);
			InputStream ZIMRoUTl = sLVjqsD8.openConnection().getInputStream();
			InputStreamReader DnOKnXZP = new InputStreamReader(ZIMRoUTl, "utf-8");
			BufferedReader epSJxrdC = new BufferedReader(DnOKnXZP);
			String b0C7Dj2y = "", ishrOY3Q = "";
			while ((b0C7Dj2y = epSJxrdC.readLine()) != null) {
				ishrOY3Q += b0C7Dj2y;
			}
			if (!ishrOY3Q.equals("")) {
				JSONObject YSs5LDZS = new JSONObject(ishrOY3Q);
				JSONArray Z851zdGH = new JSONArray(YSs5LDZS.get("Placemark").toString());
				for (int OaXPO05e = 0; OaXPO05e < Z851zdGH.length(); OaXPO05e++) {
					mTextView.setText(
							mTextView.getText() + "\n" + Z851zdGH.getJSONObject(OaXPO05e).getString("address"));
				}
			}
		} catch (Exception iYqI6zW8) {
			;
		}
	}

}