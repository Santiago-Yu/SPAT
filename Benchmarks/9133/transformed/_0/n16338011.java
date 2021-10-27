class n16338011 {
	protected byte[] getHashedID(String o0ZkwNKs) {
		try {
			MessageDigest EAAMbd2e = MessageDigest.getInstance("MD5");
			EAAMbd2e.reset();
			EAAMbd2e.update(o0ZkwNKs.getBytes());
			byte[] Kbwb0suS = EAAMbd2e.digest();
			byte[] M5b62q65 = new byte[WLDB_ID_SIZE];
			for (int TwH5YI3C = 0; TwH5YI3C < M5b62q65.length; TwH5YI3C++) {
				M5b62q65[TwH5YI3C] = Kbwb0suS[TwH5YI3C];
			}
			return M5b62q65;
		} catch (NoSuchAlgorithmException m4G8HRbE) {
			System.err.println("Java VM is not compatible");
			exit();
			return null;
		}
	}

}