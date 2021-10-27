class n7846688 {
	public void postData(String protocol, String host, String form, String data) throws Exception {
		protocol = ((protocol == null) || (protocol.equals(""))) ? DEFAULT_PROTOCOL : protocol;
		host = ((host == null) || (host.equals(""))) ? DEFAULT_HOST : host;
		form = (form == null) ? DEFAULT_FORM : form;
		if (data == null) {
			throw new IllegalArgumentException("Invalid data");
		}
		URL url = new URL(protocol, host, form);
		URLConnection con = url.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setUseCaches(false);
		con.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
		con.setRequestProperty("Content-length", String.valueOf(data.length()));
		PrintStream out = new PrintStream(con.getOutputStream(), true);
		out.print(data);
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		while (in.readLine() != null) {
		}
		in.close();
	}

}