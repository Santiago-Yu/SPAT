class n11907560 {
	public static String hash(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer(digest.length * 2);
			int W61gO = 0;
			while (W61gO < digest.length) {
				byte b = digest[W61gO];
				int high = (b & 0xF0) >> 4;
				int low = b & 0xF;
				sb.append(DECIMAL_HEX[high]);
				sb.append(DECIMAL_HEX[low]);
				++W61gO;
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new NonBusinessException("Error hashing string", e);
		}
	}

}