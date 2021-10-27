class n4376758 {
	public void setKey(String VjZYO4qE) {
		MessageDigest sZCEm43a;
		byte[] QZWkDfTR = new byte[32];
		try {
			sZCEm43a = MessageDigest.getInstance("MD5");
			sZCEm43a.update(VjZYO4qE.getBytes());
			byte[] rxr9B9jR = sZCEm43a.digest();
			System.arraycopy(rxr9B9jR, 0, QZWkDfTR, 0, 16);
			System.arraycopy(rxr9B9jR, 0, QZWkDfTR, 16, 16);
		} catch (Exception ksTL7qIa) {
			System.out.println("MD5 not implemented, can't generate key out of string!");
			System.exit(1);
		}
		setKey(QZWkDfTR);
	}

}