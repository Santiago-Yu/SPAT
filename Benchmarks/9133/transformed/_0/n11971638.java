class n11971638 {
	private void btnOkActionPerformed(java.awt.event.ActionEvent wwDKEecb) {
		if (validateData()) {
			LoginUser G2vTaW4v = AdministrationPanelView.getMe();
			Connection pubpXwkq = null;
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				pubpXwkq = DriverManager.getConnection(G2vTaW4v.getSqlReportsURL(), G2vTaW4v.getSqlReportsUser(),
						G2vTaW4v.getSqlReportsPassword());
				pubpXwkq.setAutoCommit(false);
				pubpXwkq.setSavepoint();
				String mtUyT9W4 = "INSERT INTO campaigns (type, name, dateCreated, createdBy) VALUES (?, ?, ?, ?)";
				PreparedStatement eikhimtf = pubpXwkq.prepareStatement(mtUyT9W4);
				eikhimtf.setByte(1,
						(optTypeAgents.isSelected()) ? CampaignStatics.CAMP_TYPE_AGENT : CampaignStatics.CAMP_TYPE_IVR);
				eikhimtf.setString(2, txtCampaignName.getText());
				eikhimtf.setTimestamp(3, new Timestamp(Calendar.getInstance().getTime().getTime()));
				eikhimtf.setLong(4, G2vTaW4v.getId());
				eikhimtf.executeUpdate();
				ResultSet ipXU7x1p = eikhimtf.getGeneratedKeys();
				ipXU7x1p.next();
				long OXlpcnes = ipXU7x1p.getLong(1);
				mtUyT9W4 = "INSERT INTO usercampaigns (userid, campaignid, role) VALUES (?, ?, ?)";
				eikhimtf = pubpXwkq.prepareStatement(mtUyT9W4);
				eikhimtf.setLong(1, G2vTaW4v.getId());
				eikhimtf.setLong(2, OXlpcnes);
				eikhimtf.setString(3, "admin");
				eikhimtf.executeUpdate();
				pubpXwkq.commit();
				pubpXwkq.close();
				CampaignAdmin jSyyMaWU = new CampaignAdmin();
				jSyyMaWU.setCampaign(txtCampaignName.getText());
				jSyyMaWU.setVisible(true);
				dispose();
			} catch (SQLException y5xmLSf1) {
				try {
					pubpXwkq.rollback();
				} catch (SQLException RGoe7sP1) {
					Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, RGoe7sP1);
				}
				JOptionPane.showMessageDialog(this.getRootPane(), y5xmLSf1.getLocalizedMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, y5xmLSf1);
			}
		}
	}

}