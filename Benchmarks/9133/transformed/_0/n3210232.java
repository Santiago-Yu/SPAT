class n3210232 {
	private void transferir() {
		PreparedStatement rYwtbd9X = null;
		StringBuilder YURvTiL1 = new StringBuilder();
		boolean N8RIpFz3 = false;
		String X0C4dCS8 = "";
		try {
			for (String YMs7IrRZ : tabelas) {
				X0C4dCS8 = mapaTabelas.get(YMs7IrRZ);
				YURvTiL1.delete(0, YURvTiL1.length());
				YURvTiL1.append("UPDATE ");
				YURvTiL1.append(YMs7IrRZ);
				YURvTiL1.append(" SET");
				YURvTiL1.append(" CODEMP" + X0C4dCS8 + "=?,");
				YURvTiL1.append(" CODFILIAL" + X0C4dCS8 + "=?,");
				YURvTiL1.append(" CODPLAN=?");
				YURvTiL1.append(" WHERE");
				YURvTiL1.append(" CODEMP" + X0C4dCS8 + "=? AND");
				YURvTiL1.append(" CODFILIAL" + X0C4dCS8 + "=? AND");
				YURvTiL1.append(" CODPLAN=?");
				try {
					status.setText("Atulizando tabela " + YMs7IrRZ);
					rYwtbd9X = con.prepareStatement(YURvTiL1.toString());
					rYwtbd9X.setInt(1, Aplicativo.iCodEmp);
					rYwtbd9X.setInt(2, lcPlanDest.getCodFilial());
					rYwtbd9X.setString(3, txtCodPlanDest.getVlrString());
					rYwtbd9X.setInt(4, Aplicativo.iCodEmp);
					rYwtbd9X.setInt(5, lcPlanOrig.getCodFilial());
					rYwtbd9X.setString(6, txtCodPlanOrig.getVlrString());
					rYwtbd9X.executeUpdate();
				} catch (SQLException k31MLlNW) {
					k31MLlNW.printStackTrace();
					N8RIpFz3 = true;
					Funcoes.mensagemErro(this, "Erro ao atualizar planejamento de destino.\n" + k31MLlNW.getMessage(),
							true, con, k31MLlNW);
					status.setText("");
					break;
				}
			}
		} finally {
			try {
				if (N8RIpFz3) {
					con.rollback();
				} else {
					YURvTiL1.delete(0, YURvTiL1.length());
					YURvTiL1.append("DELETE FROM FNSALDOLANCA ");
					YURvTiL1.append("WHERE CODEMPPN=? AND CODFILIALPN=? AND CODPLAN=?");
					rYwtbd9X = con.prepareStatement(YURvTiL1.toString());
					rYwtbd9X.setInt(1, Aplicativo.iCodEmp);
					rYwtbd9X.setInt(2, lcPlanOrig.getCodFilial());
					rYwtbd9X.setString(3, txtCodPlanOrig.getVlrString());
					rYwtbd9X.executeUpdate();
					con.commit();
					btTransferir.setEnabled(false);
					status.setText("Transfer?ncia completada.");
				}
			} catch (SQLException HBVTO8g0) {
				HBVTO8g0.printStackTrace();
			}
		}
	}

}