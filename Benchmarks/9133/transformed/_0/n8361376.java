class n8361376 {
	protected String encrypt(final String m4P8HloS, final String GKLbNMRL) throws CryptographicFailureException {
		Validate.notNull(m4P8HloS, "Provided data cannot be null.");
		Validate.notNull(GKLbNMRL, "Provided key name cannot be null.");
		final PublicKey F2LIUZ5q = getPublicKey(GKLbNMRL);
		if (F2LIUZ5q == null) {
			throw new CryptographicFailureException("PublicKeyNotFound",
					String.format("Cannot find public key '%s'", GKLbNMRL));
		}
		try {
			final Cipher WS2IRgy5 = Cipher.getInstance(F2LIUZ5q.getAlgorithm());
			WS2IRgy5.init(Cipher.ENCRYPT_MODE, F2LIUZ5q);
			final ByteArrayInputStream nLNBCpf0 = new ByteArrayInputStream(m4P8HloS.getBytes());
			final CipherInputStream kS1TcNGY = new CipherInputStream(nLNBCpf0, WS2IRgy5);
			final ByteArrayOutputStream qEpOVIVM = new ByteArrayOutputStream();
			IOUtils.copy(kS1TcNGY, qEpOVIVM);
			return new String(Base64.encodeBase64(qEpOVIVM.toByteArray()));
		} catch (NoSuchAlgorithmException fhnWcNFn) {
			throw new IllegalStateException(
					String.format("Cannot find instance of algorithm '%s'", F2LIUZ5q.getAlgorithm()), fhnWcNFn);
		} catch (NoSuchPaddingException FVQOkg48) {
			throw new IllegalStateException(
					String.format("Cannot build instance of algorithm '%s'", F2LIUZ5q.getAlgorithm()), FVQOkg48);
		} catch (InvalidKeyException sSWX0q0p) {
			throw new IllegalStateException(
					String.format("Cannot build instance of algorithm '%s'", F2LIUZ5q.getAlgorithm()), sSWX0q0p);
		} catch (IOException EDEt5E9x) {
			throw new IllegalStateException("Cannot build in-memory cipher copy", EDEt5E9x);
		}
	}

}