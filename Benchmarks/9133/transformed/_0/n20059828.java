class n20059828 {
	public synchronized AbstractBaseObject update(AbstractBaseObject VMLhHF1K) throws ApplicationException {
		PreparedStatement nXr2Ezi5 = null;
		StringBuffer ojEv8whm = new StringBuffer();
		MailSetting ha3rchTR = (MailSetting) ((MailSetting) VMLhHF1K).clone();
		synchronized (dbConn) {
			try {
				int v7BVrrHn = 0;
				Timestamp kRGmRVY6 = Utility.getCurrentTimestamp();
				ojEv8whm.append("UPDATE MAIL_SETTING ");
				ojEv8whm.append(
						"SET  USER_RECORD_ID=?, PROFILE_NAME=?, MAIL_SERVER_TYPE=?, DISPLAY_NAME=?, EMAIL_ADDRESS=?, REMEMBER_PWD_FLAG=?, SPA_LOGIN_FLAG=?, INCOMING_SERVER_HOST=?, INCOMING_SERVER_PORT=?, INCOMING_SERVER_LOGIN_NAME=?, INCOMING_SERVER_LOGIN_PWD=?, OUTGOING_SERVER_HOST=?, OUTGOING_SERVER_PORT=?, OUTGOING_SERVER_LOGIN_NAME=?, OUTGOING_SERVER_LOGIN_PWD=?, PARAMETER_1=?, PARAMETER_2=?, PARAMETER_3=?, PARAMETER_4=?, PARAMETER_5=?, UPDATE_COUNT=?, UPDATER_ID=?, UPDATE_DATE=? ");
				ojEv8whm.append("WHERE  ID=? AND UPDATE_COUNT=? ");
				nXr2Ezi5 = dbConn.prepareStatement(ojEv8whm.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				setPrepareStatement(nXr2Ezi5, 1, ha3rchTR.getUserRecordID());
				setPrepareStatement(nXr2Ezi5, 2, ha3rchTR.getProfileName());
				setPrepareStatement(nXr2Ezi5, 3, ha3rchTR.getMailServerType());
				setPrepareStatement(nXr2Ezi5, 4, ha3rchTR.getDisplayName());
				setPrepareStatement(nXr2Ezi5, 5, ha3rchTR.getEmailAddress());
				setPrepareStatement(nXr2Ezi5, 6, ha3rchTR.getRememberPwdFlag());
				setPrepareStatement(nXr2Ezi5, 7, ha3rchTR.getSpaLoginFlag());
				setPrepareStatement(nXr2Ezi5, 8, ha3rchTR.getIncomingServerHost());
				setPrepareStatement(nXr2Ezi5, 9, ha3rchTR.getIncomingServerPort());
				setPrepareStatement(nXr2Ezi5, 10, ha3rchTR.getIncomingServerLoginName());
				setPrepareStatement(nXr2Ezi5, 11, ha3rchTR.getIncomingServerLoginPwd());
				setPrepareStatement(nXr2Ezi5, 12, ha3rchTR.getOutgoingServerHost());
				setPrepareStatement(nXr2Ezi5, 13, ha3rchTR.getOutgoingServerPort());
				setPrepareStatement(nXr2Ezi5, 14, ha3rchTR.getOutgoingServerLoginName());
				setPrepareStatement(nXr2Ezi5, 15, ha3rchTR.getOutgoingServerLoginPwd());
				setPrepareStatement(nXr2Ezi5, 16, ha3rchTR.getParameter1());
				setPrepareStatement(nXr2Ezi5, 17, ha3rchTR.getParameter2());
				setPrepareStatement(nXr2Ezi5, 18, ha3rchTR.getParameter3());
				setPrepareStatement(nXr2Ezi5, 19, ha3rchTR.getParameter4());
				setPrepareStatement(nXr2Ezi5, 20, ha3rchTR.getParameter5());
				setPrepareStatement(nXr2Ezi5, 21, new Integer(ha3rchTR.getUpdateCount().intValue() + 1));
				setPrepareStatement(nXr2Ezi5, 22, sessionContainer.getUserRecordID());
				setPrepareStatement(nXr2Ezi5, 23, kRGmRVY6);
				setPrepareStatement(nXr2Ezi5, 24, ha3rchTR.getID());
				setPrepareStatement(nXr2Ezi5, 25, ha3rchTR.getUpdateCount());
				v7BVrrHn = nXr2Ezi5.executeUpdate();
				dbConn.commit();
				if (v7BVrrHn == 0) {
					throw new ApplicationException(ErrorConstant.DB_CONCURRENT_ERROR);
				} else {
					ha3rchTR.setUpdaterID(sessionContainer.getUserRecordID());
					ha3rchTR.setUpdateDate(kRGmRVY6);
					ha3rchTR.setUpdateCount(new Integer(ha3rchTR.getUpdateCount().intValue() + 1));
					ha3rchTR.setCreatorName(UserInfoFactory.getUserFullName(ha3rchTR.getCreatorID()));
					ha3rchTR.setUpdaterName(UserInfoFactory.getUserFullName(ha3rchTR.getUpdaterID()));
					return (ha3rchTR);
				}
			} catch (Exception v2U0pJj0) {
				try {
					dbConn.rollback();
				} catch (Exception WO4dQz5y) {
				}
				log.error(v2U0pJj0, v2U0pJj0);
				throw new ApplicationException(ErrorConstant.DB_UPDATE_ERROR, v2U0pJj0);
			} finally {
				try {
					nXr2Ezi5.close();
				} catch (Exception JAw72x73) {
				} finally {
					nXr2Ezi5 = null;
				}
			}
		}
	}

}