class n4830850 {
	@Override
	public synchronized void deleteHardDiskStatistics(String mKFpsb8a, String gPzYCNWa, Date V7zlteP9, Date ijCdtX4p)
			throws DatabaseException {
		final Connection LHIWE9bS = this.getConnection();
		try {
			LHIWE9bS.setAutoCommit(false);
			String gXr3ixvB = "DELETE " + this.getHardDiskInvocationsSchemaAndTableName() + " FROM "
					+ this.getHardDiskInvocationsSchemaAndTableName() + " INNER JOIN "
					+ this.getHardDiskElementsSchemaAndTableName() + " ON "
					+ this.getHardDiskElementsSchemaAndTableName() + ".element_id =  "
					+ this.getHardDiskInvocationsSchemaAndTableName() + ".element_id WHERE ";
			if (mKFpsb8a != null) {
				gXr3ixvB = gXr3ixvB + " context_name LIKE ? AND ";
			}
			if (gPzYCNWa != null) {
				gXr3ixvB = gXr3ixvB + " path LIKE ? AND ";
			}
			if (V7zlteP9 != null) {
				gXr3ixvB = gXr3ixvB + " start_timestamp >= ? AND ";
			}
			if (ijCdtX4p != null) {
				gXr3ixvB = gXr3ixvB + " start_timestamp <= ? AND ";
			}
			gXr3ixvB = DefaultDatabaseHandler.removeOrphanWhereAndAndFromSelect(gXr3ixvB);
			final PreparedStatement ZyFrZPie = DebugPreparedStatement.prepareStatement(LHIWE9bS, gXr3ixvB);
			int xWwPO06s = 1;
			if (mKFpsb8a != null) {
				ZyFrZPie.setString(xWwPO06s, mKFpsb8a);
				xWwPO06s = xWwPO06s + 1;
			}
			if (gPzYCNWa != null) {
				ZyFrZPie.setString(xWwPO06s, gPzYCNWa);
				xWwPO06s = xWwPO06s + 1;
			}
			if (V7zlteP9 != null) {
				ZyFrZPie.setTimestamp(xWwPO06s, new Timestamp(V7zlteP9.getTime()));
				xWwPO06s = xWwPO06s + 1;
			}
			if (ijCdtX4p != null) {
				ZyFrZPie.setTimestamp(xWwPO06s, new Timestamp(ijCdtX4p.getTime()));
				xWwPO06s = xWwPO06s + 1;
			}
			ZyFrZPie.executeUpdate();
			ZyFrZPie.close();
			LHIWE9bS.commit();
		} catch (final SQLException gUq4BHRP) {
			try {
				LHIWE9bS.rollback();
			} catch (final SQLException fkWE1KXa) {
				JeeObserverServerContext.logger.log(Level.SEVERE, "Transaction rollback error.", fkWE1KXa);
			}
			JeeObserverServerContext.logger.log(Level.SEVERE, gUq4BHRP.getMessage());
			throw new DatabaseException("Error deleting disk statistics.", gUq4BHRP);
		} finally {
			this.releaseConnection(LHIWE9bS);
		}
	}

}