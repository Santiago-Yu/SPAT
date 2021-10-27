class n6644756 {
	public void alterar(Cliente bIjSdatC) throws Exception {
		Connection cUuVnMHu = criaConexao(false);
		String I97nfTE3 = "update cliente set nome = ?, sexo = ?, cod_cidade = ? where cod_cliente = ?";
		PreparedStatement zduFAkgL = null;
		try {
			zduFAkgL = cUuVnMHu.prepareStatement(I97nfTE3);
			zduFAkgL.setString(1, bIjSdatC.getNome());
			zduFAkgL.setString(2, bIjSdatC.getSexo());
			zduFAkgL.setInt(3, bIjSdatC.getCidade().getCodCidade());
			zduFAkgL.setLong(4, bIjSdatC.getId());
			int CBHb8dN8 = zduFAkgL.executeUpdate();
			if (CBHb8dN8 == 0) {
				cUuVnMHu.rollback();
				throw new SQLException("Ocorreu um erro inesperado no momento de alterar dados de cliente no banco!");
			}
			cUuVnMHu.commit();
		} catch (SQLException LXdHSTFy) {
			cUuVnMHu.rollback();
			throw LXdHSTFy;
		} finally {
			try {
				zduFAkgL.close();
				this.fechaConexao();
			} catch (SQLException VBlNWMCE) {
				throw VBlNWMCE;
			}
		}
	}

}