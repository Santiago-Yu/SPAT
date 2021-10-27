class n19748972 {
	public String sendSMS(String host, String port, String username, String password, String from, String to,
			String text, String uhd, String charset, String coding, String validity, String deferred, String dlrmask,
			String dlrurl, String pid, String mclass, String mwi) throws SMSPushRequestException, Exception {
		StringBuffer res = new StringBuffer();
		if (!Utils.checkNonEmptyStringAttribute(coding) || coding.equals("0"))
			text = Utils.convertTextForGSMEncodingURLEncoded(text);
		else
			text = (coding.equals("1")) ? Utils.convertTextForUTFEncodingURLEncoded(text, "UTF-8")
					: Utils.convertTextForUTFEncodingURLEncoded(text, "UCS-2");
		String directives = "username=" + username;
		directives += "&password=" + password;
		directives += "&from=" + URLEncoder.encode(from, "UTF-8");
		directives += "&to=" + to;
		directives += "&text=" + text;
		directives = (Utils.checkNonEmptyStringAttribute(uhd)) ? "&uhd=" + uhd : directives;
		directives = (Utils.checkNonEmptyStringAttribute(charset)) ? "&charset=" + charset : directives;
		directives = (Utils.checkNonEmptyStringAttribute(coding)) ? "&coding=" + coding : directives;
		directives = (Utils.checkNonEmptyStringAttribute(validity)) ? "&validity=" + validity : directives;
		directives = (Utils.checkNonEmptyStringAttribute(deferred)) ? "&deferred=" + deferred : directives;
		directives = (Utils.checkNonEmptyStringAttribute(dlrmask)) ? "&dlrmask=" + dlrmask : directives;
		directives = (Utils.checkNonEmptyStringAttribute(dlrurl)) ? "&dlrurl=" + dlrurl : directives;
		directives = (Utils.checkNonEmptyStringAttribute(pid)) ? "&pid=" + pid : directives;
		directives = (Utils.checkNonEmptyStringAttribute(mclass)) ? "&mclass=" + mclass : directives;
		directives = (Utils.checkNonEmptyStringAttribute(mwi)) ? "&mwi=" + mwi : directives;
		URL url = new URL("http://" + host + ":" + port + "/cgi-bin/sendsms?" + directives);
		URLConnection conn = url.openConnection();
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String response;
		while ((response = rd.readLine()) != null)
			res.append(response);
		rd.close();
		String resultCode = res.substring(0, res.indexOf(":"));
		if (!resultCode.equals(SMS_PUSH_RESPONSE_SUCCESS_CODE))
			throw new SMSPushRequestException(resultCode);
		return res.toString();
	}

}