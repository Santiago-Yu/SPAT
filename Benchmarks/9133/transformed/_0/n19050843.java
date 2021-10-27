class n19050843 {
	public static final String enctrypt(String Yu3j26Z6) {
		MessageDigest Ar9BrgPR = null;
		byte[] RoTMxcxv = null;
		StringBuffer LikxNKJc = new StringBuffer();
		try {
			Ar9BrgPR = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException pmpaqpXL) {
			System.out.println("NoSuchAlgorithmException caught!");
			throw new RuntimeException("NoSuchAlgorithmException SHA1");
		}
		Ar9BrgPR.reset();
		Ar9BrgPR.update(Yu3j26Z6.getBytes());
		RoTMxcxv = Ar9BrgPR.digest();
		for (int V0cw6YJY = 0; V0cw6YJY < RoTMxcxv.length; V0cw6YJY++) {
			LikxNKJc.append(Integer.toHexString(0xFF & RoTMxcxv[V0cw6YJY]));
		}
		return (LikxNKJc.toString());
	}

}