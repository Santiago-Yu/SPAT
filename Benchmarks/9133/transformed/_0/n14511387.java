class n14511387 {
	public void authenticate(final ConnectionHandler vCf5Dl5B, final AuthenticationCriteria dEAYkcWD)
			throws NamingException {
		byte[] QLO8m27Y = new byte[DIGEST_SIZE];
		try {
			final MessageDigest NRsAxHf5 = MessageDigest.getInstance(this.passwordScheme);
			NRsAxHf5.update(((String) dEAYkcWD.getCredential()).getBytes());
			QLO8m27Y = NRsAxHf5.digest();
		} catch (NoSuchAlgorithmException QUg7WeAr) {
			throw new NamingException(QUg7WeAr.getMessage());
		}
		vCf5Dl5B.connect(this.config.getBindDn(), this.config.getBindCredential());
		NamingEnumeration<SearchResult> h7uU9pzg = null;
		try {
			h7uU9pzg = vCf5Dl5B.getLdapContext().search(dEAYkcWD.getDn(), "userPassword={0}",
					new Object[] {
							String.format("{%s}%s", this.passwordScheme, LdapUtil.base64Encode(QLO8m27Y)).getBytes() },
					LdapConfig.getCompareSearchControls());
			if (!h7uU9pzg.hasMore()) {
				throw new AuthenticationException("Compare authentication failed.");
			}
		} finally {
			if (h7uU9pzg != null) {
				h7uU9pzg.close();
			}
		}
	}

}