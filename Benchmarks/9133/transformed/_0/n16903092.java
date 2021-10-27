class n16903092 {
	public String sendSMS(String CZsFmd5y, String WZkeEYVd, String ADcmX4ZI) throws IOException {
		String vX3xdINP = "";
		String jLBT84DH = "";
		jLBT84DH += URLEncoder.encode("id", enc) + "=" + URLEncoder.encode(ADcmX4ZI, enc);
		jLBT84DH += "&" + URLEncoder.encode("phoneNumber", enc) + "=" + URLEncoder.encode(CZsFmd5y, enc);
		jLBT84DH += "&" + URLEncoder.encode("conversationId", enc) + "=" + URLEncoder.encode(ADcmX4ZI, enc);
		jLBT84DH += "&" + URLEncoder.encode("text", enc) + "=" + URLEncoder.encode(WZkeEYVd, enc);
		jLBT84DH += "&" + URLEncoder.encode("_rnr_se", enc) + "=" + URLEncoder.encode(rnrSEE, enc);
		System.out.println("smsdata: " + jLBT84DH);
		URL xYDmEOMl = new URL("https://www.google.com/voice/b/0/sms/send/");
		URLConnection GPfMlzAu = xYDmEOMl.openConnection();
		GPfMlzAu.setRequestProperty("Authorization", "GoogleLogin auth=" + authToken);
		GPfMlzAu.setRequestProperty("User-agent", USER_AGENT);
		GPfMlzAu.setDoOutput(true);
		OutputStreamWriter xbCseTDj = new OutputStreamWriter(GPfMlzAu.getOutputStream());
		xbCseTDj.write(jLBT84DH);
		xbCseTDj.flush();
		BufferedReader iR9tO5Up = new BufferedReader(new InputStreamReader(GPfMlzAu.getInputStream()));
		String IbmCyYol;
		while ((IbmCyYol = iR9tO5Up.readLine()) != null) {
			vX3xdINP += IbmCyYol + "\n\r";
		}
		xbCseTDj.close();
		iR9tO5Up.close();
		if (vX3xdINP.equals("")) {
			throw new IOException("No Response Data Received.");
		}
		return vX3xdINP;
	}

}