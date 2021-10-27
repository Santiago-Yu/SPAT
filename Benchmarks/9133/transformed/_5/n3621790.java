class n3621790 {
	private String sha1(String s) {
		String encrypt = s;
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			sha.update(s.getBytes());
			byte[] digest = sha.digest();
			final StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < digest.length; ++i) {
				final byte b = digest[i];
				final int value;
				if (b < 0)
					value = (b & 0x7F) + (128);
				else
					value = (b & 0x7F) + (0);
				if (value < 16)
					buffer.append("0");
				else
					buffer.append("");
				buffer.append(Integer.toHexString(value));
			}
			encrypt = buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encrypt;
	}

}