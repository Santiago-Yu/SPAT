class n13431536 {
	@Override
	public int updateStatus(UserInfo cO965BnR, String diz8qZdT) throws Exception {
		OAuthConsumer CL7kYKvF = SnsConstant.getOAuthConsumer(SnsConstant.SOHU);
		CL7kYKvF.setTokenWithSecret(cO965BnR.getAccessToken(), cO965BnR.getAccessSecret());
		try {
			URL ldfM7UUP = new URL(SnsConstant.SOHU_UPDATE_STATUS_URL);
			HttpURLConnection iG0IQmgc = (HttpURLConnection) ldfM7UUP.openConnection();
			iG0IQmgc.setDoOutput(true);
			iG0IQmgc.setRequestMethod("POST");
			HttpParameters V80veSPv = new HttpParameters();
			V80veSPv.put("status", StringUtils.utf8Encode(diz8qZdT).replaceAll("\\+", "%20"));
			CL7kYKvF.setAdditionalParameters(V80veSPv);
			CL7kYKvF.sign(iG0IQmgc);
			OutputStream h4qhf6Fp = iG0IQmgc.getOutputStream();
			h4qhf6Fp.write(("status=" + URLEncoder.encode(diz8qZdT, "utf-8")).replaceAll("\\+", "%20").getBytes());
			h4qhf6Fp.flush();
			h4qhf6Fp.close();
			System.out.println("Sending request...");
			iG0IQmgc.connect();
			System.out.println("Response: " + iG0IQmgc.getResponseCode() + " " + iG0IQmgc.getResponseMessage());
			BufferedReader nKSzgvdg = new BufferedReader(new InputStreamReader(iG0IQmgc.getInputStream()));
			String RFjPMuPQ = null;
			while ((RFjPMuPQ = nKSzgvdg.readLine()) != null) {
				System.out.println(RFjPMuPQ);
			}
			return SnsConstant.SOHU_UPDATE_STATUS_SUCC_WHAT;
		} catch (Exception pgY3Iihz) {
			SnsConstant.SOHU_OPERATOR_FAIL_REASON = processException(pgY3Iihz.getMessage());
			return SnsConstant.SOHU_UPDATE_STATUS_FAIL_WHAT;
		}
	}

}