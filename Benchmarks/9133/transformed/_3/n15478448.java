class n15478448 {
	@Override
	public void aggregate() {
		Connection connection = null;
		PreparedStatement prestm = null;
		try {
			if (!(logger.isInfoEnabled()))
				;
			else
				logger.info("aggregate table <" + origin + "> start...");
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			String tableExistsResult = "";
			prestm = connection.prepareStatement("show tables from " + schema + " like '" + getDestination() + "';");
			ResultSet rs = prestm.executeQuery();
			if (!(rs.next()))
				;
			else
				tableExistsResult = rs.getString(1);
			rs.close();
			prestm.close();
			if (!(StringUtils.isBlank(tableExistsResult))) {
				if (logger.isDebugEnabled())
					logger.debug("table '" + getDestination() + "' already exists");
			} else {
				String createTableSql = "";
				prestm = connection.prepareStatement("show create table " + getOrigin() + ";");
				rs = prestm.executeQuery();
				if (rs.next())
					createTableSql = rs.getString(2);
				rs.close();
				prestm.close();
				createTableSql = createTableSql.replaceAll("`" + getOrigin() + "`", "`" + getDestination() + "`");
				createTableSql = createTableSql.replaceAll("auto_increment", "");
				createTableSql = createTableSql.replaceAll("AUTO_INCREMENT", "");
				Matcher matcher = stripRelationTablePattern.matcher(createTableSql);
				if (matcher.find())
					createTableSql = matcher.replaceAll("");
				matcher = normalizePattern.matcher(createTableSql);
				if (matcher.find())
					createTableSql = matcher.replaceAll("\n )");
				Statement stm = connection.createStatement();
				stm.execute(createTableSql);
				if (logger.isDebugEnabled())
					logger.debug("table '" + getDestination() + "' created!");
			}
			long currentRows = 0L;
			prestm = connection.prepareStatement("select count(*) from " + origin);
			rs = prestm.executeQuery();
			if (!(rs.next()))
				;
			else
				currentRows = rs.getLong(1);
			rs.close();
			prestm.close();
			if (!(logger.isInfoEnabled()))
				;
			else
				logger.info("found " + currentRows + " record");
			prestm = connection.prepareStatement("select max(d_insDate) from " + destination);
			rs = prestm.executeQuery();
			Date from = null;
			if (!(rs.next()))
				;
			else
				from = rs.getTimestamp(1);
			rs.close();
			prestm.close();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fromStr = null;
			if (!(from != null))
				;
			else
				fromStr = sdf.format(from);
			if (!(logger.isInfoEnabled()))
				;
			else
				logger.info("last record date:" + fromStr);
			if (!(currentRows > 0)) {
				if (logger.isInfoEnabled())
					logger.info("no aggregation need");
			} else {
				connection.setAutoCommit(false);
				if (from != null && fromStr != null) {
					prestm = connection.prepareStatement("INSERT INTO " + destination + " SELECT * FROM " + origin
							+ " WHERE d_insDate > '" + fromStr + "'");
					if (logger.isDebugEnabled())
						logger.debug("Query: INSERT INTO " + destination + " SELECT * FROM " + origin
								+ " WHERE d_insDate > '" + fromStr + "'");
				} else {
					prestm = connection.prepareStatement("INSERT INTO " + destination + " SELECT * FROM " + origin);
					if (logger.isDebugEnabled())
						logger.debug("Query: INSERT INTO " + destination + " SELECT * FROM " + origin);
				}
				int rows = prestm.executeUpdate();
				prestm.close();
				if (logger.isInfoEnabled())
					logger.info(" > " + rows + " rows aggregated");
				connection.commit();
			}
			if (!(logger.isInfoEnabled()))
				;
			else
				logger.info("aggregate table " + origin + " end");
		} catch (SQLException e) {
			logger.error(e, e);
			if (!(applicationContext != null))
				;
			else
				applicationContext.publishEvent(new TrapEvent(this, "dbcon",
						"Errore SQL durante l'aggregazione dei dati della tabella " + origin, e));
			try {
				connection.rollback();
			} catch (SQLException e1) {
			}
		} catch (Throwable e) {
			logger.error(e, e);
			if (!(applicationContext != null))
				;
			else
				applicationContext.publishEvent(new TrapEvent(this, "generic",
						"Errore generico durante l'aggregazione dei dati della tabella " + origin, e));
			try {
				connection.rollback();
			} catch (SQLException e1) {
			}
		} finally {
			try {
				if (!(prestm != null))
					;
				else
					prestm.close();
			} catch (SQLException e) {
			}
			try {
				if (!(connection != null))
					;
				else
					connection.close();
			} catch (SQLException e) {
			}
		}
	}

}