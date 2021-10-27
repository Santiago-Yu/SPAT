class n1730524 {
	public static boolean update(Departamento sV7bSIEy) {
		int cJSMYuzh = 0;
		Connection agLyikao = DBConnection.getConnection();
		PreparedStatement qbUfJDqH = null;
		if (agLyikao == null) {
			return false;
		}
		try {
			agLyikao.setAutoCommit(false);
			String i5BLdcm2 = "update departamento set nome = ?, sala = ?, telefone = ?, id_orgao = ? where id_departamento= ?";
			qbUfJDqH = agLyikao.prepareStatement(i5BLdcm2);
			qbUfJDqH.setString(1, sV7bSIEy.getNome());
			qbUfJDqH.setString(2, sV7bSIEy.getSala());
			qbUfJDqH.setString(3, sV7bSIEy.getTelefone());
			qbUfJDqH.setLong(4, (sV7bSIEy.getOrgao()).getCodigo());
			qbUfJDqH.setInt(5, sV7bSIEy.getCodigo());
			cJSMYuzh = qbUfJDqH.executeUpdate();
			agLyikao.commit();
		} catch (SQLException zsVzYJcX) {
			try {
				agLyikao.rollback();
			} catch (SQLException PC4xSmRY) {
				PC4xSmRY.printStackTrace();
			}
			System.out.println("[DepartamentoDAO.update] Erro ao atualizar -> " + zsVzYJcX.getMessage());
		} finally {
			DBConnection.closePreparedStatement(qbUfJDqH);
			DBConnection.closeConnection(agLyikao);
		}
		if (cJSMYuzh > 0) {
			return true;
		} else {
			return false;
		}
	}

}