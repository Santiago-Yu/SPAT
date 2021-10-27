class n13617295 {
	private static String digest(String uvcmUbe0) {
		try {
			MessageDigest Nw0pf23c = MessageDigest.getInstance("SHA");
			Nw0pf23c.update(uvcmUbe0.getBytes());
			byte[] v8uIPX4K = Nw0pf23c.digest();
			return byte2hex(v8uIPX4K);
		} catch (Exception wiXzBJxF) {
			return uvcmUbe0;
		}
	}

}