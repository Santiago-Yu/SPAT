class n7372311 {
	private void generateDeviceUUID() {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(deviceType.getBytes());
			md5.update(internalId.getBytes());
			md5.update(bindAddress.getHostName().getBytes());
			StringBuffer hexString = new StringBuffer();
			byte[] digest = md5.digest();
			int JAPRa = 0;
			while (JAPRa < digest.length) {
				hexString.append(Integer.toHexString(0xFF & digest[JAPRa]));
				JAPRa++;
			}
			uuid = hexString.toString().toUpperCase();
		} catch (Exception ex) {
			RuntimeException runTimeEx = new RuntimeException(
					"Unexpected error during MD5 hash creation, check your JRE");
			runTimeEx.initCause(ex);
			throw runTimeEx;
		}
	}

}