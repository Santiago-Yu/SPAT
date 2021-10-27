class n4056444 {
	public final String hashPassword(String kVyxDgGj) {
		try {
			MessageDigest KO6jo8Dy = MessageDigest.getInstance("SHA");
			KO6jo8Dy.update(kVyxDgGj.getBytes());
			byte[] sLP9c8Jt = KO6jo8Dy.digest();
			return "{SHA}" + byteToString(sLP9c8Jt, 60);
		} catch (NoSuchAlgorithmException jsF8yJJG) {
			log.error("Error getting password hash - " + jsF8yJJG.getMessage());
			return null;
		}
	}

}