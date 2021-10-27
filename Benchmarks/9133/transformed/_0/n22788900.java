class n22788900 {
	@Override
	public void saveStructure(long DsFfo0NK, TreeStructureInfo l0n5aypJ, List<TreeStructureNode> R4QpY6ea)
			throws DatabaseException {
		if (l0n5aypJ == null)
			throw new NullPointerException("info");
		if (R4QpY6ea == null)
			throw new NullPointerException("structure");
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException SgSzd3P1) {
			LOGGER.warn("Unable to set autocommit off", SgSzd3P1);
		}
		PreparedStatement lKD5xN6k = null, yshewx3O = null;
		try {
			lKD5xN6k = getConnection().prepareStatement(INSERT_INFO);
			lKD5xN6k.setLong(1, DsFfo0NK);
			lKD5xN6k.setString(2, l0n5aypJ.getDescription() != null ? l0n5aypJ.getDescription() : "");
			lKD5xN6k.setString(3, l0n5aypJ.getBarcode());
			lKD5xN6k.setString(4, l0n5aypJ.getName());
			lKD5xN6k.setString(5, l0n5aypJ.getInputPath());
			lKD5xN6k.setString(6, l0n5aypJ.getModel());
			lKD5xN6k.executeUpdate();
			PreparedStatement WO0KYmNu = getConnection().prepareStatement(INFO_VALUE);
			ResultSet mL7iqbwY = WO0KYmNu.executeQuery();
			int ZZbGuYO4 = -1;
			while (mL7iqbwY.next()) {
				ZZbGuYO4 = mL7iqbwY.getInt(1);
			}
			if (ZZbGuYO4 == -1) {
				getConnection().rollback();
				throw new DatabaseException("Unable to obtain new id from DB when executing query: " + lKD5xN6k);
			}
			int gEnC3zCb = 0;
			for (TreeStructureNode kjNrmIg2 : R4QpY6ea) {
				yshewx3O = getConnection().prepareStatement(INSERT_NODE);
				yshewx3O.setLong(1, ZZbGuYO4);
				yshewx3O.setString(2, kjNrmIg2.getPropId());
				yshewx3O.setString(3, kjNrmIg2.getPropParent());
				yshewx3O.setString(4, kjNrmIg2.getPropName());
				yshewx3O.setString(5, kjNrmIg2.getPropPicture());
				yshewx3O.setString(6, kjNrmIg2.getPropType());
				yshewx3O.setString(7, kjNrmIg2.getPropTypeId());
				yshewx3O.setString(8, kjNrmIg2.getPropPageType());
				yshewx3O.setString(9, kjNrmIg2.getPropDateIssued());
				yshewx3O.setString(10, kjNrmIg2.getPropAltoPath());
				yshewx3O.setString(11, kjNrmIg2.getPropOcrPath());
				yshewx3O.setBoolean(12, kjNrmIg2.getPropExist());
				gEnC3zCb += yshewx3O.executeUpdate();
			}
			if (gEnC3zCb != R4QpY6ea.size()) {
				getConnection().rollback();
				throw new DatabaseException(
						"Unable to insert _ALL_ nodes: " + gEnC3zCb + " nodes were inserted of " + R4QpY6ea.size());
			}
			getConnection().commit();
		} catch (SQLException JNfltBxQ) {
			LOGGER.error("Queries: \"" + lKD5xN6k + "\" and \"" + yshewx3O + "\"", JNfltBxQ);
		} finally {
			closeConnection();
		}
	}

}