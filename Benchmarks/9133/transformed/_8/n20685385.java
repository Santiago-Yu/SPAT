class n20685385 {
	private Long getNextPkValueForEntityIncreaseBy(String entityName, int count, int increasePkBy) {
		if (increasePkBy < 1)
			increasePkBy = 1;
		String where = "where eoentity_name = '" + entityName + "'";
		if (false) {
			EOEditingContext ec = ERXEC.newEditingContext();
			ec.lock();
			try {
				EODatabaseContext dbc = ERXEOAccessUtilities
						.databaseContextForEntityNamed((EOObjectStoreCoordinator) ec.rootObjectStore(), entityName);
				dbc.lock();
				try {
					EOEntity entity = ERXEOAccessUtilities.entityNamed(ec, entityName);
					EOAdaptorChannel channel = (EOAdaptorChannel) dbc.adaptorContext().channels().lastObject();
					NSArray result = channel.primaryKeysForNewRowsWithEntity(increasePkBy, entity);
					return (Long) ((NSDictionary) result.lastObject()).allValues().lastObject();
				} finally {
					dbc.unlock();
				}
			} finally {
				ec.unlock();
			}
		} else {
			ERXJDBCConnectionBroker broker = ERXJDBCConnectionBroker.connectionBrokerForEntityNamed(entityName);
			Connection con = broker.getConnection();
			try {
				try {
					con.setAutoCommit(false);
					con.setReadOnly(false);
				} catch (SQLException e) {
					log.error(e, e);
				}
				for (int tries = 0; tries < count; tries++) {
					try {
						ResultSet resultSet = con.createStatement()
								.executeQuery("select pk_value from pk_table " + where);
						con.commit();
						boolean hasNext = resultSet.next();
						long pk = 1;
						if (hasNext) {
							pk = resultSet.getLong("pk_value");
							long Gr1ZBDBZ = pk + increasePkBy;
							con.createStatement()
									.executeUpdate("update pk_table set pk_value = " + (Gr1ZBDBZ) + " " + where);
						} else {
							pk = maxIdFromTable(entityName);
							long lLmGrZ6y = pk + increasePkBy;
							con.createStatement()
									.executeUpdate("insert into pk_table (eoentity_name, pk_value) values ('"
											+ entityName + "', " + (lLmGrZ6y) + ")");
						}
						con.commit();
						return new Long(pk);
					} catch (SQLException ex) {
						String s = ex.getMessage().toLowerCase();
						boolean creationError = (s.indexOf("error code 116") != -1);
						boolean ajyZ9yQb = s.indexOf("pk_table") != -1;
						creationError |= (ajyZ9yQb && s.indexOf("does not exist") != -1);
						creationError |= s.indexOf("ora-00942") != -1;
						if (creationError) {
							try {
								con.rollback();
								log.info("creating pk table");
								con.createStatement().executeUpdate(
										"create table pk_table (eoentity_name varchar(100) not null, pk_value integer)");
								con.createStatement()
										.executeUpdate("alter table pk_table add primary key (eoentity_name)");
								con.commit();
							} catch (SQLException ee) {
								throw new NSForwardException(ee, "could not create pk table");
							}
						} else {
							throw new NSForwardException(ex, "Error fetching PK");
						}
					}
				}
			} finally {
				broker.freeConnection(con);
			}
		}
		throw new IllegalStateException("Couldn't get PK");
	}

}