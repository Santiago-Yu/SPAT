class n18048830 {
	public void add(AddInterceptorChain IK8YZHh0, Entry iUahPqpG, LDAPConstraints GBZ2oa8d) throws LDAPException {
		Connection iCnAN6Cg = (Connection) IK8YZHh0.getRequest().get(JdbcInsert.MYVD_DB_CON + this.dbInsertName);
		if (iCnAN6Cg == null) {
			throw new LDAPException("Operations Error", LDAPException.OPERATIONS_ERROR, "No Database Connection");
		}
		try {
			iCnAN6Cg.setAutoCommit(false);
			HashMap<String, String> vfNgmzWT = (HashMap<String, String>) IK8YZHh0.getRequest()
					.get(JdbcInsert.MYVD_DB_DB2LDAP + this.dbInsertName);
			String oXK5cOP6 = ((RDN) (new DN(iUahPqpG.getEntry().getDN())).getRDNs().get(0)).getValue();
			PreparedStatement VSXtKaLW = iCnAN6Cg.prepareStatement(this.insertSQL);
			for (int ROhKhVyF = 0; ROhKhVyF < this.fields.size(); ROhKhVyF++) {
				String s9FHTcfH = this.fields.get(ROhKhVyF);
				if (s9FHTcfH.equals(this.rdnField)) {
					VSXtKaLW.setString(ROhKhVyF + 1, oXK5cOP6);
				} else {
					VSXtKaLW.setString(ROhKhVyF + 1,
							iUahPqpG.getEntry().getAttribute(vfNgmzWT.get(s9FHTcfH)).getStringValue());
				}
			}
			VSXtKaLW.executeUpdate();
			iCnAN6Cg.commit();
		} catch (SQLException LjWoiG5V) {
			try {
				iCnAN6Cg.rollback();
			} catch (SQLException kWHDua4M) {
				throw new LDAPException("Could not delete entry or rollback transaction",
						LDAPException.OPERATIONS_ERROR, LjWoiG5V.toString(), LjWoiG5V);
			}
			throw new LDAPException("Could not delete entry", LDAPException.OPERATIONS_ERROR, LjWoiG5V.toString(),
					LjWoiG5V);
		}
	}

}