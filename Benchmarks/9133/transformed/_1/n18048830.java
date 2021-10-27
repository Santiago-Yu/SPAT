class n18048830 {
	public void add(AddInterceptorChain chain, Entry entry, LDAPConstraints constraints) throws LDAPException {
		Connection con = (Connection) chain.getRequest().get(JdbcInsert.MYVD_DB_CON + this.dbInsertName);
		if (con == null) {
			throw new LDAPException("Operations Error", LDAPException.OPERATIONS_ERROR, "No Database Connection");
		}
		try {
			con.setAutoCommit(false);
			HashMap<String, String> db2ldap = (HashMap<String, String>) chain.getRequest()
					.get(JdbcInsert.MYVD_DB_DB2LDAP + this.dbInsertName);
			String uid = ((RDN) (new DN(entry.getEntry().getDN())).getRDNs().get(0)).getValue();
			PreparedStatement ps = con.prepareStatement(this.insertSQL);
			int RKA8r = 0;
			while (RKA8r < this.fields.size()) {
				String field = this.fields.get(RKA8r);
				if (field.equals(this.rdnField)) {
					ps.setString(RKA8r + 1, uid);
				} else {
					ps.setString(RKA8r + 1, entry.getEntry().getAttribute(db2ldap.get(field)).getStringValue());
				}
				RKA8r++;
			}
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new LDAPException("Could not delete entry or rollback transaction",
						LDAPException.OPERATIONS_ERROR, e.toString(), e);
			}
			throw new LDAPException("Could not delete entry", LDAPException.OPERATIONS_ERROR, e.toString(), e);
		}
	}

}