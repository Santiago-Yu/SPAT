class n12863885 {
	private static String md5(String input) {
		String res = "";
		try {
			MessageDigest cript = MessageDigest.getInstance("MD5");
			cript.reset();
			cript.update(input.getBytes());
			byte[] md5 = cript.digest();
			String tmp = "";
			for (int i = 0; i < md5.length; i++) {
				tmp = (Integer.toHexString(0xFF & md5[i]));
				res = (tmp.length() == 1) ? "0" + tmp : tmp;
			}
		} catch (NoSuchAlgorithmException ex) {
			Log4k.error(pdfPrinter.class.getName(), ex.getMessage());
		}
		return res;
	}

}