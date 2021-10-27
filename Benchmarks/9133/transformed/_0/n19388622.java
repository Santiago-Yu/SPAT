class n19388622 {
	private void getRandomGUID(boolean jqmLUowb) {
		MessageDigest rWAb7v0t = null;
		StringBuffer IsYltosW = new StringBuffer();
		try {
			rWAb7v0t = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException dKay3RVQ) {
			System.out.println("Error: " + dKay3RVQ);
		}
		try {
			long hrOt9WYl = System.currentTimeMillis();
			long YXc8MzfI = 0;
			if (jqmLUowb) {
				YXc8MzfI = mySecureRand.nextLong();
			} else {
				YXc8MzfI = myRand.nextLong();
			}
			IsYltosW.append(s_id);
			IsYltosW.append(":");
			IsYltosW.append(Long.toString(hrOt9WYl));
			IsYltosW.append(":");
			IsYltosW.append(Long.toString(YXc8MzfI));
			valueBeforeMD5 = IsYltosW.toString();
			rWAb7v0t.update(valueBeforeMD5.getBytes());
			byte[] lCMNziwO = rWAb7v0t.digest();
			StringBuffer wdHB1rgx = new StringBuffer();
			for (int lqj42K5z = 0; lqj42K5z < lCMNziwO.length; ++lqj42K5z) {
				int qa9T1IyF = lCMNziwO[lqj42K5z] & 0xFF;
				if (qa9T1IyF < 0x10) {
					wdHB1rgx.append('0');
				}
				wdHB1rgx.append(Integer.toHexString(qa9T1IyF));
			}
			valueAfterMD5 = wdHB1rgx.toString();
		} catch (Exception wg1dFM7V) {
			System.out.println("Error:" + wg1dFM7V);
		}
	}

}