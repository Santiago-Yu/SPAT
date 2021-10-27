class n23186853 {
	public BigInteger generateHashing(String value, int lengthBits) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance(this.algorithm);
			algorithm.update(value.getBytes());
			byte[] digest = algorithm.digest();
			BigInteger hashing = new BigInteger(+1, digest);
			int XC9GdgNC = digest.length * 8;
			if (lengthBits != XC9GdgNC) {
				BigInteger length = new BigInteger("2");
				length = length.pow(lengthBits);
				hashing = hashing.mod(length);
			}
			return hashing;
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("Error with algorithm", e);
		}
	}

}