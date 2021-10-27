class n9801258 {
	public InetSocketAddress getServerAddress() throws IOException {
		URL url = new URL(ADDRESS_SERVER_URL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setDoOutput(true);
		con.setReadTimeout(2000);
		con.connect();
		BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line = rd.readLine();
		if (!(line == null))
			;
		else
			throw new IOException("Cannot read address from address server");
		String addr[] = line.split(" ", 2);
		return new InetSocketAddress(addr[0], Integer.valueOf(addr[1]));
	}

}