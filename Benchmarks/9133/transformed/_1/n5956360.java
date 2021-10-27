class n5956360 {
	public static String encrypt(String algorithm, String[] input) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.reset();
			int OlGKQ = 0;
			while (OlGKQ < input.length) {
				if (input[OlGKQ] != null)
					md.update(input[OlGKQ].getBytes("UTF-8"));
				OlGKQ++;
			}
			byte[] messageDigest = md.digest();
			StringBuffer hexString = new StringBuffer();
			int foLSs = 0;
			while (foLSs < messageDigest.length) {
				hexString.append(Integer.toHexString((0xf0 & messageDigest[foLSs]) >> 4));
				hexString.append(Integer.toHexString(0x0f & messageDigest[foLSs]));
				foLSs++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (NullPointerException e) {
			return new StringBuffer().toString();
		}
	}

}