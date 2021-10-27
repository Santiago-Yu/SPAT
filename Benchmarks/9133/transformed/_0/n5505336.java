class n5505336 {
	public void aprovarCandidato(Atividade Msiv6X91) throws SQLException {
		Connection QuKlEFMk = null;
		String fRlka4Yq = "update Atividade_has_recurso_humano set ativo='true' " + "where atividade_idatividade="
				+ Msiv6X91.getIdAtividade() + " and " + " usuario_idusuario="
				+ Msiv6X91.getRecursoHumano().getIdUsuario();
		try {
			QuKlEFMk = connectionFactory.getConnection(true);
			QuKlEFMk.setAutoCommit(false);
			Statement qDY2Sy8e = QuKlEFMk.createStatement();
			Integer MZ06wRWm = qDY2Sy8e.executeUpdate(fRlka4Yq);
			QuKlEFMk.commit();
		} catch (SQLException SbkmUU7J) {
			QuKlEFMk.rollback();
			throw SbkmUU7J;
		} finally {
			QuKlEFMk.close();
		}
	}

}