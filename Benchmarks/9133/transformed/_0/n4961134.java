class n4961134 {
	private void alterarArtista(Artista snjZHXme) throws Exception {
		Connection D22kMMDi = null;
		PreparedStatement DPSMMSRC = null;
		try {
			D22kMMDi = C3P0Pool.getConnection();
			String H788qrrr = "UPDATE artista SET nome = ?,sexo = ?,email = ?,obs = ?,telefone = ? where numeroinscricao = ?";
			DPSMMSRC = D22kMMDi.prepareStatement(H788qrrr);
			DPSMMSRC.setString(1, snjZHXme.getNome());
			DPSMMSRC.setBoolean(2, snjZHXme.isSexo());
			DPSMMSRC.setString(3, snjZHXme.getEmail());
			DPSMMSRC.setString(4, snjZHXme.getObs());
			DPSMMSRC.setString(5, snjZHXme.getTelefone());
			DPSMMSRC.setInt(6, snjZHXme.getNumeroInscricao());
			DPSMMSRC.executeUpdate();
			alterarEndereco(D22kMMDi, DPSMMSRC, snjZHXme);
			delObras(D22kMMDi, DPSMMSRC, snjZHXme.getNumeroInscricao());
			H788qrrr = "insert into obra VALUES (?,?,?,?,?,?)";
			DPSMMSRC = D22kMMDi.prepareStatement(H788qrrr);
			for (Obra S5sjeUs8 : snjZHXme.getListaObras()) {
				salvarObra(D22kMMDi, DPSMMSRC, S5sjeUs8, snjZHXme.getNumeroInscricao());
			}
			D22kMMDi.commit();
		} catch (Exception PWFoHoys) {
			if (D22kMMDi != null)
				D22kMMDi.rollback();
			throw PWFoHoys;
		} finally {
			close(D22kMMDi, DPSMMSRC);
		}
	}

}