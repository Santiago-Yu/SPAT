class n12876684 {
	public String getMD5(String B4BIc555) {
		try {
			MessageDigest wLjAIhq6 = MessageDigest.getInstance("MD5");
			wLjAIhq6.update(B4BIc555.getBytes(), 0, B4BIc555.length());
			byte[] sMBy6tkN = wLjAIhq6.digest();
			StringBuffer yeyW6UUP = new StringBuffer();
			String hfluWLzc = null;
			for (int aClYY1ij = 0; aClYY1ij < sMBy6tkN.length; aClYY1ij++) {
				hfluWLzc = Integer.toHexString(0xFF & sMBy6tkN[aClYY1ij]);
				if (hfluWLzc.length() < 2) {
					hfluWLzc = "0" + hfluWLzc;
				}
				yeyW6UUP.append(hfluWLzc);
			}
			return yeyW6UUP.toString();
		} catch (NoSuchAlgorithmException UDi32Vbp) {
			return B4BIc555;
		}
	}

}