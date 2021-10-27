class n7034069 {
	public static String getSHA1Hash(String stringToHash) {
		MessageDigest md;
		String result = "";
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(stringToHash.getBytes("utf-8"));
			StringBuffer hashString = new StringBuffer();
			byte[] hash = md.digest();
			for (int i = 0; i < hash.length; i++) {
				int twoHalves = 0;
				int halfByte = (hash[i] >>> 4) & 0x0F;
				do {
					if ((0 <= halfByte) && (halfByte <= 9)) {
						hashString.append((char) ('0' + halfByte));
					} else {
						hashString.append((char) ('a' + (halfByte - 10)));
					}
					halfByte = hash[i] & 0x0F;
				} while (twoHalves++ < 1);
			}
			result = hashString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

}