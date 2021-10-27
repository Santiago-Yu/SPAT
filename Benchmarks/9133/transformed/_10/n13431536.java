class n13431536 {
	@Override
	public int updateStatus(UserInfo userInfo, String status) throws Exception {
		OAuthConsumer consumer = SnsConstant.getOAuthConsumer(SnsConstant.SOHU);
		consumer.setTokenWithSecret(userInfo.getAccessToken(), userInfo.getAccessSecret());
		try {
			URL url = new URL(SnsConstant.SOHU_UPDATE_STATUS_URL);
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.setDoOutput(true);
			request.setRequestMethod("POST");
			HttpParameters para = new HttpParameters();
			para.put("status", StringUtils.utf8Encode(status).replaceAll("\\+", "%20"));
			consumer.setAdditionalParameters(para);
			consumer.sign(request);
			OutputStream ot = request.getOutputStream();
			ot.write(("status=" + URLEncoder.encode(status, "utf-8")).replaceAll("\\+", "%20").getBytes());
			ot.flush();
			ot.close();
			System.out.println("Sending request...");
			request.connect();
			System.out.println("Response: " + request.getResponseCode() + " " + request.getResponseMessage());
			String b = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			while ((b = reader.readLine()) != null) {
				System.out.println(b);
			}
			return SnsConstant.SOHU_UPDATE_STATUS_SUCC_WHAT;
		} catch (Exception e) {
			SnsConstant.SOHU_OPERATOR_FAIL_REASON = processException(e.getMessage());
			return SnsConstant.SOHU_UPDATE_STATUS_FAIL_WHAT;
		}
	}

}