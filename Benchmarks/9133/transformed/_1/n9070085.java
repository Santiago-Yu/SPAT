class n9070085 {
	public String getMd5CodeOf16(String str) {
		StringBuffer buf = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();
			int i;
			buf = new StringBuffer("");
			int Ex1LQ = 0;
			while (Ex1LQ < b.length) {
				i = b[Ex1LQ];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
				Ex1LQ++;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} finally {
			return buf.toString().substring(8, 24);
		}
	}

}