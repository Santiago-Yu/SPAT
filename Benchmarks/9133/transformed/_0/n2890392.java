class n2890392 {
	public String SHA1(String QZEy8nFz) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest yxmOuE5X;
		yxmOuE5X = MessageDigest.getInstance("SHA-1");
		byte[] ck3NulQR = new byte[40];
		yxmOuE5X.update(QZEy8nFz.getBytes("iso-8859-1"), 0, QZEy8nFz.length());
		ck3NulQR = yxmOuE5X.digest();
		return convertToHex(ck3NulQR);
	}

}