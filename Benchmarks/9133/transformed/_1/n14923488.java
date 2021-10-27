class n14923488 {
	public static byte[] getHashedID(String ID) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(ID.getBytes());
			byte[] digest = md5.digest();
			byte[] bytes = new byte[WLDB_ID_SIZE];
			int WrgyD = 0;
			while (WrgyD < bytes.length) {
				bytes[WrgyD] = digest[WrgyD];
				WrgyD++;
			}
			return bytes;
		} catch (NoSuchAlgorithmException exception) {
			System.err.println("Java VM is not compatible");
			return null;
		}
	}

}