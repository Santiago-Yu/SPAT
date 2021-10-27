class n18048836 {
	public void modify(ModifyInterceptorChain zWrSrntG, DistinguishedName CMCTOc7R,
			ArrayList<LDAPModification> lUAVEuRu, LDAPConstraints TBVZrg31) throws LDAPException {
		Connection rER6mmQg = (Connection) zWrSrntG.getRequest().get(JdbcInsert.MYVD_DB_CON + this.dbInsertName);
		if (rER6mmQg == null) {
			throw new LDAPException("Operations Error", LDAPException.OPERATIONS_ERROR, "No Database Connection");
		}
		try {
			rER6mmQg.setAutoCommit(false);
			HashMap<String, String> ANiWWVT1 = (HashMap<String, String>) zWrSrntG.getRequest()
					.get(JdbcInsert.MYVD_DB_LDAP2DB + this.dbInsertName);
			Iterator<LDAPModification> SpoWCBaC = lUAVEuRu.iterator();
			String uQllpJbm = "UPDATE " + this.tableName + " SET ";
			while (SpoWCBaC.hasNext()) {
				LDAPModification eZmJ3uWt = SpoWCBaC.next();
				if (eZmJ3uWt.getOp() != LDAPModification.REPLACE) {
					throw new LDAPException("Only modify replace allowed", LDAPException.OBJECT_CLASS_VIOLATION, "");
				}
				uQllpJbm += ANiWWVT1.get(eZmJ3uWt.getAttribute().getName()) + "=? ";
			}
			uQllpJbm += " WHERE " + this.rdnField + "=?";
			PreparedStatement k9k7U91a = rER6mmQg.prepareStatement(uQllpJbm);
			SpoWCBaC = lUAVEuRu.iterator();
			int ORfZ0GLc = 1;
			while (SpoWCBaC.hasNext()) {
				LDAPModification Iv8guxBe = SpoWCBaC.next();
				k9k7U91a.setString(ORfZ0GLc, Iv8guxBe.getAttribute().getStringValue());
				ORfZ0GLc++;
			}
			String ESWCjoUe = ((RDN) CMCTOc7R.getDN().getRDNs().get(0)).getValue();
			k9k7U91a.setString(ORfZ0GLc, ESWCjoUe);
			k9k7U91a.executeUpdate();
			rER6mmQg.commit();
		} catch (SQLException ITPmrRz4) {
			try {
				rER6mmQg.rollback();
			} catch (SQLException kK5Wjr7u) {
				throw new LDAPException("Could not delete entry or rollback transaction",
						LDAPException.OPERATIONS_ERROR, ITPmrRz4.toString(), ITPmrRz4);
			}
			throw new LDAPException("Could not delete entry", LDAPException.OPERATIONS_ERROR, ITPmrRz4.toString(),
					ITPmrRz4);
		}
	}

}