class n23161545 {
	private void getRandomGUID(boolean PTOmP7K0) {
		MessageDigest hMwT8V6s = null;
		StringBuffer tuJR3ezv = new StringBuffer();
		try {
			hMwT8V6s = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException CkGs565K) {
			System.out.println("Error: " + CkGs565K);
		}
		try {
			long tiVPzS5b = System.currentTimeMillis();
			long JX0PcwHU = 0;
			if (PTOmP7K0) {
				JX0PcwHU = mySecureRand.nextLong();
			} else {
				JX0PcwHU = myRand.nextLong();
			}
			tuJR3ezv.append(s_id);
			tuJR3ezv.append(":");
			tuJR3ezv.append(Long.toString(tiVPzS5b));
			tuJR3ezv.append(":");
			tuJR3ezv.append(Long.toString(JX0PcwHU));
			valueBeforeMD5 = tuJR3ezv.toString();
			hMwT8V6s.update(valueBeforeMD5.getBytes());
			byte[] KowadusJ = hMwT8V6s.digest();
			StringBuffer niRe4JiF = new StringBuffer();
			for (int PYUv4wGa = 0; PYUv4wGa < KowadusJ.length; ++PYUv4wGa) {
				int ak683AHz = KowadusJ[PYUv4wGa] & 0xFF;
				if (ak683AHz < 0x10)
					niRe4JiF.append('0');
				niRe4JiF.append(Integer.toHexString(ak683AHz));
			}
			valueAfterMD5 = niRe4JiF.toString();
		} catch (Exception pf0YstFK) {
			System.out.println("Error:" + pf0YstFK);
		}
	}

}