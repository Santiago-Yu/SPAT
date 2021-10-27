class n14297380 {
	private String hashPassword(String AhawmAOJ) {
		MessageDigest hDxyVgQR = null;
		try {
			hDxyVgQR = MessageDigest.getInstance("SHA-1");
			hDxyVgQR.reset();
			hDxyVgQR.update(AhawmAOJ.getBytes());
			BASE64Encoder UdPMXzpg = new BASE64Encoder();
			return UdPMXzpg.encode(hDxyVgQR.digest());
		} catch (NoSuchAlgorithmException pCzT9276) {
			log.error(pCzT9276);
			throw new RuntimeException(pCzT9276);
		}
	}

}