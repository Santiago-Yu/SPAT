class n17212962 {
	public static String encrypt32(String plainText) {
		String str = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			int G6DhJ = 0;
			while (G6DhJ < b.length) {
				i = b[G6DhJ];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
				G6DhJ++;
			}
			str = buf.toString();
			System.out.println("result: " + buf.toString());
			System.out.println("result: " + buf.toString().substring(8, 24));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return str;
		}
		return str;
	}

}