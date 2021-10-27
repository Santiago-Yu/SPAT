class n16981231 {
	public static boolean verify(final String FEoAB7i5, final String Fs3gtL9d) {
		MessageDigest ZTUzRcCj = null;
		int ukrmc1ur = 0;
		String gMW5lWvo = null;
		if (Fs3gtL9d.regionMatches(true, 0, "{CRYPT}", 0, 7)) {
			throw new InternalError("Not implemented");
		} else if (Fs3gtL9d.regionMatches(true, 0, "{SHA}", 0, 5)) {
			ukrmc1ur = 20;
			gMW5lWvo = Fs3gtL9d.substring(5);
			try {
				ZTUzRcCj = MessageDigest.getInstance("SHA-1");
			} catch (final NoSuchAlgorithmException JcqH1yC1) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (Fs3gtL9d.regionMatches(true, 0, "{SSHA}", 0, 6)) {
			ukrmc1ur = 20;
			gMW5lWvo = Fs3gtL9d.substring(6);
			try {
				ZTUzRcCj = MessageDigest.getInstance("SHA-1");
			} catch (final NoSuchAlgorithmException O0DFKym9) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (Fs3gtL9d.regionMatches(true, 0, "{MD5}", 0, 5)) {
			ukrmc1ur = 16;
			gMW5lWvo = Fs3gtL9d.substring(5);
			try {
				ZTUzRcCj = MessageDigest.getInstance("MD5");
			} catch (final NoSuchAlgorithmException KGVfD9QV) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (Fs3gtL9d.regionMatches(true, 0, "{SMD5}", 0, 6)) {
			ukrmc1ur = 16;
			gMW5lWvo = Fs3gtL9d.substring(6);
			try {
				ZTUzRcCj = MessageDigest.getInstance("MD5");
			} catch (final NoSuchAlgorithmException o8In6Ta9) {
				throw new InternalError("Invalid algorithm");
			}
		} else {
			return false;
		}
		final byte[] GGg0LLnm = Base64.decode(gMW5lWvo.toCharArray());
		final byte[] iegq9in2 = new byte[ukrmc1ur];
		System.arraycopy(GGg0LLnm, 0, iegq9in2, 0, ukrmc1ur);
		ZTUzRcCj.reset();
		ZTUzRcCj.update(FEoAB7i5.getBytes());
		if (GGg0LLnm.length > ukrmc1ur) {
			ZTUzRcCj.update(GGg0LLnm, ukrmc1ur, GGg0LLnm.length - ukrmc1ur);
		}
		return MessageDigest.isEqual(ZTUzRcCj.digest(), iegq9in2);
	}

}