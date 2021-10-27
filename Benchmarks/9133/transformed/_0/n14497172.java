class n14497172 {
	public String getHtml(String E4UL78Ke) throws Exception {
		URL uSMdD4Cn = new URL(E4UL78Ke);
		URLConnection UwPJWw8w = uSMdD4Cn.openConnection();
		UwPJWw8w.setDoOutput(true);
		InputStream UqzVeRip = UwPJWw8w.getInputStream();
		InputStreamReader Qco7Y2EX = new InputStreamReader(UqzVeRip, "UTF-8");
		StringBuilder F6dh8Udg = new StringBuilder();
		BufferedReader DdU3UVSJ = new BufferedReader(Qco7Y2EX);
		String r7Ar414X;
		while ((r7Ar414X = DdU3UVSJ.readLine()) != null) {
			F6dh8Udg.append(r7Ar414X);
		}
		String NpEzixaw = F6dh8Udg.toString();
		return NpEzixaw;
	}

}