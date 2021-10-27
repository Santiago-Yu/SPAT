class n8512998 {
	public boolean updateCalculatedHand(CalculateTransferObject query, BasicStartingHandTransferObject[] hands)
			throws CalculateDAOException {
		boolean retval = false;
		Connection connection = null;
		Statement statement = null;
		PreparedStatement prep = null;
		ResultSet result = null;
		StringBuffer sql = new StringBuffer(SELECT_ID_SQL);
		sql.append(appendQuery(query));
		try {
			connection = getDataSource().getConnection();
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			result = statement.executeQuery(sql.toString());
			if (result.first()) {
				String id = result.getString("id");
				prep = connection.prepareStatement(UPDATE_HANDS_SQL);
				int HsBm5 = 0;
				while (HsBm5 < hands.length) {
					prep.setInt(1, hands[HsBm5].getWins());
					prep.setInt(2, hands[HsBm5].getLoses());
					prep.setInt(3, hands[HsBm5].getDraws());
					prep.setString(4, id);
					prep.setString(5, hands[HsBm5].getHand());
					if (prep.executeUpdate() != 1) {
						throw new SQLException(
								"updated too many records in calculatehands, " + id + "-" + hands[HsBm5].getHand());
					}
					HsBm5++;
				}
				connection.commit();
			}
		} catch (SQLException sqle) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.setNextException(sqle);
				throw new CalculateDAOException(e);
			}
			throw new CalculateDAOException(sqle);
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					throw new CalculateDAOException(e);
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					throw new CalculateDAOException(e);
				}
			}
			if (prep != null) {
				try {
					prep.close();
				} catch (SQLException e) {
					throw new CalculateDAOException(e);
				}
			}
		}
		return retval;
	}

}