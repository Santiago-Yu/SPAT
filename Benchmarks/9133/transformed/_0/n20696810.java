class n20696810 {
	public static boolean insereMidia(final Connection moVSSz0O, Midia SiGDAeeI, Autor UAwtnUD3, Descricao b8XZCgWP) {
		try {
			moVSSz0O.setAutoCommit(false);
			Statement xYiwKzDx = moVSSz0O.createStatement();
			if (UAwtnUD3.getCodAutor() == 0) {
				GeraID.gerarCodAutor(moVSSz0O, UAwtnUD3);
				xYiwKzDx.executeUpdate("INSERT INTO autor VALUES(" + UAwtnUD3.getCodAutor() + ",'" + UAwtnUD3.getNome()
						+ "','" + UAwtnUD3.getEmail() + "')");
			}
			GeraID.gerarCodMidia(moVSSz0O, SiGDAeeI);
			GeraID.gerarCodDescricao(moVSSz0O, b8XZCgWP);
			String RkO1ERr7 = SiGDAeeI.getTitulo().replaceAll("['\"]", "");
			String zSujCYVB = SiGDAeeI.getComentario().replaceAll("[']", "\"");
			String bWbZN1gy = b8XZCgWP.getTexto().replaceAll("[']", "\"");
			xYiwKzDx.executeUpdate("INSERT INTO descricao VALUES(" + b8XZCgWP.getCodDesc() + ",'" + bWbZN1gy + "')");
			xYiwKzDx.executeUpdate(
					"INSERT INTO midia VALUES(" + SiGDAeeI.getCodigo() + ", '" + RkO1ERr7 + "', '" + zSujCYVB + "','"
							+ SiGDAeeI.getUrl() + "', '" + SiGDAeeI.getTipo() + "', " + b8XZCgWP.getCodDesc() + ")");
			xYiwKzDx.executeUpdate(
					"INSERT INTO mid_aut VALUES(" + SiGDAeeI.getCodigo() + "," + UAwtnUD3.getCodAutor() + ")");
			moVSSz0O.commit();
			return (true);
		} catch (SQLException QQXshMTL) {
			try {
				JOptionPane.showMessageDialog(null, "Rolling back transaction", "MIDIA: Database error",
						JOptionPane.ERROR_MESSAGE);
				System.err.print(QQXshMTL.getMessage());
				moVSSz0O.rollback();
			} catch (SQLException mJeYtC1h) {
				System.err.print(mJeYtC1h.getSQLState());
			}
			return (false);
		} finally {
			try {
				moVSSz0O.setAutoCommit(true);
			} catch (SQLException n7O7IwIW) {
				System.err.print(n7O7IwIW.getMessage());
			}
		}
	}

}