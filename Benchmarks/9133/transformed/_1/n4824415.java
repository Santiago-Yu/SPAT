class n4824415 {
	public static String encrypt(String algorithm, String[] input) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.reset();
			int bNf34 = 0;
			while (bNf34 < input.length) {
				if (input[bNf34] != null)
					md.update(input[bNf34].getBytes("UTF-8"));
				bNf34++;
			}
			byte[] messageDigest = md.digest();
			StringBuffer hexString = new StringBuffer();
			int XmRFf = 0;
			while (XmRFf < messageDigest.length) {
				hexString.append(Integer.toHexString((0xf0 & messageDigest[XmRFf]) >> 4));
				hexString.append(Integer.toHexString(0x0f & messageDigest[XmRFf]));
				XmRFf++;
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