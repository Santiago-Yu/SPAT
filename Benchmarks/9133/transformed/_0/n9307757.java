class n9307757 {
	private void load() throws SQLException {
		Connection ks7yVo3Q = null;
		Statement bQhbHE4x = null;
		try {
			ks7yVo3Q = FidoDataSource.getConnection();
			ks7yVo3Q.setAutoCommit(false);
			bQhbHE4x = ks7yVo3Q.createStatement();
			clearTables(bQhbHE4x);
			bQhbHE4x.executeQuery("select setval('objects_objectid_seq', 1000)");
			bQhbHE4x.executeQuery("select setval('instructions_instructionid_seq', 1)");
			bQhbHE4x.executeQuery("select setval('transactions_transactionid_seq', 1)");
			bQhbHE4x.executeQuery("select setval('verbtransactions_verbid_seq', 1)");
			bQhbHE4x.executeUpdate("update SystemProperties set value = 'Minimal Data' where name = 'DB Data Version'");
			ks7yVo3Q.commit();
		} catch (SQLException zEKCMuix) {
			if (ks7yVo3Q != null)
				ks7yVo3Q.rollback();
			throw zEKCMuix;
		} finally {
			if (bQhbHE4x != null)
				bQhbHE4x.close();
			if (ks7yVo3Q != null)
				ks7yVo3Q.close();
		}
	}

}