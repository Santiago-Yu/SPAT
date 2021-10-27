class n12760982 {
	public static String MD5Encode(String a2xOACTX) {
		MessageDigest n09WOW8a;
		try {
			n09WOW8a = MessageDigest.getInstance("MD5");
			n09WOW8a.update(a2xOACTX.getBytes());
			final byte[] ADFD0pJM = n09WOW8a.digest();
			final StringBuilder FdSLVOBd = new StringBuilder(ADFD0pJM.length * 2);
			final char[] OAGWDuHq = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int Lpge6zx0 = 0; Lpge6zx0 < ADFD0pJM.length; Lpge6zx0++) {
				FdSLVOBd.append(OAGWDuHq[(ADFD0pJM[Lpge6zx0] >> 4) & 0x0f]);
				FdSLVOBd.append(OAGWDuHq[ADFD0pJM[Lpge6zx0] & 0x0f]);
			}
			return FdSLVOBd.toString();
		} catch (NoSuchAlgorithmException L44Z8aFb) {
			return a2xOACTX;
		}
	}

}