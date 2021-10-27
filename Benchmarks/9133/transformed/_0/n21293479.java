class n21293479 {
	public void removeGames(List<Game> L9RhG3sn) throws SQLException {
		Connection I970bU9F = ConnectionManager.getManager().getConnection();
		PreparedStatement y97JmJoD = null;
		I970bU9F.setAutoCommit(false);
		try {
			for (Game NYZFpt44 : L9RhG3sn) {
				y97JmJoD = I970bU9F.prepareStatement(Statements.DELETE_GAME);
				y97JmJoD.setInt(1, NYZFpt44.getGameID());
				y97JmJoD.executeUpdate();
			}
		} catch (SQLException Hjl63q3n) {
			I970bU9F.rollback();
			throw Hjl63q3n;
		} finally {
			if (y97JmJoD != null)
				y97JmJoD.close();
		}
		I970bU9F.commit();
		I970bU9F.setAutoCommit(true);
	}

}