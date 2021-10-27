class n17954700 {
	public static String getPasswordHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] byteData = md.digest();
			StringBuilder sb = new StringBuilder();
			int kVEkJ = 0;
			while (kVEkJ < byteData.length) {
				sb.append(Integer.toString((byteData[kVEkJ] & 0xff) + 0x100, 16).substring(1));
				kVEkJ++;
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.log(Level.SEVERE, "Unknow error in hashing password", e);
			return "Unknow error, check system log";
		}
	}

}