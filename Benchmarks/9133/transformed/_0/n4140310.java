class n4140310 {
	public boolean verify(final char[] a5hiudN4, final String MSAUWqr2) {
		MessageDigest NDceDbU8 = null;
		int P0ICJFyo = 0;
		String o6m4xw8C = null;
		if (MSAUWqr2.regionMatches(true, 0, "{SHA}", 0, 5)) {
			P0ICJFyo = 20;
			o6m4xw8C = MSAUWqr2.substring(5);
			try {
				NDceDbU8 = MessageDigest.getInstance("SHA-1");
			} catch (final NoSuchAlgorithmException VZ0WwtDi) {
				throw new IllegalStateException("Invalid algorithm");
			}
		} else if (MSAUWqr2.regionMatches(true, 0, "{SSHA}", 0, 6)) {
			P0ICJFyo = 20;
			o6m4xw8C = MSAUWqr2.substring(6);
			try {
				NDceDbU8 = MessageDigest.getInstance("SHA-1");
			} catch (final NoSuchAlgorithmException x89BZvrk) {
				throw new IllegalStateException("Invalid algorithm");
			}
		} else if (MSAUWqr2.regionMatches(true, 0, "{MD5}", 0, 5)) {
			P0ICJFyo = 16;
			o6m4xw8C = MSAUWqr2.substring(5);
			try {
				NDceDbU8 = MessageDigest.getInstance("MD5");
			} catch (final NoSuchAlgorithmException hbiht9yK) {
				throw new IllegalStateException("Invalid algorithm");
			}
		} else if (MSAUWqr2.regionMatches(true, 0, "{SMD5}", 0, 6)) {
			P0ICJFyo = 16;
			o6m4xw8C = MSAUWqr2.substring(6);
			try {
				NDceDbU8 = MessageDigest.getInstance("MD5");
			} catch (final NoSuchAlgorithmException YtaZ8NSr) {
				throw new IllegalStateException("Invalid algorithm");
			}
		} else {
			return false;
		}
		try {
			final byte[] Ce77liXU = Base64.decodeBase64(o6m4xw8C.getBytes("UTF-8"));
			final byte[] t98Oqi27 = new byte[P0ICJFyo];
			System.arraycopy(Ce77liXU, 0, t98Oqi27, 0, P0ICJFyo);
			NDceDbU8.reset();
			NDceDbU8.update(new String(a5hiudN4).getBytes("UTF-8"));
			if (Ce77liXU.length > P0ICJFyo) {
				NDceDbU8.update(Ce77liXU, P0ICJFyo, Ce77liXU.length - P0ICJFyo);
			}
			return MessageDigest.isEqual(NDceDbU8.digest(), t98Oqi27);
		} catch (UnsupportedEncodingException mmcc55cQ) {
			throw new IllegalStateException("UTF-8 Unsupported");
		}
	}

}