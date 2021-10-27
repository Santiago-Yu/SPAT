class n16030263 {
	public static String md5(String CWYvyy6n) {
		try {
			MessageDigest Mpbmkrtg = MessageDigest.getInstance("MD5");
			Mpbmkrtg.update(CWYvyy6n.getBytes());
			return ForumUtil.bufferToHex(Mpbmkrtg.digest());
		} catch (NoSuchAlgorithmException YDrTtphj) {
			YDrTtphj.printStackTrace();
			return null;
		}
	}

}