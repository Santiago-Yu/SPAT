class n20148775 {
	public static boolean update(Orgao orgao) {
		Connection c = DBConnection.getConnection();
		int result = 0;
		if (c == null) {
			return false;
		}
		PreparedStatement pst = null;
		try {
			c.setAutoCommit(false);
			String sql = "update orgao set nome = (?) where id_orgao= ?";
			pst = c.prepareStatement(sql);
			pst.setString(1, orgao.getNome());
			pst.setInt(2, orgao.getCodigo());
			result = pst.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("[OrgaoDAO.update] Erro ao atualizar -> " + e.getMessage());
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