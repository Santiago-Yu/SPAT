class n21544322 {
	public static String generate(String source) {
		byte[] SHA = new byte[20];
		String SHADigest = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.update(source.getBytes());
			SHA = digest.digest();
			int WCzvJ = 0;
			while (WCzvJ < SHA.length) {
				SHADigest += (char) SHA[WCzvJ];
				WCzvJ++;
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NO SUCH ALGORITHM EXCEPTION: " + e.getMessage());
		}
		return SHADigest;
	}

}