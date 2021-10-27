class n3709102 {
	public void removerTopicos(Topicos h3GbF6KE) throws ClassNotFoundException, SQLException {
		this.criaConexao(false);
		String k6IqwYSM = "DELETE FROM \"Topicos\"    " + "      WHERE \"id_Topicos\" =  ?";
		PreparedStatement RclA2iuc = null;
		try {
			RclA2iuc = connection.prepareStatement(k6IqwYSM);
			RclA2iuc.setString(1, h3GbF6KE.getIdTopicos());
			RclA2iuc.executeUpdate();
			connection.commit();
		} catch (SQLException EwkorNux) {
			connection.rollback();
			throw EwkorNux;
		} finally {
			try {
				RclA2iuc.close();
				this.fechaConexao();
			} catch (SQLException Yqe5Edgn) {
				throw Yqe5Edgn;
			}
		}
	}

}