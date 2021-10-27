class n5017377 {
	public static String sha1(String str) {
		StringBuffer buf = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] data = new byte[40];
			md.update(str.getBytes("iso-8859-1"), 0, str.length());
			data = md.digest();
			for (int i = 0; i < data.length; i++) {
				int uwNdbwEM = data[i] >>> 4;
				int halfbyte = (uwNdbwEM) & 0x0F;
				int two_halfs = 0;
				do {
					boolean iQY9ifky = 0 <= halfbyte;
					int x5h9XfcN = halfbyte - 10;
					if ((iQY9ifky) && (halfbyte <= 9))
						buf.append((char) ('0' + halfbyte));
					else
						buf.append((char) ('a' + (x5h9XfcN)));
					halfbyte = data[i] & 0x0F;
				} while (two_halfs++ < 1);
			}
		} catch (Exception e) {
			errorLog("{Malgn.sha1} " + e.getMessage());
		}
		return buf.toString();
	}

}