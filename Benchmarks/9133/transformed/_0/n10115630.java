class n10115630 {
	public static boolean copyDataToNewTable(EboContext mzmSMmrJ, String tNDO7tvh, String iRR7bxcJ, String KK4C0bOU,
			boolean mWIVr7TG, int Qo5jiuWV) throws boRuntimeException {
		tNDO7tvh = tNDO7tvh.toUpperCase();
		iRR7bxcJ = iRR7bxcJ.toUpperCase();
		Connection BvwMnlAu = null;
		Connection NbuQPk2C = null;
		boolean sY0pXHCy = false;
		try {
			boolean KJ8epKKE = false;
			boolean fCd7HbI1 = false;
			final InitialContext UNCkdNzj = new InitialContext();
			BvwMnlAu = mzmSMmrJ.getConnectionData();
			NbuQPk2C = mzmSMmrJ.getConnectionDef();
			PreparedStatement pOBcljPo = BvwMnlAu
					.prepareStatement("SELECT TABLE_NAME FROM USER_TABLES WHERE TABLE_NAME=?");
			pOBcljPo.setString(1, tNDO7tvh);
			ResultSet xmuhEzrd = pOBcljPo.executeQuery();
			if (xmuhEzrd.next()) {
				KJ8epKKE = true;
			}
			xmuhEzrd.close();
			pOBcljPo.setString(1, iRR7bxcJ);
			xmuhEzrd = pOBcljPo.executeQuery();
			if (xmuhEzrd.next()) {
				fCd7HbI1 = true;
			}
			if (!fCd7HbI1) {
				xmuhEzrd.close();
				pOBcljPo.close();
				pOBcljPo = BvwMnlAu.prepareStatement("SELECT VIEW_NAME FROM USER_VIEWS WHERE VIEW_NAME=?");
				pOBcljPo.setString(1, iRR7bxcJ);
				xmuhEzrd = pOBcljPo.executeQuery();
				if (xmuhEzrd.next()) {
					CallableStatement qHi92NdM = BvwMnlAu.prepareCall("DROP VIEW " + iRR7bxcJ);
					qHi92NdM.execute();
					qHi92NdM.close();
				}
			}
			xmuhEzrd.close();
			pOBcljPo.close();
			if (KJ8epKKE && !fCd7HbI1) {
				if (mWIVr7TG) {
					logger.finest(LoggerMessageLocalizer.getMessage("CREATING_AND_COPY_DATA_FROM") + " [" + tNDO7tvh
							+ "] " + LoggerMessageLocalizer.getMessage("TO") + " [" + iRR7bxcJ + "]");
				}
				CallableStatement pPVmxUzU = BvwMnlAu
						.prepareCall("CREATE TABLE " + iRR7bxcJ + " AS SELECT * FROM " + tNDO7tvh + " "
								+ (((KK4C0bOU != null) && (KK4C0bOU.length() > 0)) ? (" WHERE " + KK4C0bOU) : ""));
				pPVmxUzU.execute();
				pPVmxUzU.close();
				if (mWIVr7TG) {
					logger.finest(LoggerMessageLocalizer.getMessage("UPDATING_NGTDIC"));
				}
				BvwMnlAu.commit();
				sY0pXHCy = true;
			} else if (KJ8epKKE && fCd7HbI1) {
				if (mWIVr7TG) {
					logger.finest(LoggerMessageLocalizer.getMessage("COPY_DATA_FROM") + " [" + tNDO7tvh + "] "
							+ LoggerMessageLocalizer.getMessage("TO") + "  [" + iRR7bxcJ + "]");
				}
				PreparedStatement EN740Gsa = BvwMnlAu
						.prepareStatement("SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ? ");
				EN740Gsa.setString(1, iRR7bxcJ);
				ResultSet r0G1OKwM = EN740Gsa.executeQuery();
				StringBuffer RmNRC8EW = new StringBuffer();
				PreparedStatement YbMhRyzM = BvwMnlAu.prepareStatement(
						"SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ? and COLUMN_NAME=?");
				while (r0G1OKwM.next()) {
					YbMhRyzM.setString(1, tNDO7tvh);
					YbMhRyzM.setString(2, r0G1OKwM.getString(1));
					ResultSet F3QYaBn9 = YbMhRyzM.executeQuery();
					if (F3QYaBn9.next()) {
						if (RmNRC8EW.length() > 0) {
							RmNRC8EW.append(',');
						}
						RmNRC8EW.append('"').append(r0G1OKwM.getString(1)).append('"');
					}
					F3QYaBn9.close();
				}
				YbMhRyzM.close();
				r0G1OKwM.close();
				EN740Gsa.close();
				CallableStatement yIzJni8k;
				int LUroePhm = 0;
				if ((Qo5jiuWV == 0) || (Qo5jiuWV == 1)) {
					yIzJni8k = BvwMnlAu.prepareCall("INSERT INTO " + iRR7bxcJ + "( " + RmNRC8EW.toString()
							+ " ) ( SELECT " + RmNRC8EW.toString() + " FROM " + tNDO7tvh + " "
							+ (((KK4C0bOU != null) && (KK4C0bOU.length() > 0)) ? (" WHERE " + KK4C0bOU) : "") + ")");
					LUroePhm = yIzJni8k.executeUpdate();
					yIzJni8k.close();
					if (mWIVr7TG) {
						logger.finest(LoggerMessageLocalizer.getMessage("DONE") + " [" + LUroePhm + "] "
								+ LoggerMessageLocalizer.getMessage("RECORDS_COPIED"));
					}
				}
				BvwMnlAu.commit();
				sY0pXHCy = true;
			}
		} catch (Exception ywfmUEY0) {
			try {
				BvwMnlAu.rollback();
			} catch (Exception ZPZo71O6) {
				throw new boRuntimeException("boBuildDB.moveTable", "BO-1304", ZPZo71O6);
			}
			throw new boRuntimeException("boBuildDB.moveTable", "BO-1304", ywfmUEY0);
		} finally {
			try {
				BvwMnlAu.close();
			} catch (Exception jkevJc8k) {
			}
			try {
				NbuQPk2C.close();
			} catch (Exception h3RFY6Mv) {
			}
		}
		return sY0pXHCy;
	}

}