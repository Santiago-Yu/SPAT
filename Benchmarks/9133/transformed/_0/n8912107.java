class n8912107 {
	private static void salvarObra(Artista hn4XDeoC, Obra WBOEgEAi) throws Exception {
		Connection DOzZziIN = null;
		PreparedStatement c4bhuh8S = null;
		int JIuiRGwz;
		System.out.println("Migracao.salvarObra() obra: " + WBOEgEAi.toString2());
		if (WBOEgEAi.getCategoria() != null) {
			JIuiRGwz = getCategoria(WBOEgEAi.getCategoria().getNome()).getCodigo();
		} else {
			JIuiRGwz = getCategoria("Sem Categoria").getCodigo();
		}
		try {
			DOzZziIN = C3P0Pool.getConnection();
			String mfncCTdj = "insert into obra VALUES (?,?,?,?,?,?)";
			c4bhuh8S = DOzZziIN.prepareStatement(mfncCTdj);
			c4bhuh8S.setNull(1, Types.INTEGER);
			c4bhuh8S.setString(2, WBOEgEAi.getTitulo());
			c4bhuh8S.setInt(3, WBOEgEAi.getSelec());
			c4bhuh8S.setInt(4, JIuiRGwz);
			c4bhuh8S.setInt(5, hn4XDeoC.getNumeroInscricao());
			c4bhuh8S.setInt(6, WBOEgEAi.getCodigo());
			c4bhuh8S.executeUpdate();
			DOzZziIN.commit();
		} catch (Exception fRqfENxF) {
			if (DOzZziIN != null)
				DOzZziIN.rollback();
			throw fRqfENxF;
		} finally {
			close(DOzZziIN, c4bhuh8S);
		}
	}

}