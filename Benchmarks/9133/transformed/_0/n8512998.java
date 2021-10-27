class n8512998 {
	public boolean updateCalculatedHand(CalculateTransferObject JwkFNIqw, BasicStartingHandTransferObject[] V0sc6yaw)
			throws CalculateDAOException {
		boolean Sh73ut5l = false;
		Connection oc2vmxrj = null;
		Statement INNKD3Ui = null;
		PreparedStatement Tu9ynEzq = null;
		ResultSet MoJjezk7 = null;
		StringBuffer ks3cIhdj = new StringBuffer(SELECT_ID_SQL);
		ks3cIhdj.append(appendQuery(JwkFNIqw));
		try {
			oc2vmxrj = getDataSource().getConnection();
			oc2vmxrj.setAutoCommit(false);
			INNKD3Ui = oc2vmxrj.createStatement();
			MoJjezk7 = INNKD3Ui.executeQuery(ks3cIhdj.toString());
			if (MoJjezk7.first()) {
				String C9C5V99z = MoJjezk7.getString("id");
				Tu9ynEzq = oc2vmxrj.prepareStatement(UPDATE_HANDS_SQL);
				for (int QsJtKfqp = 0; QsJtKfqp < V0sc6yaw.length; QsJtKfqp++) {
					Tu9ynEzq.setInt(1, V0sc6yaw[QsJtKfqp].getWins());
					Tu9ynEzq.setInt(2, V0sc6yaw[QsJtKfqp].getLoses());
					Tu9ynEzq.setInt(3, V0sc6yaw[QsJtKfqp].getDraws());
					Tu9ynEzq.setString(4, C9C5V99z);
					Tu9ynEzq.setString(5, V0sc6yaw[QsJtKfqp].getHand());
					if (Tu9ynEzq.executeUpdate() != 1) {
						throw new SQLException("updated too many records in calculatehands, " + C9C5V99z + "-"
								+ V0sc6yaw[QsJtKfqp].getHand());
					}
				}
				oc2vmxrj.commit();
			}
		} catch (SQLException sWwyjInt) {
			try {
				oc2vmxrj.rollback();
			} catch (SQLException HVYVkZtA) {
				HVYVkZtA.setNextException(sWwyjInt);
				throw new CalculateDAOException(HVYVkZtA);
			}
			throw new CalculateDAOException(sWwyjInt);
		} finally {
			if (MoJjezk7 != null) {
				try {
					MoJjezk7.close();
				} catch (SQLException d3T8riDp) {
					throw new CalculateDAOException(d3T8riDp);
				}
			}
			if (INNKD3Ui != null) {
				try {
					INNKD3Ui.close();
				} catch (SQLException rPulLqCe) {
					throw new CalculateDAOException(rPulLqCe);
				}
			}
			if (Tu9ynEzq != null) {
				try {
					Tu9ynEzq.close();
				} catch (SQLException EBWwNAtN) {
					throw new CalculateDAOException(EBWwNAtN);
				}
			}
		}
		return Sh73ut5l;
	}

}