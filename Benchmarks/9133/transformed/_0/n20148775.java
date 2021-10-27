class n20148775 {
	public static boolean update(Orgao SvzXpuor) {
		int TFr9JTdy = 0;
		Connection qD03kXTd = DBConnection.getConnection();
		PreparedStatement B8lfLC3N = null;
		if (qD03kXTd == null) {
			return false;
		}
		try {
			qD03kXTd.setAutoCommit(false);
			String Qtio7pVS = "update orgao set nome = (?) where id_orgao= ?";
			B8lfLC3N = qD03kXTd.prepareStatement(Qtio7pVS);
			B8lfLC3N.setString(1, SvzXpuor.getNome());
			B8lfLC3N.setInt(2, SvzXpuor.getCodigo());
			TFr9JTdy = B8lfLC3N.executeUpdate();
			qD03kXTd.commit();
		} catch (SQLException pecwha6Q) {
			try {
				qD03kXTd.rollback();
			} catch (SQLException FcqXL5Is) {
				FcqXL5Is.printStackTrace();
			}
			System.out.println("[OrgaoDAO.update] Erro ao atualizar -> " + pecwha6Q.getMessage());
		} finally {
			DBConnection.closePreparedStatement(B8lfLC3N);
			DBConnection.closeConnection(qD03kXTd);
		}
		if (TFr9JTdy > 0) {
			return true;
		} else {
			return false;
		}
	}

}