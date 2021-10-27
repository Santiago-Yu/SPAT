class n15478448 {
	@Override
	public void aggregate() {
		Connection Rn8Wq7PS = null;
		PreparedStatement QDJrtKDJ = null;
		try {
			if (logger.isInfoEnabled())
				logger.info("aggregate table <" + origin + "> start...");
			Class.forName(driver);
			Rn8Wq7PS = DriverManager.getConnection(url, username, password);
			String U1I2IZur = "";
			QDJrtKDJ = Rn8Wq7PS.prepareStatement("show tables from " + schema + " like '" + getDestination() + "';");
			ResultSet cSqssi64 = QDJrtKDJ.executeQuery();
			if (cSqssi64.next())
				U1I2IZur = cSqssi64.getString(1);
			cSqssi64.close();
			QDJrtKDJ.close();
			if (StringUtils.isBlank(U1I2IZur)) {
				String VwJQxbwE = "";
				QDJrtKDJ = Rn8Wq7PS.prepareStatement("show create table " + getOrigin() + ";");
				cSqssi64 = QDJrtKDJ.executeQuery();
				if (cSqssi64.next())
					VwJQxbwE = cSqssi64.getString(2);
				cSqssi64.close();
				QDJrtKDJ.close();
				VwJQxbwE = VwJQxbwE.replaceAll("`" + getOrigin() + "`", "`" + getDestination() + "`");
				VwJQxbwE = VwJQxbwE.replaceAll("auto_increment", "");
				VwJQxbwE = VwJQxbwE.replaceAll("AUTO_INCREMENT", "");
				Matcher VnuqyoyE = stripRelationTablePattern.matcher(VwJQxbwE);
				if (VnuqyoyE.find())
					VwJQxbwE = VnuqyoyE.replaceAll("");
				VnuqyoyE = normalizePattern.matcher(VwJQxbwE);
				if (VnuqyoyE.find())
					VwJQxbwE = VnuqyoyE.replaceAll("\n )");
				Statement tK8YfSuS = Rn8Wq7PS.createStatement();
				tK8YfSuS.execute(VwJQxbwE);
				if (logger.isDebugEnabled())
					logger.debug("table '" + getDestination() + "' created!");
			} else if (logger.isDebugEnabled())
				logger.debug("table '" + getDestination() + "' already exists");
			long H1JqL1KJ = 0L;
			QDJrtKDJ = Rn8Wq7PS.prepareStatement("select count(*) from " + origin);
			cSqssi64 = QDJrtKDJ.executeQuery();
			if (cSqssi64.next())
				H1JqL1KJ = cSqssi64.getLong(1);
			cSqssi64.close();
			QDJrtKDJ.close();
			if (logger.isInfoEnabled())
				logger.info("found " + H1JqL1KJ + " record");
			QDJrtKDJ = Rn8Wq7PS.prepareStatement("select max(d_insDate) from " + destination);
			cSqssi64 = QDJrtKDJ.executeQuery();
			Date I9yWmtFh = null;
			if (cSqssi64.next())
				I9yWmtFh = cSqssi64.getTimestamp(1);
			cSqssi64.close();
			QDJrtKDJ.close();
			SimpleDateFormat EwojKjBV = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String AhS3rscr = null;
			if (I9yWmtFh != null)
				AhS3rscr = EwojKjBV.format(I9yWmtFh);
			if (logger.isInfoEnabled())
				logger.info("last record date:" + AhS3rscr);
			if (H1JqL1KJ > 0) {
				Rn8Wq7PS.setAutoCommit(false);
				if (I9yWmtFh != null && AhS3rscr != null) {
					QDJrtKDJ = Rn8Wq7PS.prepareStatement("INSERT INTO " + destination + " SELECT * FROM " + origin
							+ " WHERE d_insDate > '" + AhS3rscr + "'");
					if (logger.isDebugEnabled())
						logger.debug("Query: INSERT INTO " + destination + " SELECT * FROM " + origin
								+ " WHERE d_insDate > '" + AhS3rscr + "'");
				} else {
					QDJrtKDJ = Rn8Wq7PS.prepareStatement("INSERT INTO " + destination + " SELECT * FROM " + origin);
					if (logger.isDebugEnabled())
						logger.debug("Query: INSERT INTO " + destination + " SELECT * FROM " + origin);
				}
				int cvnbyhSC = QDJrtKDJ.executeUpdate();
				QDJrtKDJ.close();
				if (logger.isInfoEnabled())
					logger.info(" > " + cvnbyhSC + " rows aggregated");
				Rn8Wq7PS.commit();
			} else if (logger.isInfoEnabled())
				logger.info("no aggregation need");
			if (logger.isInfoEnabled())
				logger.info("aggregate table " + origin + " end");
		} catch (SQLException h8w4ED25) {
			logger.error(h8w4ED25, h8w4ED25);
			if (applicationContext != null)
				applicationContext.publishEvent(new TrapEvent(this, "dbcon",
						"Errore SQL durante l'aggregazione dei dati della tabella " + origin, h8w4ED25));
			try {
				Rn8Wq7PS.rollback();
			} catch (SQLException uDeO71Wy) {
			}
		} catch (Throwable fGhHZzg7) {
			logger.error(fGhHZzg7, fGhHZzg7);
			if (applicationContext != null)
				applicationContext.publishEvent(new TrapEvent(this, "generic",
						"Errore generico durante l'aggregazione dei dati della tabella " + origin, fGhHZzg7));
			try {
				Rn8Wq7PS.rollback();
			} catch (SQLException d0bODXaM) {
			}
		} finally {
			try {
				if (QDJrtKDJ != null)
					QDJrtKDJ.close();
			} catch (SQLException VlAOOszU) {
			}
			try {
				if (Rn8Wq7PS != null)
					Rn8Wq7PS.close();
			} catch (SQLException I5PEJ91v) {
			}
		}
	}

}