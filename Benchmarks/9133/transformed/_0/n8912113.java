class n8912113 {
	private static void salvarCategoria(Categoria Xw5OrDSQ) throws Exception {
		Connection zXsm8OjZ = null;
		PreparedStatement DP35daFF = null;
		try {
			zXsm8OjZ = C3P0Pool.getConnection();
			String n9njWZzx = "insert into categoria VALUES (?,?)";
			DP35daFF = zXsm8OjZ.prepareStatement(n9njWZzx);
			DP35daFF.setNull(1, Types.INTEGER);
			DP35daFF.setString(2, Xw5OrDSQ.getNome());
			DP35daFF.executeUpdate();
			zXsm8OjZ.commit();
		} catch (Exception E9RxMdEM) {
			if (zXsm8OjZ != null)
				zXsm8OjZ.rollback();
			throw E9RxMdEM;
		} finally {
			close(zXsm8OjZ, DP35daFF);
		}
	}

}