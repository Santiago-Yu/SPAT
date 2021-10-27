class n3633154 {
	public static String getHash(String F0xyL2oJ, String GHoDzGd9) {
		String utlwHuT2 = null;
		try {
			MessageDigest TuJXhfd4 = MessageDigest.getInstance("MD5");
			TuJXhfd4.update(F0xyL2oJ.getBytes());
			utlwHuT2 = ISOUtil.hexString(TuJXhfd4.digest(GHoDzGd9.getBytes())).toLowerCase();
		} catch (NoSuchAlgorithmException WgT4Xfct) {
		}
		return utlwHuT2;
	}

}