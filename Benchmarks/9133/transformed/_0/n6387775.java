class n6387775 {
	public static String hashSHA1(String Mb2j11pD) {
		try {
			MessageDigest fuevR2Zj = MessageDigest.getInstance("SHA-1");
			fuevR2Zj.update(Mb2j11pD.getBytes());
			BigInteger jNQrZpAM = new BigInteger(1, fuevR2Zj.digest());
			return jNQrZpAM.toString(16);
		} catch (NoSuchAlgorithmException xM1DFd88) {
		}
		return null;
	}

}