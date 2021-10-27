class n21293476 {
	public void addGames(List<Game> aqXdesOv) throws StadiumException, SQLException {
		Connection R8KBUrGy = ConnectionManager.getManager().getConnection();
		R8KBUrGy.setAutoCommit(false);
		PreparedStatement Mht8UDCs = null;
		ResultSet M6pCQF9H = null;
		try {
			for (Game YyCsFZ60 : aqXdesOv) {
				Mht8UDCs = R8KBUrGy.prepareStatement(Statements.SELECT_STADIUM);
				Mht8UDCs.setString(1, YyCsFZ60.getStadiumName());
				Mht8UDCs.setString(2, YyCsFZ60.getStadiumCity());
				M6pCQF9H = Mht8UDCs.executeQuery();
				int kLuypda7 = -1;
				while (M6pCQF9H.next()) {
					kLuypda7 = M6pCQF9H.getInt("stadiumID");
				}
				if (kLuypda7 == -1)
					throw new StadiumException("No such stadium");
				Mht8UDCs = R8KBUrGy.prepareStatement(Statements.INSERT_GAME);
				Mht8UDCs.setInt(1, kLuypda7);
				Mht8UDCs.setDate(2, YyCsFZ60.getGameDate());
				Mht8UDCs.setTime(3, YyCsFZ60.getGameTime());
				Mht8UDCs.setString(4, YyCsFZ60.getTeamA());
				Mht8UDCs.setString(5, YyCsFZ60.getTeamB());
				Mht8UDCs.executeUpdate();
				int uZYKt7UL = getMaxId();
				List<SectorPrice> sa8XvAdI = YyCsFZ60.getSectorPrices();
				for (SectorPrice qrtqbFSv : sa8XvAdI) {
					Mht8UDCs = R8KBUrGy.prepareStatement(Statements.INSERT_TICKET_PRICE);
					Mht8UDCs.setInt(1, uZYKt7UL);
					Mht8UDCs.setInt(2, qrtqbFSv.getSectorId());
					Mht8UDCs.setInt(3, qrtqbFSv.getPrice());
					Mht8UDCs.executeUpdate();
				}
			}
		} catch (SQLException kFbYbyhU) {
			R8KBUrGy.rollback();
			throw kFbYbyhU;
		} finally {
			M6pCQF9H.close();
			Mht8UDCs.close();
		}
		R8KBUrGy.commit();
		R8KBUrGy.setAutoCommit(true);
	}

}