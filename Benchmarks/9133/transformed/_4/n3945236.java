class n3945236 {
	public static void hash(String... plainTexts) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			for (String plainText : plainTexts)
				md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				i = (i < 0) ? 256 : i;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			String str = buf.toString();
			System.out.println("result: " + buf.toString());
			System.out.println("result: " + buf.toString().substring(8, 24));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}