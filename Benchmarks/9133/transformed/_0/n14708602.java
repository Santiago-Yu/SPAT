class n14708602 {
	private void gerarFaturamento() {
		int x4wzsBp6 = Funcoes.mensagemConfirma(null, "Confirma o faturamento?");
		if (x4wzsBp6 == JOptionPane.OK_OPTION) {
			StringBuilder ypN5Fcqt = new StringBuilder();
			ypN5Fcqt.append("INSERT INTO RPFATURAMENTO ");
			ypN5Fcqt.append("(CODEMP, CODFILIAL, CODPED, CODITPED, ");
			ypN5Fcqt.append("QTDFATURADO, VLRFATURADO, QTDPENDENTE, ");
			ypN5Fcqt.append("PERCCOMISFAT, VLRCOMISFAT, DTFATURADO ) ");
			ypN5Fcqt.append("VALUES");
			ypN5Fcqt.append("(?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement ZODN3ncI;
			int vNUjCl0k;
			try {
				for (int SH8W96Z2 = 0; SH8W96Z2 < tab.getNumLinhas(); SH8W96Z2++) {
					vNUjCl0k = 1;
					ZODN3ncI = con.prepareStatement(ypN5Fcqt.toString());
					ZODN3ncI.setInt(vNUjCl0k++, AplicativoRep.iCodEmp);
					ZODN3ncI.setInt(vNUjCl0k++, ListaCampos.getMasterFilial("RPFATURAMENTO"));
					ZODN3ncI.setInt(vNUjCl0k++, txtCodPed.getVlrInteger());
					ZODN3ncI.setInt(vNUjCl0k++, (Integer) tab.getValor(SH8W96Z2, ETabNota.ITEM.ordinal()));
					ZODN3ncI.setBigDecimal(vNUjCl0k++,
							(BigDecimal) tab.getValor(SH8W96Z2, ETabNota.QTDFATURADA.ordinal()));
					ZODN3ncI.setBigDecimal(vNUjCl0k++,
							(BigDecimal) tab.getValor(SH8W96Z2, ETabNota.VLRFATURADO.ordinal()));
					ZODN3ncI.setBigDecimal(vNUjCl0k++,
							(BigDecimal) tab.getValor(SH8W96Z2, ETabNota.QDTPENDENTE.ordinal()));
					ZODN3ncI.setBigDecimal(vNUjCl0k++,
							(BigDecimal) tab.getValor(SH8W96Z2, ETabNota.PERCCOMIS.ordinal()));
					ZODN3ncI.setBigDecimal(vNUjCl0k++,
							(BigDecimal) tab.getValor(SH8W96Z2, ETabNota.VLRCOMIS.ordinal()));
					ZODN3ncI.setDate(vNUjCl0k++, Funcoes.dateToSQLDate(Calendar.getInstance().getTime()));
					ZODN3ncI.executeUpdate();
				}
				gerarFaturamento.setEnabled(false);
				gerarComissao.setEnabled(true);
				Funcoes.mensagemInforma(null, "Faturamento criado para pedido " + txtCodPed.getVlrInteger());
				con.commit();
			} catch (Exception yIvHJZfT) {
				yIvHJZfT.printStackTrace();
				Funcoes.mensagemErro(this, "Erro ao gerar faturamento!\n" + yIvHJZfT.getMessage());
				try {
					con.rollback();
				} catch (SQLException dZ3JODFL) {
					dZ3JODFL.printStackTrace();
				}
			}
		}
	}

}