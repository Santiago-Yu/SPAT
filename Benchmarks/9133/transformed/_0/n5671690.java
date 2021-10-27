class n5671690 {
	@Override
	public void backup() {
		Connection YHrP3dUD = null;
		PreparedStatement n4k5K1n2 = null;
		try {
			if (logger.isInfoEnabled())
				logger.info("backup table " + getOrigin() + " start...");
			Class.forName(driver);
			YHrP3dUD = DriverManager.getConnection(url, username, password);
			String nVzwiZVQ = "";
			n4k5K1n2 = YHrP3dUD.prepareStatement("show tables from " + schema + " like '" + getDestination() + "';");
			ResultSet Jqw4JuLP = n4k5K1n2.executeQuery();
			if (Jqw4JuLP.next())
				nVzwiZVQ = Jqw4JuLP.getString(1);
			Jqw4JuLP.close();
			n4k5K1n2.close();
			if (StringUtils.isBlank(nVzwiZVQ)) {
				String oRevZH00 = "";
				n4k5K1n2 = YHrP3dUD.prepareStatement("show create table " + getOrigin() + ";");
				Jqw4JuLP = n4k5K1n2.executeQuery();
				if (Jqw4JuLP.next())
					oRevZH00 = Jqw4JuLP.getString(2);
				Jqw4JuLP.close();
				n4k5K1n2.close();
				oRevZH00 = oRevZH00.replaceAll("`" + getOrigin() + "`", "`" + getDestination() + "`");
				oRevZH00 = oRevZH00.replaceAll("auto_increment", "");
				oRevZH00 = oRevZH00.replaceAll("AUTO_INCREMENT", "");
				Matcher u1gYpPfx = stripRelationTablePattern.matcher(oRevZH00);
				if (u1gYpPfx.find())
					oRevZH00 = u1gYpPfx.replaceAll("");
				u1gYpPfx = normalizePattern.matcher(oRevZH00);
				if (u1gYpPfx.find())
					oRevZH00 = u1gYpPfx.replaceAll("\n )");
				Statement eh43E1uI = YHrP3dUD.createStatement();
				eh43E1uI.execute(oRevZH00);
				if (logger.isDebugEnabled())
					logger.debug("table '" + getDestination() + "' created!");
			} else if (logger.isDebugEnabled())
				logger.debug("table '" + getDestination() + "' already exists");
			Date yamByomJ = new Date();
			yamByomJ.setTime(TimeUtil.addHours(yamByomJ, -getHours()).getTimeInMillis());
			yamByomJ.setTime(TimeUtil.getTodayAtMidnight().getTimeInMillis());
			if (logger.isInfoEnabled())
				logger.info("backuping records before: " + yamByomJ);
			long I3Fo5qDz = 0L;
			n4k5K1n2 = YHrP3dUD
					.prepareStatement("select count(*) from " + getOrigin() + " where " + getCondition() + "");
			java.sql.Date OzGrIXun = new java.sql.Date(yamByomJ.getTime());
			n4k5K1n2.setDate(1, OzGrIXun);
			Jqw4JuLP = n4k5K1n2.executeQuery();
			if (Jqw4JuLP.next())
				I3Fo5qDz = Jqw4JuLP.getLong(1);
			Jqw4JuLP.close();
			n4k5K1n2.close();
			if (I3Fo5qDz > 0) {
				YHrP3dUD.setAutoCommit(false);
				n4k5K1n2 = YHrP3dUD.prepareStatement("INSERT INTO " + getDestination() + " SELECT * FROM " + getOrigin()
						+ " WHERE " + getCondition());
				n4k5K1n2.setDate(1, OzGrIXun);
				int V49xcjQv = n4k5K1n2.executeUpdate();
				n4k5K1n2.close();
				if (logger.isInfoEnabled())
					logger.info(V49xcjQv + " rows backupped");
				n4k5K1n2 = YHrP3dUD.prepareStatement("DELETE FROM " + getOrigin() + " WHERE " + getCondition());
				n4k5K1n2.setDate(1, OzGrIXun);
				V49xcjQv = n4k5K1n2.executeUpdate();
				n4k5K1n2.close();
				YHrP3dUD.commit();
				if (logger.isInfoEnabled())
					logger.info(V49xcjQv + " rows deleted");
			} else if (logger.isInfoEnabled())
				logger.info("no backup need");
			if (logger.isInfoEnabled())
				logger.info("backup table " + getOrigin() + " end");
		} catch (SQLException kpADSkvv) {
			logger.error(kpADSkvv, kpADSkvv);
			if (applicationContext != null)
				applicationContext.publishEvent(new TrapEvent(this, "dbcon",
						"Errore SQL durante il backup dei dati della tabella " + getOrigin(), kpADSkvv));
			try {
				YHrP3dUD.rollback();
			} catch (SQLException XKjKNa2M) {
			}
		} catch (Throwable NfjMJdnw) {
			logger.error(NfjMJdnw, NfjMJdnw);
			if (applicationContext != null)
				applicationContext.publishEvent(new TrapEvent(this, "generic",
						"Errore generico durante il backup dei dati della tabella " + getOrigin(), NfjMJdnw));
			try {
				YHrP3dUD.rollback();
			} catch (SQLException wkgXWG3G) {
			}
		} finally {
			try {
				if (n4k5K1n2 != null)
					n4k5K1n2.close();
			} catch (SQLException bhF1U7Xk) {
			}
			try {
				if (YHrP3dUD != null)
					YHrP3dUD.close();
			} catch (SQLException pNge4GC3) {
			}
		}
	}

}