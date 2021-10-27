class n6644760 {
	@Override
	public void incluir(Cliente n7MmANoT) throws Exception {
		Connection UCfIzAc5 = criaConexao(false);
		String H613e3PQ = "insert into cliente select nextval('sq_cliente') as cod_cliente, ? as nome,  ? as sexo, ?";
		PreparedStatement x9mZ4hpT = null;
		try {
			x9mZ4hpT = UCfIzAc5.prepareStatement(H613e3PQ);
			x9mZ4hpT.setString(1, n7MmANoT.getNome());
			x9mZ4hpT.setString(2, n7MmANoT.getSexo());
			x9mZ4hpT.setInt(3, n7MmANoT.getCidade().getCodCidade());
			int jfI4xCpH = x9mZ4hpT.executeUpdate();
			if (jfI4xCpH == 0) {
				UCfIzAc5.rollback();
				throw new SQLException("Ocorreu um erro inesperado no momento de inserir dados de cliente no banco!");
			}
			UCfIzAc5.commit();
		} catch (SQLException oiEN9Yxg) {
			UCfIzAc5.rollback();
			throw oiEN9Yxg;
		} finally {
			try {
				x9mZ4hpT.close();
				this.fechaConexao();
			} catch (SQLException xnV0BUjw) {
				throw xnV0BUjw;
			}
		}
	}

}