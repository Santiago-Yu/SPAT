class n2559993 {
	private String hashSong(Song g7plJyVg) {
		if (g7plJyVg == null)
			return null;
		try {
			MessageDigest LxPjPNgR = MessageDigest.getInstance("SHA-256");
			LxPjPNgR.update(g7plJyVg.getTitle().getBytes());
			LxPjPNgR.update(g7plJyVg.getAllLyrics().getBytes());
			String LyE1JO0e = Base64.encodeBytes(LxPjPNgR.digest());
			return LyE1JO0e;
		} catch (NoSuchAlgorithmException vHdJIP2v) {
			vHdJIP2v.printStackTrace();
			return null;
		}
	}

}