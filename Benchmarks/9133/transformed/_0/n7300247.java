class n7300247 {
	public void moveMessage(DBMimeMessage TJjBTd2h) throws MessagingException {
		if (DebugFile.trace) {
			DebugFile.writeln("Begin DBFolder.moveMessage()");
			DebugFile.incIdent();
		}
		JDCConnection E9e1qcMR = null;
		PreparedStatement JO03hwdK = null;
		ResultSet AdIDw84n = null;
		BigDecimal du4eDfZB = null;
		BigDecimal R06eMmx3 = null;
		int FhUA10WM = 0;
		try {
			E9e1qcMR = ((DBStore) getStore()).getConnection();
			JO03hwdK = E9e1qcMR.prepareStatement("SELECT " + DB.pg_message + "," + DB.nu_position + "," + DB.len_mimemsg
					+ " FROM " + DB.k_mime_msgs + " WHERE " + DB.gu_mimemsg + "=?");
			JO03hwdK.setString(1, TJjBTd2h.getMessageGuid());
			AdIDw84n = JO03hwdK.executeQuery();
			if (AdIDw84n.next()) {
				du4eDfZB = AdIDw84n.getBigDecimal(1);
				R06eMmx3 = AdIDw84n.getBigDecimal(2);
				FhUA10WM = AdIDw84n.getInt(3);
			}
			AdIDw84n.close();
			AdIDw84n = null;
			JO03hwdK.close();
			JO03hwdK = null;
			E9e1qcMR.setAutoCommit(false);
			JO03hwdK = E9e1qcMR.prepareStatement("UPDATE " + DB.k_categories + " SET " + DB.len_size + "=" + DB.len_size
					+ "-" + String.valueOf(FhUA10WM) + " WHERE " + DB.gu_category + "=?");
			JO03hwdK.setString(1, ((DBFolder) (TJjBTd2h.getFolder())).getCategory().getString(DB.gu_category));
			JO03hwdK.executeUpdate();
			JO03hwdK.close();
			JO03hwdK = null;
			JO03hwdK = E9e1qcMR.prepareStatement("UPDATE " + DB.k_categories + " SET " + DB.len_size + "=" + DB.len_size
					+ "+" + String.valueOf(FhUA10WM) + " WHERE " + DB.gu_category + "=?");
			JO03hwdK.setString(1, getCategory().getString(DB.gu_category));
			JO03hwdK.executeUpdate();
			JO03hwdK.close();
			JO03hwdK = null;
			E9e1qcMR.commit();
		} catch (SQLException dWT1fEeI) {
			if (null != AdIDw84n) {
				try {
					AdIDw84n.close();
				} catch (Exception CEJXyTga) {
				}
			}
			if (null != JO03hwdK) {
				try {
					JO03hwdK.close();
				} catch (Exception huGwdPCj) {
				}
			}
			if (null != E9e1qcMR) {
				try {
					E9e1qcMR.rollback();
				} catch (Exception xBGjdVdQ) {
				}
			}
			throw new MessagingException(dWT1fEeI.getMessage(), dWT1fEeI);
		}
		if (null == du4eDfZB)
			throw new MessagingException("Source message not found");
		if (null == R06eMmx3)
			throw new MessagingException("Source message position is not valid");
		DBFolder KeEPODO4 = (DBFolder) TJjBTd2h.getFolder();
		MboxFile MNz3748W = null, HHiOdXL7 = null;
		try {
			MNz3748W = new MboxFile(KeEPODO4.getFile(), MboxFile.READ_WRITE);
			HHiOdXL7 = new MboxFile(KeEPODO4.getFile(), MboxFile.READ_WRITE);
			HHiOdXL7.appendMessage(MNz3748W, R06eMmx3.longValue(), FhUA10WM);
			HHiOdXL7.close();
			HHiOdXL7 = null;
			MNz3748W.purge(new int[] { du4eDfZB.intValue() });
			MNz3748W.close();
			MNz3748W = null;
		} catch (Exception Li0YwRUg) {
			if (HHiOdXL7 != null) {
				try {
					HHiOdXL7.close();
				} catch (Exception yrC55Y4e) {
				}
			}
			if (MNz3748W != null) {
				try {
					MNz3748W.close();
				} catch (Exception TgovBb7l) {
				}
			}
			throw new MessagingException(Li0YwRUg.getMessage(), Li0YwRUg);
		}
		try {
			E9e1qcMR = ((DBStore) getStore()).getConnection();
			BigDecimal lk5MwgzV = getNextMessage();
			String qrxFkXTO = getCategory().getString(DB.gu_category);
			JO03hwdK = E9e1qcMR.prepareStatement("UPDATE " + DB.k_mime_msgs + " SET " + DB.gu_category + "=?,"
					+ DB.pg_message + "=? WHERE " + DB.gu_mimemsg + "=?");
			JO03hwdK.setString(1, qrxFkXTO);
			JO03hwdK.setBigDecimal(2, lk5MwgzV);
			JO03hwdK.setString(3, TJjBTd2h.getMessageGuid());
			JO03hwdK.executeUpdate();
			JO03hwdK.close();
			JO03hwdK = null;
			E9e1qcMR.commit();
		} catch (SQLException MBGgTayO) {
			if (null != JO03hwdK) {
				try {
					JO03hwdK.close();
				} catch (Exception wPbqKHnd) {
				}
			}
			if (null != E9e1qcMR) {
				try {
					E9e1qcMR.rollback();
				} catch (Exception lMHD0EPE) {
				}
			}
			throw new MessagingException(MBGgTayO.getMessage(), MBGgTayO);
		}
		if (DebugFile.trace) {
			DebugFile.decIdent();
			DebugFile.writeln("End DBFolder.moveMessage()");
		}
	}

}