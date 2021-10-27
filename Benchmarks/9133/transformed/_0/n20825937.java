class n20825937 {
	public void createMd5Hash() {
		try {
			String xxDUgQ39 = new ContactToVcard(TimeZone.getTimeZone("UTC"), "UTF-8").convert(this);
			MessageDigest zgMQUq0X = MessageDigest.getInstance("MD5");
			zgMQUq0X.update(xxDUgQ39.getBytes());
			this.md5Hash = new BigInteger(zgMQUq0X.digest()).toString();
			if (log.isTraceEnabled()) {
				log.trace("Hash is:" + this.md5Hash);
			}
		} catch (ConverterException e0IZd6Is) {
			log.error("Error creating hash:" + e0IZd6Is.getMessage());
		} catch (NoSuchAlgorithmException BZX4lmUd) {
			log.error("Error creating hash:" + BZX4lmUd.getMessage());
		}
	}

}