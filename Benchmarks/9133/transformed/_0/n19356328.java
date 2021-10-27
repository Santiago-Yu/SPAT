class n19356328 {
	private void btnOkActionPerformed(java.awt.event.ActionEvent Uam7GwRc) {
		try {
			int aV2zroGx = 0;
			String k59RmwJj = "SELECT MAX(ID) as MAX_ID from CORE_USER_GROUPS";
			PreparedStatement Onma7cEF = Database.getMyConnection().prepareStatement(k59RmwJj);
			ResultSet mEduSLeN = Onma7cEF.executeQuery();
			if (mEduSLeN.next()) {
				aV2zroGx = mEduSLeN.getInt("MAX_ID") + 1;
			} else {
				aV2zroGx = 1;
			}
			Database.close(Onma7cEF);
			k59RmwJj = "INSERT INTO CORE_USER_GROUPS"
					+ " (ID, GRP_NAME, GRP_DESC, DATE_INITIAL, DATE_FINAL, IND_STATUS)" + " VALUES (?, ?, ?, ?, ?, ?)";
			Onma7cEF = Database.getMyConnection().prepareStatement(k59RmwJj);
			Onma7cEF.setInt(1, aV2zroGx);
			Onma7cEF.setString(2, txtGrpName.getText());
			Onma7cEF.setString(3, txtGrpDesc.getText());
			Onma7cEF.setDate(4, Utils.getTodaySql());
			Onma7cEF.setDate(5, Date.valueOf("9999-12-31"));
			Onma7cEF.setString(6, "A");
			Onma7cEF.executeUpdate();
			Database.getMyConnection().commit();
			Database.close(Onma7cEF);
			MessageBox.ok("New group added successfully", this);
			mEduSLeN = getGroups();
			tblGroups.setModel(new GroupsTableModel(mEduSLeN));
			Database.close(mEduSLeN);
		} catch (SQLException FTgWX8wp) {
			log.error("Failed with update operation \n" + FTgWX8wp.getMessage());
			MessageBox.ok("Failed to create the new group in the database", this);
			try {
				Database.getMyConnection().rollback();
			} catch (Exception c75jEu8o) {
			}
			;
		} catch (IllegalArgumentException Jzfemnj9) {
			log.error("Illegal argument for the DATE_FINAL \n" + Jzfemnj9.getMessage());
			MessageBox.ok("Failed to create the new group in the database", this);
			try {
				Database.getMyConnection().rollback();
			} catch (Exception TJFt6lqT) {
			}
			;
		} finally {
			txtGrpName.setEnabled(false);
			txtGrpDesc.setEnabled(false);
			btnOk.setEnabled(false);
			btnCancel.requestFocus();
		}
	}

}