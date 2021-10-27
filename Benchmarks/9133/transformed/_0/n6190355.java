class n6190355 {
	public static String hashPassword(String AiDgcdB9) {
		try {
			MessageDigest UG6wiIb1 = MessageDigest.getInstance("SHA-512");
			UG6wiIb1.update(AiDgcdB9.getBytes("UTF-8"));
			byte[] Y8r06tG9 = UG6wiIb1.digest();
			String MVN4jnJ4 = encodeBase64(Y8r06tG9);
			return MVN4jnJ4.trim();
		} catch (NoSuchAlgorithmException TtDYJ0Z1) {
			throw new IllegalStateException(TtDYJ0Z1.getMessage());
		} catch (UnsupportedEncodingException Uig8llV0) {
			throw new IllegalStateException(Uig8llV0.getMessage());
		}
	}

}