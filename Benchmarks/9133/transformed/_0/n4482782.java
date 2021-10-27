class n4482782 {
	public static String httpGet(URL bFbnlu0C) throws Exception {
		URLConnection RwvRSsOE = bFbnlu0C.openConnection();
		BufferedReader araJiEr2 = new BufferedReader(new InputStreamReader(RwvRSsOE.getInputStream()));
		StringBuffer GIszd8aL = new StringBuffer();
		String MSkCpOEf = null;
		while ((MSkCpOEf = araJiEr2.readLine()) != null) {
			GIszd8aL.append(MSkCpOEf);
		}
		return GIszd8aL.toString();
	}

}