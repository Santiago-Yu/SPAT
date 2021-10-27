class n22275470 {
	public static boolean insert(final Funcionario kQcALLcz) {
		int MAbbSqHs = 0;
		final Connection YOwrBPOa = DBConnection.getConnection();
		PreparedStatement oOcKpvmQ = null;
		if (YOwrBPOa == null) {
			return false;
		}
		try {
			YOwrBPOa.setAutoCommit(false);
			final String AKhxvi27 = "insert into funcionario " + "(nome, cpf, telefone, email, senha, login, id_cargo)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			oOcKpvmQ = YOwrBPOa.prepareStatement(AKhxvi27);
			oOcKpvmQ.setString(1, kQcALLcz.getNome());
			oOcKpvmQ.setString(2, kQcALLcz.getCpf());
			oOcKpvmQ.setString(3, kQcALLcz.getTelefone());
			oOcKpvmQ.setString(4, kQcALLcz.getEmail());
			oOcKpvmQ.setString(5, kQcALLcz.getSenha());
			oOcKpvmQ.setString(6, kQcALLcz.getLogin());
			oOcKpvmQ.setLong(7, (kQcALLcz.getCargo()).getCodigo());
			MAbbSqHs = oOcKpvmQ.executeUpdate();
			YOwrBPOa.commit();
		} catch (final SQLException VQ2loShx) {
			try {
				YOwrBPOa.rollback();
			} catch (final SQLException PkZTjmEJ) {
				System.out.println("[FuncionarioDAO.insert] Erro ao inserir -> " + PkZTjmEJ.getMessage());
			}
			System.out.println("[FuncionarioDAO.insert] Erro ao inserir -> " + VQ2loShx.getMessage());
		} finally {
			DBConnection.closePreparedStatement(oOcKpvmQ);
			DBConnection.closeConnection(YOwrBPOa);
		}
		if (MAbbSqHs > 0) {
			return true;
		} else {
			return false;
		}
	}

}