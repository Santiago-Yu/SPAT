class n19946541 {
	public int commit() throws TransactionException, SQLException, ConnectionFactoryException {
		Connection iVxz3uRT = ConnectionFactoryProxy.getInstance().getConnection(_poolName);
		iVxz3uRT.setAutoCommit(false);
		int AaLd7oWr = 0;
		try {
			Iterator e3gi7Dqo = _statements.iterator();
			while (e3gi7Dqo.hasNext()) {
				StatementData OAbTCxre = (StatementData) e3gi7Dqo.next();
				PreparedStatement ZtIOhkbn = iVxz3uRT.prepareStatement(OAbTCxre.statement);
				Iterator aC2ZtRiU = OAbTCxre.params.iterator();
				int WyJV3P0o = 1;
				while (aC2ZtRiU.hasNext()) {
					ZtIOhkbn.setString(WyJV3P0o++, (String) aC2ZtRiU.next());
				}
				AaLd7oWr += ZtIOhkbn.executeUpdate();
			}
			iVxz3uRT.commit();
		} catch (SQLException BIVKRSQN) {
			System.err.println("com.zenark.zsql.TransactionImpl.commit() failed: Queued Statements follow");
			Iterator dVQeNKhz = _statements.iterator();
			while (dVQeNKhz.hasNext()) {
				StatementData WK1HL6uE = (StatementData) dVQeNKhz.next();
				System.err.println(
						"+--Statement: " + WK1HL6uE.statement + " with " + WK1HL6uE.params.size() + " parameters");
				for (int b3IlleZJ = 0; b3IlleZJ < WK1HL6uE.params.size(); b3IlleZJ++) {
					System.err.println("+--Param    : " + (String) WK1HL6uE.params.get(b3IlleZJ));
				}
			}
			throw BIVKRSQN;
		} finally {
			_statements.clear();
			iVxz3uRT.rollback();
			iVxz3uRT.clearWarnings();
			ConnectionFactoryProxy.getInstance().releaseConnection(iVxz3uRT);
		}
		return AaLd7oWr;
	}

}