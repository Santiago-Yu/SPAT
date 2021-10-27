class n20696808 {
	public static boolean insereCapitulo(final Connection pUW70GwR, Capitulo NgoPR5cy, Autor OmHpyxPP,
			Descricao rRqmdrQq) {
		try {
			pUW70GwR.setAutoCommit(false);
			Statement rGyuHCCv = pUW70GwR.createStatement();
			if (OmHpyxPP.getCodAutor() == 0) {
				GeraID.gerarCodAutor(pUW70GwR, OmHpyxPP);
				rGyuHCCv.executeUpdate("INSERT INTO autor VALUES(" + OmHpyxPP.getCodAutor() + ",'" + OmHpyxPP.getNome()
						+ "','" + OmHpyxPP.getEmail() + "')");
			}
			GeraID.gerarCodDescricao(pUW70GwR, rRqmdrQq);
			GeraID.gerarCodCapitulo(pUW70GwR, NgoPR5cy);
			String dqpZOs8X = rRqmdrQq.getTexto().replaceAll("[']", "\"");
			String CmxggeAP = NgoPR5cy.getTitulo().replaceAll("['\"]", "");
			String Ps6ZOUUu = NgoPR5cy.getComentario().replaceAll("[']", "\"");
			rGyuHCCv.executeUpdate("INSERT INTO descricao VALUES(" + rRqmdrQq.getCodDesc() + ",'" + dqpZOs8X + "')");
			rGyuHCCv.executeUpdate("INSERT INTO capitulo VALUES(" + NgoPR5cy.getCodigo() + ",'" + CmxggeAP + "','"
					+ Ps6ZOUUu + "'," + rRqmdrQq.getCodDesc() + ")");
			rGyuHCCv.executeUpdate(
					"INSERT INTO cap_aut VALUES(" + NgoPR5cy.getCodigo() + "," + OmHpyxPP.getCodAutor() + ")");
			pUW70GwR.commit();
			return (true);
		} catch (SQLException AjIaOUyb) {
			try {
				JOptionPane.showMessageDialog(null, "Rolling back transaction", "CAPITULO: Database error",
						JOptionPane.ERROR_MESSAGE);
				pUW70GwR.rollback();
			} catch (SQLException WMrk9flY) {
				System.err.print(WMrk9flY.getSQLState());
			}
			return (false);
		} finally {
			try {
				pUW70GwR.setAutoCommit(true);
			} catch (SQLException zhOlf9W8) {
				System.err.print(zhOlf9W8.getSQLState());
			}
		}
	}

}