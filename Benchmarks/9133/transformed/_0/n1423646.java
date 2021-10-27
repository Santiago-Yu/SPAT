class n1423646 {
	public void removerDisciplina(Disciplina pwk9qd6d) throws ClassNotFoundException, SQLException {
		this.criaConexao(false);
		String pWYe6lXz = "DELETE FROM \"Disciplina\"    " + "      WHERE ID_Disciplina =  ? )";
		PreparedStatement FmVeIVUC = null;
		try {
			FmVeIVUC = connection.prepareStatement(pWYe6lXz);
			FmVeIVUC.setString(1, pwk9qd6d.getId());
			FmVeIVUC.executeUpdate();
			connection.commit();
		} catch (SQLException JtvCuBBD) {
			connection.rollback();
			throw JtvCuBBD;
		} finally {
			try {
				FmVeIVUC.close();
				this.fechaConexao();
			} catch (SQLException VqFoG2M6) {
				throw VqFoG2M6;
			}
		}
	}

}