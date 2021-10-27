class n9945506 {
	public synchronized String decrypt(String plaintext) throws Exception {
		String strhash = new String((new BASE64Decoder()).decodeBuffer(plaintext));
		MessageDigest md = null;
		System.out.println("strhash1122  " + strhash);
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte raw[] = md.digest();
		try {
			md.update(new String(raw).getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("plain text  " + strhash);
		String strcode = new String(raw);
		System.out.println("strcode.." + strcode);
		return strcode;
	}

}