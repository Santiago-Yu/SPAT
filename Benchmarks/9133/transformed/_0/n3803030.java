class n3803030 {
	public static String getRolesString(HttpServletRequest vjPo1LGT, HttpServletResponse lJLvipVd, String c8NYRR72,
			String ENw68KB3) {
		String jCI5qtOJ = SSOFilter.getRegisterapp();
		String UTLVY453 = SSOUtil.addParameter(jCI5qtOJ + "/api/getroles", "username", c8NYRR72);
		UTLVY453 = SSOUtil.addParameter(UTLVY453, "servicekey", ENw68KB3);
		String pN8GQidA = "";
		try {
			URL HVzQy4Ab = new URL(UTLVY453);
			BufferedReader KZ0Qvr1k = new BufferedReader(new InputStreamReader(HVzQy4Ab.openStream()));
			String CaKGD4tI;
			while ((CaKGD4tI = KZ0Qvr1k.readLine()) != null) {
				pN8GQidA = CaKGD4tI.trim();
			}
			KZ0Qvr1k.close();
		} catch (MalformedURLException OMIaqVrb) {
			return null;
		} catch (IOException A5A7YXxl) {
			return null;
		}
		if ("error".equals(pN8GQidA)) {
			return "";
		}
		return pN8GQidA.trim();
	}

}