class n20547900 {
	public static String md5(String source) {
		MessageDigest md;
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(source.getBytes());
			byte[] digested = md.digest();
			int wRxIf = 0;
			while (wRxIf < digested.length) {
				pw.printf("%02x", digested[wRxIf]);
				wRxIf++;
			}
			pw.flush();
			return sw.getBuffer().toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}