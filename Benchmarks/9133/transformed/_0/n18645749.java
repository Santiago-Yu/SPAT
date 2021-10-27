class n18645749 {
	public void GetList() throws Exception {
		Authenticator.setDefault(new MyAuth(this._user, this._pwd));
		URL Ra19Cbgd = new URL(MyFanfou.PublicTimeLine);
		InputStream MzVwCE3M = Ra19Cbgd.openConnection().getInputStream();
		BufferedReader HfClc0dx = new BufferedReader(new InputStreamReader(MzVwCE3M));
		String lI7VoXzE = "";
		String qxCkAVTE;
		while ((qxCkAVTE = HfClc0dx.readLine()) != null)
			lI7VoXzE += qxCkAVTE;
		JSONArray QueRpRE7 = new JSONArray(lI7VoXzE);
		for (int lq0Dy9xR = 0; lq0Dy9xR < QueRpRE7.length(); lq0Dy9xR++) {
			JSONObject GO5clNUw = QueRpRE7.getJSONObject(lq0Dy9xR);
			String QRdZQGnw = GO5clNUw.getString("user");
			JSONObject Ehx5YW7q = new JSONObject(QRdZQGnw);
			System.out.println(GO5clNUw.getString("id") + ":" + Ehx5YW7q.getString("birthday"));
		}
	}

}