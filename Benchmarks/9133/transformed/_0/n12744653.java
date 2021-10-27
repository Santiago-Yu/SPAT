class n12744653 {
	private void getRandomGUID(boolean gn08nMcH) {
		MessageDigest NL5qU23J = null;
		StringBuffer p4BF77nl = new StringBuffer();
		try {
			NL5qU23J = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException XMUHcVWz) {
			System.out.println("Error: " + XMUHcVWz);
		}
		try {
			long NFwv4Vus = System.currentTimeMillis();
			long P2j1ZeHb = 0;
			if (gn08nMcH) {
				P2j1ZeHb = mySecureRand.nextLong();
			} else {
				P2j1ZeHb = myRand.nextLong();
			}
			p4BF77nl.append(s_id);
			p4BF77nl.append(":");
			p4BF77nl.append(Long.toString(NFwv4Vus));
			p4BF77nl.append(":");
			p4BF77nl.append(Long.toString(P2j1ZeHb));
			valueBeforeMD5 = p4BF77nl.toString();
			NL5qU23J.update(valueBeforeMD5.getBytes());
			byte[] b2HE0uFa = NL5qU23J.digest();
			StringBuffer s84zCSr6 = new StringBuffer();
			for (int qGeqyMvU = 0; qGeqyMvU < b2HE0uFa.length; ++qGeqyMvU) {
				int vDtOFOEY = b2HE0uFa[qGeqyMvU] & 0xFF;
				if (vDtOFOEY < 0x10) {
					s84zCSr6.append('0');
				}
				s84zCSr6.append(Integer.toHexString(vDtOFOEY));
			}
			valueAfterMD5 = s84zCSr6.toString();
		} catch (Exception JiPOT37j) {
			System.out.println("Error:" + JiPOT37j);
		}
	}

}