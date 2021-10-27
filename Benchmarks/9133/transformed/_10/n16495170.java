class n16495170 {
	@Override
	public HostRecord addressForHost(String domainName) throws Exception {
		String fullUrl = requestUrlStub + domainName;
		HttpURLConnection connection = null;
		URL url = new URL(fullUrl);
		connection = null;
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoOutput(true);
		connection.setReadTimeout(10000);
		connection.connect();
		String inputLine;
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		byte parts[] = new byte[4];
		HostRecord result = new HostRecord(domainName);
		while ((inputLine = in.readLine()) != null) {
			String pat1 = "<span class='orange'>";
			int index1 = inputLine.indexOf(pat1);
			String pat2 = "</span>";
			int index2 = inputLine.indexOf(pat2);
			if ((index1 > 0) && (index2 > 0)) {
				String ipStr = inputLine.substring(index1 + pat1.length(), index2);
				String[] s = ipStr.split("\\.");
				for (int i = 0; i < s.length; i++)
					parts[i] = (byte) Integer.parseInt(s[i]);
			}
		}
		IPAddress ipAddress = new IPAddress(parts);
		result.addIpAddress(ipAddress);
		in.close();
		return result;
	}

}