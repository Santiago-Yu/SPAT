class n23525240 {
	private void gravaOp(Vector<?> Qjt3YSXU) {
		PreparedStatement a17bmFoC = null;
		String f0LUO3mQ = null;
		ResultSet h0FJcuGR = null;
		int mpZsZPmC = 0;
		Date UqU67bUd = null;
		try {
			f0LUO3mQ = "SELECT MAX(SEQOP) FROM PPOP WHERE CODEMP=? AND CODFILIAL=? AND CODOP=?";
			a17bmFoC = con.prepareStatement(f0LUO3mQ);
			a17bmFoC.setInt(1, Aplicativo.iCodEmp);
			a17bmFoC.setInt(2, ListaCampos.getMasterFilial("PPOP"));
			a17bmFoC.setInt(3, txtCodOP.getVlrInteger().intValue());
			h0FJcuGR = a17bmFoC.executeQuery();
			if (h0FJcuGR.next()) {
				mpZsZPmC = h0FJcuGR.getInt(1) + 1;
			}
			h0FJcuGR.close();
			a17bmFoC.close();
			con.commit();
			f0LUO3mQ = "SELECT DTFABROP FROM PPOP WHERE CODEMP=? AND CODFILIAL=? AND CODOP=? AND SEQOP=?";
			a17bmFoC = con.prepareStatement(f0LUO3mQ);
			a17bmFoC.setInt(1, Aplicativo.iCodEmp);
			a17bmFoC.setInt(2, ListaCampos.getMasterFilial("PPOP"));
			a17bmFoC.setInt(3, txtCodOP.getVlrInteger().intValue());
			a17bmFoC.setInt(4, txtSeqOP.getVlrInteger().intValue());
			h0FJcuGR = a17bmFoC.executeQuery();
			if (h0FJcuGR.next()) {
				UqU67bUd = h0FJcuGR.getDate(1);
			}
			h0FJcuGR.close();
			a17bmFoC.close();
			con.commit();
			f0LUO3mQ = "INSERT INTO PPOP (CODEMP,CODFILIAL,CODOP,SEQOP,CODEMPPD,CODFILIALPD,CODPROD,SEQEST,DTFABROP,"
					+ "QTDPREVPRODOP,QTDFINALPRODOP,DTVALIDPDOP,CODEMPLE,CODFILIALLE,CODLOTE,CODEMPTM,CODFILIALTM,CODTIPOMOV,"
					+ "CODEMPAX,CODFILIALAX,CODALMOX,CODEMPOPM,CODFILIALOPM,CODOPM,SEQOPM,QTDDISTIOP,QTDSUGPRODOP)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			a17bmFoC = con.prepareStatement(f0LUO3mQ);
			a17bmFoC.setInt(1, Aplicativo.iCodEmp);
			a17bmFoC.setInt(2, ListaCampos.getMasterFilial("PPOP"));
			a17bmFoC.setInt(3, txtCodOP.getVlrInteger().intValue());
			a17bmFoC.setInt(4, mpZsZPmC);
			a17bmFoC.setInt(5, Aplicativo.iCodEmp);
			a17bmFoC.setInt(6, ListaCampos.getMasterFilial("PPESTRUTURA"));
			a17bmFoC.setInt(7, ((Integer) Qjt3YSXU.elementAt(4)).intValue());
			a17bmFoC.setInt(8, ((Integer) Qjt3YSXU.elementAt(6)).intValue());
			a17bmFoC.setDate(9, UqU67bUd);
			a17bmFoC.setFloat(10, ((BigDecimal) Qjt3YSXU.elementAt(7)).floatValue());
			a17bmFoC.setFloat(11, 0);
			a17bmFoC.setDate(12, (Funcoes.strDateToSqlDate((String) Qjt3YSXU.elementAt(11))));
			a17bmFoC.setInt(13, Aplicativo.iCodEmp);
			a17bmFoC.setInt(14, ListaCampos.getMasterFilial("EQLOTE"));
			a17bmFoC.setString(15, ((String) Qjt3YSXU.elementAt(10)));
			a17bmFoC.setInt(16, Aplicativo.iCodEmp);
			a17bmFoC.setInt(17, ListaCampos.getMasterFilial("EQTIPOMOV"));
			a17bmFoC.setInt(18, buscaTipoMov());
			a17bmFoC.setInt(19, ((Integer) Qjt3YSXU.elementAt(13)).intValue());
			a17bmFoC.setInt(20, ((Integer) Qjt3YSXU.elementAt(14)).intValue());
			a17bmFoC.setInt(21, ((Integer) Qjt3YSXU.elementAt(12)).intValue());
			a17bmFoC.setInt(22, Aplicativo.iCodEmp);
			a17bmFoC.setInt(23, ListaCampos.getMasterFilial("PPOP"));
			a17bmFoC.setInt(24, txtCodOP.getVlrInteger().intValue());
			a17bmFoC.setInt(25, txtSeqOP.getVlrInteger().intValue());
			a17bmFoC.setFloat(26, ((BigDecimal) Qjt3YSXU.elementAt(9)).floatValue());
			a17bmFoC.setFloat(27, ((BigDecimal) Qjt3YSXU.elementAt(7)).floatValue());
			a17bmFoC.executeUpdate();
			a17bmFoC.close();
			con.commit();
			geraRMA(mpZsZPmC);
		} catch (SQLException Z2MgkDzz) {
			Funcoes.mensagemErro(null, "Erro ao gerar OP's de distribui??o!\n" + Z2MgkDzz.getMessage());
			try {
				con.rollback();
			} catch (SQLException TVXFMFzb) {
			}
		}
	}

}