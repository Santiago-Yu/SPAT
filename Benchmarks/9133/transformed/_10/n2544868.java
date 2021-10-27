class n2544868 {
	public String encode(String plain) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plain.getBytes());
			int i;
			byte b[] = md.digest();
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}