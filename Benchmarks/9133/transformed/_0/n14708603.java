class n14708603 {
	private void gerarComissao() {
		int a5lafprh = Funcoes.mensagemConfirma(null,
				"Confirma gerar comiss?es para o vendedor " + txtNomeVend.getVlrString().trim() + "?");
		if (a5lafprh == JOptionPane.OK_OPTION) {
			StringBuilder y0TKQXgx = new StringBuilder();
			y0TKQXgx.append("INSERT INTO RPCOMISSAO ");
			y0TKQXgx.append("(CODEMP, CODFILIAL, CODPED, CODITPED, ");
			y0TKQXgx.append("CODEMPVD, CODFILIALVD, CODVEND, VLRCOMISS ) ");
			y0TKQXgx.append("VALUES ");
			y0TKQXgx.append("(?,?,?,?,?,?,?,?)");
			PreparedStatement OK8lOroK;
			int pgg7pCLp;
			boolean lX6377yg = false;
			try {
				for (int gpXcGwzN = 0; gpXcGwzN < tab.getNumLinhas(); gpXcGwzN++) {
					if (((BigDecimal) tab.getValor(gpXcGwzN, 8)).floatValue() > 0) {
						pgg7pCLp = 1;
						OK8lOroK = con.prepareStatement(y0TKQXgx.toString());
						OK8lOroK.setInt(pgg7pCLp++, AplicativoRep.iCodEmp);
						OK8lOroK.setInt(pgg7pCLp++, ListaCampos.getMasterFilial("RPCOMISSAO"));
						OK8lOroK.setInt(pgg7pCLp++, txtCodPed.getVlrInteger());
						OK8lOroK.setInt(pgg7pCLp++, (Integer) tab.getValor(gpXcGwzN, ETabNota.ITEM.ordinal()));
						OK8lOroK.setInt(pgg7pCLp++, AplicativoRep.iCodEmp);
						OK8lOroK.setInt(pgg7pCLp++, ListaCampos.getMasterFilial("RPVENDEDOR"));
						OK8lOroK.setInt(pgg7pCLp++, txtCodVend.getVlrInteger());
						OK8lOroK.setBigDecimal(pgg7pCLp++,
								(BigDecimal) tab.getValor(gpXcGwzN, ETabNota.VLRCOMIS.ordinal()));
						OK8lOroK.executeUpdate();
						lX6377yg = true;
					}
				}
				if (lX6377yg) {
					Funcoes.mensagemInforma(null, "Comiss?o gerada para " + txtNomeVend.getVlrString().trim());
					txtCodPed.setText("0");
					lcPedido.carregaDados();
					carregaTabela();
					con.commit();
				} else {
					Funcoes.mensagemInforma(null,
							"N?o foi possiv?l gerar comiss?o!\nVerifique os valores das comiss?es dos itens.");
				}
			} catch (Exception myojmPlQ) {
				myojmPlQ.printStackTrace();
				Funcoes.mensagemErro(this, "Erro ao gerar comiss?o!\n" + myojmPlQ.getMessage());
				try {
					con.rollback();
				} catch (SQLException OEUUvmlQ) {
					OEUUvmlQ.printStackTrace();
				}
			}
		}
	}

}