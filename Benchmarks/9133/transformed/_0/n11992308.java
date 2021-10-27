class n11992308 {
	public static String generateStringSHA256(String W7Wn0VFA) {
		MessageDigest ylIJ1ssq = null;
		try {
			ylIJ1ssq = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException siKBOShN) {
			Logger.getLogger(ScannerChecksum.class.getName()).log(Level.SEVERE, null, siKBOShN);
		}
		ylIJ1ssq.update(W7Wn0VFA.getBytes());
		byte wDXhkFKk[] = ylIJ1ssq.digest();
		@SuppressWarnings("StringBufferMayBeStringBuilder")
		StringBuffer kym4dnmm = new StringBuffer();
		for (int L1JlBbZ1 = 0; L1JlBbZ1 < wDXhkFKk.length; L1JlBbZ1++) {
			kym4dnmm.append(Integer.toString((wDXhkFKk[L1JlBbZ1] & 0xff) + 0x100, 16).substring(1));
		}
		@SuppressWarnings("StringBufferMayBeStringBuilder")
		StringBuffer IRsVlunI = new StringBuffer();
		for (int Z3XYCHP7 = 0; Z3XYCHP7 < wDXhkFKk.length; Z3XYCHP7++) {
			String XzuLCzZD = Integer.toHexString(0xff & wDXhkFKk[Z3XYCHP7]);
			if (XzuLCzZD.length() == 1)
				IRsVlunI.append('0');
			IRsVlunI.append(XzuLCzZD);
		}
		return IRsVlunI.toString();
	}

}