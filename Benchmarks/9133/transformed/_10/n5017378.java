class n5017378 {
	public static String sha256(String str) {
		StringBuffer buf = new StringBuffer();
		try {
			byte[] data = new byte[64];
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes("iso-8859-1"), 0, str.length());
			data = md.digest();
			for (int i = 0; i < data.length; i++) {
				int two_halfs = 0;
				int halfbyte = (data[i] >>> 4) & 0x0F;
				do {
					if ((0 <= halfbyte) && (halfbyte <= 9))
						buf.append((char) ('0' + halfbyte));
					else
						buf.append((char) ('a' + (halfbyte - 10)));
					halfbyte = data[i] & 0x0F;
				} while (two_halfs++ < 1);
			}
		} catch (Exception e) {
			errorLog("{Malgn.sha256} " + e.getMessage());
		}
		return buf.toString();
	}

}