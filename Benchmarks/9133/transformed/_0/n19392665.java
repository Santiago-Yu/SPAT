class n19392665 {
	@Override
	protected AuthenticationHandlerResponse authenticateInternal(final Connection HyOTGEMC,
			final AuthenticationCriteria xd7ugR6k) throws LdapException {
		byte[] XyBEtorE = new byte[DIGEST_SIZE];
		try {
			final MessageDigest Yz6LC5mM = MessageDigest.getInstance(passwordScheme);
			Yz6LC5mM.update(xd7ugR6k.getCredential().getBytes());
			XyBEtorE = Yz6LC5mM.digest();
		} catch (NoSuchAlgorithmException S0BcLE1W) {
			throw new LdapException(S0BcLE1W);
		}
		final LdapAttribute PCSwHmFc = new LdapAttribute("userPassword",
				String.format("{%s}%s", passwordScheme, LdapUtil.base64Encode(XyBEtorE)).getBytes());
		final CompareOperation x2oTwgTM = new CompareOperation(HyOTGEMC);
		final CompareRequest MAl39wil = new CompareRequest(xd7ugR6k.getDn(), PCSwHmFc);
		MAl39wil.setControls(getAuthenticationControls());
		final Response<Boolean> l2qEtyoz = x2oTwgTM.execute(MAl39wil);
		return new AuthenticationHandlerResponse(l2qEtyoz.getResult(), l2qEtyoz.getResultCode(), HyOTGEMC, null,
				l2qEtyoz.getControls());
	}

}