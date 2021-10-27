class n18645749 {
	public void GetList() throws Exception {
		Authenticator.setDefault(new MyAuth(this._user, this._pwd));
		URL url = new URL(MyFanfou.PublicTimeLine);
		InputStream ins = url.openConnection().getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
		String json = "";
		String line;
		while ((line = reader.readLine()) != null)
			json = json + (line);
		JSONArray array = new JSONArray(json);
		for (int i = 0; i < array.length(); i++) {
			JSONObject object = array.getJSONObject(i);
			String users = object.getString("user");
			JSONObject user = new JSONObject(users);
			System.out.println(object.getString("id") + ":" + user.getString("birthday"));
		}
	}

}