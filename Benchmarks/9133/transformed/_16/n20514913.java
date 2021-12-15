class n20514913 {
	private void saveCampaign() throws HeadlessException {
		try {
			dbConnection.setAutoCommit(false);
			dbConnection.setSavepoint();
			String sql = "UPDATE campaigns SET " + "queue = ? ," + "adjustRatioPeriod = ?, " + "asterisk = ?, "
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
			PreparedStatement statement = dbConnection.prepareStatement(sql);
			int i = 1;
			statement.setString(i, txtQueue.getText());
			i++;
			statement.setInt(i, Integer.valueOf(txtAdjustRatio.getText()));
			i++;
			statement.setString(i, "");
			i++;
			statement.setString(i, txtContext.getText());
			i++;
			statement.setString(i, txtExtension.getText());
			i++;
			statement.setString(i, txtDialContext.getText());
			i++;
			statement.setString(i, txtDialPrefix.getText());
			i++;
			statement.setInt(i, 30000);
			i++;
			statement.setInt(i, cboDialingMethod.getSelectedIndex());
			i++;
			statement.setFloat(i, Float.valueOf(txtInitialDialingRatio.getText()));
			i++;
			statement.setInt(i, Integer.valueOf(txtMaxIVRChannels.getText()));
			i++;
			statement.setInt(i, Integer.valueOf(txtDialLimit.getText()));
			i++;
			statement.setFloat(i, Float.valueOf(txtMaxDialingRatio.getText()));
			i++;
			statement.setFloat(i, Float.valueOf(txtMinDialingRatio.getText()));
			i++;
			statement.setInt(i, Integer.valueOf(txtMaxRetries.getText()));
			i++;
			statement.setInt(i, Integer.valueOf(txtFirstRetry.getText()));
			i++;
			statement.setInt(i, Integer.valueOf(txtSecondRetry.getText()));
			i++;
			statement.setInt(i, Integer.valueOf(txtFurtherRetries.getText()));
			i++;
			statement.setDate(i, Date.valueOf(txtStartDate.getText()));
			i++;
			statement.setDate(i, Date.valueOf(txtEndDate.getText()));
			i++;
			statement.setString(i, txtURL.getText());
			i++;
			statement.setInt(i, Integer.valueOf(txtContactBatchSize.getText()));
			i++;
			statement.setInt(i, Integer.valueOf(txtRetryBatchPct.getText()));
			i++;
			statement.setInt(i, Integer.valueOf(txtRescheduleBatchPct.getText()));
			i++;
			statement.setInt(i, chkAgentCanReschedule.isSelected() ? 1 : 0);
			i++;
			statement.setInt(i, chkAgentCanRescheduleSelf.isSelected() ? 1 : 0);
			i++;
			statement.setString(i, txtScript.getText());
			i++;
			statement.setInt(i, chkAgentCanUpdateContacts.isSelected() ? 1 : 0);
			i++;
			statement.setString(i, "");
			i++;
			statement.setInt(i, Integer.valueOf(txtACW.getText()));
			i++;
			statement.setInt(i, Integer.valueOf(txtReserveAgents.getText()));
			i++;
			statement.setInt(i, cboDNCListPreference.getSelectedIndex());
			i++;
			statement.setInt(i, 1);
			i++;
			statement.setString(i, "");
			i++;
			statement.setInt(i, 0);
			i++;
			statement.setInt(i, cboRecordingPolicy.getSelectedIndex());
			i++;
			statement.setInt(i, Integer.valueOf(txtRecordingPct.getText()));
			i++;
			statement.setInt(i, Integer.valueOf(txtRecordingMaxAge.getText()));
			i++;
			statement.setString(i, campaign);
			i++;
			statement.executeUpdate();
			dbConnection.commit();
		} catch (SQLException ex) {
			try {
				dbConnection.rollback();
			} catch (SQLException ex1) {
				Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex1);
			}
			JOptionPane.showMessageDialog(this.getRootPane(), ex.getLocalizedMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
		}
	}

}