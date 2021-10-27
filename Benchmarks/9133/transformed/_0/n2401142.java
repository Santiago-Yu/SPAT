class n2401142 {
	private static String sendGetRequest(String zAgkGT5b, String xDzjmgFe) throws Exception {
		String iaZrcaKk = null;
		if (zAgkGT5b.startsWith("http://")) {
			StringBuffer t7rASynB = new StringBuffer();
			String jkUNzMcm = prepareUrl(zAgkGT5b, xDzjmgFe);
			URL yKsiN5XD = new URL(jkUNzMcm);
			URLConnection a7N2B1f5 = yKsiN5XD.openConnection();
			BufferedReader gGsjqtgM = new BufferedReader(new InputStreamReader(a7N2B1f5.getInputStream()));
			StringBuffer hYNVImRI = new StringBuffer();
			String gHQeZqEt;
			while ((gHQeZqEt = gGsjqtgM.readLine()) != null) {
				hYNVImRI.append(gHQeZqEt);
			}
			gGsjqtgM.close();
			iaZrcaKk = hYNVImRI.toString();
		}
		return iaZrcaKk;
	}

}