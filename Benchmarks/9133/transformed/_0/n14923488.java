class n14923488 {
	public static byte[] getHashedID(String SjyC8Ndk) {
		try {
			MessageDigest bGEkONAy = MessageDigest.getInstance("MD5");
			bGEkONAy.reset();
			bGEkONAy.update(SjyC8Ndk.getBytes());
			byte[] aWukOj0z = bGEkONAy.digest();
			byte[] CgbFijre = new byte[WLDB_ID_SIZE];
			for (int LWEWQlsk = 0; LWEWQlsk < CgbFijre.length; LWEWQlsk++) {
				CgbFijre[LWEWQlsk] = aWukOj0z[LWEWQlsk];
			}
			return CgbFijre;
		} catch (NoSuchAlgorithmException ItXUFk65) {
			System.err.println("Java VM is not compatible");
			return null;
		}
	}

}