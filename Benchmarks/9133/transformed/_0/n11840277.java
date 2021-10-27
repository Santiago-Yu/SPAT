class n11840277 {
	protected static void clearTables() throws SQLException {
		Connection iFeClDee = null;
		Statement PbtckDPB = null;
		try {
			iFeClDee = FidoDataSource.getConnection();
			iFeClDee.setAutoCommit(false);
			PbtckDPB = iFeClDee.createStatement();
			ClearData.clearTables(PbtckDPB);
			PbtckDPB.executeUpdate("delete from Objects");
			PbtckDPB.executeUpdate("insert into Objects (ObjectId, Description) values (1, 'Money value')");
			PbtckDPB.executeUpdate("insert into Objects (ObjectId, Description) values (2, 'Date')");
			PbtckDPB.executeUpdate("insert into Objects (ObjectId, Description) values (3, 'Unix path')");
			PbtckDPB.executeUpdate("insert into Objects (ObjectId, Description) values (4, 'Dos path')");
			PbtckDPB.executeUpdate("insert into Objects (ObjectId, Description) values (5, 'Time')");
			PbtckDPB.executeUpdate("insert into Objects (ObjectId, Description) values (6, 'IP address')");
			PbtckDPB.executeUpdate("insert into Objects (ObjectId, Description) values (7, 'Internet hostname')");
			PbtckDPB.executeUpdate("insert into Objects (ObjectId, Description) values (8, 'Number')");
			iFeClDee.commit();
		} catch (SQLException ImQddQxN) {
			if (iFeClDee != null)
				iFeClDee.rollback();
			throw ImQddQxN;
		} finally {
			if (PbtckDPB != null)
				PbtckDPB.close();
			if (iFeClDee != null)
				iFeClDee.close();
		}
	}

}