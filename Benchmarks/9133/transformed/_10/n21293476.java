class n21293476 {
	public void addGames(List<Game> games) throws StadiumException, SQLException {
		Connection conn = ConnectionManager.getManager().getConnection();
		conn.setAutoCommit(false);
		ResultSet rs = null;
		PreparedStatement stm = null;
		try {
			for (Game game : games) {
				stm = conn.prepareStatement(Statements.SELECT_STADIUM);
				stm.setString(1, game.getStadiumName());
				stm.setString(2, game.getStadiumCity());
				int stadiumId = -1;
				rs = stm.executeQuery();
				while (rs.next()) {
					stadiumId = rs.getInt("stadiumID");
				}
				stm = conn.prepareStatement(Statements.INSERT_GAME);
				if (stadiumId == -1)
					throw new StadiumException("No such stadium");
				stm.setInt(1, stadiumId);
				stm.setDate(2, game.getGameDate());
				stm.setTime(3, game.getGameTime());
				stm.setString(4, game.getTeamA());
				stm.setString(5, game.getTeamB());
				stm.executeUpdate();
				int gameId = getMaxId();
				List<SectorPrice> sectorPrices = game.getSectorPrices();
				for (SectorPrice price : sectorPrices) {
					stm = conn.prepareStatement(Statements.INSERT_TICKET_PRICE);
					stm.setInt(1, gameId);
					stm.setInt(2, price.getSectorId());
					stm.setInt(3, price.getPrice());
					stm.executeUpdate();
				}
			}
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			rs.close();
			stm.close();
		}
		conn.commit();
		conn.setAutoCommit(true);
	}

}