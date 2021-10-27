class n23548072 {
	public static boolean insert(final Cargo I21CybSJ) {
		int qBd84RpT = 0;
		final Connection FurapE8Q = DBConnection.getConnection();
		PreparedStatement dIDkqAlN = null;
		if (FurapE8Q == null) {
			return false;
		}
		try {
			FurapE8Q.setAutoCommit(false);
			final String icOZQF74 = "insert into cargo (nome) values (?)";
			dIDkqAlN = FurapE8Q.prepareStatement(icOZQF74);
			dIDkqAlN.setString(1, I21CybSJ.getNome());
			qBd84RpT = dIDkqAlN.executeUpdate();
			FurapE8Q.commit();
		} catch (final SQLException K7Jredig) {
			try {
				FurapE8Q.rollback();
			} catch (final SQLException mE0dKd9T) {
				mE0dKd9T.printStackTrace();
			}
			System.out.println("[CargoDAO.insert] Erro ao inserir -> " + K7Jredig.getMessage());
		} finally {
			DBConnection.closePreparedStatement(dIDkqAlN);
			DBConnection.closeConnection(FurapE8Q);
		}
		if (qBd84RpT > 0) {
			return true;
		} else {
			return false;
		}
	}

}