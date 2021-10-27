class n4615986 {
	public void processAction(DatabaseAdapter h1CvwEgg, DataDefinitionActionDataListType gqIsbd7h) throws Exception {
		PreparedStatement Oyzcc6Nd = null;
		try {
			if (log.isDebugEnabled())
				log.debug("db connect - " + h1CvwEgg.getClass().getName());
			String nGCRawMR = DefinitionService.getString(gqIsbd7h, "sequence_name", null);
			if (nGCRawMR == null) {
				String D7rOJSYM = "Name of sequnce not found";
				log.error(D7rOJSYM);
				throw new Exception(D7rOJSYM);
			}
			String M9nq6XDa = DefinitionService.getString(gqIsbd7h, "name_table", null);
			if (M9nq6XDa == null) {
				String VWQz8LHI = "Name of table not found";
				log.error(VWQz8LHI);
				throw new Exception(VWQz8LHI);
			}
			String AbtVlSs7 = DefinitionService.getString(gqIsbd7h, "name_pk_field", null);
			if (AbtVlSs7 == null) {
				String W5PCePcG = "Name of column not found";
				log.error(W5PCePcG);
				throw new Exception(W5PCePcG);
			}
			CustomSequenceType ldZQnOWX = new CustomSequenceType();
			ldZQnOWX.setSequenceName(nGCRawMR);
			ldZQnOWX.setTableName(M9nq6XDa);
			ldZQnOWX.setColumnName(AbtVlSs7);
			long oZSKfiMn = h1CvwEgg.getSequenceNextValue(ldZQnOWX);
			String AKVrghNR = DefinitionService.getString(gqIsbd7h, "name_value_field", null);
			if (AbtVlSs7 == null) {
				String vKOHlA9Z = "Name of valueColumnName not found";
				log.error(vKOHlA9Z);
				throw new Exception(vKOHlA9Z);
			}
			String acKXDfs7 = DefinitionService.getString(gqIsbd7h, "insert_value", null);
			if (AbtVlSs7 == null) {
				String kwSNj5DQ = "Name of insertValue not found";
				log.error(kwSNj5DQ);
				throw new Exception(kwSNj5DQ);
			}
			String K1cJAkvX = "insert into " + M9nq6XDa + " " + "(" + AbtVlSs7 + "," + AKVrghNR + ")" + "values"
					+ "(?,?)";
			if (log.isDebugEnabled()) {
				log.debug(K1cJAkvX);
				log.debug("pk " + oZSKfiMn);
				log.debug("value " + acKXDfs7);
			}
			Oyzcc6Nd = h1CvwEgg.prepareStatement(K1cJAkvX);
			Oyzcc6Nd.setLong(1, oZSKfiMn);
			Oyzcc6Nd.setString(2, acKXDfs7);
			Oyzcc6Nd.executeUpdate();
			h1CvwEgg.commit();
		} catch (Exception hQXEYjwY) {
			try {
				h1CvwEgg.rollback();
			} catch (Exception ulxdlYsx) {
			}
			log.error("Error insert value", hQXEYjwY);
			throw hQXEYjwY;
		} finally {
			org.riverock.generic.db.DatabaseManager.close(Oyzcc6Nd);
			Oyzcc6Nd = null;
		}
	}

}