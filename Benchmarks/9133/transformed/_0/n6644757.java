class n6644757 {
	public void excluir(Cliente uEj8HJkJ) throws Exception {
		Connection oKPdtmL8 = criaConexao(false);
		String VLvWl9Dg = "delete from cliente where cod_cliente = ?";
		PreparedStatement akLGIS0S = null;
		try {
			akLGIS0S = oKPdtmL8.prepareStatement(VLvWl9Dg);
			akLGIS0S.setLong(1, uEj8HJkJ.getId());
			int KONyzB0o = akLGIS0S.executeUpdate();
			if (KONyzB0o == 0) {
				oKPdtmL8.rollback();
				throw new SQLException("Ocorreu um erro inesperado no momento de remover dados de cliente no banco!");
			}
			oKPdtmL8.commit();
		} catch (SQLException btDTa5Ww) {
			oKPdtmL8.rollback();
			throw btDTa5Ww;
		} finally {
			try {
				akLGIS0S.close();
				this.fechaConexao();
			} catch (SQLException FGpxGcYn) {
				throw FGpxGcYn;
			}
		}
	}

}