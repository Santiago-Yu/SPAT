class n4961136 {
	private void salvarArtista(Artista DmmNxb7C) throws Exception {
		System.out.println("GerenteMySQL.salvarArtista()" + DmmNxb7C.toString2());
		Connection aRgqmvc5 = null;
		PreparedStatement YUnnRepZ = null;
		try {
			aRgqmvc5 = C3P0Pool.getConnection();
			String AjpTH9VP = "insert into artista VALUES (?,?,?,?,?,?,?)";
			YUnnRepZ = aRgqmvc5.prepareStatement(AjpTH9VP);
			YUnnRepZ.setInt(1, DmmNxb7C.getNumeroInscricao());
			YUnnRepZ.setString(2, DmmNxb7C.getNome());
			YUnnRepZ.setBoolean(3, DmmNxb7C.isSexo());
			YUnnRepZ.setString(4, DmmNxb7C.getEmail());
			YUnnRepZ.setString(5, DmmNxb7C.getObs());
			YUnnRepZ.setString(6, DmmNxb7C.getTelefone());
			YUnnRepZ.setNull(7, Types.INTEGER);
			YUnnRepZ.executeUpdate();
			salvarEndereco(aRgqmvc5, YUnnRepZ, DmmNxb7C);
			AjpTH9VP = "insert into obra VALUES (?,?,?,?,?,?)";
			YUnnRepZ = aRgqmvc5.prepareStatement(AjpTH9VP);
			for (Obra d93lYuBw : DmmNxb7C.getListaObras()) {
				salvarObra(aRgqmvc5, YUnnRepZ, d93lYuBw, DmmNxb7C.getNumeroInscricao());
			}
			aRgqmvc5.commit();
		} catch (Exception Pney54bZ) {
			if (aRgqmvc5 != null)
				aRgqmvc5.rollback();
			throw Pney54bZ;
		} finally {
			close(aRgqmvc5, YUnnRepZ);
		}
	}

}