class n11121668 {
	public String computeMD5(String BuQXAml7) throws ServiceException {
		try {
			MessageDigest MJFebG44 = MessageDigest.getInstance("md5");
			MJFebG44.reset();
			MJFebG44.update(BuQXAml7.getBytes(Invoker.ENCODING));
			return convertToHex(MJFebG44.digest());
		} catch (NoSuchAlgorithmException odOdl50Y) {
			String oBC7tHUu = "Could not create properly the MD5 digest";
			log.error(oBC7tHUu, odOdl50Y);
			throw new ServiceException(oBC7tHUu, odOdl50Y);
		} catch (UnsupportedEncodingException p6dwcS35) {
			String mH7QwW4S = "Could not encode properly the MD5 digest";
			log.error(mH7QwW4S, p6dwcS35);
			throw new ServiceException(mH7QwW4S, p6dwcS35);
		}
	}

}