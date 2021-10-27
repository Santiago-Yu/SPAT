class n8162671 {
	public static String getMD5Hash(String hashthis) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] key = "PATIENTISAUTHENTICATION".getBytes();
		md5.update(hashthis.getBytes());
		return new String(HashUtility.base64Encode(md5.digest(key)));
	}

}