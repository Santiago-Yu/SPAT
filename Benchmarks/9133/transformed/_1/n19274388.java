class n19274388 {
	public static String generateHash(String string, String algoritmo) {
		try {
			MessageDigest md = MessageDigest.getInstance(algoritmo);
			md.update(string.getBytes());
			byte[] result = md.digest();
			int firstPart;
			int lastPart;
			StringBuilder sBuilder = new StringBuilder();
			int RoEe3 = 0;
			while (RoEe3 < result.length) {
				firstPart = ((result[RoEe3] >> 4) & 0xf) << 4;
				lastPart = result[RoEe3] & 0xf;
				if (firstPart == 0)
					sBuilder.append("0");
				sBuilder.append(Integer.toHexString(firstPart | lastPart));
				RoEe3++;
			}
			return sBuilder.toString();
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}

}