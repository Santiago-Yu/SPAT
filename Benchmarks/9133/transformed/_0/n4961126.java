class n4961126 {
	private void salvarCategoria(Categoria jH2Cnj5y) throws Exception {
		Connection PNEDpfcb = null;
		PreparedStatement X1UyrnTc = null;
		try {
			PNEDpfcb = C3P0Pool.getConnection();
			String BbTXHfNV = "insert into categoria VALUES (?,?)";
			X1UyrnTc = PNEDpfcb.prepareStatement(BbTXHfNV);
			X1UyrnTc.setNull(1, Types.INTEGER);
			X1UyrnTc.setString(2, jH2Cnj5y.getNome());
			X1UyrnTc.executeUpdate();
			PNEDpfcb.commit();
		} catch (Exception dAmcOBAt) {
			if (PNEDpfcb != null)
				PNEDpfcb.rollback();
			throw dAmcOBAt;
		} finally {
			close(PNEDpfcb, X1UyrnTc);
		}
	}

}