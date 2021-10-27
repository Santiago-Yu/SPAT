class n7468819 {
	public void run() {
		try {
			HttpURLConnection SUKTrppO = (HttpURLConnection) url.openConnection();
			SUKTrppO.setRequestMethod("GET");
			SUKTrppO.setDoInput(true);
			byte[] z6elDV2h = (username + ":" + password).getBytes();
			BASE64Encoder JoaPE0EF = new BASE64Encoder();
			SUKTrppO.setRequestProperty("Authorization", "Basic " + JoaPE0EF.encode(z6elDV2h));
			InputStream yqEW8K9o = SUKTrppO.getInputStream();
			BufferedReader Xmb0BmXc = new BufferedReader(new InputStreamReader(yqEW8K9o));
			String hp49W90q;
			StringBuffer oNSnSyZ1 = new StringBuffer();
			while ((hp49W90q = Xmb0BmXc.readLine()) != null) {
				oNSnSyZ1.append(hp49W90q);
				oNSnSyZ1.append('\n');
				lastIteraction = System.currentTimeMillis();
			}
			Xmb0BmXc.close();
			yqEW8K9o.close();
			SUKTrppO.disconnect();
			result = oNSnSyZ1.toString();
			finish = true;
		} catch (Throwable hYzvNy4Z) {
			this.e = hYzvNy4Z;
		}
	}

}