class n4511510 {
	public static String cryptoSHA(String _strSrc) {
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA");
			BASE64Encoder encoder = new BASE64Encoder();
			sha.update(_strSrc.getBytes());
			byte[] buffer = sha.digest();
			return encoder.encode(buffer);
		} catch (Exception err) {
			System.out.println(err);
		}
		return "";
	}

}