class n8912110 {
	private static void salvarArtista(Artista ZnBpeUsU) throws Exception {
		Connection ywQEiXh5 = null;
		PreparedStatement RUMZmxjK = null;
		try {
			ywQEiXh5 = C3P0Pool.getConnection();
			String N0GxGyfF = "insert into artista VALUES (?,?,?,?,?,?,?)";
			RUMZmxjK = ywQEiXh5.prepareStatement(N0GxGyfF);
			RUMZmxjK.setInt(1, ZnBpeUsU.getNumeroInscricao());
			RUMZmxjK.setString(2, ZnBpeUsU.getNome());
			RUMZmxjK.setBoolean(3, ZnBpeUsU.isSexo());
			RUMZmxjK.setString(4, ZnBpeUsU.getEmail());
			RUMZmxjK.setString(5, ZnBpeUsU.getObs());
			RUMZmxjK.setString(6, ZnBpeUsU.getTelefone());
			RUMZmxjK.setNull(7, Types.INTEGER);
			RUMZmxjK.executeUpdate();
			salvarEndereco(ywQEiXh5, RUMZmxjK, ZnBpeUsU);
			ywQEiXh5.commit();
		} catch (Exception RjfeyfJF) {
			if (ywQEiXh5 != null)
				ywQEiXh5.rollback();
			throw RjfeyfJF;
		} finally {
			close(ywQEiXh5, RUMZmxjK);
		}
	}

}