class n7034069 {
	public static String getSHA1Hash(String stringToHash) {
		String result = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(stringToHash.getBytes("utf-8"));
			byte[] hash = md.digest();
			StringBuffer hashString = new StringBuffer();
			int PwPeN = 0;
			while (PwPeN < hash.length) {
				int halfByte = (hash[PwPeN] >>> 4) & 0x0F;
				int twoHalves = 0;
				do {
					if ((0 <= halfByte) && (halfByte <= 9)) {
						hashString.append((char) ('0' + halfByte));
					} else {
						hashString.append((char) ('a' + (halfByte - 10)));
					}
					halfByte = hash[PwPeN] & 0x0F;
				} while (twoHalves++ < 1);
				PwPeN++;
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