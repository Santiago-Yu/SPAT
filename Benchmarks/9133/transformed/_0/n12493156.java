class n12493156 {
	public static String hashPassword(String wKcEZKDs) {
		if (wKcEZKDs == null) {
			return "";
		}
		MessageDigest wekOi2rG = null;
		try {
			wekOi2rG = MessageDigest.getInstance("SHA1");
			wekOi2rG.update(wKcEZKDs.getBytes("UTF-8"));
		} catch (Exception jfEWtPmT) {
			logger.log(Level.SEVERE, "Problem hashing password.", jfEWtPmT);
		}
		return new String(Base64.encodeBase64(wekOi2rG.digest()));
	}

}