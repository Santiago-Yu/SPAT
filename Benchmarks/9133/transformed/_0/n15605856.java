class n15605856 {
	public EFaxResult sendFax(ototype.SendFaxWrapper gUbUoWen) {
		EFaxResult ZByHDzQN = new EFaxResult();
		if (!validFaxUser(gUbUoWen.getUserID(), gUbUoWen.getPassWord())) {
			ZByHDzQN.setResultCode(211);
			return ZByHDzQN;
		}
		Connection PDgXcHuN = null;
		String CuTnOysU = getSegquence("t_fax_send") + "";
		String NiuGZWpr = "insert into t_fax_send(faxKey,userID,appcode,sendername,"
				+ "sendernumber,sendercompany,sendtime,accountId, userId2, PID, moduleId, CDRType) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Fax cQHitUhE = gUbUoWen.getFax();
		FaxContactor bMcfhiuV = cQHitUhE.getSender();
		FaxContactor[] MfUoUZ5p = cQHitUhE.getReceiver();
		try {
			PDgXcHuN = this.getJdbcTemplate().getDataSource().getConnection();
			PDgXcHuN.setAutoCommit(false);
			PreparedStatement aCf7agBr = PDgXcHuN.prepareStatement(NiuGZWpr);
			aCf7agBr.setString(1, CuTnOysU);
			aCf7agBr.setString(2, gUbUoWen.getUserID());
			aCf7agBr.setString(3, gUbUoWen.getAppCode());
			aCf7agBr.setString(4, bMcfhiuV.getContactor());
			aCf7agBr.setString(5, bMcfhiuV.getFaxNumber());
			aCf7agBr.setString(6, bMcfhiuV.getCompany());
			aCf7agBr.setString(7, cQHitUhE.getSendTime());
			aCf7agBr.setString(8, gUbUoWen.getAccountId());
			aCf7agBr.setString(9, gUbUoWen.getUserId());
			aCf7agBr.setString(10, gUbUoWen.getPID());
			aCf7agBr.setInt(11, gUbUoWen.getModuleId());
			aCf7agBr.setInt(12, gUbUoWen.getCDRType());
			aCf7agBr.executeUpdate();
			NiuGZWpr = "insert into t_fax_contactor(faxKey,contactorID,contactor,faxnumber,company) values(?,?,?,?,?)";
			aCf7agBr = PDgXcHuN.prepareStatement(NiuGZWpr);
			for (int ZlFlGfHW = 0; ZlFlGfHW < MfUoUZ5p.length; ZlFlGfHW++) {
				aCf7agBr.setString(1, CuTnOysU);
				aCf7agBr.setString(2, MfUoUZ5p[ZlFlGfHW].getContactorID());
				aCf7agBr.setString(3, MfUoUZ5p[ZlFlGfHW].getContactor());
				aCf7agBr.setString(4, MfUoUZ5p[ZlFlGfHW].getFaxNumber());
				aCf7agBr.setString(5, MfUoUZ5p[ZlFlGfHW].getCompany());
				aCf7agBr.addBatch();
			}
			aCf7agBr.executeBatch();
			NiuGZWpr = "insert into t_fax_file(faxKey,fileID,filename,filetype,fileurl,faxpages) values(?,?,?,?,?,?)";
			aCf7agBr = PDgXcHuN.prepareStatement(NiuGZWpr);
			FaxFile[] VNYQlGuO = cQHitUhE.getFiles();
			for (int q4c9JFb9 = 0; q4c9JFb9 < VNYQlGuO.length; q4c9JFb9++) {
				String hRKBRyM1 = getSegquence("t_Fax_file") + "";
				aCf7agBr.setString(1, CuTnOysU);
				aCf7agBr.setString(2, hRKBRyM1);
				aCf7agBr.setString(3, VNYQlGuO[q4c9JFb9].getFileName());
				aCf7agBr.setString(4, VNYQlGuO[q4c9JFb9].getFileType());
				aCf7agBr.setString(5, VNYQlGuO[q4c9JFb9].getFileURL());
				aCf7agBr.setInt(6, VNYQlGuO[q4c9JFb9].getFaxPages());
				Service.writeByteFile(VNYQlGuO[q4c9JFb9].getFile(), hRKBRyM1);
				aCf7agBr.addBatch();
			}
			aCf7agBr.executeBatch();
			PDgXcHuN.commit();
			ZByHDzQN.setResultCode(100);
			ZByHDzQN.setResultInfo(CuTnOysU);
		} catch (SQLException ywM35gTY) {
			ZByHDzQN.setResultCode(200);
			try {
				PDgXcHuN.rollback();
			} catch (Exception dhugCuqv) {
				logger.error("Error validFaxUser", dhugCuqv);
			}
			logger.error("Error validFaxUser", ywM35gTY);
		} catch (IOException J0abMDnG) {
			ZByHDzQN.setResultCode(200);
			logger.error("Error write file on sendfax", J0abMDnG);
		} finally {
			if (PDgXcHuN != null) {
				try {
					PDgXcHuN.close();
				} catch (Exception CYq3euiR) {
					logger.error("Error sendFax on close conn", CYq3euiR);
				}
			}
		}
		return ZByHDzQN;
	}

}