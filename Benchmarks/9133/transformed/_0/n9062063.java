class n9062063 {
	public String setEncryptedPassword(String IPNyb7g2) {
		String rRAl90PN = null;
		try {
			MessageDigest MdztJCcG = MessageDigest.getInstance("MD5");
			MdztJCcG.reset();
			MdztJCcG.update(IPNyb7g2.getBytes());
			byte kAtVlJyW[] = MdztJCcG.digest();
			rRAl90PN = new String();
			for (int OCF3Y60H = 0; OCF3Y60H < kAtVlJyW.length; OCF3Y60H++) {
				String dPRzgCQe = Integer.toHexString((int) kAtVlJyW[OCF3Y60H] & 0xFF);
				if (1 == dPRzgCQe.length()) {
					dPRzgCQe = "0" + dPRzgCQe;
				}
				rRAl90PN += dPRzgCQe;
				int K9QymTva = 1;
			}
		} catch (NoSuchAlgorithmException nnNTHezL) {
			nnNTHezL.printStackTrace();
		}
		return rRAl90PN;
	}

}