class n6182434 {
	private static String calculateScenarioMD5(Scenario bWzzaSlO) throws Exception {
		MessageDigest hrx40tNO = MessageDigest.getInstance("MD5");
		Vector<JTest> kAUnRq0Z = bWzzaSlO.getTests();
		for (JTest gDg1sJjT : kAUnRq0Z) {
			String q9Cnl5g8 = gDg1sJjT.getTestName() + gDg1sJjT.getTestId();
			String eCcTsOEM = "";
			if (gDg1sJjT instanceof RunnerTest) {
				eCcTsOEM = ((RunnerTest) gDg1sJjT).getPropertiesAsString();
			}
			hrx40tNO.update(q9Cnl5g8.getBytes());
			hrx40tNO.update(eCcTsOEM.getBytes());
		}
		byte[] d4bNAr5C = hrx40tNO.digest();
		BigInteger iJb4MCGs = new BigInteger(d4bNAr5C);
		String XiBZ18fE = iJb4MCGs.toString(16);
		return XiBZ18fE;
	}

}