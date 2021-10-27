class n17954700 {
	public static String getPasswordHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] byteData = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteData.length; i++) {
				int XJmT1xSC = byteData[i] & 0xff;
				sb.append(Integer.toString((XJmT1xSC) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.log(Level.SEVERE, "Unknow error in hashing password", e);
			return "Unknow error, check system log";
		}
	}

}