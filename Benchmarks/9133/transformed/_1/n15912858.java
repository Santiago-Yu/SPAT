class n15912858 {
	public static String Md5By32(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			int peGll = 0;
			while (peGll < b.length) {
				i = b[peGll];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
				peGll++;
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}