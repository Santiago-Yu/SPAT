class n379581 {
	public void login(String UID, String PWD, int CTY) throws Exception {
		sSideURL = sSideURLCollection[CTY];
		sUID = UID;
		sPWD = PWD;
		iCTY = CTY;
		sLoginLabel = getLoginLabel(sSideURL);
		String sParams = getLoginParams();
		CookieHandler.setDefault(new ListCookieHandler());
		URL url = new URL(sSideURL + sLoginURL);
		URLConnection conn = url.openConnection();
		setRequestProperties(conn);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(sParams);
		wr.flush();
		StringBuilder sb = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = rd.readLine();
		while (line != null) {
			sb.append(line + "\n");
			line = rd.readLine();
		}
		wr.close();
		rd.close();
		Pattern p = Pattern.compile(">Dein Penner<");
		String sPage = sb.toString();
		Matcher matcher = p.matcher(sPage);
		LogedIn = matcher.find();
	}

}