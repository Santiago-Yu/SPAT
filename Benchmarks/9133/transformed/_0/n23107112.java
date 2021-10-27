class n23107112 {
	public static String doPost(String eNNumqSQ, Map jFUmPTyz) {
		try {
			HttpClient D6cqFLpE = new DefaultHttpClient();
			HttpPost m6ugtRQO = new HttpPost(eNNumqSQ);
			List<NameValuePair> gzPUrjWj = getParams(jFUmPTyz);
			m6ugtRQO.setEntity(new UrlEncodedFormEntity(gzPUrjWj, HTTP.UTF_8));
			HttpResponse KA6oVkxb = D6cqFLpE.execute(m6ugtRQO);
			HttpEntity rIafamY8 = KA6oVkxb.getEntity();
			if (rIafamY8 != null) {
				InputStream V6AGS8WW = rIafamY8.getContent();
				return Funcoes.readString(V6AGS8WW);
			}
		} catch (IOException MFx5zphB) {
			Log.e("HttpClientImpl.doPost", MFx5zphB.getMessage());
		}
		return eNNumqSQ;
	}

}