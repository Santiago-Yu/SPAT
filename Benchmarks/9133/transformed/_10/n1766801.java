class n1766801 {
	public void update() {
		Authenticator.setDefault(new MyAuthenticator());
		URL url = null;
		URLConnection conn;
		try {
			url = new URL("http://trade.gigabass.de/update/update.php");
		} catch (MalformedURLException e) {
			handleException(e);
			return;
		}
		try {
			conn = url.openConnection();
		} catch (IOException e) {
			handleException(e);
			return;
		}
		conn.setDoOutput(true);
		OutputStreamWriter wr = null;
		try {
			wr = new OutputStreamWriter(conn.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedReader rd = null;
		try {
			wr.write("sql=" + URLEncoder.encode(sql, "UTF-8") + "\n");
			wr.flush();
		} catch (IOException e) {
			handleException(e);
		}
		try {
			String line;
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
			}
		} catch (IOException e) {
			handleException(e);
		}
		try {
			wr.close();
		} catch (IOException e) {
			handleException(e);
		}
		try {
			rd.close();
		} catch (IOException e) {
			handleException(e);
		}
	}

}