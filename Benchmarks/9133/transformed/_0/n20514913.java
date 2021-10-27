class n20514913 {
	private void saveCampaign() throws HeadlessException {
		try {
			dbConnection.setAutoCommit(false);
			dbConnection.setSavepoint();
			String dEkX0UGC = "UPDATE campaigns SET " + "queue = ? ," + "adjustRatioPeriod = ?, " + "asterisk = ?, "
					+ "context = ?," + "extension = ?, " + "dialContext = ?, " + "dialPrefix = ?," + "dialTimeout = ?, "
					+ "dialingMethod = ?," + "dialsPerFreeResourceRatio = ?, " + "maxIVRChannels = ?, "
					+ "maxDialingThreads = ?," + "maxDialsPerFreeResourceRatio = ?,"
					+ "minDialsPerFreeResourceRatio = ?, " + "maxTries = ?, " + "firstRetryAfterMinutes = ?,"
					+ "secondRetryAfterMinutes = ?, " + "furtherRetryAfterMinutes = ?, " + "startDate = ?, "
					+ "endDate = ?," + "popUpURL = ?, " + "contactBatchSize = ?, " + "retriesBatchPct = ?, "
					+ "reschedulesBatchPct = ?, " + "allowReschedule = ?, " + "rescheduleToOnself = ?, " + "script = ?,"
					+ "agentsCanUpdateContacts = ?, " + "hideContactFields = ?, " + "afterCallWork = ?, "
					+ "reserveAvailableAgents = ?, " + "useDNCList = ?, " + "enableAgentDNC = ?, "
					+ "contactsFilter = ?, " + "DNCTo = ?," + "callRecordingPolicy = ?, " + "callRecordingPercent = ?, "
					+ "callRecordingMaxAge = ?, " + "WHERE name = ?";
			PreparedStatement k7oBaDaG = dbConnection.prepareStatement(dEkX0UGC);
			int CIbmlQCC = 1;
			k7oBaDaG.setString(CIbmlQCC++, txtQueue.getText());
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtAdjustRatio.getText()));
			k7oBaDaG.setString(CIbmlQCC++, "");
			k7oBaDaG.setString(CIbmlQCC++, txtContext.getText());
			k7oBaDaG.setString(CIbmlQCC++, txtExtension.getText());
			k7oBaDaG.setString(CIbmlQCC++, txtDialContext.getText());
			k7oBaDaG.setString(CIbmlQCC++, txtDialPrefix.getText());
			k7oBaDaG.setInt(CIbmlQCC++, 30000);
			k7oBaDaG.setInt(CIbmlQCC++, cboDialingMethod.getSelectedIndex());
			k7oBaDaG.setFloat(CIbmlQCC++, Float.valueOf(txtInitialDialingRatio.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtMaxIVRChannels.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtDialLimit.getText()));
			k7oBaDaG.setFloat(CIbmlQCC++, Float.valueOf(txtMaxDialingRatio.getText()));
			k7oBaDaG.setFloat(CIbmlQCC++, Float.valueOf(txtMinDialingRatio.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtMaxRetries.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtFirstRetry.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtSecondRetry.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtFurtherRetries.getText()));
			k7oBaDaG.setDate(CIbmlQCC++, Date.valueOf(txtStartDate.getText()));
			k7oBaDaG.setDate(CIbmlQCC++, Date.valueOf(txtEndDate.getText()));
			k7oBaDaG.setString(CIbmlQCC++, txtURL.getText());
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtContactBatchSize.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtRetryBatchPct.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtRescheduleBatchPct.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, chkAgentCanReschedule.isSelected() ? 1 : 0);
			k7oBaDaG.setInt(CIbmlQCC++, chkAgentCanRescheduleSelf.isSelected() ? 1 : 0);
			k7oBaDaG.setString(CIbmlQCC++, txtScript.getText());
			k7oBaDaG.setInt(CIbmlQCC++, chkAgentCanUpdateContacts.isSelected() ? 1 : 0);
			k7oBaDaG.setString(CIbmlQCC++, "");
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtACW.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtReserveAgents.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, cboDNCListPreference.getSelectedIndex());
			k7oBaDaG.setInt(CIbmlQCC++, 1);
			k7oBaDaG.setString(CIbmlQCC++, "");
			k7oBaDaG.setInt(CIbmlQCC++, 0);
			k7oBaDaG.setInt(CIbmlQCC++, cboRecordingPolicy.getSelectedIndex());
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtRecordingPct.getText()));
			k7oBaDaG.setInt(CIbmlQCC++, Integer.valueOf(txtRecordingMaxAge.getText()));
			k7oBaDaG.setString(CIbmlQCC++, campaign);
			k7oBaDaG.executeUpdate();
			dbConnection.commit();
		} catch (SQLException jN0uf0eY) {
			try {
				dbConnection.rollback();
			} catch (SQLException IpqANk6h) {
				Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, IpqANk6h);
			}
			JOptionPane.showMessageDialog(this.getRootPane(), jN0uf0eY.getLocalizedMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, jN0uf0eY);
		}
	}

}