class n9024096 {
	public static final String enCode(String BpJMWZEJ, String S6CJEBqT) {
		MessageDigest yOQOnf3g;
		String AFhyUnEn = "";
		try {
			yOQOnf3g = MessageDigest.getInstance(BpJMWZEJ);
			yOQOnf3g.update(S6CJEBqT.getBytes());
			AFhyUnEn = binaryToString(yOQOnf3g.digest());
		} catch (NoSuchAlgorithmException kCN3EZIl) {
			kCN3EZIl.printStackTrace();
		}
		return AFhyUnEn;
	}

}