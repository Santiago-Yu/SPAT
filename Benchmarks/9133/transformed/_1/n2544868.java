class n2544868 {
	public String encode(String plain) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plain.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			int rKBH1 = 0;
			while (rKBH1 < b.length) {
				i = b[rKBH1];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
				rKBH1++;
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}