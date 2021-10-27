class n20696811 {
	private static boolean insereTutorial(final Connection gLCTf1c1, final Tutorial GZJ26CCO, final Autor Qq009EM0,
			final Descricao IuxJFwlt) {
		try {
			gLCTf1c1.setAutoCommit(false);
			Statement u9FlgrMh = gLCTf1c1.createStatement();
			if (Qq009EM0.getCodAutor() == 0) {
				GeraID.gerarCodAutor(gLCTf1c1, Qq009EM0);
				u9FlgrMh.executeUpdate("INSERT INTO autor VALUES(" + Qq009EM0.getCodAutor() + ",'" + Qq009EM0.getNome()
						+ "','" + Qq009EM0.getEmail() + "')");
			}
			GeraID.gerarCodDescricao(gLCTf1c1, IuxJFwlt);
			GeraID.gerarCodTutorial(gLCTf1c1, GZJ26CCO);
			String y5EWJ2HH = GZJ26CCO.getTitulo().replaceAll("['\"]", "");
			String uITPgiEG = GZJ26CCO.getComentario().replaceAll("[']", "\"");
			String fqfud5ke = IuxJFwlt.getTexto().replaceAll("[']", "\"");
			u9FlgrMh.executeUpdate("INSERT INTO descricao VALUES(" + IuxJFwlt.getCodDesc() + ",'" + fqfud5ke + "')");
			u9FlgrMh.executeUpdate("INSERT INTO tutorial VALUES(" + GZJ26CCO.getCodigo() + ",'" + y5EWJ2HH + "','"
					+ uITPgiEG + "'," + IuxJFwlt.getCodDesc() + ")");
			u9FlgrMh.executeUpdate(
					"INSERT INTO tut_aut VALUES(" + GZJ26CCO.getCodigo() + "," + Qq009EM0.getCodAutor() + ")");
			gLCTf1c1.commit();
			return (true);
		} catch (SQLException CaZmsyCy) {
			try {
				JOptionPane.showMessageDialog(null, "Rolling back transaction", "TUTORIAL: Database error",
						JOptionPane.ERROR_MESSAGE);
				System.out.print(CaZmsyCy.getMessage());
				gLCTf1c1.rollback();
			} catch (SQLException m4Qw4hCV) {
				System.err.print(m4Qw4hCV.getSQLState());
			}
			return (false);
		} finally {
			try {
				gLCTf1c1.setAutoCommit(true);
			} catch (SQLException enl4EAjb) {
				System.err.print(enl4EAjb.getSQLState());
			}
		}
	}

}