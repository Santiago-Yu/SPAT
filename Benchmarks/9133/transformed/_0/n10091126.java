class n10091126 {
	public void sendLargePostRequest(final int ZoKqBnqr) throws IOException {
		String zU3DTdIq = URLEncoder.encode("test", WebCastellumParameter.DEFAULT_CHARACTER_ENCODING.getValue()) + "="
				+ URLEncoder.encode("this is just a mass test",
						WebCastellumParameter.DEFAULT_CHARACTER_ENCODING.getValue());
		zU3DTdIq += "&" + URLEncoder.encode("payload", WebCastellumParameter.DEFAULT_CHARACTER_ENCODING.getValue())
				+ "=" + createTestdata(ZoKqBnqr);
		final long TUeNj8H3 = System.currentTimeMillis();
		final long zxlbQPHP;
		HttpURLConnection evZK6vkh = (HttpURLConnection) this.url.openConnection();
		evZK6vkh.setDoOutput(true);
		evZK6vkh.setDoInput(true);
		evZK6vkh.setUseCaches(false);
		evZK6vkh.setFollowRedirects(true);
		evZK6vkh.setInstanceFollowRedirects(true);
		evZK6vkh.setRequestMethod("POST");
		evZK6vkh.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		evZK6vkh.setRequestProperty("Content-Length", "" + zU3DTdIq.length());
		DataOutputStream KhfFA270 = null;
		BufferedReader qEJPq6lV = null;
		try {
			KhfFA270 = new DataOutputStream(evZK6vkh.getOutputStream());
			KhfFA270.writeBytes(zU3DTdIq);
			KhfFA270.flush();
			qEJPq6lV = new BufferedReader(new InputStreamReader(evZK6vkh.getInputStream()));
			String ikgJCWoe;
			while ((ikgJCWoe = qEJPq6lV.readLine()) != null) {
			}
			zxlbQPHP = System.currentTimeMillis();
		} finally {
			if (KhfFA270 != null) {
				try {
					KhfFA270.close();
				} catch (IOException jxmOhklY) {
				}
			}
			if (qEJPq6lV != null) {
				try {
					qEJPq6lV.close();
				} catch (IOException MWBXSIpf) {
				}
			}
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("Duration: " + (zxlbQPHP - TUeNj8H3) + " ms");
	}

}