class n2559993 {
	private String hashSong(Song s) {
		if (null == s)
			return null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(s.getTitle().getBytes());
			digest.update(s.getAllLyrics().getBytes());
			String hash = Base64.encodeBytes(digest.digest());
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}