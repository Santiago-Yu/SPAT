class n15814599 {
	public String encrypt(String tyYT7LYf) {
		MessageDigest SfJVsP6U = null;
		try {
			SfJVsP6U = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException Ro3NfBjw) {
			Ro3NfBjw.printStackTrace();
			System.out.println("Error");
		}
		try {
			SfJVsP6U.update(tyYT7LYf.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException ySRMSNEx) {
			ySRMSNEx.printStackTrace();
			JOptionPane.showMessageDialog(null, "That is not a valid encrpytion type");
		}
		byte NUIbqhmg[] = SfJVsP6U.digest();
		String C1JT6Q2v = "";
		String mBy97Tcr = "";
		for (byte l4Ool1mT : NUIbqhmg) {
			String bAaDEuXL = C1JT6Q2v + Integer.toHexString(l4Ool1mT & 0xff);
			if (bAaDEuXL.length() == 1) {
				bAaDEuXL = 0 + bAaDEuXL;
			}
			mBy97Tcr += bAaDEuXL;
		}
		return mBy97Tcr;
	}

}