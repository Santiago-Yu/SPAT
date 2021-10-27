class n5505334 {
	public void candidatarAtividade(Atividade WJOsNJ5R) throws SQLException {
		Connection hwV4Lg33 = null;
		String r8HSSaef = "insert into Atividade_has_recurso_humano "
				+ "(atividade_idatividade, usuario_idusuario, ativo) " + "values " + "(" + WJOsNJ5R.getIdAtividade()
				+ ", " + "" + WJOsNJ5R.getRecursoHumano().getIdUsuario() + ", " + "'false')";
		try {
			hwV4Lg33 = connectionFactory.getConnection(true);
			hwV4Lg33.setAutoCommit(false);
			Statement nXeb1XC9 = hwV4Lg33.createStatement();
			Integer xQRTZA6D = nXeb1XC9.executeUpdate(r8HSSaef);
			hwV4Lg33.commit();
		} catch (SQLException mDec7hE2) {
			hwV4Lg33.rollback();
			throw mDec7hE2;
		} finally {
			hwV4Lg33.close();
		}
	}

}