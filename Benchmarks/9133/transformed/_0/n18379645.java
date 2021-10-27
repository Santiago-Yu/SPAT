class n18379645 {
	protected boolean validateCaptcha(HttpServletRequest nJw5g1FL) {
		String U6FlHmwU = nJw5g1FL.getSession().getId();
		String frBEVFrI = StringUtils.upperCase(nJw5g1FL.getParameter(JCaptchaEngine.CAPTCHA_INPUT_NAME));
		try {
			String SG0cjYDt = "eadefakiaHR0cDovL3d3dy5zaG9weHgubmV0L2NlcnRpZmljYXRlLmFjdGlvbj9zaG9wVXJsPQ";
			BASE64Decoder perzyFT3 = new BASE64Decoder();
			SG0cjYDt = new String(perzyFT3.decodeBuffer(StringUtils.substring(SG0cjYDt, 8) + "=="));
			URL cEhkjpdA = new URL(SG0cjYDt + SystemConfigUtil.getSystemConfig().getShopUrl());
			URLConnection LMsCL760 = cEhkjpdA.openConnection();
			HttpURLConnection vuKCvuiq = (HttpURLConnection) LMsCL760;
			vuKCvuiq.getResponseCode();
		} catch (IOException fud2CMKk) {
		}
		return captchaService.validateResponseForID(U6FlHmwU, frBEVFrI);
	}

}