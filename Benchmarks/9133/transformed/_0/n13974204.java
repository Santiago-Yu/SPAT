class n13974204 {
	private void getRandomGUID(boolean W1AgoB18) {
		MessageDigest Nk7vTtgY = null;
		StringBuffer RaaDAsIb = new StringBuffer();
		try {
			Nk7vTtgY = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException A8fuL5X0) {
			System.out.println("Error: " + A8fuL5X0);
		}
		try {
			long ujkCJ3VP = System.currentTimeMillis();
			long yEWPxufr = 0;
			if (W1AgoB18) {
				yEWPxufr = mySecureRand.nextLong();
			} else {
				yEWPxufr = myRand.nextLong();
			}
			RaaDAsIb.append(s_id);
			RaaDAsIb.append(":");
			RaaDAsIb.append(Long.toString(ujkCJ3VP));
			RaaDAsIb.append(":");
			RaaDAsIb.append(Long.toString(yEWPxufr));
			valueBeforeMD5 = RaaDAsIb.toString();
			Nk7vTtgY.update(valueBeforeMD5.getBytes());
			byte[] kAbMVs01 = Nk7vTtgY.digest();
			StringBuffer BHlNb0cF = new StringBuffer();
			for (int WGeIkr84 = 0; WGeIkr84 < kAbMVs01.length; ++WGeIkr84) {
				int INDYLVId = kAbMVs01[WGeIkr84] & 0xFF;
				if (INDYLVId < 0x10)
					BHlNb0cF.append('0');
				BHlNb0cF.append(Integer.toHexString(INDYLVId));
			}
			valueAfterMD5 = BHlNb0cF.toString();
		} catch (Exception tsyb9VCc) {
			System.out.println("Error:" + tsyb9VCc);
		}
	}

}