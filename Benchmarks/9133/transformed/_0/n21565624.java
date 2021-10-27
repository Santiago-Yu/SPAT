class n21565624 {
	public static String encryption(String YOBm8S9m) {
		MessageDigest ZWHMfPOI = null;
		try {
			ZWHMfPOI = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException snJpiCp6) {
			snJpiCp6.printStackTrace();
		}
		ZWHMfPOI.update(YOBm8S9m.getBytes());
		byte DNgPGheB[] = ZWHMfPOI.digest();
		int F9xItfSh;
		StringBuffer obhdQ4OK = new StringBuffer();
		for (int KiiI3Yh0 = 0; KiiI3Yh0 < DNgPGheB.length; KiiI3Yh0++) {
			F9xItfSh = DNgPGheB[KiiI3Yh0];
			if (F9xItfSh < 0) {
				F9xItfSh += 256;
			}
			if (F9xItfSh < 16) {
				obhdQ4OK.append("0");
			}
			obhdQ4OK.append(Integer.toHexString(F9xItfSh));
		}
		String xhoJWohP = obhdQ4OK.toString();
		return xhoJWohP;
	}

}