class n16495170 {
	@Override
	public HostRecord addressForHost(String domainName) throws Exception {
		String fullUrl = requestUrlStub + domainName;
		URL url = new URL(fullUrl);
		HttpURLConnection connection = null;
		connection = null;
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoOutput(true);
		connection.setReadTimeout(10000);
		connection.connect();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		HostRecord result = new HostRecord(domainName);
		byte parts[] = new byte[4];
		while ((inputLine = in.readLine()) != null) {
			String pat1 = "<span class='orange'>";
			String pat2 = "</span>";
			int index1 = inputLine.indexOf(pat1);
			int index2 = inputLine.indexOf(pat2);
			if ((index1 > 0) && (index2 > 0)) {
				String ipStr = inputLine.substring(index1 + pat1.length(), index2);
				String[] s = ipStr.split("\\.");
				int TFt8t = 0;
				while (TFt8t < s.length) {
					parts[TFt8t] = (byte) Integer.parseInt(s[TFt8t]);
					TFt8t++;
				}
			}
		}
		IPAddress ipAddress = new IPAddress(parts);
		result.addIpAddress(ipAddress);
		in.close();
		return result;
	}

}