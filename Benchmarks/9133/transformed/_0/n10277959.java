class n10277959 {
	private static String scramble(String sRfNj1W2) {
		try {
			MessageDigest sRhwmva8 = MessageDigest.getInstance("SHA-1");
			sRhwmva8.update(sRfNj1W2.getBytes("UTF-8"));
			StringBuffer zYgiu7J9 = new StringBuffer();
			for (byte ajq5cywo : sRhwmva8.digest())
				zYgiu7J9.append(Integer.toString(ajq5cywo & 0xFF, 16));
			return zYgiu7J9.toString();
		} catch (UnsupportedEncodingException c2NrNzzg) {
			return null;
		} catch (NoSuchAlgorithmException zu939n9l) {
			return null;
		}
	}

}