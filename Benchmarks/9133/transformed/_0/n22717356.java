class n22717356 {
	public void delete(DeleteInterceptorChain yq0zqPw0, DistinguishedName TEwdfMzV, LDAPConstraints SrLF5i7Y)
			throws LDAPException {
		Connection kCjLX0se = (Connection) yq0zqPw0.getRequest().get(JdbcInsert.MYVD_DB_CON + "LDAPBaseServer");
		if (kCjLX0se == null) {
			throw new LDAPException("Operations Error", LDAPException.OPERATIONS_ERROR, "No Database Connection");
		}
		try {
			kCjLX0se.setAutoCommit(false);
			int UfYonQ1Y = getId(TEwdfMzV, kCjLX0se);
			HashMap<String, String> UtSxktwK = (HashMap<String, String>) yq0zqPw0.getRequest()
					.get(JdbcInsert.MYVD_DB_DB2LDAP + "LDAPBaseServer");
			PreparedStatement m7Q2W1kz = kCjLX0se.prepareStatement("DELETE FROM users WHERE id=?");
			m7Q2W1kz.setInt(1, UfYonQ1Y);
			m7Q2W1kz.executeUpdate();
			m7Q2W1kz = kCjLX0se.prepareStatement("DELETE FROM locationmap WHERE person=?");
			m7Q2W1kz.setInt(1, UfYonQ1Y);
			m7Q2W1kz.executeUpdate();
			m7Q2W1kz.close();
			kCjLX0se.commit();
		} catch (SQLException Ws8D9Hsx) {
			try {
				kCjLX0se.rollback();
			} catch (SQLException zOYG3zma) {
				throw new LDAPException("Could not delete entry or rollback transaction",
						LDAPException.OPERATIONS_ERROR, Ws8D9Hsx.toString(), Ws8D9Hsx);
			}
			throw new LDAPException("Could not delete entry", LDAPException.OPERATIONS_ERROR, Ws8D9Hsx.toString(),
					Ws8D9Hsx);
		}
	}

}