class n9270406 {
	public void downSync(Vector Vz9hOJRY) throws SQLException {
		try {
			con = allocateConnection(tableName);
			PreparedStatement G7zpi7WT = con.prepareStatement("update cal_Event set owner=?,subject=?,text=?,place=?,"
					+ "contactperson=?,startdate=?,enddate=?,starttime=?,endtime=?,allday=?,"
					+ "syncstatus=?,dirtybits=? where OId=? and syncstatus=?");
			PreparedStatement XgF3QT3X = con.prepareStatement("insert into cal_Event (owner,subject,text,place,"
					+ "contactperson,startdate,enddate,starttime,endtime,allday,syncstatus,"
					+ "dirtybits) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement HR3hBmot = con.prepareStatement(DBUtil.getQueryCurrentOID(con, "cal_Event", "newoid"));
			PreparedStatement us1iEO8g = con.prepareStatement("delete from  cal_Event_Remind where event=?");
			PreparedStatement N28BAYt7 = con
					.prepareStatement("delete from  cal_Event where OId=? " + "and (syncstatus=? or syncstatus=?)");
			for (int ueQKZDxi = 0; ueQKZDxi < Vz9hOJRY.size(); ueQKZDxi++) {
				try {
					DO = (EventDO) Vz9hOJRY.elementAt(ueQKZDxi);
					if (DO.getSyncstatus() == INSERT) {
						XgF3QT3X.setBigDecimal(1, DO.getOwner());
						XgF3QT3X.setString(2, DO.getSubject());
						XgF3QT3X.setString(3, DO.getText());
						XgF3QT3X.setString(4, DO.getPlace());
						XgF3QT3X.setString(5, DO.getContactperson());
						XgF3QT3X.setDate(6, DO.getStartdate());
						XgF3QT3X.setDate(7, DO.getEnddate());
						XgF3QT3X.setTime(8, DO.getStarttime());
						XgF3QT3X.setTime(9, DO.getEndtime());
						XgF3QT3X.setBoolean(10, DO.getAllday());
						XgF3QT3X.setInt(11, RESET);
						XgF3QT3X.setInt(12, RESET);
						con.executeUpdate(XgF3QT3X, null);
						con.reset();
						rs = con.executeQuery(HR3hBmot, null);
						if (rs.next())
							DO.setOId(rs.getBigDecimal("newoid"));
						con.reset();
					} else if (DO.getSyncstatus() == UPDATE) {
						G7zpi7WT.setBigDecimal(1, DO.getOwner());
						G7zpi7WT.setString(2, DO.getSubject());
						G7zpi7WT.setString(3, DO.getText());
						G7zpi7WT.setString(4, DO.getPlace());
						G7zpi7WT.setString(5, DO.getContactperson());
						G7zpi7WT.setDate(6, DO.getStartdate());
						G7zpi7WT.setDate(7, DO.getEnddate());
						G7zpi7WT.setTime(8, DO.getStarttime());
						G7zpi7WT.setTime(9, DO.getEndtime());
						G7zpi7WT.setBoolean(10, DO.getAllday());
						G7zpi7WT.setInt(11, RESET);
						G7zpi7WT.setInt(12, RESET);
						G7zpi7WT.setBigDecimal(13, DO.getOId());
						G7zpi7WT.setInt(14, RESET);
						con.executeUpdate(G7zpi7WT, null);
						con.reset();
					} else if (DO.getSyncstatus() == DELETE) {
						try {
							con.setAutoCommit(false);
							us1iEO8g.setBigDecimal(1, DO.getOId());
							con.executeUpdate(us1iEO8g, null);
							N28BAYt7.setBigDecimal(1, DO.getOId());
							N28BAYt7.setInt(2, RESET);
							N28BAYt7.setInt(3, DELETE);
							if (con.executeUpdate(N28BAYt7, null) < 1) {
								con.rollback();
							} else {
								con.commit();
							}
						} catch (Exception Ad7UttlJ) {
							con.rollback();
							throw Ad7UttlJ;
						} finally {
							con.reset();
						}
					}
				} catch (Exception gqHSWjz4) {
					if (DO != null)
						logError("Sync-EventDO.owner = " + DO.getOwner().toString() + " oid = "
								+ (DO.getOId() != null ? DO.getOId().toString() : "NULL"), gqHSWjz4);
				}
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException fVyqadoV) {
			if (DEBUG)
				logError("", fVyqadoV);
			throw fVyqadoV;
		} finally {
			release();
		}
	}

}