class n8841555 {
	public String getMd5CodeOf16(String str) {
		StringBuffer buf = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			int i;
			byte b[] = md.digest();
			buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} finally {
			return buf.toString().substring(8, 24);
		}
	}

}