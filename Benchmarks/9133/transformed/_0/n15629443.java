class n15629443 {
	public static String encryptPassword(String SNnKIfUM) throws PasswordException {
		String iJdH9KRp = null;
		if (SNnKIfUM != null && !SNnKIfUM.equals("")) {
			try {
				MessageDigest eW8uo2QO = MessageDigest.getInstance("SHA");
				eW8uo2QO.update(SNnKIfUM.getBytes("UTF-8"));
				byte ZrcfjfmT[] = eW8uo2QO.digest();
				iJdH9KRp = (new BASE64Encoder()).encode(ZrcfjfmT);
			} catch (NoSuchAlgorithmException D5Ze3SYo) {
				throw new PasswordException(PasswordException.SYSTEM_ERROR);
			} catch (UnsupportedEncodingException tx5oe3Rl) {
				throw new PasswordException(PasswordException.SYSTEM_ERROR);
			}
		}
		return iJdH9KRp;
	}

}