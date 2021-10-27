class n7088303 {
	public void delete(DeleteInterceptorChain aw4UFzgt, DistinguishedName wl4sICvA, LDAPConstraints hoeOQMcS)
			throws LDAPException {
		Connection I7XPctUc = (Connection) aw4UFzgt.getRequest().get(JdbcInsert.MYVD_DB_CON + this.dbInsertName);
		if (I7XPctUc == null) {
			throw new LDAPException("Operations Error", LDAPException.OPERATIONS_ERROR, "No Database Connection");
		}
		try {
			I7XPctUc.setAutoCommit(false);
			String eE3Kh9K4 = ((RDN) wl4sICvA.getDN().getRDNs().get(0)).getValue();
			PreparedStatement ziuoHHP3 = I7XPctUc.prepareStatement(this.deleteSQL);
			ziuoHHP3.setString(1, eE3Kh9K4);
			ziuoHHP3.executeUpdate();
			I7XPctUc.commit();
		} catch (SQLException FDY0thkj) {
			try {
				I7XPctUc.rollback();
			} catch (SQLException OCDiKgEM) {
				throw new LDAPException("Could not delete entry or rollback transaction",
						LDAPException.OPERATIONS_ERROR, FDY0thkj.toString(), FDY0thkj);
			}
			throw new LDAPException("Could not delete entry", LDAPException.OPERATIONS_ERROR, FDY0thkj.toString(),
					FDY0thkj);
		}
	}

}