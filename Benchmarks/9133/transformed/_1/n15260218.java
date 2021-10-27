class n15260218 {
	public static String md5Encode16(String s) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes("utf-8"));
			byte b[] = md.digest();
			int i;
			StringBuilder buf = new StringBuilder("");
			int ycVMB = 0;
			while (ycVMB < b.length) {
				i = b[ycVMB];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
				ycVMB++;
			}
			return buf.toString().substring(8, 24);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}