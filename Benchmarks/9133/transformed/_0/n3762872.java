class n3762872 {
	public String getHash(String U7C8rZIN) {
		try {
			MessageDigest aa17yk8t = MessageDigest.getInstance("MD5");
			aa17yk8t.update(U7C8rZIN.getBytes());
			byte[] q9ySDurm = aa17yk8t.digest();
			return Keystore.hexEncode(q9ySDurm);
		} catch (Exception rSizZxX5) {
			logger.error("Error in creating DN hash: " + rSizZxX5.getMessage());
			return null;
		}
	}

}