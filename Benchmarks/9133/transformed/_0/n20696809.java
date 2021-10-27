class n20696809 {
	public static boolean insereLicao(final Connection XcAFx05U, Licao ZpcZH2ck, Autor yAuZICEi, Descricao oj2hFGbS) {
		try {
			XcAFx05U.setAutoCommit(false);
			Statement a38Og8kq = XcAFx05U.createStatement();
			if (yAuZICEi.getCodAutor() == 0) {
				GeraID.gerarCodAutor(XcAFx05U, yAuZICEi);
				a38Og8kq.executeUpdate("INSERT INTO autor VALUES(" + yAuZICEi.getCodAutor() + ",'" + yAuZICEi.getNome()
						+ "','" + yAuZICEi.getEmail() + "')");
			}
			GeraID.gerarCodDescricao(XcAFx05U, oj2hFGbS);
			GeraID.gerarCodLicao(XcAFx05U, ZpcZH2ck);
			String KqAT6umZ = ZpcZH2ck.getTitulo().replaceAll("['\"]", "");
			String epJ4BnbZ = ZpcZH2ck.getComentario().replaceAll("[']", "\"");
			String ztXqcPdH = oj2hFGbS.getTexto().replaceAll("[']", "\"");
			a38Og8kq.executeUpdate("INSERT INTO descricao VALUES(" + oj2hFGbS.getCodDesc() + ",'" + ztXqcPdH + "')");
			a38Og8kq.executeUpdate("INSERT INTO licao VALUES(" + ZpcZH2ck.getCodigo() + ",'" + KqAT6umZ + "','"
					+ epJ4BnbZ + "'," + oj2hFGbS.getCodDesc() + ")");
			a38Og8kq.executeUpdate(
					"INSERT INTO lic_aut VALUES(" + ZpcZH2ck.getCodigo() + "," + yAuZICEi.getCodAutor() + ")");
			XcAFx05U.commit();
			return (true);
		} catch (SQLException Y3k82tF4) {
			try {
				JOptionPane.showMessageDialog(null, "Rolling back transaction", "LICAO: Database error",
						JOptionPane.ERROR_MESSAGE);
				XcAFx05U.rollback();
			} catch (SQLException IroTGQqI) {
				System.err.print(IroTGQqI.getSQLState());
			}
			return (false);
		} finally {
			try {
				XcAFx05U.setAutoCommit(true);
			} catch (SQLException WpvzPuA7) {
				System.err.print(WpvzPuA7.getSQLState());
			}
		}
	}

}