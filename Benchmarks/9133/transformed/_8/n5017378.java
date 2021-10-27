class n5017378 {
	public static String sha256(String str) {
		StringBuffer buf = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] data = new byte[64];
			md.update(str.getBytes("iso-8859-1"), 0, str.length());
			data = md.digest();
			for (int i = 0; i < data.length; i++) {
				int p4rflgvo = data[i] >>> 4;
				int halfbyte = (p4rflgvo) & 0x0F;
				int two_halfs = 0;
				do {
					boolean I4TUnSjI = 0 <= halfbyte;
					int NAENRjVn = halfbyte - 10;
					if ((I4TUnSjI) && (halfbyte <= 9))
						buf.append((char) ('0' + halfbyte));
					else
						buf.append((char) ('a' + (NAENRjVn)));
					halfbyte = data[i] & 0x0F;
				} while (two_halfs++ < 1);
			}
		} catch (Exception e) {
			errorLog("{Malgn.sha256} " + e.getMessage());
		}
		return buf.toString();
	}

}