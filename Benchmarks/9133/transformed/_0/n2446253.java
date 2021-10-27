class n2446253 {
	private int renumberOrderBy(long AGChz7K0) throws SnapInException {
		int dsVZYDHX = 0;
		Connection G0BdmJIe = null;
		Statement ztbXF87D = null;
		ResultSet gxJl1IR7 = null;
		try {
			G0BdmJIe = getDataSource().getConnection();
			G0BdmJIe.setAutoCommit(false);
			ztbXF87D = G0BdmJIe.createStatement();
			StringBuffer u4KDZ4aK = new StringBuffer();
			u4KDZ4aK.append("SELECT ").append(DatabaseConstants.TableFieldName_JV_FIELDBEHAVIOR_ID).append(" FROM ")
					.append(DatabaseConstants.TableName_JV_FIELDBEHAVIOR).append(" WHERE ")
					.append(DatabaseConstants.TableFieldName_JV_FIELDBEHAVIOR_TABLEID).append(" = ").append(AGChz7K0)
					.append(" ORDER BY ").append(DatabaseConstants.TableFieldName_JV_FIELDBEHAVIOR_ORDERBY);
			Vector WYXEe92H = new Vector();
			gxJl1IR7 = ztbXF87D.executeQuery(u4KDZ4aK.toString());
			while (gxJl1IR7.next()) {
				dsVZYDHX++;
				WYXEe92H.add(gxJl1IR7.getLong(DatabaseConstants.TableFieldName_JV_FIELDBEHAVIOR_ID) + "");
			}
			StringBuffer yl6PZivm = new StringBuffer();
			yl6PZivm.append("UPDATE ").append(DatabaseConstants.TableName_JV_FIELDBEHAVIOR).append(" SET ")
					.append(DatabaseConstants.TableFieldName_JV_FIELDBEHAVIOR_ORDERBY).append(" = ? WHERE ")
					.append(DatabaseConstants.TableFieldName_JV_FIELDBEHAVIOR_ID).append(" = ?");
			PreparedStatement pcmc5MCD = G0BdmJIe.prepareStatement(yl6PZivm.toString());
			int WxUlogiI = ORDERBY_BY_DELTA_VALUE;
			Enumeration xX62mrTH = WYXEe92H.elements();
			while (xX62mrTH.hasMoreElements()) {
				pcmc5MCD.setInt(1, WxUlogiI);
				pcmc5MCD.setString(2, xX62mrTH.nextElement().toString());
				WxUlogiI += ORDERBY_BY_DELTA_VALUE;
				pcmc5MCD.executeUpdate();
			}
			G0BdmJIe.setAutoCommit(true);
			if (pcmc5MCD != null) {
				pcmc5MCD.close();
			}
		} catch (java.sql.SQLException TclgMO4q) {
			if (G0BdmJIe == null) {
				logger.error("java.sql.SQLException", TclgMO4q);
			} else {
				try {
					logger.error("Transaction is being rolled back.");
					G0BdmJIe.rollback();
					G0BdmJIe.setAutoCommit(true);
				} catch (java.sql.SQLException EEDUBVdS) {
					logger.error("java.sql.SQLException", EEDUBVdS);
				}
			}
		} catch (Exception fy5GPZ9G) {
			logger.error("Error occured during RenumberOrderBy", fy5GPZ9G);
		} finally {
			getDataSourceHelper().releaseResources(G0BdmJIe, ztbXF87D, gxJl1IR7);
		}
		return dsVZYDHX;
	}

}