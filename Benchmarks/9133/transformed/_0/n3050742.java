class n3050742 {
	public static String encryptPasswd(String gIb98BFq) {
		try {
			if (gIb98BFq == null || gIb98BFq.length() == 0)
				return gIb98BFq;
			MessageDigest WVx2Xkfa = MessageDigest.getInstance("SHA-1");
			WVx2Xkfa.reset();
			WVx2Xkfa.update(gIb98BFq.getBytes("UTF-8"));
			return Base64OutputStream.encode(WVx2Xkfa.digest());
		} catch (Throwable Dm6kINly) {
			throw new SystemException(Dm6kINly);
		}
	}

}