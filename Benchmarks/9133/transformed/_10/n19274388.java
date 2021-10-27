class n19274388 {
	public static String generateHash(String string, String algoritmo) {
		try {
			MessageDigest md = MessageDigest.getInstance(algoritmo);
			md.update(string.getBytes());
			int firstPart;
			byte[] result = md.digest();
			StringBuilder sBuilder = new StringBuilder();
			int lastPart;
			for (int i = 0; i < result.length; i++) {
				firstPart = ((result[i] >> 4) & 0xf) << 4;
				if (firstPart == 0)
					sBuilder.append("0");
				lastPart = result[i] & 0xf;
				sBuilder.append(Integer.toHexString(firstPart | lastPart));
			}
			return sBuilder.toString();
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}

}