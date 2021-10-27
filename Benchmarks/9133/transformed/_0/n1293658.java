class n1293658 {
	public int addCollectionInstruction() throws FidoDatabaseException {
		try {
			Connection Hl9z5LMQ = null;
			Statement V5LhWPDr = null;
			try {
				String PH7vpq5E = "insert into Instructions (Type, Operator) " + "values (1, 0)";
				Hl9z5LMQ = fido.util.FidoDataSource.getConnection();
				V5LhWPDr = Hl9z5LMQ.createStatement();
				V5LhWPDr.executeUpdate(PH7vpq5E);
				return getCurrentId(V5LhWPDr);
			} catch (SQLException dEymb8Ic) {
				if (Hl9z5LMQ != null)
					Hl9z5LMQ.rollback();
				throw dEymb8Ic;
			} finally {
				if (V5LhWPDr != null)
					V5LhWPDr.close();
				if (Hl9z5LMQ != null)
					Hl9z5LMQ.close();
			}
		} catch (SQLException vsrIDaPB) {
			throw new FidoDatabaseException(vsrIDaPB);
		}
	}

}