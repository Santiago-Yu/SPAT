class n16903092 {
	public String sendSMS(String destinationNumber, String txt, String id) throws IOException {
		String out = "";
		String smsdata = "";
		smsdata = smsdata + (URLEncoder.encode("id", enc) + "=" + URLEncoder.encode(id, enc));
		smsdata = smsdata
				+ ("&" + URLEncoder.encode("phoneNumber", enc) + "=" + URLEncoder.encode(destinationNumber, enc));
		smsdata = smsdata + ("&" + URLEncoder.encode("conversationId", enc) + "=" + URLEncoder.encode(id, enc));
		smsdata = smsdata + ("&" + URLEncoder.encode("text", enc) + "=" + URLEncoder.encode(txt, enc));
		smsdata = smsdata + ("&" + URLEncoder.encode("_rnr_se", enc) + "=" + URLEncoder.encode(rnrSEE, enc));
		System.out.println("smsdata: " + smsdata);
		URL smsurl = new URL("https://www.google.com/voice/b/0/sms/send/");
		URLConnection smsconn = smsurl.openConnection();
		smsconn.setRequestProperty("Authorization", "GoogleLogin auth=" + authToken);
		smsconn.setRequestProperty("User-agent", USER_AGENT);
		smsconn.setDoOutput(true);
		OutputStreamWriter callwr = new OutputStreamWriter(smsconn.getOutputStream());
		callwr.write(smsdata);
		callwr.flush();
		BufferedReader callrd = new BufferedReader(new InputStreamReader(smsconn.getInputStream()));
		String line;
		while ((line = callrd.readLine()) != null) {
			out = out + (line + "\n\r");
		}
		callwr.close();
		callrd.close();
		if (out.equals("")) {
			throw new IOException("No Response Data Received.");
		}
		return out;
	}

}