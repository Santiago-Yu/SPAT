class n2791310 {
	protected synchronized AbstractBaseObject insert(AbstractBaseObject Q5sYBkwc) throws ApplicationException {
		PreparedStatement D4NEImHR = null;
		StringBuffer Zx7gswm6 = new StringBuffer();
		DmsRelationalWord bQy85Txs = (DmsRelationalWord) ((DmsRelationalWord) Q5sYBkwc).clone();
		synchronized (dbConn) {
			try {
				Integer OiY2diqh = getNextPrimaryID();
				Timestamp uifV7cXU = Utility.getCurrentTimestamp();
				Zx7gswm6.append("INSERT ");
				Zx7gswm6.append(
						"INTO   DMS_RELATIONAL_WORD(ID, RECORD_STATUS, UPDATE_COUNT, CREATOR_ID, CREATE_DATE, UPDATER_ID, UPDATE_DATE, WORD, PARENT_ID, TYPE) ");
				Zx7gswm6.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
				D4NEImHR = dbConn.prepareStatement(Zx7gswm6.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				setPrepareStatement(D4NEImHR, 1, OiY2diqh);
				setPrepareStatement(D4NEImHR, 2, bQy85Txs.getRecordStatus());
				setPrepareStatement(D4NEImHR, 3, new Integer(0));
				setPrepareStatement(D4NEImHR, 4, bQy85Txs.getCreatorID());
				setPrepareStatement(D4NEImHR, 5, uifV7cXU);
				setPrepareStatement(D4NEImHR, 6, bQy85Txs.getUpdaterID());
				setPrepareStatement(D4NEImHR, 7, uifV7cXU);
				if (bQy85Txs.getWord() == null || "".equals(bQy85Txs.getWord().trim())) {
					return null;
				}
				setPrepareStatement(D4NEImHR, 8, bQy85Txs.getWord());
				setPrepareStatement(D4NEImHR, 9, bQy85Txs.getParentID());
				setPrepareStatement(D4NEImHR, 10, bQy85Txs.getType());
				D4NEImHR.executeUpdate();
				bQy85Txs.setID(OiY2diqh);
				bQy85Txs.setCreatorID(bQy85Txs.getCreatorID());
				bQy85Txs.setCreateDate(uifV7cXU);
				bQy85Txs.setUpdaterID(bQy85Txs.getUpdaterID());
				bQy85Txs.setUpdateDate(uifV7cXU);
				bQy85Txs.setUpdateCount(new Integer(0));
				bQy85Txs.setCreatorName(UserInfoFactory.getUserFullName(bQy85Txs.getCreatorID()));
				bQy85Txs.setUpdaterName(UserInfoFactory.getUserFullName(bQy85Txs.getUpdaterID()));
				dbConn.commit();
				return (bQy85Txs);
			} catch (Exception obgF1IWo) {
				try {
					dbConn.rollback();
				} catch (Exception qpm4Pt53) {
				}
				log.error(obgF1IWo, obgF1IWo);
				throw new ApplicationException(ErrorConstant.DB_INSERT_ERROR, obgF1IWo);
			} finally {
				try {
					D4NEImHR.close();
				} catch (Exception AQPuUtyc) {
				} finally {
					D4NEImHR = null;
				}
			}
		}
	}

}