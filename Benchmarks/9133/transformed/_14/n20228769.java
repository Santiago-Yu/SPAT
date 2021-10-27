class n20228769 {
	public Vector getData(DataDescription descr, Station station, DateInterval dateInterval, int sampling)
			throws ApiException {
		Connection con = null;
		Statement stmt = null;
		String table = (descr != null) ? descr.getTable() : null;
		Vector dsList = new Vector();
		try {
			String wsflag = Settings.get(table + ".useWebService");
			if ("yes".equals(wsflag) || "true".equals(wsflag)) {
				String serviceUrl = Settings.get(table + ".dataServiceUrl");
				String serviceUser = Settings.get(table + ".dataServiceUser");
				String servicePassword = Settings.get(table + ".dataServicePassword");
				Call call = (Call) (new Service()).createCall();
				call.setTargetEndpointAddress(serviceUrl);
				call.setOperationName("getData");
				if (serviceUser != null) {
					call.setUsername(serviceUser);
					if (servicePassword != null) {
						call.setPassword(servicePassword);
					}
				}
				if (log.isDebugEnabled()) {
					log.debug("Service " + serviceUrl + " authentication user=" + serviceUser + " passwd="
							+ servicePassword + " call method getData" + " for table " + table + " station "
							+ ((station != null) ? station.getStn() : "") + " element "
							+ ((descr != null && descr.getElement() != null) ? descr.getElement() : "") + " dateFrom "
							+ dateInterval.getDateFrom().getDayId() + " dateTo " + dateInterval.getDateTo().getDayId()
							+ " sampling " + sampling);
				}
				String dssUrl = (String) call.invoke(new Object[] { table, ((station != null) ? station.getStn() : ""),
						((descr != null && descr.getElement() != null) ? descr.getElement() : ""),
						"" + dateInterval.getDateFrom().getDayId(), "" + dateInterval.getDateTo().getDayId(), "",
						"" + sampling });
				if (log.isDebugEnabled()) {
					log.debug("Service return url '" + dssUrl + "'");
				}
				if (dssUrl != null && !"".equals(dssUrl)) {
					URL dataurl = new URL(dssUrl);
					DataSequenceSet dsstmp = readDataSet(dataurl.openStream());
					if (dsstmp != null && dsstmp.size() > 0) {
						dsList.addAll(dsstmp);
						if (log.isDebugEnabled()) {
							log.debug("Data set list size is " + dsstmp.size());
						}
					} else {
						if (log.isDebugEnabled()) {
							log.debug("Data set list is empty");
						}
					}
				}
			} else {
				con = ConnectionPool.getConnection(table);
				stmt = con.createStatement();
				String className = Settings.get(table + ".classGetter");
				if (null == className) {
					throw new ApiException("Undefined classGetter field for table '" + table + "'");
				}
				dsList = ((DBAccess) Class.forName(className).newInstance()).getDataSequence(stmt, descr, station,
						dateInterval, sampling);
			}
			return dsList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException("Data are not available: " + e.toString());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
			}
			ConnectionPool.releaseConnection(con);
		}
	}

}