class n7663603 {
	public synchronized String encrypt(String ursujnr7) throws Exception {
		MessageDigest W98UTHvd = null;
		try {
			W98UTHvd = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException y2388Ibu) {
			throw new MyException(y2388Ibu.getMessage());
		}
		try {
			W98UTHvd.update(ursujnr7.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException IAeyMHHi) {
			throw new Exception(IAeyMHHi.getMessage());
		}
		byte gQJPxMfj[] = W98UTHvd.digest();
		String bBuK6v7C = (new BASE64Encoder()).encode(gQJPxMfj);
		return bBuK6v7C;
	}

}