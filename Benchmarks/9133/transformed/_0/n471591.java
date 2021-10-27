class n471591 {
	private String getFanFouMessage(int gRxJ3BHm) throws IOException {
		URL LMBEcgej = new URL("http://api.fanfou.com/statuses/user_timeline.json?page=" + gRxJ3BHm);
		HttpURLConnection OvYzDdDh = (HttpURLConnection) LMBEcgej.openConnection();
		OvYzDdDh.setDoOutput(true);
		OvYzDdDh.setRequestMethod("GET");
		String y5Ut5LGb = Base64.encode((getUsername() + ":" + getPassword()).getBytes());
		OvYzDdDh.addRequestProperty("Authorization", "Basic " + y5Ut5LGb);
		System.out.println("Sending request...");
		OvYzDdDh.connect();
		System.out.println("Response: " + OvYzDdDh.getResponseCode() + " " + OvYzDdDh.getResponseMessage());
		BufferedReader gIAn2dqc = new BufferedReader(new InputStreamReader(OvYzDdDh.getInputStream()));
		String aQKorYva = null;
		StringBuffer Cx2viu2Z = new StringBuffer();
		while ((aQKorYva = gIAn2dqc.readLine()) != null) {
			Cx2viu2Z.append(aQKorYva);
		}
		return Cx2viu2Z.toString();
	}

}