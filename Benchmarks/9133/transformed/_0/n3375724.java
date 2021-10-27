class n3375724 {
	public void importarEmissoresDosTitulosFinanceiros(File m5wBaDfq, Andamento ywEFJyhj)
			throws FileNotFoundException, SQLException {
		int aFopIoJA = -1;
		Scanner rIqTAkkk = null;
		Statement KkQxhUZb = conDestino.createStatement();
		String PVLIn7Tk = "TRUNCATE TABLE TMP_TB_EMISSOR_TITULO";
		KkQxhUZb.executeUpdate(PVLIn7Tk);
		PVLIn7Tk = "INSERT INTO TMP_TB_EMISSOR_TITULO(SIGLA, NOME, CNPJ, DATA_CRIACAO) VALUES(:SIGLA, :NOME, :CNPJ, :DATA_CRIACAO)";
		OraclePreparedStatement ywblgAcA = (OraclePreparedStatement) conDestino.prepareStatement(PVLIn7Tk);
		ywblgAcA.setExecuteBatch(COMANDOS_POR_LOTE);
		final int I5VKJXva = 0;
		final int G4CYwQZR = 0;
		final int JIddEFlF = I5VKJXva + G4CYwQZR;
		final int wPpPvWWg = 81;
		long xqBFWYqO = m5wBaDfq.length();
		int z3MWqkYr = (int) (xqBFWYqO - JIddEFlF) / wPpPvWWg;
		String ty3wgj21;
		String[] hVl4aYwR;
		try {
			rIqTAkkk = new Scanner(new FileInputStream(m5wBaDfq),
					Constantes.CONJUNTO_DE_CARACTERES_DOS_ARQUIVOS_TEXTO_DA_BOVESPA.name());
			int aXOLVdPJ = 0;
			aFopIoJA = 0;
			String Qs6ACA13, SZXJlEFh;
			BigDecimal mS69Te2G;
			java.sql.Date apNHoAYX;
			final int NZsD0jmY = CampoDoArquivoDosEmissoresDeTitulosFinanceiros.values().length;
			final String bobNJjTq = ",";
			final String Bebfu9Po = "\"";
			while (rIqTAkkk.hasNextLine()) {
				++aFopIoJA;
				ty3wgj21 = rIqTAkkk.nextLine();
				ywblgAcA.clearParameters();
				ty3wgj21 = ty3wgj21.substring(1, ty3wgj21.length() - 1);
				if (ty3wgj21.endsWith(Bebfu9Po)) {
					ty3wgj21 = ty3wgj21 + " ";
				}
				hVl4aYwR = ty3wgj21.split(Bebfu9Po + bobNJjTq + Bebfu9Po);
				int jPFNs3pV = hVl4aYwR.length;
				if (jPFNs3pV != NZsD0jmY) {
					throw new CampoMalDelimitadoEmRegistroDoArquivoImportado(ty3wgj21);
				}
				Qs6ACA13 = hVl4aYwR[CampoDoArquivoDosEmissoresDeTitulosFinanceiros.SIGLA.ordinal()];
				SZXJlEFh = hVl4aYwR[CampoDoArquivoDosEmissoresDeTitulosFinanceiros.NOME.ordinal()];
				String k32rMyqI = hVl4aYwR[CampoDoArquivoDosEmissoresDeTitulosFinanceiros.CNPJ.ordinal()];
				if (k32rMyqI != null && k32rMyqI.trim().length() > 0) {
					mS69Te2G = new BigDecimal(k32rMyqI);
				} else {
					mS69Te2G = null;
				}
				String j5i6Httb = hVl4aYwR[CampoDoArquivoDosEmissoresDeTitulosFinanceiros.DATA_CRIACAO.ordinal()];
				if (j5i6Httb != null && j5i6Httb.trim().length() > 0) {
					int GvShob4Y = Integer.parseInt(j5i6Httb.substring(6, 8)),
							xlwaMRdV = Integer.parseInt(j5i6Httb.substring(4, 6)) - 1,
							xhZiacn4 = Integer.parseInt(j5i6Httb.substring(0, 4));
					Calendar Zm0ylYIZ = Calendar.getInstance();
					Zm0ylYIZ.clear();
					Zm0ylYIZ.set(xhZiacn4, xlwaMRdV, GvShob4Y);
					apNHoAYX = new java.sql.Date(Zm0ylYIZ.getTimeInMillis());
				} else {
					apNHoAYX = null;
				}
				ywblgAcA.setStringAtName("SIGLA", Qs6ACA13);
				ywblgAcA.setStringAtName("NOME", SZXJlEFh);
				ywblgAcA.setBigDecimalAtName("CNPJ", mS69Te2G);
				ywblgAcA.setDateAtName("DATA_CRIACAO", apNHoAYX);
				int YxDOzuNM = ywblgAcA.executeUpdate();
				aXOLVdPJ++;
				double POIiQ6Xb = (double) aXOLVdPJ / z3MWqkYr * 100;
				ywEFJyhj.setPercentualCompleto((int) POIiQ6Xb);
			}
			conDestino.commit();
		} catch (Exception ijkV5qXU) {
			conDestino.rollback();
			ProblemaNaImportacaoDeArquivo Np2PJ25s = new ProblemaNaImportacaoDeArquivo();
			Np2PJ25s.nomeDoArquivo = m5wBaDfq.getName();
			Np2PJ25s.linhaProblematicaDoArquivo = aFopIoJA;
			Np2PJ25s.detalhesSobreOProblema = ijkV5qXU;
			throw Np2PJ25s;
		} finally {
			ywEFJyhj.setPercentualCompleto(100);
			rIqTAkkk.close();
			if (KkQxhUZb != null && (!KkQxhUZb.isClosed())) {
				KkQxhUZb.close();
			}
			if (ywblgAcA != null && (!ywblgAcA.isClosed())) {
				ywblgAcA.close();
			}
		}
	}

}