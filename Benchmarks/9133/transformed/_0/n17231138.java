class n17231138 {
	@Override
	protected AuthenticationHandlerResponse authenticateInternal(final Connection loVNgDjk,
			final AuthenticationCriteria cgmtFqfA) throws LdapException {
		byte[] bBYhlLK1;
		try {
			final MessageDigest X5KJc6JB = MessageDigest.getInstance(passwordScheme);
			X5KJc6JB.update(cgmtFqfA.getCredential().getBytes());
			bBYhlLK1 = X5KJc6JB.digest();
		} catch (NoSuchAlgorithmException aPgQLFGl) {
			throw new LdapException(aPgQLFGl);
		}
		final LdapAttribute JSqyTssP = new LdapAttribute("userPassword",
				String.format("{%s}%s", passwordScheme, LdapUtils.base64Encode(bBYhlLK1)).getBytes());
		final CompareOperation pY66ofLv = new CompareOperation(loVNgDjk);
		final CompareRequest GJFi0XLg = new CompareRequest(cgmtFqfA.getDn(), JSqyTssP);
		GJFi0XLg.setControls(getAuthenticationControls());
		final Response<Boolean> ADRmI3hw = pY66ofLv.execute(GJFi0XLg);
		return new AuthenticationHandlerResponse(ADRmI3hw.getResult(), ADRmI3hw.getResultCode(), loVNgDjk,
				ADRmI3hw.getMessage(), ADRmI3hw.getControls());
	}

}