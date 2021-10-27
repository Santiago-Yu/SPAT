class n10968489 {
	private void storeFieldMap(Content jgzNmhWk, Connection lIbUFF50) throws SQLException {
		SQLDialect PNpzL4md = getDatabase().getSQLDialect();
		if (TRANSACTIONS_ENABLED) {
			lIbUFF50.setAutoCommit(false);
		}
		try {
			Object WeAiDSTZ = jgzNmhWk.getPrimaryKey();
			deleteFieldContent(WeAiDSTZ, lIbUFF50);
			PreparedStatement OOnHBdOJ = null;
			StructureItem TZv0crUV;
			Map TsbuhthE = jgzNmhWk.getFieldMap();
			String I9S8XpDK;
			Object Z1NbjVP2, nmz1Pw6z;
			for (Iterator rgbQOupH = jgzNmhWk.getStructure().getStructureItems().iterator(); rgbQOupH.hasNext();) {
				TZv0crUV = (StructureItem) rgbQOupH.next();
				I9S8XpDK = TZv0crUV.getDataType().toUpperCase();
				nmz1Pw6z = TZv0crUV.getPrimaryKey();
				Z1NbjVP2 = TsbuhthE.get(TZv0crUV.getName());
				if (I9S8XpDK.equals(StructureItem.DATE)) {
					OOnHBdOJ = lIbUFF50.prepareStatement(sqlConstants.get("INSERT_DATE_FIELD"));
					OOnHBdOJ.setObject(1, WeAiDSTZ);
					OOnHBdOJ.setObject(2, nmz1Pw6z);
					PNpzL4md.setDate(OOnHBdOJ, 3, (java.util.Date) Z1NbjVP2);
					OOnHBdOJ.executeUpdate();
				} else if (I9S8XpDK.equals(StructureItem.INT) || I9S8XpDK.equals(StructureItem.FLOAT)
						|| I9S8XpDK.equals(StructureItem.VARCHAR)) {
					OOnHBdOJ = lIbUFF50.prepareStatement(sqlConstants.get("INSERT_" + I9S8XpDK + "_FIELD"));
					OOnHBdOJ.setObject(1, WeAiDSTZ);
					OOnHBdOJ.setObject(2, nmz1Pw6z);
					if (Z1NbjVP2 != null) {
						OOnHBdOJ.setObject(3, Z1NbjVP2);
					} else {
						int otCeOlx3 = Types.INTEGER;
						if (I9S8XpDK.equals(StructureItem.FLOAT)) {
							otCeOlx3 = Types.FLOAT;
						} else if (I9S8XpDK.equals(StructureItem.VARCHAR)) {
							otCeOlx3 = Types.VARCHAR;
						}
						OOnHBdOJ.setNull(3, otCeOlx3);
					}
					OOnHBdOJ.executeUpdate();
				} else if (I9S8XpDK.equals(StructureItem.TEXT)) {
					setTextField(jgzNmhWk, nmz1Pw6z, (String) Z1NbjVP2, lIbUFF50);
				}
				if (OOnHBdOJ != null) {
					OOnHBdOJ.close();
					OOnHBdOJ = null;
				}
			}
			if (TRANSACTIONS_ENABLED) {
				lIbUFF50.commit();
			}
		} catch (SQLException Bu1UlQHt) {
			if (TRANSACTIONS_ENABLED) {
				lIbUFF50.rollback();
			}
			throw Bu1UlQHt;
		} finally {
			if (TRANSACTIONS_ENABLED) {
				lIbUFF50.setAutoCommit(true);
			}
		}
	}

}