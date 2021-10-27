class n22717352 {
	public void add(AddInterceptorChain OI1vA1jg, Entry b8veQ8zp, LDAPConstraints qjfyzvAI) throws LDAPException {
		Connection qOADLvbz = (Connection) OI1vA1jg.getRequest().get(JdbcInsert.MYVD_DB_CON + "LDAPBaseServer");
		if (qOADLvbz == null) {
			throw new LDAPException("Operations Error", LDAPException.OPERATIONS_ERROR, "No Database Connection");
		}
		try {
			qOADLvbz.setAutoCommit(false);
			HashMap<String, String> Jx7igjHf = (HashMap<String, String>) OI1vA1jg.getRequest()
					.get(JdbcInsert.MYVD_DB_DB2LDAP + "LDAPBaseServer");
			PreparedStatement GhefqX8G = qOADLvbz
					.prepareStatement("INSERT INTO USERS (id,firstname,lastname,username) VALUES (?,?,?,?)");
			GhefqX8G.setInt(1, 5);
			GhefqX8G.setString(2, b8veQ8zp.getEntry().getAttribute(Jx7igjHf.get("firstname")).getStringValue());
			GhefqX8G.setString(3, b8veQ8zp.getEntry().getAttribute(Jx7igjHf.get("lastname")).getStringValue());
			GhefqX8G.setString(4, b8veQ8zp.getEntry().getAttribute(Jx7igjHf.get("username")).getStringValue());
			GhefqX8G.executeUpdate();
			GhefqX8G.close();
			GhefqX8G = qOADLvbz.prepareStatement("SELECT id FROM LOCATIONS WHERE name=?");
			PreparedStatement y1M0aMyu = qOADLvbz
					.prepareStatement("INSERT INTO LOCATIONMAP (person,location) VALUES (?,?)");
			LDAPAttribute Fh9U0UCv = b8veQ8zp.getEntry().getAttribute(Jx7igjHf.get("name"));
			if (Fh9U0UCv == null) {
				qOADLvbz.rollback();
				throw new LDAPException("Location is required", LDAPException.OBJECT_CLASS_VIOLATION,
						"Location is required");
			}
			String[] FhyIF01n = Fh9U0UCv.getStringValueArray();
			for (int YPGkGIAI = 0; YPGkGIAI < FhyIF01n.length; YPGkGIAI++) {
				GhefqX8G.setString(1, FhyIF01n[YPGkGIAI]);
				ResultSet tO28EfdG = GhefqX8G.executeQuery();
				if (!tO28EfdG.next()) {
					qOADLvbz.rollback();
					throw new LDAPException("Location " + FhyIF01n[YPGkGIAI] + " does not exist",
							LDAPException.OBJECT_CLASS_VIOLATION, "Location " + FhyIF01n[YPGkGIAI] + " does not exist");
				}
				y1M0aMyu.setInt(1, 5);
				y1M0aMyu.setInt(2, tO28EfdG.getInt("id"));
				y1M0aMyu.executeUpdate();
			}
			GhefqX8G.close();
			y1M0aMyu.close();
			qOADLvbz.commit();
		} catch (SQLException z8gqvca9) {
			try {
				qOADLvbz.rollback();
			} catch (SQLException mDcdk8HC) {
				throw new LDAPException("Could not add entry or rollback transaction", LDAPException.OPERATIONS_ERROR,
						z8gqvca9.toString(), z8gqvca9);
			}
			throw new LDAPException("Could not add entry", LDAPException.OPERATIONS_ERROR, z8gqvca9.toString(),
					z8gqvca9);
		}
	}

}