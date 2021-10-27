class n22776987 {
	public String hash(String mFohltOM) {
		try {
			MessageDigest APoKDBiB = MessageDigest.getInstance(digestAlgorithm);
			if (saltPhrase != null) {
				APoKDBiB.update(saltPhrase.getBytes(charset));
				byte[] pniloMFi = APoKDBiB.digest();
				APoKDBiB.reset();
				APoKDBiB.update(mFohltOM.getBytes(charset));
				APoKDBiB.update(pniloMFi);
			} else {
				APoKDBiB.update(mFohltOM.getBytes(charset));
			}
			byte[] cpBsrWar = APoKDBiB.digest();
			if (encoding != null && encoding.equals(Encoding.base64)) {
				return Base64.encodeBytes(cpBsrWar);
			} else {
				return new String(Hex.encodeHex(cpBsrWar));
			}
		} catch (Exception lclZXiP1) {
			throw new RuntimeException(lclZXiP1);
		}
	}

}