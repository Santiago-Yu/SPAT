class n13024538 {
	public static String getHash(String MLYxwPVm) throws NoSuchAlgorithmException {
		MessageDigest ciUxPmwA = MessageDigest.getInstance("MD5");
		ciUxPmwA.update(MLYxwPVm.getBytes());
		byte c9mOZMja[] = ciUxPmwA.digest();
		StringBuffer YMtH2eLx = new StringBuffer();
		for (int j3ChKUFB = 0; j3ChKUFB < c9mOZMja.length; j3ChKUFB++) {
			YMtH2eLx.append(Integer.toHexString(0xFF & c9mOZMja[j3ChKUFB]));
		}
		return YMtH2eLx.toString();
	}

}