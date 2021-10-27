class n4961130 {
	@Override
	public void delCategoria(Integer SoSde9WW) throws Exception {
		Connection DVYmCqlx = null;
		PreparedStatement uZIE4dzd = null;
		try {
			DVYmCqlx = C3P0Pool.getConnection();
			String YQykSe3K = "delete from categoria where id_categoria = ?";
			uZIE4dzd = DVYmCqlx.prepareStatement(YQykSe3K);
			uZIE4dzd.setInt(1, SoSde9WW);
			uZIE4dzd.executeUpdate();
			DVYmCqlx.commit();
		} catch (Exception BSDxtTOE) {
			if (DVYmCqlx != null)
				DVYmCqlx.rollback();
			throw BSDxtTOE;
		} finally {
			close(DVYmCqlx, uZIE4dzd);
		}
	}

}