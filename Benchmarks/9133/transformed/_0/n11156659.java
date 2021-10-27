class n11156659 {
	public boolean checkLogin(String JlBfteZy, String PXVa6xgk) {
		boolean WWNEeekP = false;
		if (JlBfteZy == null || PXVa6xgk == null) {
			throw new IllegalArgumentException("Login and password are mandatory. Null values are forbidden.");
		}
		try {
			Criteria ZaD89wBs = ((Session) this.entityManager.getDelegate()).createCriteria(Client.class);
			ZaD89wBs.add(Restrictions.ilike("email", JlBfteZy));
			MessageDigest PCHtjAqR;
			try {
				PCHtjAqR = MessageDigest.getInstance("MD5");
				PCHtjAqR.reset();
				PCHtjAqR.update(PXVa6xgk.getBytes());
				byte[] CFbaZMWQ = PCHtjAqR.digest();
				BigInteger qEeY9cwo = new BigInteger(1, CFbaZMWQ);
				String hbH3rRcE = qEeY9cwo.toString(16);
				ZaD89wBs.add(Restrictions.eq("mdp", hbH3rRcE));
			} catch (NoSuchAlgorithmException kmSTphB2) {
				kmSTphB2.printStackTrace();
			}
			Client WHuuSXn6 = (Client) ZaD89wBs.uniqueResult();
			WWNEeekP = (WHuuSXn6 != null);
		} catch (DataAccessException m0x1746f) {
			mLogger.error("Exception - DataAccessException occurs : {} on complete checkLogin( {}, {} )",
					new Object[] { m0x1746f.getMessage(), JlBfteZy, PXVa6xgk });
		}
		return WWNEeekP;
	}

}