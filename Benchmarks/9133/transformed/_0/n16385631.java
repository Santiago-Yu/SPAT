class n16385631 {
	private void getRandomGUID(boolean Tif0VlQR) {
		MessageDigest LQqYcbg6 = null;
		StringBuffer hfnQNMud = new StringBuffer();
		try {
			LQqYcbg6 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException oJM2qvsX) {
			System.out.println("Error: " + oJM2qvsX);
		}
		try {
			long eygjNEfZ = System.currentTimeMillis();
			long WDhqetE8 = 0;
			if (Tif0VlQR) {
				WDhqetE8 = mySecureRand.nextLong();
			} else {
				WDhqetE8 = myRand.nextLong();
			}
			hfnQNMud.append(s_id);
			hfnQNMud.append(":");
			hfnQNMud.append(Long.toString(eygjNEfZ));
			hfnQNMud.append(":");
			hfnQNMud.append(Long.toString(WDhqetE8));
			valueBeforeMD5 = hfnQNMud.toString();
			LQqYcbg6.update(valueBeforeMD5.getBytes());
			byte[] iYGtdfCu = LQqYcbg6.digest();
			StringBuffer FftrIjhg = new StringBuffer();
			for (int yaModHGN = 0; yaModHGN < iYGtdfCu.length; ++yaModHGN) {
				int Hl6dLg1c = iYGtdfCu[yaModHGN] & 0xFF;
				if (Hl6dLg1c < 0x10)
					FftrIjhg.append('0');
				FftrIjhg.append(Integer.toHexString(Hl6dLg1c));
			}
			valueAfterMD5 = FftrIjhg.toString();
		} catch (Exception fIfbwIwF) {
			System.out.println("Error:" + fIfbwIwF);
		}
	}

}