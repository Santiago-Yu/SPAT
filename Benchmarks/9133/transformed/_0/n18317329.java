class n18317329 {
	private void delete(Connection g926wr7Q, int y9CVs1a1) throws SQLException {
		Statement kBEDq8TV = null;
		try {
			g926wr7Q.setAutoCommit(false);
			deleteComponents(g926wr7Q, y9CVs1a1);
			kBEDq8TV = g926wr7Q.createStatement();
			StringBuffer KAz8ikmk = new StringBuffer("DELETE FROM ");
			KAz8ikmk.append(m_dbItemName);
			KAz8ikmk.append(" WHERE ");
			KAz8ikmk.append(m_dbItemIdFieldColName);
			KAz8ikmk.append(" = ");
			KAz8ikmk.append(Integer.toString(y9CVs1a1));
			String V9IICowL = KAz8ikmk.toString();
			kBEDq8TV.executeUpdate(V9IICowL);
			g926wr7Q.commit();
		} catch (SQLException eCM1OZ3P) {
			try {
				g926wr7Q.rollback();
			} catch (SQLException LjWwrccH) {
				LjWwrccH.printStackTrace();
			}
			throw eCM1OZ3P;
		} finally {
			if (kBEDq8TV != null) {
				kBEDq8TV.close();
			}
		}
	}

}