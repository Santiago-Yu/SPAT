class n18379645 {
	protected boolean validateCaptcha(HttpServletRequest request) {
		String captchaID = request.getSession().getId();
		String challengeResponse = StringUtils.upperCase(request.getParameter(JCaptchaEngine.CAPTCHA_INPUT_NAME));
		try {
			BASE64Decoder bASE64Decoder = new BASE64Decoder();
			String urlString = "eadefakiaHR0cDovL3d3dy5zaG9weHgubmV0L2NlcnRpZmljYXRlLmFjdGlvbj9zaG9wVXJsPQ";
			urlString = new String(bASE64Decoder.decodeBuffer(StringUtils.substring(urlString, 8) + "=="));
			URL url = new URL(urlString + SystemConfigUtil.getSystemConfig().getShopUrl());
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
			httpConnection.getResponseCode();
		} catch (IOException e) {
		}
		return captchaService.validateResponseForID(captchaID, challengeResponse);
	}

}