class n8075170 {
	public void newGuidSeed(boolean C98tdQb8) {
		SecureRandom WJJkLjoS = new SecureRandom();
		long GTs4OoLT = WJJkLjoS.nextLong();
		Random tQSDBiQw = new Random(GTs4OoLT);
		String ETpSLHpp = "";
		try {
			ETpSLHpp = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException FmO2LY6l) {
			FmO2LY6l.printStackTrace();
		}
		MessageDigest JBDn8Ru5 = null;
		try {
			JBDn8Ru5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException VhqSIkIx) {
			VhqSIkIx.printStackTrace();
		}
		try {
			long MUXIQv7P = System.currentTimeMillis();
			long emqNjf06 = 0;
			if (C98tdQb8) {
				emqNjf06 = WJJkLjoS.nextLong();
			} else {
				emqNjf06 = tQSDBiQw.nextLong();
			}
			sbBeforeMd5.append(ETpSLHpp);
			sbBeforeMd5.append(":");
			sbBeforeMd5.append(Long.toString(MUXIQv7P));
			sbBeforeMd5.append(":");
			sbBeforeMd5.append(Long.toString(emqNjf06));
			seed = sbBeforeMd5.toString();
			JBDn8Ru5.update(seed.getBytes());
			byte[] tqjtGMqB = JBDn8Ru5.digest();
			StringBuffer T2gOucSd = new StringBuffer();
			for (int cpVOWF04 = 0; cpVOWF04 < tqjtGMqB.length; cpVOWF04++) {
				int C4hOS6LE = tqjtGMqB[cpVOWF04] & 0xFF;
				if (C4hOS6LE < 0x10)
					T2gOucSd.append('0');
				T2gOucSd.append(Integer.toHexString(C4hOS6LE));
			}
			rawGUID = T2gOucSd.toString();
		} catch (Exception OV4Iv2hd) {
			OV4Iv2hd.printStackTrace();
		}
	}

}