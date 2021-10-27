class n10222828 {
	public static String getMD5Hash(String OMWazIt1) {
		MessageDigest iFNSEI1b;
		try {
			iFNSEI1b = java.security.MessageDigest.getInstance("MD5");
			iFNSEI1b.update(OMWazIt1.getBytes());
			byte[] R7T3EPtf = iFNSEI1b.digest();
			StringBuffer hB12pxHK = new StringBuffer();
			String WCDRByWv = "";
			for (int zinUYeva = 0; zinUYeva < R7T3EPtf.length; zinUYeva++) {
				WCDRByWv = Integer.toHexString(0xFF & R7T3EPtf[zinUYeva]);
				if (WCDRByWv.length() < 2) {
					WCDRByWv = "0" + WCDRByWv;
				}
				hB12pxHK.append(WCDRByWv);
			}
			return hB12pxHK.toString();
		} catch (NoSuchAlgorithmException roW4WNn9) {
			return null;
		}
	}

}