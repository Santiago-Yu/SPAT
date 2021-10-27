class n13719500 {
	private void onDhReply(final SshDhReply SXAPH8eX) throws GeneralSecurityException, IOException {
		if ((this.keyPair == null) || this.connection.isServer())
			throw new SshException("%s: unexpected %s", this.connection.uri, SXAPH8eX.getType());
		final BigInteger pZ3wdo3Q;
		{
			final DHPublicKeySpec tWVhQDPf = new DHPublicKeySpec(new BigInteger(SXAPH8eX.f), P1, G);
			final KeyFactory iFb9o2b3 = KeyFactory.getInstance("DH");
			final DHPublicKey ezIpupxS = (DHPublicKey) iFb9o2b3.generatePublic(tWVhQDPf);
			final KeyAgreement kR3ktYS3 = KeyAgreement.getInstance("DH");
			kR3ktYS3.init(this.keyPair.getPrivate());
			kR3ktYS3.doPhase(ezIpupxS, true);
			pZ3wdo3Q = new BigInteger(kR3ktYS3.generateSecret());
		}
		final MessageDigest hUgt3sDs = createMessageDigest();
		final byte[] Yuu9ogBy;
		{
			updateByteArray(hUgt3sDs, SshVersion.LOCAL.toString().getBytes());
			updateByteArray(hUgt3sDs, this.connection.getRemoteSshVersion().toString().getBytes());
			updateByteArray(hUgt3sDs, this.keyExchangeInitLocal.getPayload());
			updateByteArray(hUgt3sDs, this.keyExchangeInitRemote.getPayload());
			updateByteArray(hUgt3sDs, SXAPH8eX.hostKey);
			updateByteArray(hUgt3sDs, ((DHPublicKey) this.keyPair.getPublic()).getY().toByteArray());
			updateByteArray(hUgt3sDs, SXAPH8eX.f);
			updateBigInt(hUgt3sDs, pZ3wdo3Q);
			Yuu9ogBy = hUgt3sDs.digest();
		}
		if (this.sessionId == null)
			this.sessionId = Yuu9ogBy;
		this.keyExchangeInitLocal = null;
		this.keyExchangeInitRemote = null;
		this.h = Yuu9ogBy;
		this.k = pZ3wdo3Q;
		this.connection.send(new SshKeyExchangeNewKeys());
	}

}