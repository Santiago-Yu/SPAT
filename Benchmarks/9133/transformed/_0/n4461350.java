class n4461350 {
	private boolean doCSVImport(String riPEgGgT, final boolean FIoPfz22) {
		StringBuffer Qai6B0bj = new StringBuffer();
		Qai6B0bj.append("INSERT INTO ");
		Qai6B0bj.append(riPEgGgT + "(");
		for (int TyHLIiZf = 0; TyHLIiZf < colNames.size(); TyHLIiZf++) {
			Qai6B0bj.append("" + colNames.get(TyHLIiZf) + ",");
		}
		Qai6B0bj.setLength(Qai6B0bj.length() - 1);
		Qai6B0bj.append(") VALUES( ");
		for (int mItIpWFC = 0; mItIpWFC < colNames.size(); mItIpWFC++) {
			Qai6B0bj.append("?,");
		}
		Qai6B0bj.setLength(Qai6B0bj.length() - 1);
		Qai6B0bj.append(")");
		Connection LPQpe8Zd = null;
		int ONCHOiT8 = 0;
		int RUpQIp0C = 0;
		String Sy6M16vj[] = null;
		try {
			LPQpe8Zd = DBExplorer.getConnection(false);
			LPQpe8Zd.setAutoCommit(false);
			PreparedStatement AGaAbCRp = LPQpe8Zd.prepareStatement(Qai6B0bj.toString());
			for (; ONCHOiT8 < csvData.size(); ONCHOiT8++) {
				if (FIoPfz22 && ONCHOiT8 == 0)
					continue;
				dlg.UpdateProgressBar(ONCHOiT8);
				if (cancel) {
					break;
				}
				Sy6M16vj = (String[]) csvData.get(ONCHOiT8);
				AGaAbCRp.clearParameters();
				for (RUpQIp0C = 0; RUpQIp0C < colTypes.size(); RUpQIp0C++) {
					if (Sy6M16vj[RUpQIp0C].equals("") && colNullAllowed.get(RUpQIp0C).toString().equals("true")) {
						AGaAbCRp.setNull(RUpQIp0C + 1, Integer.parseInt(colTypeInt.get(RUpQIp0C).toString()));
					} else {
						AGaAbCRp.setObject(RUpQIp0C + 1, Sy6M16vj[RUpQIp0C],
								Integer.parseInt(colTypeInt.get(RUpQIp0C).toString()));
					}
				}
				AGaAbCRp.executeUpdate();
			}
			if (cancel)
				LPQpe8Zd.rollback();
			else
				LPQpe8Zd.commit();
			LPQpe8Zd.setAutoCommit(true);
			LPQpe8Zd.close();
			LPQpe8Zd = null;
			dialog.getDisplay().asyncExec(new Runnable() {

				public void run() {
					if (!cancel) {
						dlg.showMessage(title, "Imported " + maxsize + " rows successfully.");
						statusLabel.setText("Import complete.");
					} else {
						dlg.UpdateProgressBar(0);
						statusLabel.setText("Import aborted.");
					}
				}
			});
			return true;
		} catch (final Exception nUZkdIiZ) {
			if (LPQpe8Zd != null)
				try {
					LPQpe8Zd.rollback();
				} catch (SQLException fL6B1XDr) {
					fL6B1XDr.printStackTrace();
				}
			dialog.getDisplay().asyncExec(new Runnable() {

				public void run() {
					statusLabel.setText("Import failed");
					dlg.showError(title, nUZkdIiZ.getMessage());
					dlg.UpdateProgressBar(0);
				}
			});
			return false;
		} finally {
			if (LPQpe8Zd != null)
				try {
					LPQpe8Zd.close();
				} catch (SQLException OgH7wKsK) {
					OgH7wKsK.printStackTrace();
				}
		}
	}

}