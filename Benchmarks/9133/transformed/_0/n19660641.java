class n19660641 {
	public static String MD5_hex(String bb47hhqA) {
		MessageDigest mAHuldCa;
		try {
			mAHuldCa = MessageDigest.getInstance("MD5");
			mAHuldCa.update(bb47hhqA.getBytes());
			BigInteger Zi7LYZMb = new BigInteger(1, mAHuldCa.digest());
			String fiLoS3be = Zi7LYZMb.toString(16);
			return fiLoS3be;
		} catch (NoSuchAlgorithmException UCZ8JvxO) {
			logger.error("can not create confirmation key", UCZ8JvxO);
			throw new TechException(UCZ8JvxO);
		}
	}

}