class n22967208 {
	public SysSequences getSeqs(String L2lENpC5) throws SQLException {
		SysSequences OnItNNkn = new SysSequences();
		if (L2lENpC5 == null || L2lENpC5.trim().equals(""))
			return null;
		Connection lebymOrD = null;
		try {
			lebymOrD = ConnectUtil.getConnect();
			lebymOrD.setAutoCommit(false);
			PreparedStatement sypET8JD = lebymOrD.prepareStatement(
					"update ss_sys_sequences set next_value=next_value+step_value where table_name='" + L2lENpC5 + "'");
			sypET8JD.executeUpdate();
			sypET8JD.close();
			sypET8JD = lebymOrD.prepareStatement("select * from ss_sys_sequences where table_name='" + L2lENpC5 + "'");
			ResultSet dsGx9hPC = sypET8JD.executeQuery();
			while (dsGx9hPC.next()) {
				long v8pSdneh = dsGx9hPC.getLong(2);
				long J14dqBao = dsGx9hPC.getLong(3);
				OnItNNkn.setTableName(L2lENpC5);
				OnItNNkn.setNextValue(v8pSdneh - J14dqBao + 1);
				OnItNNkn.setStepValue(J14dqBao);
			}
			dsGx9hPC.close();
			sypET8JD.close();
			if (OnItNNkn.getTableName() == null) {
				sypET8JD = lebymOrD.prepareStatement("insert into ss_sys_sequences values('" + L2lENpC5 + "',"
						+ (Constants.DEFAULT_CURR_VALUE + Constants.DEFAULT_STEP_VALUE) + ","
						+ Constants.DEFAULT_STEP_VALUE + ")");
				sypET8JD.executeUpdate();
				sypET8JD.close();
				OnItNNkn.setTableName(L2lENpC5);
				OnItNNkn.setNextValue(Constants.DEFAULT_CURR_VALUE + 1);
				OnItNNkn.setStepValue(Constants.DEFAULT_STEP_VALUE);
			}
			lebymOrD.commit();
		} catch (Exception p0tvxrwn) {
			lebymOrD.rollback();
			p0tvxrwn.printStackTrace();
		} finally {
			try {
				lebymOrD.setAutoCommit(true);
			} catch (Exception Bz1cvZaY) {
			}
			ConnectUtil.closeConn(lebymOrD);
		}
		return OnItNNkn;
	}

}