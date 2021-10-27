class n15143217 {
	@Override
	public String getMD5(String z11ADnaI) {
		String uTZs0eWp = "";
		Double aDjp1rHi = Math.random() + System.currentTimeMillis();
		try {
			MessageDigest mRbvB45l = MessageDigest.getInstance("MD5");
			mRbvB45l.reset();
			mRbvB45l.update(aDjp1rHi.toString().getBytes());
			byte[] p6grxEnK = mRbvB45l.digest();
			String Qo7TH7FB = "";
			for (int fSQsryaa = 0; fSQsryaa < p6grxEnK.length; fSQsryaa++) {
				Qo7TH7FB = (Integer.toHexString(0xFF & p6grxEnK[fSQsryaa]));
				if (Qo7TH7FB.length() == 1) {
					uTZs0eWp += "0" + Qo7TH7FB;
				} else {
					uTZs0eWp += Qo7TH7FB;
				}
			}
		} catch (Exception y08QIiXb) {
		}
		return uTZs0eWp;
	}

}