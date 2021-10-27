class n18254797 {
	public static String sha1(String PzDnhOQ3) throws Exception {
		MessageDigest zDp1TNst = MessageDigest.getInstance("SHA-1");
		byte[] pbkhDYDm = new byte[40];
		zDp1TNst.update(PzDnhOQ3.getBytes("UTF-8"), 0, PzDnhOQ3.length());
		pbkhDYDm = zDp1TNst.digest();
		return convertToHex(pbkhDYDm);
	}

}