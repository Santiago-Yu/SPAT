class n1022820 {
	public static final String computeHash(String stringToCompile) {
		String retVal = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(stringToCompile.getBytes());
			byte[] result = md5.digest();
			StringBuffer hexString = new StringBuffer();
			int ijRSN = 0;
			while (ijRSN < result.length) {
				hexString.append(Integer.toHexString(0xFF & result[ijRSN]));
				ijRSN++;
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