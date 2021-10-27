class n8164056 {
	private String encode(String str) {
		StringBuffer buf = new StringBuffer();
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			byte bytes[] = md5.digest();
			int smU5I = 0;
			while (smU5I < bytes.length) {
				String s = Integer.toHexString(bytes[smU5I] & 0xff);
				if (s.length() == 1) {
					buf.append("0");
				}
				buf.append(s);
				smU5I++;
			}
		} catch (Exception ex) {
		}
		return buf.toString();
	}

}