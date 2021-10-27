class n1022820 {
	public static final String computeHash(String stringToCompile) {
		String retVal = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(stringToCompile.getBytes());
			StringBuffer hexString = new StringBuffer();
			byte[] result = md5.digest();
			for (int i = 0; i < result.length; i++) {
				hexString.append(Integer.toHexString(0xFF & result[i]));
			}
			retVal = hexString.toString();
			if (log.isDebugEnabled())
				log.debug("MD5 hash for \"" + stringToCompile + "\" is: " + retVal);
		} catch (Exception exe) {
			log.error(exe.getMessage(), exe);
		}
		return retVal;
	}

}