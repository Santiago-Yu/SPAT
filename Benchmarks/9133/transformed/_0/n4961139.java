class n4961139 {
	@Override
	public void delArtista(Integer cL8cD01c) throws Exception {
		Connection uoEuJnPG = null;
		PreparedStatement i1C6kOnG = null;
		try {
			uoEuJnPG = C3P0Pool.getConnection();
			String B72G6Zeh = "delete from artista where numeroinscricao = ?";
			i1C6kOnG = uoEuJnPG.prepareStatement(B72G6Zeh);
			i1C6kOnG.setInt(1, cL8cD01c);
			i1C6kOnG.executeUpdate();
			delEndereco(uoEuJnPG, i1C6kOnG, cL8cD01c);
			delObras(uoEuJnPG, i1C6kOnG, cL8cD01c);
			uoEuJnPG.commit();
		} catch (Exception e5pjnvFS) {
			if (uoEuJnPG != null)
				uoEuJnPG.rollback();
			throw e5pjnvFS;
		} finally {
			close(uoEuJnPG, i1C6kOnG);
		}
	}

}