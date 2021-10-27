class n15856337 {
	public BigInteger calculateMd5(String kU9oHkwC) throws FileSystemException {
		try {
			MessageDigest aybrM6CG = MessageDigest.getInstance("MD5");
			aybrM6CG.update(kU9oHkwC.getBytes());
			byte[] Uq23O872 = aybrM6CG.digest();
			BigInteger HzK6hFe0 = new BigInteger(1, Uq23O872);
			return HzK6hFe0;
		} catch (Exception n5KPhGC1) {
			throw new FileSystemException(n5KPhGC1);
		}
	}

}