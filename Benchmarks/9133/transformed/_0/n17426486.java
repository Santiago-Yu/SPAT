class n17426486 {
	public String encrypt(String K268WHkp) {
		MessageDigest Ot8NLKZz = null;
		try {
			Ot8NLKZz = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ctQuV5Mi) {
			ctQuV5Mi.printStackTrace();
			System.out.println("Error");
		}
		try {
			Ot8NLKZz.update(K268WHkp.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException nKw3hW5x) {
			nKw3hW5x.printStackTrace();
			JOptionPane.showMessageDialog(null, "That is not a valid encrpytion type");
		}
		byte rMAMrMmc[] = Ot8NLKZz.digest();
		String gfPxDjXz = "";
		String gmce36IK = "";
		for (byte OhY6i1rM : rMAMrMmc) {
			String MT7CSRAK = gfPxDjXz + Integer.toHexString(OhY6i1rM & 0xff);
			if (MT7CSRAK.length() == 1) {
				MT7CSRAK = 0 + MT7CSRAK;
			}
			gmce36IK += MT7CSRAK;
		}
		return gmce36IK;
	}

}