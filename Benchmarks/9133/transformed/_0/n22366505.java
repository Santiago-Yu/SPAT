class n22366505 {
	@Override
	public void incluir(Igreja NyFJng4p) throws Exception {
		Connection ECituz39 = criaConexao(false);
		String xd4huXVZ = "insert into igreja ? as idlocal, ? as possui_salao;";
		String AZK4iBCT = "SELECT MAX(idlocal) FROM Local";
		PreparedStatement AjRGwkzb = null;
		PreparedStatement LwQUojAi = null;
		ResultSet w4DHbhvs = null;
		try {
			AjRGwkzb = ECituz39.prepareStatement(xd4huXVZ);
			LwQUojAi = ECituz39.prepareStatement(AZK4iBCT);
			w4DHbhvs = LwQUojAi.executeQuery();
			AjRGwkzb.setInt(1, w4DHbhvs.getInt("max"));
			AjRGwkzb.setBoolean(2, NyFJng4p.getPossuiSalao());
			int S53NczXW = AjRGwkzb.executeUpdate();
			if (S53NczXW == 0) {
				ECituz39.rollback();
				throw new SQLException("Ocorreu um erro inesperado no momento de inserir dados de cliente no banco!");
			}
			ECituz39.commit();
		} catch (SQLException BzVCITCy) {
			ECituz39.rollback();
			throw BzVCITCy;
		} finally {
			try {
				AjRGwkzb.close();
				LwQUojAi.close();
				w4DHbhvs.close();
				this.fechaConexao();
			} catch (SQLException Lsc4zwyi) {
				throw Lsc4zwyi;
			}
		}
	}

}