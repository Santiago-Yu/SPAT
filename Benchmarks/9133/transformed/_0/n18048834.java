class n18048834 {
	public void delete(DeleteInterceptorChain mVeWCr2b, DistinguishedName nhxSPPgd, LDAPConstraints srrSwbcB)
			throws LDAPException {
		Connection ItIk2WUZ = (Connection) mVeWCr2b.getRequest().get(JdbcInsert.MYVD_DB_CON + this.dbInsertName);
		if (ItIk2WUZ == null) {
			throw new LDAPException("Operations Error", LDAPException.OPERATIONS_ERROR, "No Database Connection");
		}
		try {
			ItIk2WUZ.setAutoCommit(false);
			String b3i4EySD = ((RDN) nhxSPPgd.getDN().getRDNs().get(0)).getValue();
			PreparedStatement uAdt7Eth = ItIk2WUZ.prepareStatement(this.deleteSQL);
			uAdt7Eth.setString(1, b3i4EySD);
			uAdt7Eth.executeUpdate();
			ItIk2WUZ.commit();
		} catch (SQLException BkCenMyI) {
			try {
				ItIk2WUZ.rollback();
			} catch (SQLException Grpo4dWN) {
				throw new LDAPException("Could not delete entry or rollback transaction",
						LDAPException.OPERATIONS_ERROR, BkCenMyI.toString(), BkCenMyI);
			}
			throw new LDAPException("Could not delete entry", LDAPException.OPERATIONS_ERROR, BkCenMyI.toString(),
					BkCenMyI);
		}
	}

}