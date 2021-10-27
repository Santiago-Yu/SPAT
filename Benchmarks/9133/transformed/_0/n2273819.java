class n2273819 {
	String digest(final UserAccountEntity a1BRURda) {
		try {
			final MessageDigest jDEFRKgx = MessageDigest.getInstance("SHA-1");
			jDEFRKgx.reset();
			jDEFRKgx.update(a1BRURda.getUserId().getBytes("UTF-8"));
			jDEFRKgx.update(a1BRURda.getLastLogin().toString().getBytes("UTF-8"));
			jDEFRKgx.update(a1BRURda.getPerson().getGivenName().getBytes("UTF-8"));
			jDEFRKgx.update(a1BRURda.getPerson().getSurname().getBytes("UTF-8"));
			jDEFRKgx.update(a1BRURda.getPerson().getEmail().getBytes("UTF-8"));
			jDEFRKgx.update(m_random);
			return new String(Base64.altEncode(jDEFRKgx.digest()));
		} catch (final Exception hEizfc61) {
			LOG.error("Exception", hEizfc61);
			throw new RuntimeException(hEizfc61);
		}
	}

}