class n9983984 {
	private String SHA1(String QX33b5Qt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest lgiBqGyz;
		lgiBqGyz = MessageDigest.getInstance("SHA-1");
		byte[] yT9LN29M = new byte[40];
		lgiBqGyz.update(QX33b5Qt.getBytes("iso-8859-1"), 0, QX33b5Qt.length());
		yT9LN29M = lgiBqGyz.digest();
		return convertToHex(yT9LN29M);
	}

}