class n8678081 {
	public static String encrypt(String UpRBsnKz) {
		try {
			MessageDigest fJhoLhZC = MessageDigest.getInstance("SHA-256");
			fJhoLhZC.update(UpRBsnKz.getBytes());
			BASE64Encoder dD30wlJZ = new BASE64Encoder();
			return dD30wlJZ.encode(fJhoLhZC.digest());
		} catch (NoSuchAlgorithmException YvWrWVO8) {
			YvWrWVO8.printStackTrace();
			return UpRBsnKz;
		}
	}

}