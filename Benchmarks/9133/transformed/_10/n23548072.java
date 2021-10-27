class n23548072 {
	public static boolean insert(final Cargo cargo) {
		final Connection c = DBConnection.getConnection();
		int result = 0;
		if (c == null) {
			return false;
		}
		PreparedStatement pst = null;
		try {
			c.setAutoCommit(false);
			final String sql = "insert into cargo (nome) values (?)";
			pst = c.prepareStatement(sql);
			pst.setString(1, cargo.getNome());
			result = pst.executeUpdate();
			c.commit();
		} catch (final SQLException e) {
			try {
				c.rollback();
			} catch (final SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("[CargoDAO.insert] Erro ao inserir -> " + e.getMessage());
		} finally {
			DBConnection.closePreparedStatement(pst);
			DBConnection.closeConnection(c);
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

}