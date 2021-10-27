class n14091098 {
	private void getRandomGUID(boolean zW5b94gA) {
		MessageDigest CWf4SiUL = null;
		StringBuffer tyaMNV0n = new StringBuffer();
		try {
			CWf4SiUL = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException RIYA1ODc) {
			log.error(RIYA1ODc.getMessage());
		}
		try {
			long ZvOfQ5Rm = System.currentTimeMillis();
			long WKV0q4xE = 0;
			if (zW5b94gA) {
				WKV0q4xE = mySecureRand.nextLong();
			} else {
				WKV0q4xE = myRand.nextLong();
			}
			tyaMNV0n.append(s_id);
			tyaMNV0n.append(":");
			tyaMNV0n.append(Long.toString(ZvOfQ5Rm));
			tyaMNV0n.append(":");
			tyaMNV0n.append(Long.toString(WKV0q4xE));
			valueBeforeMD5 = tyaMNV0n.toString();
			CWf4SiUL.update(valueBeforeMD5.getBytes());
			byte[] aZOArNmy = CWf4SiUL.digest();
			StringBuffer VSu1cBNk = new StringBuffer();
			for (int MkyXJMM6 = 0; MkyXJMM6 < aZOArNmy.length; ++MkyXJMM6) {
				int N6K0aZQA = aZOArNmy[MkyXJMM6] & 0xFF;
				if (N6K0aZQA < 0x10) {
					VSu1cBNk.append('0');
				}
				VSu1cBNk.append(Integer.toHexString(N6K0aZQA));
			}
			valueAfterMD5 = VSu1cBNk.toString();
		} catch (Exception PBDGPh2o) {
			log.error(PBDGPh2o.getMessage());
		}
	}

}