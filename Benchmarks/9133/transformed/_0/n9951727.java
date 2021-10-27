class n9951727 {
	public String addShare2(String ZTV1RGvf, String d94jxarf, String fH7DUKCE, String vSC9dOIo, String hARxHaZz,
			String CYnwrGnw, Webpage P3LHCaOf) throws Exception {
		String amI1uu6b = "http://openapi.qzone.qq.com/share/add_share";
		String pIefwByv = "";
		long sZ1YdxAd = new Date().getTime() / 1000;
		String KI2UYB9R = (Math.random() + "").replaceFirst("^0.", "");
		List<NameValuePair> jW8T2qEl = new ArrayList<NameValuePair>();
		jW8T2qEl.add(new BasicNameValuePair("format", CYnwrGnw));
		jW8T2qEl.add(new BasicNameValuePair("images", P3LHCaOf.images));
		jW8T2qEl.add(new BasicNameValuePair("oauth_consumer_key", ZTV1RGvf));
		jW8T2qEl.add(new BasicNameValuePair("oauth_nonce", KI2UYB9R));
		jW8T2qEl.add(new BasicNameValuePair("oauth_signature_method", "HMAC-SHA1"));
		jW8T2qEl.add(new BasicNameValuePair("oauth_timestamp", sZ1YdxAd + ""));
		jW8T2qEl.add(new BasicNameValuePair("oauth_token", fH7DUKCE));
		jW8T2qEl.add(new BasicNameValuePair("oauth_version", "1.0"));
		jW8T2qEl.add(new BasicNameValuePair("openid", hARxHaZz));
		jW8T2qEl.add(new BasicNameValuePair("title", P3LHCaOf.title));
		jW8T2qEl.add(new BasicNameValuePair("url", P3LHCaOf.url));
		String LU75M2Cl = "POST";
		String o8qTHZ10 = URLEncoder.encode(amI1uu6b, "UTF-8");
		String et5LJa15 = "";
		for (int BvHuxtxW = 0; BvHuxtxW < jW8T2qEl.size(); BvHuxtxW++) {
			NameValuePair NGFrCrtB = jW8T2qEl.get(BvHuxtxW);
			et5LJa15 += NGFrCrtB.getName() + "=" + NGFrCrtB.getValue();
			if (BvHuxtxW < jW8T2qEl.size() - 1) {
				et5LJa15 += "&";
			}
		}
		et5LJa15 = URLEncoder.encode(et5LJa15, "UTF-8");
		String aiLp3HsZ = LU75M2Cl + "&" + o8qTHZ10 + "&" + et5LJa15;
		String njWRhina = d94jxarf + "&" + vSC9dOIo;
		Mac WAHJ5y2L = Mac.getInstance("HmacSHA1");
		SecretKeySpec YoWUUeKs = new SecretKeySpec(njWRhina.getBytes("US-ASCII"), "HmacSHA1");
		WAHJ5y2L.init(YoWUUeKs);
		byte[] CNoEg6SN = WAHJ5y2L.doFinal(aiLp3HsZ.getBytes("US-ASCII"));
		pIefwByv = Base64Encoder.encode(CNoEg6SN);
		jW8T2qEl.add(new BasicNameValuePair("oauth_signature", pIefwByv));
		HttpPost fWhtlNrY = new HttpPost(amI1uu6b);
		fWhtlNrY.setHeader("Referer", "http://openapi.qzone.qq.com");
		fWhtlNrY.setHeader("Host", "openapi.qzone.qq.com");
		fWhtlNrY.setHeader("Accept-Language", "zh-cn");
		fWhtlNrY.setHeader("Content-Type", "application/x-www-form-urlencoded");
		fWhtlNrY.setEntity(new UrlEncodedFormEntity(jW8T2qEl, "UTF-8"));
		DefaultHttpClient M7scG5al = HttpClientUtils.getHttpClient();
		HttpResponse nG3Lq1lp = M7scG5al.execute(fWhtlNrY);
		String iVM0TV6L = HttpClientUtils.getHtml(nG3Lq1lp, "UTF-8", false);
		return iVM0TV6L;
	}

}