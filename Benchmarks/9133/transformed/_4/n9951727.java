class n9951727 {
	public String addShare2(String appid, String appkey, String oauth_token, String oauth_token_secret, String openid,
			String format, Webpage webpage) throws Exception {
		String shareUrl = "http://openapi.qzone.qq.com/share/add_share";
		String oauth_signature = "";
		long oauth_timestamp = new Date().getTime() / 1000;
		String oauth_nonce = (Math.random() + "").replaceFirst("^0.", "");
		List<NameValuePair> shareParameters = new ArrayList<NameValuePair>();
		shareParameters.add(new BasicNameValuePair("format", format));
		shareParameters.add(new BasicNameValuePair("images", webpage.images));
		shareParameters.add(new BasicNameValuePair("oauth_consumer_key", appid));
		shareParameters.add(new BasicNameValuePair("oauth_nonce", oauth_nonce));
		shareParameters.add(new BasicNameValuePair("oauth_signature_method", "HMAC-SHA1"));
		shareParameters.add(new BasicNameValuePair("oauth_timestamp", oauth_timestamp + ""));
		shareParameters.add(new BasicNameValuePair("oauth_token", oauth_token));
		shareParameters.add(new BasicNameValuePair("oauth_version", "1.0"));
		shareParameters.add(new BasicNameValuePair("openid", openid));
		shareParameters.add(new BasicNameValuePair("title", webpage.title));
		shareParameters.add(new BasicNameValuePair("url", webpage.url));
		String stepA1 = "POST";
		String stepA2 = URLEncoder.encode(shareUrl, "UTF-8");
		String stepA3 = "";
		for (int i = 0; i < shareParameters.size(); i++) {
			NameValuePair item = shareParameters.get(i);
			stepA3 += item.getName() + "=" + item.getValue();
			stepA3 = (i < shareParameters.size() - 1) ? "&" : stepA3;
		}
		stepA3 = URLEncoder.encode(stepA3, "UTF-8");
		String stepA = stepA1 + "&" + stepA2 + "&" + stepA3;
		String stepB = appkey + "&" + oauth_token_secret;
		Mac mac = Mac.getInstance("HmacSHA1");
		SecretKeySpec spec = new SecretKeySpec(stepB.getBytes("US-ASCII"), "HmacSHA1");
		mac.init(spec);
		byte[] oauthSignature = mac.doFinal(stepA.getBytes("US-ASCII"));
		oauth_signature = Base64Encoder.encode(oauthSignature);
		shareParameters.add(new BasicNameValuePair("oauth_signature", oauth_signature));
		HttpPost sharePost = new HttpPost(shareUrl);
		sharePost.setHeader("Referer", "http://openapi.qzone.qq.com");
		sharePost.setHeader("Host", "openapi.qzone.qq.com");
		sharePost.setHeader("Accept-Language", "zh-cn");
		sharePost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		sharePost.setEntity(new UrlEncodedFormEntity(shareParameters, "UTF-8"));
		DefaultHttpClient httpclient = HttpClientUtils.getHttpClient();
		HttpResponse loginPostRes = httpclient.execute(sharePost);
		String shareHtml = HttpClientUtils.getHtml(loginPostRes, "UTF-8", false);
		return shareHtml;
	}

}