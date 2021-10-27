class n7088306 {
	private void modifyEntry(ModifyInterceptorChain mxvzK8Nx, DistinguishedName jcttsPJI,
			ArrayList<LDAPModification> KpcuEVCV, Connection vry1goUL) throws LDAPException {
		try {
			vry1goUL.setAutoCommit(false);
			HashMap<String, String> oZYHPopc = (HashMap<String, String>) mxvzK8Nx.getRequest()
					.get(JdbcInsert.MYVD_DB_LDAP2DB + this.dbInsertName);
			Iterator<LDAPModification> TDRDW0EF = KpcuEVCV.iterator();
			String xFzdD3YH = "UPDATE " + this.tableName + " SET ";
			while (TDRDW0EF.hasNext()) {
				LDAPModification r0IQxSrW = TDRDW0EF.next();
				if (r0IQxSrW.getOp() != LDAPModification.REPLACE) {
					throw new LDAPException("Only modify replace allowed", LDAPException.OBJECT_CLASS_VIOLATION, "");
				}
				xFzdD3YH += oZYHPopc.get(r0IQxSrW.getAttribute().getName()) + "=? ";
			}
			xFzdD3YH += " WHERE " + this.rdnField + "=?";
			PreparedStatement restUCT7 = vry1goUL.prepareStatement(xFzdD3YH);
			TDRDW0EF = KpcuEVCV.iterator();
			int rfPJc02U = 1;
			while (TDRDW0EF.hasNext()) {
				LDAPModification muFAxIxD = TDRDW0EF.next();
				restUCT7.setString(rfPJc02U, muFAxIxD.getAttribute().getStringValue());
				rfPJc02U++;
			}
			String ZAoyMM1V = ((RDN) jcttsPJI.getDN().getRDNs().get(0)).getValue();
			restUCT7.setString(rfPJc02U, ZAoyMM1V);
			restUCT7.executeUpdate();
			vry1goUL.commit();
		} catch (SQLException A5g4k4Ty) {
			try {
				vry1goUL.rollback();
			} catch (SQLException EJZQs9GW) {
				throw new LDAPException("Could not delete entry or rollback transaction",
						LDAPException.OPERATIONS_ERROR, A5g4k4Ty.toString(), A5g4k4Ty);
			}
			throw new LDAPException("Could not delete entry", LDAPException.OPERATIONS_ERROR, A5g4k4Ty.toString(),
					A5g4k4Ty);
		}
	}

}