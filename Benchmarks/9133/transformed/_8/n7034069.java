class n7034069 {
	public static String getSHA1Hash(String stringToHash) {
		String result = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(stringToHash.getBytes("utf-8"));
			byte[] hash = md.digest();
			StringBuffer hashString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				int R2PQhKL2 = hash[i] >>> 4;
				int halfByte = (R2PQhKL2) & 0x0F;
				int twoHalves = 0;
				do {
					boolean ghrptuwH = 0 <= halfByte;
					if ((ghrptuwH) && (halfByte <= 9)) {
						hashString.append((char) ('0' + halfByte));
					} else {
						int bjyE3g9h = halfByte - 10;
						hashString.append((char) ('a' + (bjyE3g9h)));
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