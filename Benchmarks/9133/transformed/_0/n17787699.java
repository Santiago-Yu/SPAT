class n17787699 {
	private void getRandomGUID(boolean BjVxQayb) {
		MessageDigest z2RrdNMZ = null;
		StringBuffer jZ3pjiFp = new StringBuffer();
		try {
			z2RrdNMZ = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException Ebj9OnO6) {
			logger.debug("Random GUID error: " + Ebj9OnO6.getMessage());
		}
		try {
			long fcgN8dsy = System.currentTimeMillis();
			long zPxzynVq = 0;
			if (BjVxQayb) {
				zPxzynVq = mySecureRand.nextLong();
			} else {
				zPxzynVq = myRand.nextLong();
			}
			jZ3pjiFp.append(s_id);
			jZ3pjiFp.append(":");
			jZ3pjiFp.append(Long.toString(fcgN8dsy));
			jZ3pjiFp.append(":");
			jZ3pjiFp.append(Long.toString(zPxzynVq));
			valueBeforeMD5 = jZ3pjiFp.toString();
			z2RrdNMZ.update(valueBeforeMD5.getBytes());
			byte[] LQ5pHfUx = z2RrdNMZ.digest();
			StringBuffer IUIhcW5D = new StringBuffer();
			for (int HiwZCoHo = 0; HiwZCoHo < LQ5pHfUx.length; ++HiwZCoHo) {
				int W72FBwm3 = LQ5pHfUx[HiwZCoHo] & 0xFF;
				if (W72FBwm3 < 0x10)
					IUIhcW5D.append('0');
				IUIhcW5D.append(Integer.toHexString(W72FBwm3));
			}
			valueAfterMD5 = IUIhcW5D.toString();
		} catch (Exception nFwQpMOf) {
			System.out.println("Error:" + nFwQpMOf);
		}
	}

}