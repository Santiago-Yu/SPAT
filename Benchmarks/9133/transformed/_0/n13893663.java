class n13893663 {
	public static int executeNoQuery(String cIkf8xNu) throws SQLException {
		MyDBConnection Pn7HvIK2 = new MyDBConnection();
		Pn7HvIK2.init();
		Statement NjKRw1oD = Pn7HvIK2.getMyConnection().createStatement();
		try {
			int GHcDR9of = NjKRw1oD.executeUpdate(cIkf8xNu);
			Pn7HvIK2.myConnection.commit();
			return GHcDR9of;
		} catch (SQLException MRvS2F09) {
			Pn7HvIK2.myConnection.rollback();
			throw new SQLException("rollback e close effettuato dopo " + MRvS2F09.getMessage());
		} finally {
			Pn7HvIK2.close();
		}
	}

}