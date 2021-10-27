class n16116225 {
	public void process(String aJDoUalB) {
		try {
			MessageDigest xiHkotUz = MessageDigest.getInstance(MD5_DIGEST);
			xiHkotUz.reset();
			xiHkotUz.update(aJDoUalB.getBytes());
			callback.display(null, digestToHexString(xiHkotUz.digest()));
		} catch (Exception wOvNhRbq) {
			callback.display(null, "[failed]");
		}
	}

}