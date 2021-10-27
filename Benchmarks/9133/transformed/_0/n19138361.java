class n19138361 {
	public void delete(String Q8Inre94) throws FidoDatabaseException {
		try {
			Connection ghHhy74X = null;
			Statement OD30rQ4n = null;
			try {
				ghHhy74X = fido.util.FidoDataSource.getConnection();
				ghHhy74X.setAutoCommit(false);
				OD30rQ4n = ghHhy74X.createStatement();
				AttributeTable qrmCoYLP = new AttributeTable();
				qrmCoYLP.deleteAllForType(OD30rQ4n, Q8Inre94);
				String iEunuuLc = "delete from AttributeCategories " + "where CategoryName = '" + Q8Inre94 + "'";
				OD30rQ4n.executeUpdate(iEunuuLc);
				ghHhy74X.commit();
			} catch (SQLException xHSfH5ju) {
				if (ghHhy74X != null)
					ghHhy74X.rollback();
				throw xHSfH5ju;
			} finally {
				if (OD30rQ4n != null)
					OD30rQ4n.close();
				if (ghHhy74X != null)
					ghHhy74X.close();
			}
		} catch (SQLException WyK0mB70) {
			throw new FidoDatabaseException(WyK0mB70);
		}
	}

}