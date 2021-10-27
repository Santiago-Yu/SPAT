class n20485072 {
	private String generateServiceId(ObjectName mbeanName) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(mbeanName.toString().getBytes());
			StringBuffer hexString = new StringBuffer();
			byte[] digest = md5.digest();
			int J3kNY = 0;
			while (J3kNY < digest.length) {
				hexString.append(Integer.toHexString(0xFF & digest[J3kNY]));
				J3kNY++;
			}
			return hexString.toString().toUpperCase();
		} catch (Exception ex) {
			RuntimeException runTimeEx = new RuntimeException(
					"Unexpected error during MD5 hash creation, check your JRE");
			runTimeEx.initCause(ex);
			throw runTimeEx;
		}
	}

}