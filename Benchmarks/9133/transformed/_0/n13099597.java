class n13099597 {
	public void deleteGroup(String NqXiG22y) throws XregistryException {
		try {
			Connection CEjJMm0w = context.createConnection();
			CEjJMm0w.setAutoCommit(false);
			try {
				PreparedStatement GkeB7EYI = CEjJMm0w.prepareStatement(DELETE_GROUP_SQL_MAIN);
				GkeB7EYI.setString(1, NqXiG22y);
				int MpO0XelK = GkeB7EYI.executeUpdate();
				if (MpO0XelK == 0) {
					throw new XregistryException("Database is not updated, Can not find such Group " + NqXiG22y);
				}
				if (cascadingDeletes) {
					PreparedStatement eeLddJfA = CEjJMm0w.prepareStatement(DELETE_GROUP_SQL_DEPEND);
					eeLddJfA.setString(1, NqXiG22y);
					eeLddJfA.setString(2, NqXiG22y);
					eeLddJfA.executeUpdate();
				}
				CEjJMm0w.commit();
				groups.remove(NqXiG22y);
				log.info("Delete Group " + NqXiG22y + (cascadingDeletes ? " with cascading deletes " : ""));
			} catch (SQLException WpFX8MpL) {
				CEjJMm0w.rollback();
				throw new XregistryException(WpFX8MpL);
			} finally {
				context.closeConnection(CEjJMm0w);
			}
		} catch (SQLException Ep50RR0b) {
			throw new XregistryException(Ep50RR0b);
		}
	}

}