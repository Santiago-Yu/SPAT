class n19424081 {
	public static String getContent(String AptK0EdS, String s22TLvTe) {
		HttpURLConnection Zbws9ZlQ = null;
		try {
			URL Keykiyzk = new URL(AptK0EdS);
			Zbws9ZlQ = (HttpURLConnection) Keykiyzk.openConnection();
			Zbws9ZlQ.setConnectTimeout(30000);
			Zbws9ZlQ.setReadTimeout(30000);
			Zbws9ZlQ.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; GTB5; .NET CLR 1.1.4322; .NET CLR 2.0.50727; Alexa Toolbar; MAXTHON 2.0)");
			return StringUtil.convertStreamToString(Zbws9ZlQ.getInputStream(), s22TLvTe);
		} catch (Exception bpwqw6a4) {
			slogger.warn(bpwqw6a4.getMessage());
		} finally {
			if (Zbws9ZlQ != null) {
				Zbws9ZlQ.disconnect();
			}
		}
		slogger.warn("这个没找到" + AptK0EdS);
		return null;
	}

}