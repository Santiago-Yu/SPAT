class n4223002 {
	public String getPasswordMD5() {
		try {
			MessageDigest KjSh1nLl = MessageDigest.getInstance("MD5");
			KjSh1nLl.reset();
			KjSh1nLl.update(password.getBytes());
			byte grKi9VEQ[] = KjSh1nLl.digest();
			StringBuffer ilIMWDUn = new StringBuffer();
			for (int JRLM95xD = 0; JRLM95xD < grKi9VEQ.length; JRLM95xD++) {
				ilIMWDUn.append(Integer.toHexString(0xFF & grKi9VEQ[JRLM95xD]));
			}
			return ilIMWDUn.toString();
		} catch (NoSuchAlgorithmException uXPsq0AM) {
		}
		return null;
	}

}