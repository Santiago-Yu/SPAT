class n297790 {
	public static String get(String YHqWs96F) {
		try {
			URL ijROKJ04 = new URL(YHqWs96F);
			URLConnection yBP3uKp1 = ijROKJ04.openConnection();
			BufferedReader FuHtNgSz = new BufferedReader(new InputStreamReader(yBP3uKp1.getInputStream()));
			String HomS0CLv = "";
			String kjBA1gWn = "";
			while ((HomS0CLv = FuHtNgSz.readLine()) != null) {
				kjBA1gWn += HomS0CLv;
			}
			return kjBA1gWn;
		} catch (MalformedURLException iE6akNeE) {
			iE6akNeE.printStackTrace();
		} catch (IOException LCCdJkN4) {
			LCCdJkN4.printStackTrace();
		}
		return "";
	}

}