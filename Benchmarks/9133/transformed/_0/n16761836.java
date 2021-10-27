class n16761836 {
	protected synchronized AbstractBaseObject insert(AbstractBaseObject uDeNxAxe) throws ApplicationException {
		PreparedStatement xGbiUXIb = null;
		StringBuffer pLclRR1i = new StringBuffer();
		DmsRelationalWord HbLp8N9M = (DmsRelationalWord) ((DmsRelationalWord) uDeNxAxe).clone();
		synchronized (dbConn) {
			try {
				Integer lpCGjOJd = getNextPrimaryID();
				Timestamp UtQixsNx = Utility.getCurrentTimestamp();
				pLclRR1i.append("INSERT ");
				pLclRR1i.append(
						"INTO   DMS_RELATIONAL_WORD(ID, RECORD_STATUS, UPDATE_COUNT, CREATOR_ID, CREATE_DATE, UPDATER_ID, UPDATE_DATE, WORD, PARENT_ID, TYPE) ");
				pLclRR1i.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
				xGbiUXIb = dbConn.prepareStatement(pLclRR1i.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				setPrepareStatement(xGbiUXIb, 1, lpCGjOJd);
				setPrepareStatement(xGbiUXIb, 2, HbLp8N9M.getRecordStatus());
				setPrepareStatement(xGbiUXIb, 3, new Integer(0));
				setPrepareStatement(xGbiUXIb, 4, HbLp8N9M.getCreatorID());
				setPrepareStatement(xGbiUXIb, 5, UtQixsNx);
				setPrepareStatement(xGbiUXIb, 6, HbLp8N9M.getUpdaterID());
				setPrepareStatement(xGbiUXIb, 7, UtQixsNx);
				if (HbLp8N9M.getWord() == null || "".equals(HbLp8N9M.getWord().trim())) {
					return null;
				}
				setPrepareStatement(xGbiUXIb, 8, HbLp8N9M.getWord());
				setPrepareStatement(xGbiUXIb, 9, HbLp8N9M.getParentID());
				setPrepareStatement(xGbiUXIb, 10, HbLp8N9M.getType());
				xGbiUXIb.executeUpdate();
				HbLp8N9M.setID(lpCGjOJd);
				HbLp8N9M.setCreatorID(HbLp8N9M.getCreatorID());
				HbLp8N9M.setCreateDate(UtQixsNx);
				HbLp8N9M.setUpdaterID(HbLp8N9M.getUpdaterID());
				HbLp8N9M.setUpdateDate(UtQixsNx);
				HbLp8N9M.setUpdateCount(new Integer(0));
				HbLp8N9M.setCreatorName(UserInfoFactory.getUserFullName(HbLp8N9M.getCreatorID()));
				HbLp8N9M.setUpdaterName(UserInfoFactory.getUserFullName(HbLp8N9M.getUpdaterID()));
				dbConn.commit();
				return (HbLp8N9M);
			} catch (Exception WD5eaeq1) {
				try {
					dbConn.rollback();
				} catch (Exception ssU4bt2G) {
				}
				log.error(WD5eaeq1, WD5eaeq1);
				throw new ApplicationException(ErrorConstant.DB_INSERT_ERROR, WD5eaeq1);
			} finally {
				try {
					xGbiUXIb.close();
				} catch (Exception Z0ptGIqv) {
				} finally {
					xGbiUXIb = null;
				}
			}
		}
	}

}