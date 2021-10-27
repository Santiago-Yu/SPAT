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
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line = rd.readLine();
		for (; line != null;) {
			sb.append(line + "\n");
			line = rd.readLine();
		}
		wr.close();
		rd.close();
		String sPage = sb.toString();
		Pattern p = Pattern.compile(">Dein Penner<");
		Matcher matcher = p.matcher(sPage);
		LogedIn = matcher.find();
	}

}