class n13456795 {
	private boolean processar(int xU9KncqG) {
		String xKwhZWTP = null;
		String MfmWKgSP = null;
		String cnH3pgrR = null;
		String rnDqLJo9 = null;
		String DvPuLUtd = null;
		String XGtTid7N = null;
		String T50aJ5Av = null;
		String scMwWnka = null;
		String x3g43ZvK = null;
		String AkJl3eV0 = null;
		String aQrxjuoN = null;
		String hM2wuZe1 = null;
		String t8JxIIEd = null;
		String sxcVqPL3 = null;
		String Rjmd5dry = null;
		PreparedStatement PemptvP8 = null;
		ResultSet tNN2ZY10 = null;
		boolean RHjNpMKD = false;
		try {
			try {
				scMwWnka = "";
				x3g43ZvK = "";
				if (cbTudo.getVlrString().equals("S"))
					x3g43ZvK = "[" + xU9KncqG + "] ";
				if (!(txtDataini.getVlrString().equals(""))) {
					scMwWnka = " AND DTMOVPROD >= '" + Funcoes.dateToStrDB(txtDataini.getVlrDate()) + "'";
				}
				xKwhZWTP = "DELETE FROM EQMOVPROD WHERE " + "CODEMP=? AND CODPROD=?" + scMwWnka;
				state(x3g43ZvK + "Limpando movimenta??es desatualizadas...");
				PemptvP8 = con.prepareStatement(xKwhZWTP);
				PemptvP8.setInt(1, Aplicativo.iCodEmp);
				PemptvP8.setInt(2, xU9KncqG);
				PemptvP8.executeUpdate();
				PemptvP8.close();
				if ((txtDataini.getVlrString().equals(""))) {
					xKwhZWTP = "UPDATE EQPRODUTO SET SLDPROD=0 WHERE " + "CODEMP=? AND CODPROD=?";
					PemptvP8 = con.prepareStatement(xKwhZWTP);
					PemptvP8.setInt(1, Aplicativo.iCodEmp);
					PemptvP8.setInt(2, xU9KncqG);
					PemptvP8.executeUpdate();
					PemptvP8.close();
					state(x3g43ZvK + "Limpando saldos...");
					xKwhZWTP = "UPDATE EQSALDOPROD SET SLDPROD=0 WHERE CODEMP=? AND CODPROD=?";
					PemptvP8 = con.prepareStatement(xKwhZWTP);
					PemptvP8.setInt(1, Aplicativo.iCodEmp);
					PemptvP8.setInt(2, xU9KncqG);
					PemptvP8.executeUpdate();
					PemptvP8.close();
					state(x3g43ZvK + "Limpando saldos...");
				}
				RHjNpMKD = true;
			} catch (SQLException CutB2VNs) {
				Funcoes.mensagemErro(null, "Erro ao limpar estoques!\n" + CutB2VNs.getMessage(), true, con, CutB2VNs);
			}
			if (RHjNpMKD) {
				RHjNpMKD = false;
				if (!txtDataini.getVlrString().equals("")) {
					AkJl3eV0 = " AND C.DTENTCOMPRA >= '" + Funcoes.dateToStrDB(txtDataini.getVlrDate()) + "'";
					aQrxjuoN = " AND I.DATAINVP >= '" + Funcoes.dateToStrDB(txtDataini.getVlrDate()) + "'";
					hM2wuZe1 = " AND V.DTEMITVENDA >= '" + Funcoes.dateToStrDB(txtDataini.getVlrDate()) + "'";
					t8JxIIEd = " AND RMA.DTAEXPRMA >= '" + Funcoes.dateToStrDB(txtDataini.getVlrDate()) + "'";
					sxcVqPL3 = " AND O.DTFABROP >= '" + Funcoes.dateToStrDB(txtDataini.getVlrDate()) + "'";
					Rjmd5dry = " AND O.DTSUBPROD >= '" + Funcoes.dateToStrDB(txtDataini.getVlrDate()) + "'";
				} else {
					AkJl3eV0 = "";
					aQrxjuoN = "";
					hM2wuZe1 = "";
					t8JxIIEd = "";
					sxcVqPL3 = "";
					Rjmd5dry = "";
				}
				cnH3pgrR = "SELECT 'A' TIPOPROC, I.CODEMPPD, I.CODFILIALPD, I.CODPROD,"
						+ "I.CODEMPLE, I.CODFILIALLE, I.CODLOTE," + "I.CODEMPTM, I.CODFILIALTM, I.CODTIPOMOV,"
						+ "I.CODEMP, I.CODFILIAL, CAST(NULL AS CHAR(1)) TIPOVENDA, "
						+ "I.CODINVPROD CODMASTER, I.CODINVPROD CODITEM, "
						+ "CAST(NULL AS INTEGER) CODEMPNT, CAST(NULL AS SMALLINT) CODFILIALNT ,CAST(NULL AS CHAR(4)) CODNAT,"
						+ "I.DATAINVP DTPROC, I.CODINVPROD DOCPROC,'N' FLAG,"
						+ "I.QTDINVP QTDPROC, I.PRECOINVP CUSTOPROC, "
						+ "I.CODEMPAX, I.CODFILIALAX, I.CODALMOX, CAST(NULL AS SMALLINT) as seqent, CAST(NULL AS SMALLINT) as seqsubprod  "
						+ "FROM EQINVPROD I " + "WHERE I.CODEMP=? AND I.CODPROD = ?" + aQrxjuoN;
				MfmWKgSP = "SELECT 'C' TIPOPROC, IC.CODEMPPD, IC.CODFILIALPD, IC.CODPROD,"
						+ "IC.CODEMPLE, IC.CODFILIALLE, IC.CODLOTE," + "C.CODEMPTM, C.CODFILIALTM, C.CODTIPOMOV,"
						+ "C.CODEMP, C.CODFILIAL, CAST(NULL AS CHAR(1)) TIPOVENDA, "
						+ "C.CODCOMPRA CODMASTER, IC.CODITCOMPRA CODITEM," + "IC.CODEMPNT, IC.CODFILIALNT, IC.CODNAT, "
						+ "C.DTENTCOMPRA DTPROC, C.DOCCOMPRA DOCPROC, C.FLAG,"
						+ "IC.QTDITCOMPRA QTDPROC, IC.CUSTOITCOMPRA CUSTOPROC, "
						+ "IC.CODEMPAX, IC.CODFILIALAX, IC.CODALMOX, CAST(NULL AS SMALLINT) as seqent, CAST(NULL AS SMALLINT) as seqsubprod "
						+ "FROM CPCOMPRA C,CPITCOMPRA IC " + "WHERE IC.CODCOMPRA=C.CODCOMPRA AND "
						+ "IC.CODEMP=C.CODEMP AND IC.CODFILIAL=C.CODFILIAL AND IC.QTDITCOMPRA > 0 AND "
						+ "C.CODEMP=? AND IC.CODPROD = ?" + AkJl3eV0;
				XGtTid7N = "SELECT 'O' TIPOPROC, O.CODEMPPD, O.CODFILIALPD, O.CODPROD,"
						+ "O.CODEMPLE, O.CODFILIALLE, O.CODLOTE," + "O.CODEMPTM, O.CODFILIALTM, O.CODTIPOMOV,"
						+ "O.CODEMP, O.CODFILIAL, CAST(NULL AS CHAR(1)) TIPOVENDA ,"
						+ "O.CODOP CODMASTER, CAST(O.SEQOP AS INTEGER) CODITEM,"
						+ "CAST(NULL AS INTEGER) CODEMPNT, CAST(NULL AS SMALLINT) CODFILIALNT, "
						+ "CAST(NULL AS CHAR(4)) CODNAT, " + "coalesce(oe.dtent,O.DTFABROP) DTPROC, "
						+ "O.CODOP DOCPROC, 'N' FLAG, " + "coalesce(oe.qtdent,O.QTDFINALPRODOP) QTDPROC, "
						+ "( SELECT SUM(PD.CUSTOMPMPROD) FROM PPITOP IT, EQPRODUTO PD "
						+ "WHERE IT.CODEMP=O.CODEMP AND IT.CODFILIAL=O.CODFILIAL AND "
						+ "IT.CODOP=O.CODOP AND IT.SEQOP=O.SEQOP AND "
						+ "PD.CODEMP=IT.CODEMPPD AND PD.CODFILIAL=IT.CODFILIALPD AND "
						+ "PD.CODPROD=IT.CODPROD) CUSTOPROC, "
						+ "O.CODEMPAX, O.CODFILIALAX, O.CODALMOX, oe.seqent, CAST(NULL AS SMALLINT) as seqsubprod "
						+ "FROM PPOP O "
						+ " left outer join ppopentrada oe on oe.codemp=o.codemp and oe.codfilial=o.codfilial and oe.codop=o.codop and oe.seqop=o.seqop "
						+ "WHERE O.QTDFINALPRODOP > 0 AND " + "O.CODEMP=? AND O.CODPROD = ? " + sxcVqPL3;
				T50aJ5Av = "SELECT 'S' TIPOPROC, O.CODEMPPD, O.CODFILIALPD, O.CODPROD,"
						+ "O.CODEMPLE, O.CODFILIALLE, O.CODLOTE," + "O.CODEMPTM, O.CODFILIALTM, O.CODTIPOMOV,"
						+ "O.CODEMP, O.CODFILIAL, CAST(NULL AS CHAR(1)) TIPOVENDA ,"
						+ "O.CODOP CODMASTER, CAST(O.SEQOP AS INTEGER) CODITEM,"
						+ "CAST(NULL AS INTEGER) CODEMPNT, CAST(NULL AS SMALLINT) CODFILIALNT, "
						+ "CAST(NULL AS CHAR(4)) CODNAT, " + "coalesce(o.dtsubprod,Op.DTFABROP) DTPROC, "
						+ "O.CODOP DOCPROC, 'N' FLAG, " + "O.QTDITSP QTDPROC, "
						+ "( SELECT PD.CUSTOMPMPROD FROM EQPRODUTO PD "
						+ "WHERE PD.CODEMP=O.CODEMPPD AND PD.CODFILIAL=O.CODFILIALPD AND "
						+ "PD.CODPROD=O.CODPROD) CUSTOPROC, "
						+ "OP.CODEMPAX, OP.CODFILIALAX, OP.CODALMOX, CAST(NULL AS SMALLINT) as seqent, O.SEQSUBPROD "
						+ "FROM PPOPSUBPROD O, PPOP OP " + "WHERE O.QTDITSP > 0 AND "
						+ "O.CODEMP=OP.CODEMP and O.CODFILIAL=OP.CODFILIAL and O.CODOP=OP.CODOP and O.SEQOP=OP.SEQOP AND "
						+ "O.CODEMP=? AND O.CODPROD = ?" + Rjmd5dry;
				DvPuLUtd = "SELECT 'R' TIPOPROC, IT.CODEMPPD, IT.CODFILIALPD, IT.CODPROD, "
						+ "IT.CODEMPLE, IT.CODFILIALLE, IT.CODLOTE, "
						+ "RMA.CODEMPTM, RMA.CODFILIALTM, RMA.CODTIPOMOV, "
						+ "RMA.CODEMP, RMA.CODFILIAL, CAST(NULL AS CHAR(1)) TIPOVENDA, "
						+ "IT.CODRMA CODMASTER, CAST(IT.CODITRMA AS INTEGER) CODITEM, "
						+ "CAST(NULL AS INTEGER) CODEMPNT, CAST(NULL AS SMALLINT) CODFILIALNT, "
						+ "CAST(NULL AS CHAR(4)) CODNAT, " + "COALESCE(IT.DTAEXPITRMA,RMA.DTAREQRMA) DTPROC, "
						+ "RMA.CODRMA DOCPROC, 'N' FLAG, " + "IT.QTDEXPITRMA QTDPROC, IT.PRECOITRMA CUSTOPROC,"
						+ "IT.CODEMPAX, IT.CODFILIALAX, IT.CODALMOX, CAST(NULL AS SMALLINT) as seqent, CAST(NULL AS SMALLINT) as seqsubprod   "
						+ "FROM EQRMA RMA ,EQITRMA IT " + "WHERE IT.CODRMA=RMA.CODRMA AND "
						+ "IT.CODEMP=RMA.CODEMP AND IT.CODFILIAL=RMA.CODFILIAL AND " + "IT.QTDITRMA > 0 AND "
						+ "RMA.CODEMP=? AND IT.CODPROD = ?" + t8JxIIEd;
				rnDqLJo9 = "SELECT 'V' TIPOPROC, IV.CODEMPPD, IV.CODFILIALPD, IV.CODPROD,"
						+ "IV.CODEMPLE, IV.CODFILIALLE, IV.CODLOTE," + "V.CODEMPTM, V.CODFILIALTM, V.CODTIPOMOV,"
						+ "V.CODEMP, V.CODFILIAL, V.TIPOVENDA, " + "V.CODVENDA CODMASTER, IV.CODITVENDA CODITEM, "
						+ "IV.CODEMPNT, IV.CODFILIALNT, IV.CODNAT, "
						+ "V.DTEMITVENDA DTPROC, V.DOCVENDA DOCPROC, V.FLAG, "
						+ "IV.QTDITVENDA QTDPROC, IV.VLRLIQITVENDA CUSTOPROC, "
						+ "IV.CODEMPAX, IV.CODFILIALAX, IV.CODALMOX, CAST(NULL AS SMALLINT) as seqent, CAST(NULL AS SMALLINT) as seqsubprod   "
						+ "FROM VDVENDA V ,VDITVENDA IV "
						+ "WHERE IV.CODVENDA=V.CODVENDA AND IV.TIPOVENDA = V.TIPOVENDA AND "
						+ "IV.CODEMP=V.CODEMP AND IV.CODFILIAL=V.CODFILIAL AND " + "IV.QTDITVENDA > 0 AND "
						+ "V.CODEMP=? AND IV.CODPROD = ?" + hM2wuZe1;
				try {
					state(x3g43ZvK + "Iniciando reconstru??o...");
					xKwhZWTP = cnH3pgrR + " UNION ALL " + MfmWKgSP + " UNION ALL " + XGtTid7N + " UNION ALL " + T50aJ5Av
							+ " UNION ALL " + DvPuLUtd + " UNION ALL " + rnDqLJo9 + " ORDER BY 19,1,20";
					System.out.println(xKwhZWTP);
					PemptvP8 = con.prepareStatement(xKwhZWTP);
					PemptvP8.setInt(paramCons.CODEMPIV.ordinal(), Aplicativo.iCodEmp);
					PemptvP8.setInt(paramCons.CODPRODIV.ordinal(), xU9KncqG);
					PemptvP8.setInt(paramCons.CODEMPCP.ordinal(), Aplicativo.iCodEmp);
					PemptvP8.setInt(paramCons.CODPRODCP.ordinal(), xU9KncqG);
					PemptvP8.setInt(paramCons.CODEMPOP.ordinal(), Aplicativo.iCodEmp);
					PemptvP8.setInt(paramCons.CODPRODOP.ordinal(), xU9KncqG);
					PemptvP8.setInt(paramCons.CODEMPOPSP.ordinal(), Aplicativo.iCodEmp);
					PemptvP8.setInt(paramCons.CODPRODOPSP.ordinal(), xU9KncqG);
					PemptvP8.setInt(paramCons.CODEMPRM.ordinal(), Aplicativo.iCodEmp);
					PemptvP8.setInt(paramCons.CODPRODRM.ordinal(), xU9KncqG);
					PemptvP8.setInt(paramCons.CODEMPVD.ordinal(), Aplicativo.iCodEmp);
					PemptvP8.setInt(paramCons.CODPRODVD.ordinal(), xU9KncqG);
					tNN2ZY10 = PemptvP8.executeQuery();
					RHjNpMKD = true;
					while (tNN2ZY10.next() && RHjNpMKD) {
						RHjNpMKD = insereMov(tNN2ZY10, x3g43ZvK);
					}
					tNN2ZY10.close();
					PemptvP8.close();
					state(x3g43ZvK + "Aguardando grava??o final...");
				} catch (SQLException Xdw9TTya) {
					RHjNpMKD = false;
					Xdw9TTya.printStackTrace();
					Funcoes.mensagemErro(null, "Erro ao reconstruir base!\n" + Xdw9TTya.getMessage(), true, con,
							Xdw9TTya);
				}
			}
			try {
				if (RHjNpMKD) {
					con.commit();
					state(x3g43ZvK + "Registros processados com sucesso!");
				} else {
					state(x3g43ZvK + "Registros antigos restaurados!");
					con.rollback();
				}
			} catch (SQLException J3SJi0sj) {
				J3SJi0sj.printStackTrace();
				Funcoes.mensagemErro(null, "Erro ao relizar procedimento!\n" + J3SJi0sj.getMessage(), true, con,
						J3SJi0sj);
			}
		} finally {
			xKwhZWTP = null;
			MfmWKgSP = null;
			cnH3pgrR = null;
			rnDqLJo9 = null;
			DvPuLUtd = null;
			scMwWnka = null;
			x3g43ZvK = null;
			AkJl3eV0 = null;
			aQrxjuoN = null;
			hM2wuZe1 = null;
			t8JxIIEd = null;
			tNN2ZY10 = null;
			PemptvP8 = null;
			bRunProcesso = false;
			btProcessar.setEnabled(true);
		}
		return RHjNpMKD;
	}

}