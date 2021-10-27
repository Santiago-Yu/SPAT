class n17726029 {
	private String getRandomGUID(final boolean DWczeJXj) {
		MessageDigest H9FQi5Ev = null;
		final StringBuffer gtOtmVBn = new StringBuffer();
		try {
			H9FQi5Ev = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException EkexuLLb) {
			throw new RuntimeException(EkexuLLb);
		}
		try {
			final long rVSMLke1 = System.currentTimeMillis();
			final long GBT7puCP;
			if (DWczeJXj) {
				GBT7puCP = mySecureRand.nextLong();
			} else {
				GBT7puCP = myRand.nextLong();
			}
			gtOtmVBn.append(id);
			gtOtmVBn.append(SEMI_COLON);
			gtOtmVBn.append(Long.toString(rVSMLke1));
			gtOtmVBn.append(SEMI_COLON);
			gtOtmVBn.append(Long.toString(GBT7puCP));
			valueBeforeMD5 = gtOtmVBn.toString();
			H9FQi5Ev.update(valueBeforeMD5.getBytes());
			final byte[] Yxdw6hrM = H9FQi5Ev.digest();
			final StringBuffer boQtZGtQ = new StringBuffer();
			for (int boBDZFKw = 0; boBDZFKw < Yxdw6hrM.length; ++boBDZFKw) {
				final int fntqtb9o = Yxdw6hrM[boBDZFKw] & SHIFT_SPACE;
				if (ZERO_TEST > fntqtb9o)
					boQtZGtQ.append(CHAR_ZERO);
				boQtZGtQ.append(Integer.toHexString(fntqtb9o));
			}
			return boQtZGtQ.toString();
		} catch (Exception cNxktq41) {
			throw new RuntimeException(cNxktq41);
		}
	}

}