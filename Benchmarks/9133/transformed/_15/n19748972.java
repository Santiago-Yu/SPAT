class n19748972 {
	public String sendSMS(String host, String port, String username, String password, String from, String to,
			String text, String uhd, String charset, String coding, String validity, String deferred, String dlrmask,
			String dlrurl, String pid, String mclass, String mwi) throws SMSPushRequestException, Exception {
		StringBuffer res = new StringBuffer();
		if (!Utils.checkNonEmptyStringAttribute(coding) || "0".equals(coding))
			text = Utils.convertTextForGSMEncodingURLEncoded(text);
		else if ("1".equals(coding))
			text = Utils.convertTextForUTFEncodingURLEncoded(text, "UTF-8");
		else
			text = Utils.convertTextForUTFEncodingURLEncoded(text, "UCS-2");
		String directives = "username=" + username;
		directives += "&password=" + password;
		directives += "&from=" + URLEncoder.encode(from, "UTF-8");
		directives += "&to=" + to;
		directives += "&text=" + text;
		if (Utils.checkNonEmptyStringAttribute(uhd))
			directives += "&uhd=" + uhd;
		if (Utils.checkNonEmptyStringAttribute(charset))
			directives += "&charset=" + charset;
		if (Utils.checkNonEmptyStringAttribute(coding))
			directives += "&coding=" + coding;
		if (Utils.checkNonEmptyStringAttribute(validity))
			directives += "&validity=" + validity;
		if (Utils.checkNonEmptyStringAttribute(deferred))
			directives += "&deferred=" + deferred;
		if (Utils.checkNonEmptyStringAttribute(dlrmask))
			directives += "&dlrmask=" + dlrmask;
		if (Utils.checkNonEmptyStringAttribute(dlrurl))
			directives += "&dlrurl=" + dlrurl;
		if (Utils.checkNonEmptyStringAttribute(pid))
			directives += "&pid=" + pid;
		if (Utils.checkNonEmptyStringAttribute(mclass))
			directives += "&mclass=" + mclass;
		if (Utils.checkNonEmptyStringAttribute(mwi))
			directives += "&mwi=" + mwi;
		URL url = new URL("http://" + host + ":" + port + "/cgi-bin/sendsms?" + directives);
		URLConnection conn = url.openConnection();
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String response;
		while ((response = rd.readLine()) != null)
			res.append(response);
		rd.close();
		String resultCode = res.substring(0, res.indexOf(":"));
		if (!(SMS_PUSH_RESPONSE_SUCCESS_CODE != null && SMS_PUSH_RESPONSE_SUCCESS_CODE.equals(resultCode)))
			throw new SMSPushRequestException(resultCode);
		return res.toString();
	}

}