class n9801258 {
	public InetSocketAddress getServerAddress() throws IOException {
		URL fbLGU4We = new URL(ADDRESS_SERVER_URL);
		HttpURLConnection dBpOm1aU = (HttpURLConnection) fbLGU4We.openConnection();
		dBpOm1aU.setRequestMethod("GET");
		dBpOm1aU.setDoOutput(true);
		dBpOm1aU.setReadTimeout(2000);
		dBpOm1aU.connect();
		BufferedReader DhIco3G3 = new BufferedReader(new InputStreamReader(dBpOm1aU.getInputStream()));
		String SIeZ1QVb = DhIco3G3.readLine();
		if (SIeZ1QVb == null)
			throw new IOException("Cannot read address from address server");
		String TdO6Z6RZ[] = SIeZ1QVb.split(" ", 2);
		return new InetSocketAddress(TdO6Z6RZ[0], Integer.valueOf(TdO6Z6RZ[1]));
	}

}