class n4431397 {
	private void processar() {
		boolean L0p0DpyZ = false;
		String IyOP62EO = "DELETE FROM FNSALDOLANCA WHERE CODEMP=? AND CODFILIAL=?";
		try {
			state("Excluindo base atual de saldos...");
			PreparedStatement r8t5baAq = con.prepareStatement(IyOP62EO);
			r8t5baAq.setInt(1, Aplicativo.iCodEmp);
			r8t5baAq.setInt(2, ListaCampos.getMasterFilial("FNSALDOLANCA"));
			r8t5baAq.executeUpdate();
			r8t5baAq.close();
			state("Base excluida...");
			L0p0DpyZ = true;
		} catch (SQLException NdUtaBDm) {
			Funcoes.mensagemErro(this, "Erro ao excluir os saldos!\n" + NdUtaBDm.getMessage(), true, con, NdUtaBDm);
			NdUtaBDm.printStackTrace();
		}
		if (L0p0DpyZ) {
			L0p0DpyZ = false;
			IyOP62EO = "SELECT CODPLAN,DATASUBLANCA,SUM(VLRSUBLANCA) VLRSUBLANCA FROM "
					+ "FNSUBLANCA WHERE CODEMP=? AND CODFILIAL=? GROUP BY CODPLAN,DATASUBLANCA "
					+ "ORDER BY CODPLAN,DATASUBLANCA";
			try {
				state("Iniciando reconstru??o...");
				PreparedStatement TZbeOL2Q = con.prepareStatement(IyOP62EO);
				TZbeOL2Q.setInt(1, Aplicativo.iCodEmp);
				TZbeOL2Q.setInt(2, ListaCampos.getMasterFilial("FNLANCA"));
				ResultSet Nrzsm2oB = TZbeOL2Q.executeQuery();
				String OKRwYwKD = "";
				double FsepuO3O = 0;
				L0p0DpyZ = true;
				int Ca6TbSHC = ListaCampos.getMasterFilial("FNPLANEJAMENTO");
				int bAm6TJQ7 = ListaCampos.getMasterFilial("FNSALDOLANCA");
				while (Nrzsm2oB.next() && L0p0DpyZ) {
					if ("1010100000004".equals(Nrzsm2oB.getString("CodPlan"))) {
						System.out.println("Debug");
					}
					if (OKRwYwKD.equals(Nrzsm2oB.getString("CodPlan"))) {
						FsepuO3O += Nrzsm2oB.getDouble("VLRSUBLANCA");
					} else
						FsepuO3O = Nrzsm2oB.getDouble("VLRSUBLANCA");
					L0p0DpyZ = insereSaldo(bAm6TJQ7, Ca6TbSHC, Nrzsm2oB.getString("CodPlan"),
							Nrzsm2oB.getDate("DataSubLanca"), FsepuO3O);
					OKRwYwKD = Nrzsm2oB.getString("CodPlan");
					if ("1010100000004".equals(OKRwYwKD)) {
						System.out.println("Debug");
					}
				}
				TZbeOL2Q.close();
				state("Aguardando grava??o final...");
			} catch (SQLException TqiALJ42) {
				L0p0DpyZ = false;
				Funcoes.mensagemErro(this, "Erro ao excluir os lan?amentos!\n" + TqiALJ42.getMessage(), true, con,
						TqiALJ42);
				TqiALJ42.printStackTrace();
			}
		}
		try {
			if (L0p0DpyZ) {
				con.commit();
				state("Registros processados com sucesso!");
			} else {
				state("Registros antigos restaurados!");
				con.rollback();
			}
		} catch (SQLException XjNVwv4U) {
			Funcoes.mensagemErro(this, "Erro ao relizar precedimento!\n" + XjNVwv4U.getMessage(), true, con, XjNVwv4U);
			XjNVwv4U.printStackTrace();
		}
		bRunProcesso = false;
		btProcessar.setEnabled(true);
	}

}