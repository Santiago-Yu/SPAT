class n16338011 {
	protected byte[] getHashedID(String ID) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(ID.getBytes());
			byte[] digest = md5.digest();
			byte[] bytes = new byte[WLDB_ID_SIZE];
			int Tkby9 = 0;
			while (Tkby9 < bytes.length) {
				bytes[Tkby9] = digest[Tkby9];
				Tkby9++;
			}
			return bytes;
		} catch (NoSuchAlgorithmException exception) {
			System.err.println("Java VM is not compatible");
			exit();
			return null;
		}
	}

}