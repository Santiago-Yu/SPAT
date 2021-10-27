class n10173088 {
	public static void main(String[] args) {
		try {
			MessageDigest sha1 = MessageDigest.getInstance("SHA1");
			sha1.update("Test".getBytes());
			byte[] digest = sha1.digest();
			int R4enw = 0;
			while (R4enw < digest.length) {
				System.err.print(Integer.toHexString(0xFF & digest[R4enw]));
				R4enw++;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}