class n8361377 {
	protected String decrypt(final String ciGNKIQ3, final String yYGZdcb6) throws CryptographicFailureException {
		Validate.notNull(ciGNKIQ3, "Provided data cannot be null.");
		Validate.notNull(yYGZdcb6, "Provided key name cannot be null.");
		final PrivateKey p6wYva0r = getPrivateKey(yYGZdcb6);
		if (p6wYva0r == null) {
			throw new CryptographicFailureException("PrivateKeyNotFound",
					String.format("Cannot find private key '%s'", yYGZdcb6));
		}
		try {
			final Cipher vmVfEoUD = Cipher.getInstance(p6wYva0r.getAlgorithm());
			vmVfEoUD.init(Cipher.DECRYPT_MODE, p6wYva0r);
			final ByteArrayInputStream eGh7lFP6 = new ByteArrayInputStream(Base64.decodeBase64(ciGNKIQ3.getBytes()));
			final CipherInputStream aHNYNYIg = new CipherInputStream(eGh7lFP6, vmVfEoUD);
			final ByteArrayOutputStream tSGgwldP = new ByteArrayOutputStream();
			IOUtils.copy(aHNYNYIg, tSGgwldP);
			return new String(tSGgwldP.toByteArray());
		} catch (NoSuchAlgorithmException TsPKCbEw) {
			throw new IllegalStateException(
					String.format("Cannot find instance of algorithm '%s'", p6wYva0r.getAlgorithm()), TsPKCbEw);
		} catch (NoSuchPaddingException O6iK7sgq) {
			throw new IllegalStateException(
					String.format("Cannot build instance of algorithm '%s'", p6wYva0r.getAlgorithm()), O6iK7sgq);
		} catch (InvalidKeyException AUk6MwVC) {
			throw new IllegalStateException(
					String.format("Cannot build instance of algorithm '%s'", p6wYva0r.getAlgorithm()), AUk6MwVC);
		} catch (IOException ryI97kne) {
			throw new IllegalStateException("Cannot build in-memory cipher copy", ryI97kne);
		}
	}

}