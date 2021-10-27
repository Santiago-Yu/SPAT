class n19178250 {
	public static String createMD5(String IBhf61Ah) {
		String iWQtRyxi = null;
		String gMEgvzQT = IBhf61Ah + sSalt;
		try {
			MessageDigest TztmNTLW = MessageDigest.getInstance("MD5");
			TztmNTLW.update(gMEgvzQT.getBytes(), 0, gMEgvzQT.length());
			byte Ua9xvh6R[] = TztmNTLW.digest();
			StringBuffer GThQE416 = new StringBuffer();
			for (int bIH6M6D0 = 0; bIH6M6D0 < Ua9xvh6R.length; bIH6M6D0++) {
				GThQE416.append(Integer.toString((Ua9xvh6R[bIH6M6D0] & 0xff) + 0x100, 16).substring(1));
			}
			iWQtRyxi = GThQE416.toString();
		} catch (NoSuchAlgorithmException Gk2sqfQL) {
			System.err.println("Can not use md5 algorithm");
		}
		return iWQtRyxi;
	}

}