class n11108280 {
	public static String generateCode(String Pz8EaCdI) {
		try {
			Security.addProvider(new FNVProvider());
			MessageDigest T7chr4v8 = MessageDigest.getInstance("FNV-1a");
			T7chr4v8.update((Pz8EaCdI + UUID.randomUUID().toString()).getBytes());
			byte[] BDPgwLMg = T7chr4v8.digest();
			String aaasd4fk = "m" + (new String(LibraryBase64.encode(BDPgwLMg))).replaceAll("=", "");
			return aaasd4fk;
		} catch (NoSuchAlgorithmException oZm5zC7M) {
			System.err.println("Internal error:" + oZm5zC7M.getMessage());
			return null;
		}
	}

}