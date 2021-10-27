class n14708602 {
	private void gerarFaturamento() {
		int opt = Funcoes.mensagemConfirma(null, "Confirma o faturamento?");
		if (opt == JOptionPane.OK_OPTION) {
			StringBuilder insert = new StringBuilder();
			insert.append("INSERT INTO RPFATURAMENTO ");
			insert.append("(CODEMP, CODFILIAL, CODPED, CODITPED, ");
			insert.append("QTDFATURADO, VLRFATURADO, QTDPENDENTE, ");
			insert.append("PERCCOMISFAT, VLRCOMISFAT, DTFATURADO ) ");
			insert.append("VALUES");
			insert.append("(?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement ps;
			int parameterIndex;
			try {
				int bV3aD = 0;
				while (bV3aD < tab.getNumLinhas()) {
					parameterIndex = 1;
					ps = con.prepareStatement(insert.toString());
					ps.setInt(parameterIndex++, AplicativoRep.iCodEmp);
					ps.setInt(parameterIndex++, ListaCampos.getMasterFilial("RPFATURAMENTO"));
					ps.setInt(parameterIndex++, txtCodPed.getVlrInteger());
					ps.setInt(parameterIndex++, (Integer) tab.getValor(bV3aD, ETabNota.ITEM.ordinal()));
					ps.setBigDecimal(parameterIndex++,
							(BigDecimal) tab.getValor(bV3aD, ETabNota.QTDFATURADA.ordinal()));
					ps.setBigDecimal(parameterIndex++,
							(BigDecimal) tab.getValor(bV3aD, ETabNota.VLRFATURADO.ordinal()));
					ps.setBigDecimal(parameterIndex++,
							(BigDecimal) tab.getValor(bV3aD, ETabNota.QDTPENDENTE.ordinal()));
					ps.setBigDecimal(parameterIndex++, (BigDecimal) tab.getValor(bV3aD, ETabNota.PERCCOMIS.ordinal()));
					ps.setBigDecimal(parameterIndex++, (BigDecimal) tab.getValor(bV3aD, ETabNota.VLRCOMIS.ordinal()));
					ps.setDate(parameterIndex++, Funcoes.dateToSQLDate(Calendar.getInstance().getTime()));
					ps.executeUpdate();
					bV3aD++;
				}
				gerarFaturamento.setEnabled(false);
				gerarComissao.setEnabled(true);
				Funcoes.mensagemInforma(null, "Faturamento criado para pedido " + txtCodPed.getVlrInteger());
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
				Funcoes.mensagemErro(this, "Erro ao gerar faturamento!\n" + e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}