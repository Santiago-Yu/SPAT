class n11617413 {
	private boolean postCorrecao() {
		boolean La1bQchE = false;
		Integer TQiigiSe = null;
		String z9k4y4HH = "SELECT MAX(SEQAC) FROM PPOPACAOCORRET WHERE CODEMP=? AND CODFILIAL=? AND CODOP=? AND SEQOP=?";
		String obt2I2bi = "SELECT MAX(SEQOPCQ) + 1 FROM PPOPCQ WHERE CODEMP=? AND CODFILIAL=? AND CODOP=? AND SEQOP=?";
		try {
			for (Entry<Integer, JCheckBoxPad> ZrvZh4dW : analises.entrySet()) {
				JCheckBoxPad OGcpU3gU = ZrvZh4dW.getValue();
				if ("S".equals(OGcpU3gU.getVlrString())) {
					La1bQchE = true;
					keysItens[2] = ZrvZh4dW.getKey();
					break;
				}
			}
			if (!La1bQchE) {
				Funcoes.mensagemInforma(this, "Selecione as analises para aplicar a corre??o!");
				return false;
			}
			if (txaCausa.getVlrString().trim().length() == 0) {
				Funcoes.mensagemInforma(this, "Informe as causas!");
				return false;
			}
			if (txaAcao.getVlrString().trim().length() == 0) {
				Funcoes.mensagemInforma(this, "Detalhe a a??o corretiva!");
				return false;
			}
			PreparedStatement Sa881q3X = con.prepareStatement(z9k4y4HH);
			Sa881q3X.setInt(1, Aplicativo.iCodEmp);
			Sa881q3X.setInt(2, ListaCampos.getMasterFilial("PPOPACAOCORRET"));
			Sa881q3X.setInt(3, txtCodOP.getVlrInteger());
			Sa881q3X.setInt(4, txtSeqOP.getVlrInteger());
			ResultSet nBDtf8DU = Sa881q3X.executeQuery();
			if (nBDtf8DU.next()) {
				TQiigiSe = nBDtf8DU.getInt(1) + 1;
				keysItens[3] = TQiigiSe;
			}
			nBDtf8DU.close();
			Sa881q3X.close();
			if (TQiigiSe != null) {
				StringBuilder htZbufpr = new StringBuilder();
				htZbufpr.append("INSERT INTO PPOPACAOCORRET ");
				htZbufpr.append("( CODEMP, CODFILIAL, CODOP, SEQOP, SEQAC, TPCAUSA, OBSCAUSA, TPACAO, OBSACAO ) ");
				htZbufpr.append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )");
				Sa881q3X = con.prepareStatement(htZbufpr.toString());
				Sa881q3X.setInt(1, Aplicativo.iCodEmp);
				Sa881q3X.setInt(2, ListaCampos.getMasterFilial("PPOPACAOCORRET"));
				Sa881q3X.setInt(3, txtCodOP.getVlrInteger());
				Sa881q3X.setInt(4, txtSeqOP.getVlrInteger());
				Sa881q3X.setInt(5, TQiigiSe);
				Sa881q3X.setString(6, m.getCode());
				Sa881q3X.setString(7, txaCausa.getVlrString());
				Sa881q3X.setString(8, rgSolucao.getVlrString());
				Sa881q3X.setString(9, txaAcao.getVlrString());
				Sa881q3X.execute();
				Sa881q3X.close();
				String xq7JHv0c = "";
				for (Entry<Integer, JCheckBoxPad> OdDMF62x : analises.entrySet()) {
					JCheckBoxPad CzH8eyTa = OdDMF62x.getValue();
					if ("S".equals(CzH8eyTa.getVlrString())) {
						if (xq7JHv0c.trim().length() > 0) {
							xq7JHv0c += ",";
						}
						xq7JHv0c += String.valueOf(OdDMF62x.getKey());
					}
				}
				htZbufpr = new StringBuilder();
				htZbufpr.append("UPDATE PPOPCQ SET SEQAC=? ");
				htZbufpr.append(
						"WHERE CODEMP=? AND CODFILIAL=? AND CODOP=? AND SEQOP=? AND SEQOPCQ IN ( " + xq7JHv0c + " )");
				Sa881q3X = con.prepareStatement(htZbufpr.toString());
				Sa881q3X.setInt(1, TQiigiSe);
				Sa881q3X.setInt(2, Aplicativo.iCodEmp);
				Sa881q3X.setInt(3, ListaCampos.getMasterFilial("PPOPACAOCORRET"));
				Sa881q3X.setInt(4, txtCodOP.getVlrInteger());
				Sa881q3X.setInt(5, txtSeqOP.getVlrInteger());
				Sa881q3X.executeUpdate();
				Sa881q3X.close();
				htZbufpr.delete(0, htZbufpr.length());
				htZbufpr.append("INSERT INTO PPOPCQ (CODEMP,CODFILIAL,CODOP,SEQOP,SEQOPCQ,");
				htZbufpr.append("CODEMPEA,CODFILIALEA,CODESTANALISE) ");
				htZbufpr.append("SELECT CODEMP,CODFILIAL,CODOP,SEQOP,(");
				htZbufpr.append(obt2I2bi);
				htZbufpr.append("),CODEMPEA,CODFILIALEA,CODESTANALISE ");
				htZbufpr.append("FROM PPOPCQ ");
				htZbufpr.append("WHERE CODEMP=? AND CODFILIAL=? AND CODOP=? AND ");
				htZbufpr.append("SEQOP=? AND SEQOPCQ IN ( " + xq7JHv0c + " )");
				System.out.println(htZbufpr.toString());
				Sa881q3X = con.prepareStatement(htZbufpr.toString());
				Sa881q3X = con.prepareStatement(htZbufpr.toString());
				Sa881q3X.setInt(1, Aplicativo.iCodEmp);
				Sa881q3X.setInt(2, ListaCampos.getMasterFilial("PPOPCQ"));
				Sa881q3X.setInt(3, txtCodOP.getVlrInteger());
				Sa881q3X.setInt(4, txtSeqOP.getVlrInteger());
				Sa881q3X.setInt(5, Aplicativo.iCodEmp);
				Sa881q3X.setInt(6, ListaCampos.getMasterFilial("PPOPCQ"));
				Sa881q3X.setInt(7, txtCodOP.getVlrInteger());
				Sa881q3X.setInt(8, txtSeqOP.getVlrInteger());
				Sa881q3X.executeUpdate();
				Sa881q3X.close();
				montaAnalises();
				Funcoes.mensagemInforma(this, "A??o corretiva aplicada com sucesso!");
			}
			con.commit();
		} catch (Exception FJb50NeP) {
			try {
				con.rollback();
			} catch (SQLException YVc1S9G8) {
				System.out.println("Erro ao realizar rollback!\n" + FJb50NeP.getMessage());
			}
			FJb50NeP.printStackTrace();
			Funcoes.mensagemErro(this, "Erro ao atualizar analises!\n" + FJb50NeP.getMessage(), true, con, FJb50NeP);
			La1bQchE = false;
		}
		return La1bQchE;
	}

}