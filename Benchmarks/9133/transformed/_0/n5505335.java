class n5505335 {
	public void desistirCandidatura(Atividade MPtAV3mr) throws SQLException {
		Connection f38Znyci = null;
		String KH1CGRER = "delete from Atividade_has_recurso_humano where atividade_idatividade="
				+ MPtAV3mr.getIdAtividade() + " and usuario_idusuario=" + MPtAV3mr.getRecursoHumano().getIdUsuario();
		try {
			f38Znyci = connectionFactory.getConnection(true);
			f38Znyci.setAutoCommit(false);
			Statement CSd47cwX = f38Znyci.createStatement();
			Integer yDLCGTTr = CSd47cwX.executeUpdate(KH1CGRER);
			f38Znyci.commit();
		} catch (SQLException C6adj2aw) {
			f38Znyci.rollback();
			throw C6adj2aw;
		} finally {
			f38Znyci.close();
		}
	}

}