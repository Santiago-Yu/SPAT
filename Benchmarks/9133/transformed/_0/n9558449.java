class n9558449 {
	public int openUrl(String GlUFarXK, String fq936iwy, Bundle Nhw5fwGw) {
		int bQGZQCFE = 0;
		try {
			if (fq936iwy.equals("GET")) {
				GlUFarXK = GlUFarXK + "?" + Utility.encodeUrl(Nhw5fwGw);
			}
			String lzN4hwLz = "";
			HttpURLConnection ZeiFpixF = (HttpURLConnection) new URL(GlUFarXK).openConnection();
			ZeiFpixF.setRequestProperty("User-Agent",
					System.getProperties().getProperty("http.agent") + " RenrenAndroidSDK");
			if (!fq936iwy.equals("GET")) {
				ZeiFpixF.setRequestMethod("POST");
				ZeiFpixF.setDoOutput(true);
				ZeiFpixF.getOutputStream().write(Utility.encodeUrl(Nhw5fwGw).getBytes("UTF-8"));
			}
			lzN4hwLz = Utility.read(ZeiFpixF.getInputStream());
			JSONObject MkmdOiAj = new JSONObject(lzN4hwLz);
			try {
				int TIGtCxDp = MkmdOiAj.getInt("result");
				if (TIGtCxDp > 0)
					bQGZQCFE = 1;
			} catch (Exception SVdwT5HR) {
				bQGZQCFE = MkmdOiAj.getInt("error_code");
				errmessage = MkmdOiAj.getString("error_msg");
			}
		} catch (Exception NZpE2J56) {
			bQGZQCFE = -1;
		}
		return bQGZQCFE;
	}

}