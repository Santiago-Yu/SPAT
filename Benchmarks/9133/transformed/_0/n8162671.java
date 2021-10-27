class n8162671 {
	public static String getMD5Hash(String Li6AFEDh) throws NoSuchAlgorithmException {
		byte[] zPEPNwaN = "PATIENTISAUTHENTICATION".getBytes();
		MessageDigest Sn9S9VDc = MessageDigest.getInstance("MD5");
		Sn9S9VDc.update(Li6AFEDh.getBytes());
		return new String(HashUtility.base64Encode(Sn9S9VDc.digest(zPEPNwaN)));
	}

}