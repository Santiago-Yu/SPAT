class n7911674 {
	public static String getStringHash(String NMceMEFm) {
		try {
			MessageDigest pPwrrXYJ = MessageDigest.getInstance("md5");
			pPwrrXYJ.reset();
			pPwrrXYJ.update(NMceMEFm.getBytes());
			byte xc4dyoMW[] = pPwrrXYJ.digest();
			StringBuilder JqCjtSGC = new StringBuilder();
			for (int Wz9RLBky = 0; Wz9RLBky < xc4dyoMW.length; Wz9RLBky++)
				JqCjtSGC.append(Integer.toHexString(0xFF & xc4dyoMW[Wz9RLBky]));
			String o8YqYpvS = JqCjtSGC.toString();
			return o8YqYpvS;
		} catch (NoSuchAlgorithmException Vfd5nWVq) {
			return NMceMEFm;
		}
	}

}