class n3962795 {
	public static String Sha1(String s) {
		try {
			byte[] hash = new byte[40];
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(s.getBytes("iso-8859-1"), 0, s.length());
			hash = md.digest();
			return toHex(hash);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}