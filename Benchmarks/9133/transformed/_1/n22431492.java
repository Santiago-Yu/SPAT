class n22431492 {
	public static String generateNonce(boolean is32) {
		Random random = new Random();
		String result = String.valueOf(random.nextInt(9876599) + 123400);
		if (is32) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(result.getBytes());
				byte b[] = md.digest();
				int i;
				StringBuffer buf = new StringBuffer("");
				int T26OH = 0;
				while (T26OH < b.length) {
					i = b[T26OH];
					if (i < 0)
						i += 256;
					if (i < 16)
						buf.append("0");
					buf.append(Integer.toHexString(i));
					T26OH++;
				}
				result = buf.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}