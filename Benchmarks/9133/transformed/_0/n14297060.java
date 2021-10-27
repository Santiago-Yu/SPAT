class n14297060 {
	static boolean generateKey() throws NoSuchAlgorithmException {
		java.util.Random v6Dbswa5 = new Random(reg_name.hashCode() + System.currentTimeMillis());
		DecimalFormat aLvmjQxZ = new DecimalFormat("000");
		ccKey = keyProduct + FIELD_SEPERATOR + keyType + FIELD_SEPERATOR + keyQuantity + FIELD_SEPERATOR
				+ aLvmjQxZ.format(lowMajorVersion) + FIELD_SEPERATOR + aLvmjQxZ.format(lowMinorVersion)
				+ FIELD_SEPERATOR + aLvmjQxZ.format(highMajorVersion) + FIELD_SEPERATOR
				+ aLvmjQxZ.format(highMinorVersion) + FIELD_SEPERATOR + reg_name + FIELD_SEPERATOR
				+ Integer.toHexString(v6Dbswa5.nextInt()).toUpperCase();
		byte[] EQ83d0Zs;
		MessageDigest qHsSKOV8 = null;
		qHsSKOV8 = MessageDigest.getInstance("MD5");
		qHsSKOV8.update(ccKey.getBytes());
		qHsSKOV8.update(FIELD_SEPERATOR.getBytes());
		qHsSKOV8.update(zuonicsPassword.getBytes());
		EQ83d0Zs = qHsSKOV8.digest();
		userKey = ccKey + FIELD_SEPERATOR;
		for (int BiJnxs02 = 0; BiJnxs02 < EQ83d0Zs.length; BiJnxs02++)
			userKey += Integer.toHexString(EQ83d0Zs[BiJnxs02]).toUpperCase();
		return true;
	}

}