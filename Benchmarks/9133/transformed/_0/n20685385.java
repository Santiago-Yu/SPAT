class n20685385 {
	private Long getNextPkValueForEntityIncreaseBy(String Ytkddqyd, int I0FUXy7d, int VAw00m42) {
		if (VAw00m42 < 1)
			VAw00m42 = 1;
		String J9Czm0wS = "where eoentity_name = '" + Ytkddqyd + "'";
		if (false) {
			EOEditingContext DEAo7ZB0 = ERXEC.newEditingContext();
			DEAo7ZB0.lock();
			try {
				EODatabaseContext g5PjhPTd = ERXEOAccessUtilities
						.databaseContextForEntityNamed((EOObjectStoreCoordinator) DEAo7ZB0.rootObjectStore(), Ytkddqyd);
				g5PjhPTd.lock();
				try {
					EOEntity WV9dknpq = ERXEOAccessUtilities.entityNamed(DEAo7ZB0, Ytkddqyd);
					EOAdaptorChannel ambP8QZi = (EOAdaptorChannel) g5PjhPTd.adaptorContext().channels().lastObject();
					NSArray YTENQMJS = ambP8QZi.primaryKeysForNewRowsWithEntity(VAw00m42, WV9dknpq);
					return (Long) ((NSDictionary) YTENQMJS.lastObject()).allValues().lastObject();
				} finally {
					g5PjhPTd.unlock();
				}
			} finally {
				DEAo7ZB0.unlock();
			}
		} else {
			ERXJDBCConnectionBroker dehpJkgZ = ERXJDBCConnectionBroker.connectionBrokerForEntityNamed(Ytkddqyd);
			Connection LvPKDfGN = dehpJkgZ.getConnection();
			try {
				try {
					LvPKDfGN.setAutoCommit(false);
					LvPKDfGN.setReadOnly(false);
				} catch (SQLException Tjl0Ve34) {
					log.error(Tjl0Ve34, Tjl0Ve34);
				}
				for (int kI8Br8NG = 0; kI8Br8NG < I0FUXy7d; kI8Br8NG++) {
					try {
						ResultSet wo6gspTc = LvPKDfGN.createStatement()
								.executeQuery("select pk_value from pk_table " + J9Czm0wS);
						LvPKDfGN.commit();
						boolean w7PNF2UO = wo6gspTc.next();
						long lUOGbOGj = 1;
						if (w7PNF2UO) {
							lUOGbOGj = wo6gspTc.getLong("pk_value");
							LvPKDfGN.createStatement().executeUpdate(
									"update pk_table set pk_value = " + (lUOGbOGj + VAw00m42) + " " + J9Czm0wS);
						} else {
							lUOGbOGj = maxIdFromTable(Ytkddqyd);
							LvPKDfGN.createStatement()
									.executeUpdate("insert into pk_table (eoentity_name, pk_value) values ('" + Ytkddqyd
											+ "', " + (lUOGbOGj + VAw00m42) + ")");
						}
						LvPKDfGN.commit();
						return new Long(lUOGbOGj);
					} catch (SQLException ljWYX0Rf) {
						String a8NNO40I = ljWYX0Rf.getMessage().toLowerCase();
						boolean XMnOULSr = (a8NNO40I.indexOf("error code 116") != -1);
						XMnOULSr |= (a8NNO40I.indexOf("pk_table") != -1 && a8NNO40I.indexOf("does not exist") != -1);
						XMnOULSr |= a8NNO40I.indexOf("ora-00942") != -1;
						if (XMnOULSr) {
							try {
								LvPKDfGN.rollback();
								log.info("creating pk table");
								LvPKDfGN.createStatement().executeUpdate(
										"create table pk_table (eoentity_name varchar(100) not null, pk_value integer)");
								LvPKDfGN.createStatement()
										.executeUpdate("alter table pk_table add primary key (eoentity_name)");
								LvPKDfGN.commit();
							} catch (SQLException j0Ts6eKS) {
								throw new NSForwardException(j0Ts6eKS, "could not create pk table");
							}
						} else {
							throw new NSForwardException(ljWYX0Rf, "Error fetching PK");
						}
					}
				}
			} finally {
				dehpJkgZ.freeConnection(LvPKDfGN);
			}
		}
		throw new IllegalStateException("Couldn't get PK");
	}

}