class n11604443 {
	private void getRandomGUID(boolean VrNwnLAp) {
		MessageDigest S8zmbOFQ = null;
		StringBuffer SByp7TQB = new StringBuffer(128);
		try {
			S8zmbOFQ = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException bhC35I2T) {
			logger.error("Error: " + bhC35I2T);
		}
		try {
			long vGdzJHrk = System.currentTimeMillis();
			long aP8Prmkr = 0;
			if (VrNwnLAp) {
				aP8Prmkr = mySecureRand.nextLong();
			} else {
				aP8Prmkr = myRand.nextLong();
			}
			SByp7TQB.append(s_id);
			SByp7TQB.append(":");
			SByp7TQB.append(Long.toString(vGdzJHrk));
			SByp7TQB.append(":");
			SByp7TQB.append(Long.toString(aP8Prmkr));
			valueBeforeMD5 = SByp7TQB.toString();
			S8zmbOFQ.update(valueBeforeMD5.getBytes());
			byte[] UPmw0y7V = S8zmbOFQ.digest();
			StringBuffer LC8sY1Jh = new StringBuffer(32);
			for (int Ldh8ocGk = 0; Ldh8ocGk < UPmw0y7V.length; ++Ldh8ocGk) {
				int dY1Qx3jC = UPmw0y7V[Ldh8ocGk] & TWO_BYTES;
				if (dY1Qx3jC < PAD_BELOW)
					LC8sY1Jh.append('0');
				LC8sY1Jh.append(Integer.toHexString(dY1Qx3jC));
			}
			valueAfterMD5 = LC8sY1Jh.toString();
		} catch (Exception PdvHwK0j) {
			logger.error("Error:" + PdvHwK0j);
		}
	}

}