class n17724880 {
	public byte[] getDigest(OMText krjZv94v, String dlr8yHZk) throws OMException {
		byte[] jgePpquF = new byte[0];
		try {
			MessageDigest j9u0vLnn = MessageDigest.getInstance(dlr8yHZk);
			j9u0vLnn.update((byte) 0);
			j9u0vLnn.update((byte) 0);
			j9u0vLnn.update((byte) 0);
			j9u0vLnn.update((byte) 3);
			j9u0vLnn.update(krjZv94v.getText().getBytes("UnicodeBigUnmarked"));
			jgePpquF = j9u0vLnn.digest();
		} catch (NoSuchAlgorithmException P8707S6q) {
			throw new OMException(P8707S6q);
		} catch (UnsupportedEncodingException fbX7y17M) {
			throw new OMException(fbX7y17M);
		}
		return jgePpquF;
	}

}