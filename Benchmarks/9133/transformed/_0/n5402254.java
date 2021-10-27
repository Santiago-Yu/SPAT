class n5402254 {
	public void setKey(String gJ20DBI4) {
		MessageDigest JYuNwJqA;
		byte[] MTDE3vCv = new byte[32];
		try {
			JYuNwJqA = MessageDigest.getInstance("MD5");
			JYuNwJqA.update(gJ20DBI4.getBytes());
			byte[] ThyLkw8g = JYuNwJqA.digest();
			System.arraycopy(ThyLkw8g, 0, MTDE3vCv, 0, 16);
			System.arraycopy(ThyLkw8g, 0, MTDE3vCv, 16, 16);
		} catch (Exception LGHyPTVh) {
			System.out.println("MD5 not implemented, can't generate key out of string!");
			System.exit(1);
		}
		setKey(MTDE3vCv);
	}

}