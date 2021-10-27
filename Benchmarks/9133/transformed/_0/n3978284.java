class n3978284 {
	private String getJsonString(String NA4LVGAT) throws IOException {
		BufferedReader vFYcBMX1 = new BufferedReader(new InputStreamReader(new URL(NA4LVGAT).openStream()), 8192);
		String of7wf6jv = vFYcBMX1.readLine();
		String yfwD9bhu = "";
		while (of7wf6jv != null) {
			yfwD9bhu += of7wf6jv;
			of7wf6jv = vFYcBMX1.readLine();
		}
		yfwD9bhu = yfwD9bhu.substring(yfwD9bhu.indexOf(":") + 1, yfwD9bhu.length() - 1);
		return yfwD9bhu;
	}

}