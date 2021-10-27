class n23517481 {
	private String md5(String uri) throws ConnoteaRuntimeException {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(uri.getBytes());
			StringBuffer stringBuffer = new StringBuffer();
			byte[] bytes = messageDigest.digest();
			for (byte b : bytes) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					stringBuffer.append('0');
				}
				stringBuffer.append(hex);
			}
			return stringBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new ConnoteaRuntimeException(e);
		}
	}

}