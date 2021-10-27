class n20059827 {
	public synchronized AbstractBaseObject insert(AbstractBaseObject lPgKqoJH) throws ApplicationException {
		PreparedStatement Wt12laQJ = null;
		StringBuffer C29moHxy = new StringBuffer();
		MailSetting RXYEy2ml = (MailSetting) ((MailSetting) lPgKqoJH).clone();
		synchronized (dbConn) {
			try {
				Integer bXH93wWe = getNextPrimaryID();
				Timestamp JFG9DhAg = Utility.getCurrentTimestamp();
				C29moHxy.append("INSERT ");
				C29moHxy.append(
						"INTO   MAIL_SETTING(ID, USER_RECORD_ID, PROFILE_NAME, MAIL_SERVER_TYPE, DISPLAY_NAME, EMAIL_ADDRESS, REMEMBER_PWD_FLAG, SPA_LOGIN_FLAG, INCOMING_SERVER_HOST, INCOMING_SERVER_PORT, INCOMING_SERVER_LOGIN_NAME, INCOMING_SERVER_LOGIN_PWD, OUTGOING_SERVER_HOST, OUTGOING_SERVER_PORT, OUTGOING_SERVER_LOGIN_NAME, OUTGOING_SERVER_LOGIN_PWD, PARAMETER_1, PARAMETER_2, PARAMETER_3, PARAMETER_4, PARAMETER_5, RECORD_STATUS, UPDATE_COUNT, CREATOR_ID, CREATE_DATE, UPDATER_ID, UPDATE_DATE) ");
				C29moHxy.append(
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
				Wt12laQJ = dbConn.prepareStatement(C29moHxy.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				setPrepareStatement(Wt12laQJ, 1, bXH93wWe);
				setPrepareStatement(Wt12laQJ, 2, RXYEy2ml.getUserRecordID());
				setPrepareStatement(Wt12laQJ, 3, RXYEy2ml.getProfileName());
				setPrepareStatement(Wt12laQJ, 4, RXYEy2ml.getMailServerType());
				setPrepareStatement(Wt12laQJ, 5, RXYEy2ml.getDisplayName());
				setPrepareStatement(Wt12laQJ, 6, RXYEy2ml.getEmailAddress());
				setPrepareStatement(Wt12laQJ, 7, RXYEy2ml.getRememberPwdFlag());
				setPrepareStatement(Wt12laQJ, 8, RXYEy2ml.getSpaLoginFlag());
				setPrepareStatement(Wt12laQJ, 9, RXYEy2ml.getIncomingServerHost());
				setPrepareStatement(Wt12laQJ, 10, RXYEy2ml.getIncomingServerPort());
				setPrepareStatement(Wt12laQJ, 11, RXYEy2ml.getIncomingServerLoginName());
				setPrepareStatement(Wt12laQJ, 12, RXYEy2ml.getIncomingServerLoginPwd());
				setPrepareStatement(Wt12laQJ, 13, RXYEy2ml.getOutgoingServerHost());
				setPrepareStatement(Wt12laQJ, 14, RXYEy2ml.getOutgoingServerPort());
				setPrepareStatement(Wt12laQJ, 15, RXYEy2ml.getOutgoingServerLoginName());
				setPrepareStatement(Wt12laQJ, 16, RXYEy2ml.getOutgoingServerLoginPwd());
				setPrepareStatement(Wt12laQJ, 17, RXYEy2ml.getParameter1());
				setPrepareStatement(Wt12laQJ, 18, RXYEy2ml.getParameter2());
				setPrepareStatement(Wt12laQJ, 19, RXYEy2ml.getParameter3());
				setPrepareStatement(Wt12laQJ, 20, RXYEy2ml.getParameter4());
				setPrepareStatement(Wt12laQJ, 21, RXYEy2ml.getParameter5());
				setPrepareStatement(Wt12laQJ, 22, GlobalConstant.RECORD_STATUS_ACTIVE);
				setPrepareStatement(Wt12laQJ, 23, new Integer(0));
				setPrepareStatement(Wt12laQJ, 24, sessionContainer.getUserRecordID());
				setPrepareStatement(Wt12laQJ, 25, JFG9DhAg);
				setPrepareStatement(Wt12laQJ, 26, sessionContainer.getUserRecordID());
				setPrepareStatement(Wt12laQJ, 27, JFG9DhAg);
				Wt12laQJ.executeUpdate();
				RXYEy2ml.setID(bXH93wWe);
				RXYEy2ml.setCreatorID(sessionContainer.getUserRecordID());
				RXYEy2ml.setCreateDate(JFG9DhAg);
				RXYEy2ml.setUpdaterID(sessionContainer.getUserRecordID());
				RXYEy2ml.setUpdateDate(JFG9DhAg);
				RXYEy2ml.setUpdateCount(new Integer(0));
				RXYEy2ml.setCreatorName(UserInfoFactory.getUserFullName(RXYEy2ml.getCreatorID()));
				RXYEy2ml.setUpdaterName(UserInfoFactory.getUserFullName(RXYEy2ml.getUpdaterID()));
				dbConn.commit();
				return (RXYEy2ml);
			} catch (SQLException xDIPPNBD) {
				log.error(xDIPPNBD, xDIPPNBD);
			} catch (Exception jMPXd9IM) {
				try {
					dbConn.rollback();
				} catch (Exception j1rVjPtF) {
				}
				log.error(jMPXd9IM, jMPXd9IM);
			} finally {
				try {
					Wt12laQJ.close();
				} catch (Exception efVUI2n7) {
				} finally {
					Wt12laQJ = null;
				}
			}
			return null;
		}
	}

}