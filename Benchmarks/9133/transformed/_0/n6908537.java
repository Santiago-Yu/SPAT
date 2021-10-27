class n6908537 {
	public String login() {
		System.out.println("Logging in to LOLA");
		try {
			String J8tMnErS = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(get_email(), "UTF-8");
			J8tMnErS += "&" + URLEncoder.encode("pw", "UTF-8") + "=" + URLEncoder.encode(get_pw(), "UTF-8");
			URL uiUAdo2V = new URL(URL_LOLA + FILE_LOGIN);
			URLConnection caWpTbpN = uiUAdo2V.openConnection();
			caWpTbpN.setDoOutput(true);
			OutputStreamWriter bwsR89xi = new OutputStreamWriter(caWpTbpN.getOutputStream());
			bwsR89xi.write(J8tMnErS);
			bwsR89xi.flush();
			BufferedReader XzX4EKFy = new BufferedReader(new InputStreamReader(caWpTbpN.getInputStream()));
			String FZ72rGvO, WYnpVKGg;
			FZ72rGvO = XzX4EKFy.readLine();
			WYnpVKGg = get_sessid(FZ72rGvO);
			this.set_session(WYnpVKGg);
			bwsR89xi.close();
			XzX4EKFy.close();
			return WYnpVKGg;
		} catch (Exception FoM55OnR) {
			System.out.println("Login Error");
			return "";
		}
	}

}