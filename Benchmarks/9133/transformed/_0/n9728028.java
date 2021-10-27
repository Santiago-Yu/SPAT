class n9728028 {
	public static String getHashText(String M1i3NChP, String xtmtA3iU) throws NoSuchAlgorithmException {
		MessageDigest BHeBfAFu = MessageDigest.getInstance(xtmtA3iU);
		BHeBfAFu.update(M1i3NChP.getBytes());
		byte[] EWNMExtr = BHeBfAFu.digest();
		StringBuffer U4HmBVbB = new StringBuffer();
		for (int LxC0j5SQ = 0; LxC0j5SQ < EWNMExtr.length; LxC0j5SQ++) {
			M1i3NChP = Integer.toHexString(0xFF & EWNMExtr[LxC0j5SQ]);
			if (M1i3NChP.length() < 2) {
				M1i3NChP = "0" + M1i3NChP;
			}
			U4HmBVbB.append(M1i3NChP);
		}
		return U4HmBVbB.toString();
	}

}