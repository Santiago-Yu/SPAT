class n3375722 {
	public void importarSetor(File wvbz7RMX, String kPfzsu5k, Andamento fLgsNUWW)
			throws FileNotFoundException, IOException, SQLException, InvalidFormatException {
		int LIQeocdL = -1;
		Statement RjY240UH = null;
		OraclePreparedStatement P4Qc8pIE = null;
		try {
			Workbook g5Qvi6L0 = WorkbookFactory.create(new FileInputStream(wvbz7RMX));
			Sheet uBjI6Uwl = g5Qvi6L0.getSheetAt(0);
			int kllupGN9 = 7;
			int XhczAfJg = 14;
			int VwFLUnwc = kllupGN9 + XhczAfJg;
			int zvk07zy5 = uBjI6Uwl.getPhysicalNumberOfRows() - VwFLUnwc;
			String CS0yAv56 = "", oRwcBKi3 = "", pts53uTT = "";
			LinhaDaPlanilhaDosSetores C67F44AX;
			int k5RpWgVa = 0;
			RjY240UH = conDestino.createStatement();
			String bmQBAtfC = "TRUNCATE TABLE TMP_TB_SETOR_SUBSETOR_SEGMENTO";
			RjY240UH.executeUpdate(bmQBAtfC);
			bmQBAtfC = "INSERT INTO TMP_TB_SETOR_SUBSETOR_SEGMENTO(SIGLA_EMPRESA, NOME_SETOR, NOME_SUBSETOR, NOME_SEGMENTO) VALUES(:SIGLA_EMPRESA, :NOME_SETOR, :NOME_SUBSETOR, :NOME_SEGMENTO)";
			P4Qc8pIE = (OraclePreparedStatement) conDestino.prepareStatement(bmQBAtfC);
			P4Qc8pIE.setExecuteBatch(COMANDOS_POR_LOTE);
			int CFg6Zk4Y = 0;
			LIQeocdL = 8;
			while (true) {
				C67F44AX = new LinhaDaPlanilhaDosSetores(uBjI6Uwl.getRow(LIQeocdL));
				if (C67F44AX.nomeDoSetor.length() > 0 && !C67F44AX.nomeDoSetor.equalsIgnoreCase(kPfzsu5k)) {
					if (C67F44AX.nomeDoSubsetor.equalsIgnoreCase("")) {
						break;
					} else {
						CS0yAv56 = C67F44AX.nomeDoSetor;
						oRwcBKi3 = null;
						pts53uTT = null;
					}
				}
				if (C67F44AX.nomeDoSubsetor.length() > 0 && !C67F44AX.nomeDoSetor.equalsIgnoreCase(kPfzsu5k)) {
					oRwcBKi3 = C67F44AX.nomeDoSubsetor;
					pts53uTT = null;
				}
				String g0puxwq1 = C67F44AX.nomeDoSegmentoOuDaEmpresa;
				if (g0puxwq1.length() > 0 && !C67F44AX.nomeDoSetor.equalsIgnoreCase(kPfzsu5k)
						&& C67F44AX.siglaDaEmpresa.equals("")) {
					if (pts53uTT != null && k5RpWgVa == 0) {
						pts53uTT = pts53uTT + " " + g0puxwq1;
					} else {
						pts53uTT = g0puxwq1;
					}
					k5RpWgVa = 0;
				}
				String aevrDlHb = C67F44AX.nomeDoSegmentoOuDaEmpresa;
				if (C67F44AX.siglaDaEmpresa.length() == 4 && !C67F44AX.nomeDoSetor.equalsIgnoreCase(kPfzsu5k)
						&& !aevrDlHb.equals("")) {
					String pmq23NEb = C67F44AX.siglaDaEmpresa;
					P4Qc8pIE.clearParameters();
					P4Qc8pIE.setStringAtName("SIGLA_EMPRESA", pmq23NEb);
					P4Qc8pIE.setStringAtName("NOME_SETOR", CS0yAv56);
					P4Qc8pIE.setStringAtName("NOME_SUBSETOR", oRwcBKi3);
					P4Qc8pIE.setStringAtName("NOME_SEGMENTO", pts53uTT);
					int FRQGao7s = P4Qc8pIE.executeUpdate();
					CFg6Zk4Y++;
					k5RpWgVa++;
				}
				LIQeocdL++;
				double tLj2ff3T = (double) CFg6Zk4Y / zvk07zy5 * 100;
				fLgsNUWW.setPercentualCompleto((int) tLj2ff3T);
			}
			conDestino.commit();
		} catch (Exception MdugYKlP) {
			conDestino.rollback();
			ProblemaNaImportacaoDeArquivo nsbWSkK9 = new ProblemaNaImportacaoDeArquivo();
			nsbWSkK9.nomeDoArquivo = wvbz7RMX.getName();
			nsbWSkK9.linhaProblematicaDoArquivo = LIQeocdL;
			nsbWSkK9.detalhesSobreOProblema = MdugYKlP;
			throw nsbWSkK9;
		} finally {
			fLgsNUWW.setPercentualCompleto(100);
			if (RjY240UH != null && (!RjY240UH.isClosed())) {
				RjY240UH.close();
			}
			if (P4Qc8pIE != null && (!P4Qc8pIE.isClosed())) {
				P4Qc8pIE.close();
			}
		}
	}

}