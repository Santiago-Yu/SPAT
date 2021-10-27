class n1766801 {
	public void update() {
		Authenticator.setDefault(new MyAuthenticator());
		URL z1LcvUJN = null;
		try {
			z1LcvUJN = new URL("http://trade.gigabass.de/update/update.php");
		} catch (MalformedURLException FF6uEbm2) {
			handleException(FF6uEbm2);
			return;
		}
		URLConnection Gbzyab3H;
		try {
			Gbzyab3H = z1LcvUJN.openConnection();
		} catch (IOException IiQprX6S) {
			handleException(IiQprX6S);
			return;
		}
		Gbzyab3H.setDoOutput(true);
		OutputStreamWriter XlbEhnnS = null;
		try {
			XlbEhnnS = new OutputStreamWriter(Gbzyab3H.getOutputStream());
		} catch (IOException j6l80zOX) {
			j6l80zOX.printStackTrace();
		}
		try {
			XlbEhnnS.write("sql=" + URLEncoder.encode(sql, "UTF-8") + "\n");
			XlbEhnnS.flush();
		} catch (IOException fflK7fA3) {
			handleException(fflK7fA3);
		}
		BufferedReader YUXAOZS7 = null;
		try {
			YUXAOZS7 = new BufferedReader(new InputStreamReader(Gbzyab3H.getInputStream()));
			String kgTBiuXs;
			while ((kgTBiuXs = YUXAOZS7.readLine()) != null) {
			}
		} catch (IOException UFWHqxeL) {
			handleException(UFWHqxeL);
		}
		try {
			XlbEhnnS.close();
		} catch (IOException K4ZrJyo4) {
			handleException(K4ZrJyo4);
		}
		try {
			YUXAOZS7.close();
		} catch (IOException MZcDgyQ4) {
			handleException(MZcDgyQ4);
		}
	}

}