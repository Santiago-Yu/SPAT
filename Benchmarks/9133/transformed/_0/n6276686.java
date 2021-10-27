class n6276686 {
	public static String sendGetRequest(String OBaNukLF, String mRLpXssU) {
		String S0UM0sTC = null;
		if (OBaNukLF.startsWith("http://")) {
			try {
				StringBuffer KGNPA3xY = new StringBuffer();
				String woU4eklc = OBaNukLF;
				if (mRLpXssU != null && mRLpXssU.length() > 0) {
					woU4eklc += "?" + mRLpXssU;
				}
				URL gR7Ltbut = new URL(woU4eklc);
				URLConnection AhaGdHlj = gR7Ltbut.openConnection();
				BufferedReader bKlPkQ9P = new BufferedReader(new InputStreamReader(AhaGdHlj.getInputStream()));
				StringBuffer zIvnjPHr = new StringBuffer();
				String hoi17DRG;
				while ((hoi17DRG = bKlPkQ9P.readLine()) != null) {
					zIvnjPHr.append(hoi17DRG + "\n");
				}
				bKlPkQ9P.close();
				S0UM0sTC = zIvnjPHr.toString();
			} catch (Exception OJl0OfjI) {
			}
		}
		return S0UM0sTC;
	}

}