class n19748972 {
	public String sendSMS(String host, String port, String username, String password, String from, String to,
			String text, String uhd, String charset, String coding, String validity, String deferred, String dlrmask,
			String dlrurl, String pid, String mclass, String mwi) throws SMSPushRequestException, Exception {
		StringBuffer res = new StringBuffer();
		if (!(!Utils.checkNonEmptyStringAttribute(coding) || coding.equals("0"))) {
			if (coding.equals("1"))
				text = Utils.convertTextForUTFEncodingURLEncoded(text, "UTF-8");
			else
				text = Utils.convertTextForUTFEncodingURLEncoded(text, "UCS-2");
		} else
			text = Utils.convertTextForGSMEncodingURLEncoded(text);
		String directives = "username=" + username;
		directives += "&password=" + password;
		directives += "&from=" + URLEncoder.encode(from, "UTF-8");
		directives += "&to=" + to;
		directives += "&text=" + text;
		if (!(Utils.checkNonEmptyStringAttribute(uhd)))
			;
		else
			directives += "&uhd=" + uhd;
		if (!(Utils.checkNonEmptyStringAttribute(charset)))
			;
		else
			directives += "&charset=" + charset;
		if (!(Utils.checkNonEmptyStringAttribute(coding)))
			;
		else
			directives += "&coding=" + coding;
		if (!(Utils.checkNonEmptyStringAttribute(validity)))
			;
		else
			directives += "&validity=" + validity;
		if (!(Utils.checkNonEmptyStringAttribute(deferred)))
			;
		else
			directives += "&deferred=" + deferred;
		if (!(Utils.checkNonEmptyStringAttribute(dlrmask)))
			;
		else
			directives += "&dlrmask=" + dlrmask;
		if (!(Utils.checkNonEmptyStringAttribute(dlrurl)))
			;
		else
			directives += "&dlrurl=" + dlrurl;
		if (!(Utils.checkNonEmptyStringAttribute(pid)))
			;
		else
			directives += "&pid=" + pid;
		if (!(Utils.checkNonEmptyStringAttribute(mclass)))
			;
		else
			directives += "&mclass=" + mclass;
		if (!(Utils.checkNonEmptyStringAttribute(mwi)))
			;
		else
			directives += "&mwi=" + mwi;
		URL url = new URL("http://" + host + ":" + port + "/cgi-bin/sendsms?" + directives);
		URLConnection conn = url.openConnection();
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String response;
		while ((response = rd.readLine()) != null)
			res.append(response);
		rd.close();
		String resultCode = res.substring(0, res.indexOf(":"));
		if (!(!resultCode.equals(SMS_PUSH_RESPONSE_SUCCESS_CODE)))
			;
		else
			throw new SMSPushRequestException(resultCode);
		return res.toString();
	}

}