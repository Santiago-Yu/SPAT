class n1730523 {
	public static boolean insert(final Departamento QakQKU8h) {
		int cTaWcR9i = 0;
		final Connection aQeVEdxU = DBConnection.getConnection();
		PreparedStatement lkqkn6YU = null;
		if (aQeVEdxU == null) {
			return false;
		}
		try {
			aQeVEdxU.setAutoCommit(false);
			final String xqee37cX = "insert into departamento " + "(nome, sala, telefone, id_orgao)"
					+ " values (?, ?, ?, ?)";
			lkqkn6YU = aQeVEdxU.prepareStatement(xqee37cX);
			lkqkn6YU.setString(1, QakQKU8h.getNome());
			lkqkn6YU.setString(2, QakQKU8h.getSala());
			lkqkn6YU.setString(3, QakQKU8h.getTelefone());
			lkqkn6YU.setInt(4, (QakQKU8h.getOrgao()).getCodigo());
			cTaWcR9i = lkqkn6YU.executeUpdate();
			aQeVEdxU.commit();
		} catch (final SQLException GO43ozdX) {
			try {
				aQeVEdxU.rollback();
			} catch (final SQLException GnN88Oiz) {
				GnN88Oiz.printStackTrace();
			}
			System.out.println("[DepartamentoDAO.insert] Erro ao inserir -> " + GO43ozdX.getMessage());
		} finally {
			DBConnection.closePreparedStatement(lkqkn6YU);
			DBConnection.closeConnection(aQeVEdxU);
		}
		if (cTaWcR9i > 0) {
			return true;
		} else {
			return false;
		}
	}

}