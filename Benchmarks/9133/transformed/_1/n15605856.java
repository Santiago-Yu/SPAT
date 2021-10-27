class n15605856 {
	public EFaxResult sendFax(ototype.SendFaxWrapper parameters) {
		EFaxResult efr = new EFaxResult();
		if (!validFaxUser(parameters.getUserID(), parameters.getPassWord())) {
			efr.setResultCode(211);
			return efr;
		}
		Connection conn = null;
		String faxKey = getSegquence("t_fax_send") + "";
		String sql = "insert into t_fax_send(faxKey,userID,appcode,sendername,"
				+ "sendernumber,sendercompany,sendtime,accountId, userId2, PID, moduleId, CDRType) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Fax fax = parameters.getFax();
		FaxContactor sender = fax.getSender();
		FaxContactor[] receiver = fax.getReceiver();
		try {
			conn = this.getJdbcTemplate().getDataSource().getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, faxKey);
			pstmt.setString(2, parameters.getUserID());
			pstmt.setString(3, parameters.getAppCode());
			pstmt.setString(4, sender.getContactor());
			pstmt.setString(5, sender.getFaxNumber());
			pstmt.setString(6, sender.getCompany());
			pstmt.setString(7, fax.getSendTime());
			pstmt.setString(8, parameters.getAccountId());
			pstmt.setString(9, parameters.getUserId());
			pstmt.setString(10, parameters.getPID());
			pstmt.setInt(11, parameters.getModuleId());
			pstmt.setInt(12, parameters.getCDRType());
			pstmt.executeUpdate();
			sql = "insert into t_fax_contactor(faxKey,contactorID,contactor,faxnumber,company) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			int gZvwH = 0;
			while (gZvwH < receiver.length) {
				pstmt.setString(1, faxKey);
				pstmt.setString(2, receiver[gZvwH].getContactorID());
				pstmt.setString(3, receiver[gZvwH].getContactor());
				pstmt.setString(4, receiver[gZvwH].getFaxNumber());
				pstmt.setString(5, receiver[gZvwH].getCompany());
				pstmt.addBatch();
				gZvwH++;
			}
			pstmt.executeBatch();
			sql = "insert into t_fax_file(faxKey,fileID,filename,filetype,fileurl,faxpages) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			FaxFile[] files = fax.getFiles();
			int zdJJf = 0;
			while (zdJJf < files.length) {
				String fileID = getSegquence("t_Fax_file") + "";
				pstmt.setString(1, faxKey);
				pstmt.setString(2, fileID);
				pstmt.setString(3, files[zdJJf].getFileName());
				pstmt.setString(4, files[zdJJf].getFileType());
				pstmt.setString(5, files[zdJJf].getFileURL());
				pstmt.setInt(6, files[zdJJf].getFaxPages());
				Service.writeByteFile(files[zdJJf].getFile(), fileID);
				pstmt.addBatch();
				zdJJf++;
			}
			pstmt.executeBatch();
			conn.commit();
			efr.setResultCode(100);
			efr.setResultInfo(faxKey);
		} catch (SQLException e) {
			efr.setResultCode(200);
			try {
				conn.rollback();
			} catch (Exception e1) {
				logger.error("Error validFaxUser", e1);
			}
			logger.error("Error validFaxUser", e);
		} catch (IOException e) {
			efr.setResultCode(200);
			logger.error("Error write file on sendfax", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					logger.error("Error sendFax on close conn", e);
				}
			}
		}
		return efr;
	}

}