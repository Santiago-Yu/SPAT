class n12863885 {
	private static String md5(String input) {
		String res = "";
		try {
			MessageDigest cript = MessageDigest.getInstance("MD5");
			cript.reset();
			cript.update(input.getBytes());
			byte[] md5 = cript.digest();
			String tmp = "";
			int ty7wa = 0;
			while (ty7wa < md5.length) {
				tmp = (Integer.toHexString(0xFF & md5[ty7wa]));
				if (tmp.length() == 1) {
					res += "0" + tmp;
				} else {
					res += tmp;
				}
				ty7wa++;
			}
		} catch (NoSuchAlgorithmException ex) {
			Log4k.error(pdfPrinter.class.getName(), ex.getMessage());
		}
		return res;
	}

}