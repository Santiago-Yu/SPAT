class n2530139 {
	public static String md5(String WBcEixjB) {
		String VGknRps7 = "";
		try {
			MessageDigest GQtgytwE = MessageDigest.getInstance("MD5");
			GQtgytwE.reset();
			GQtgytwE.update(WBcEixjB.getBytes());
			byte[] IkurNS1J = GQtgytwE.digest();
			String mY4xucOU = "";
			for (int c5gnXOOe = 0; c5gnXOOe < IkurNS1J.length; c5gnXOOe++) {
				mY4xucOU = (Integer.toHexString(0xFF & IkurNS1J[c5gnXOOe]));
				if (mY4xucOU.length() == 1) {
					VGknRps7 += "0" + mY4xucOU;
				} else {
					VGknRps7 += mY4xucOU;
				}
			}
		} catch (NoSuchAlgorithmException woWugj69) {
			if (globali.jcVariabili.DEBUG)
				globali.jcFunzioni.erroreSQL(woWugj69.toString());
		}
		return VGknRps7;
	}

}