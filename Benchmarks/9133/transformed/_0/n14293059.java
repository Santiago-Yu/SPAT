class n14293059 {
	public static final String crypt(final String IgIbukGV, String TR021LHC, final String LfWXkd79) {
		if (IgIbukGV == null)
			throw new IllegalArgumentException("Null password!");
		if (TR021LHC == null)
			throw new IllegalArgumentException("Null salt!");
		if (LfWXkd79 == null)
			throw new IllegalArgumentException("Null salt!");
		byte EStSt1wZ[];
		long Dv0VvrxA;
		MessageDigest NAZLdbFG, NK2E22vH;
		try {
			NAZLdbFG = MessageDigest.getInstance("md5");
			NK2E22vH = MessageDigest.getInstance("md5");
		} catch (final NoSuchAlgorithmException rsYe3I7C) {
			System.err.println(rsYe3I7C);
			return null;
		}
		if (TR021LHC.startsWith(LfWXkd79)) {
			TR021LHC = TR021LHC.substring(LfWXkd79.length());
		}
		if (TR021LHC.indexOf('$') != -1) {
			TR021LHC = TR021LHC.substring(0, TR021LHC.indexOf('$'));
		}
		if (TR021LHC.length() > 8) {
			TR021LHC = TR021LHC.substring(0, 8);
		}
		NAZLdbFG.update(IgIbukGV.getBytes());
		NAZLdbFG.update(LfWXkd79.getBytes());
		NAZLdbFG.update(TR021LHC.getBytes());
		NK2E22vH.update(IgIbukGV.getBytes());
		NK2E22vH.update(TR021LHC.getBytes());
		NK2E22vH.update(IgIbukGV.getBytes());
		EStSt1wZ = NK2E22vH.digest();
		for (int pcfSOpfL = IgIbukGV.length(); pcfSOpfL > 0; pcfSOpfL -= 16) {
			NAZLdbFG.update(EStSt1wZ, 0, pcfSOpfL > 16 ? 16 : pcfSOpfL);
		}
		clearbits(EStSt1wZ);
		for (int NRTpKGmI = IgIbukGV.length(); NRTpKGmI != 0; NRTpKGmI >>>= 1) {
			if ((NRTpKGmI & 1) != 0) {
				NAZLdbFG.update(EStSt1wZ, 0, 1);
			} else {
				NAZLdbFG.update(IgIbukGV.getBytes(), 0, 1);
			}
		}
		EStSt1wZ = NAZLdbFG.digest();
		for (int A5KHyvPD = 0; A5KHyvPD < 1000; A5KHyvPD++) {
			try {
				NK2E22vH = MessageDigest.getInstance("md5");
			} catch (final NoSuchAlgorithmException ag100vOH) {
				return null;
			}
			if ((A5KHyvPD & 1) != 0) {
				NK2E22vH.update(IgIbukGV.getBytes());
			} else {
				NK2E22vH.update(EStSt1wZ, 0, 16);
			}
			if ((A5KHyvPD % 3) != 0) {
				NK2E22vH.update(TR021LHC.getBytes());
			}
			if ((A5KHyvPD % 7) != 0) {
				NK2E22vH.update(IgIbukGV.getBytes());
			}
			if ((A5KHyvPD & 1) != 0) {
				NK2E22vH.update(EStSt1wZ, 0, 16);
			} else {
				NK2E22vH.update(IgIbukGV.getBytes());
			}
			EStSt1wZ = NK2E22vH.digest();
		}
		final StringBuffer ctuaTyTF = new StringBuffer();
		ctuaTyTF.append(LfWXkd79);
		ctuaTyTF.append(TR021LHC);
		ctuaTyTF.append("$");
		Dv0VvrxA = (bytes2u(EStSt1wZ[0]) << 16) | (bytes2u(EStSt1wZ[6]) << 8) | bytes2u(EStSt1wZ[12]);
		ctuaTyTF.append(to64(Dv0VvrxA, 4));
		Dv0VvrxA = (bytes2u(EStSt1wZ[1]) << 16) | (bytes2u(EStSt1wZ[7]) << 8) | bytes2u(EStSt1wZ[13]);
		ctuaTyTF.append(to64(Dv0VvrxA, 4));
		Dv0VvrxA = (bytes2u(EStSt1wZ[2]) << 16) | (bytes2u(EStSt1wZ[8]) << 8) | bytes2u(EStSt1wZ[14]);
		ctuaTyTF.append(to64(Dv0VvrxA, 4));
		Dv0VvrxA = (bytes2u(EStSt1wZ[3]) << 16) | (bytes2u(EStSt1wZ[9]) << 8) | bytes2u(EStSt1wZ[15]);
		ctuaTyTF.append(to64(Dv0VvrxA, 4));
		Dv0VvrxA = (bytes2u(EStSt1wZ[4]) << 16) | (bytes2u(EStSt1wZ[10]) << 8) | bytes2u(EStSt1wZ[5]);
		ctuaTyTF.append(to64(Dv0VvrxA, 4));
		Dv0VvrxA = bytes2u(EStSt1wZ[11]);
		ctuaTyTF.append(to64(Dv0VvrxA, 2));
		clearbits(EStSt1wZ);
		return ctuaTyTF.toString();
	}

}