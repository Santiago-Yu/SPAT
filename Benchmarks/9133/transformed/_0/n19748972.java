class n19748972 {
	public String sendSMS(String pvhxtvTr, String UF3UNUOy, String S0kbVXev, String oXZ1iU5T, String WDbqIs41,
			String h3odW23f, String tdZMlMMg, String lwoF6QBf, String Yn6YoQc9, String YyM1V39N, String wHZbbVhN,
			String KdlUyZSG, String hmGAR702, String zRIAk7J2, String miQxVNpQ, String NIyHZ0nR, String NYbohAi8)
			throws SMSPushRequestException, Exception {
		StringBuffer M8F8emw6 = new StringBuffer();
		if (!Utils.checkNonEmptyStringAttribute(YyM1V39N) || YyM1V39N.equals("0"))
			tdZMlMMg = Utils.convertTextForGSMEncodingURLEncoded(tdZMlMMg);
		else if (YyM1V39N.equals("1"))
			tdZMlMMg = Utils.convertTextForUTFEncodingURLEncoded(tdZMlMMg, "UTF-8");
		else
			tdZMlMMg = Utils.convertTextForUTFEncodingURLEncoded(tdZMlMMg, "UCS-2");
		String VhHX3vt3 = "username=" + S0kbVXev;
		VhHX3vt3 += "&password=" + oXZ1iU5T;
		VhHX3vt3 += "&from=" + URLEncoder.encode(WDbqIs41, "UTF-8");
		VhHX3vt3 += "&to=" + h3odW23f;
		VhHX3vt3 += "&text=" + tdZMlMMg;
		if (Utils.checkNonEmptyStringAttribute(lwoF6QBf))
			VhHX3vt3 += "&uhd=" + lwoF6QBf;
		if (Utils.checkNonEmptyStringAttribute(Yn6YoQc9))
			VhHX3vt3 += "&charset=" + Yn6YoQc9;
		if (Utils.checkNonEmptyStringAttribute(YyM1V39N))
			VhHX3vt3 += "&coding=" + YyM1V39N;
		if (Utils.checkNonEmptyStringAttribute(wHZbbVhN))
			VhHX3vt3 += "&validity=" + wHZbbVhN;
		if (Utils.checkNonEmptyStringAttribute(KdlUyZSG))
			VhHX3vt3 += "&deferred=" + KdlUyZSG;
		if (Utils.checkNonEmptyStringAttribute(hmGAR702))
			VhHX3vt3 += "&dlrmask=" + hmGAR702;
		if (Utils.checkNonEmptyStringAttribute(zRIAk7J2))
			VhHX3vt3 += "&dlrurl=" + zRIAk7J2;
		if (Utils.checkNonEmptyStringAttribute(miQxVNpQ))
			VhHX3vt3 += "&pid=" + miQxVNpQ;
		if (Utils.checkNonEmptyStringAttribute(NIyHZ0nR))
			VhHX3vt3 += "&mclass=" + NIyHZ0nR;
		if (Utils.checkNonEmptyStringAttribute(NYbohAi8))
			VhHX3vt3 += "&mwi=" + NYbohAi8;
		URL X1sDsOnG = new URL("http://" + pvhxtvTr + ":" + UF3UNUOy + "/cgi-bin/sendsms?" + VhHX3vt3);
		URLConnection fAE8PdxT = X1sDsOnG.openConnection();
		BufferedReader H7XSrGHM = new BufferedReader(new InputStreamReader(fAE8PdxT.getInputStream()));
		String eGtpx6i6;
		while ((eGtpx6i6 = H7XSrGHM.readLine()) != null)
			M8F8emw6.append(eGtpx6i6);
		H7XSrGHM.close();
		String x0dLcayZ = M8F8emw6.substring(0, M8F8emw6.indexOf(":"));
		if (!x0dLcayZ.equals(SMS_PUSH_RESPONSE_SUCCESS_CODE))
			throw new SMSPushRequestException(x0dLcayZ);
		return M8F8emw6.toString();
	}

}