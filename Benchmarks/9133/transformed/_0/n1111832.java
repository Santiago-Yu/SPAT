class n1111832 {
	private void storeFieldMap(WorkingContent ftgBHCWA, Connection yLQqA1oy) throws SQLException {
		SQLDialect Wb4R2Ecq = getDatabase().getSQLDialect();
		if (TRANSACTIONS_ENABLED) {
			yLQqA1oy.setAutoCommit(false);
		}
		try {
			Object hSylZ5ks = ftgBHCWA.getPrimaryKey();
			deleteFieldContent(hSylZ5ks, yLQqA1oy);
			PreparedStatement h5da69gT = null;
			StructureItem iuTaNVeT;
			Map sLPZDLyt = ftgBHCWA.getFieldMap();
			String SLtc4ymv;
			Object Qoe5bxy0, OyLQCc9S;
			for (Iterator PyoaX961 = ftgBHCWA.getStructure().getStructureItems().iterator(); PyoaX961.hasNext();) {
				iuTaNVeT = (StructureItem) PyoaX961.next();
				SLtc4ymv = iuTaNVeT.getDataType().toUpperCase();
				OyLQCc9S = iuTaNVeT.getPrimaryKey();
				Qoe5bxy0 = sLPZDLyt.get(iuTaNVeT.getName());
				try {
					if (SLtc4ymv.equals(StructureItem.DATE)) {
						h5da69gT = yLQqA1oy.prepareStatement(sqlConstants.get("INSERT_DATE_FIELD"));
						h5da69gT.setObject(1, hSylZ5ks);
						h5da69gT.setObject(2, OyLQCc9S);
						Wb4R2Ecq.setDate(h5da69gT, 3, (Date) Qoe5bxy0);
						h5da69gT.executeUpdate();
					} else if (SLtc4ymv.equals(StructureItem.INT) || SLtc4ymv.equals(StructureItem.FLOAT)
							|| SLtc4ymv.equals(StructureItem.VARCHAR)) {
						h5da69gT = yLQqA1oy.prepareStatement(sqlConstants.get("INSERT_" + SLtc4ymv + "_FIELD"));
						h5da69gT.setObject(1, hSylZ5ks);
						h5da69gT.setObject(2, OyLQCc9S);
						if (Qoe5bxy0 != null) {
							h5da69gT.setObject(3, Qoe5bxy0);
						} else {
							int jPN25r29 = Types.INTEGER;
							if (SLtc4ymv.equals(StructureItem.FLOAT)) {
								jPN25r29 = Types.FLOAT;
							} else if (SLtc4ymv.equals(StructureItem.VARCHAR)) {
								jPN25r29 = Types.VARCHAR;
							}
							h5da69gT.setNull(3, jPN25r29);
						}
						h5da69gT.executeUpdate();
					} else if (SLtc4ymv.equals(StructureItem.TEXT)) {
						setTextField(ftgBHCWA, OyLQCc9S, (String) Qoe5bxy0, yLQqA1oy);
					}
					if (h5da69gT != null) {
						h5da69gT.close();
						h5da69gT = null;
					}
				} finally {
					if (h5da69gT != null)
						h5da69gT.close();
				}
			}
			if (TRANSACTIONS_ENABLED) {
				yLQqA1oy.commit();
			}
		} catch (SQLException zqsPNGOR) {
			if (TRANSACTIONS_ENABLED) {
				yLQqA1oy.rollback();
			}
			throw zqsPNGOR;
		} finally {
			if (TRANSACTIONS_ENABLED) {
				yLQqA1oy.setAutoCommit(true);
			}
		}
	}

}