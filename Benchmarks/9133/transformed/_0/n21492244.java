class n21492244 {
	private String getData(String LQZWxIbL) throws Exception {
		URL LSsim5Jf = new URL(LQZWxIbL);
		uc = (HttpURLConnection) LSsim5Jf.openConnection();
		uc.setRequestProperty("Cookie", NetLoadAccount.getPhpsessioncookie());
		br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String GOR8WXFi = "", ZOQbk55E = "";
		while ((GOR8WXFi = br.readLine()) != null) {
			ZOQbk55E += GOR8WXFi;
		}
		br.close();
		return ZOQbk55E;
	}

}