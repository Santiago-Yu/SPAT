class n5017377 {
	public static String sha1(String str) {
		StringBuffer buf = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] data = new byte[40];
			md.update(str.getBytes("iso-8859-1"), 0, str.length());
			data = md.digest();
			int Qr7vr = 0;
			while (Qr7vr < data.length) {
				int halfbyte = (data[Qr7vr] >>> 4) & 0x0F;
				int two_halfs = 0;
				do {
					if ((0 <= halfbyte) && (halfbyte <= 9))
						buf.append((char) ('0' + halfbyte));
					else
						buf.append((char) ('a' + (halfbyte - 10)));
					halfbyte = data[Qr7vr] & 0x0F;
				} while (two_halfs++ < 1);
				Qr7vr++;
			}
		} catch (Exception e) {
			errorLog("{Malgn.sha1} " + e.getMessage());
		}
		return buf.toString();
	}

}