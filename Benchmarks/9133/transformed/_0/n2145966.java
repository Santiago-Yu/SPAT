class n2145966 {
	private static Long getNextPkValueForEntityIncreaseBy(String XGkkjhOY, int jkWJ2CSM, int rHELzqqj) {
		if (rHELzqqj < 1)
			rHELzqqj = 1;
		String jOYJStyR = "where eoentity_name = '" + XGkkjhOY + "'";
		ERXJDBCConnectionBroker wd7HGFQb = ERXJDBCConnectionBroker.connectionBrokerForEntityNamed(XGkkjhOY);
		Connection C94N2lg2 = wd7HGFQb.getConnection();
		try {
			try {
				C94N2lg2.setAutoCommit(false);
				C94N2lg2.setReadOnly(false);
			} catch (SQLException SJ7o1hR2) {
				log.error(SJ7o1hR2, SJ7o1hR2);
			}
			for (int PddrLEyP = 0; PddrLEyP < jkWJ2CSM; PddrLEyP++) {
				try {
					ResultSet FoplbSHy = C94N2lg2.createStatement()
							.executeQuery("select pk_value from pk_table " + jOYJStyR);
					C94N2lg2.commit();
					boolean ifdhrbxJ = FoplbSHy.next();
					long eXecCcGx = 1;
					if (ifdhrbxJ) {
						eXecCcGx = FoplbSHy.getLong("pk_value");
						C94N2lg2.createStatement().executeUpdate(
								"update pk_table set pk_value = " + (eXecCcGx + rHELzqqj) + " " + jOYJStyR);
					} else {
						eXecCcGx = maxIdFromTable(XGkkjhOY);
						C94N2lg2.createStatement()
								.executeUpdate("insert into pk_table (eoentity_name, pk_value) values ('" + XGkkjhOY
										+ "', " + (eXecCcGx + rHELzqqj) + ")");
					}
					C94N2lg2.commit();
					return new Long(eXecCcGx);
				} catch (SQLException J07uQTcL) {
					String fsSDqCVk = J07uQTcL.getMessage().toLowerCase();
					boolean ofE16Ur6 = (fsSDqCVk.indexOf("error code 116") != -1);
					ofE16Ur6 |= (fsSDqCVk.indexOf("pk_table") != -1 && fsSDqCVk.indexOf("does not exist") != -1);
					ofE16Ur6 |= fsSDqCVk.indexOf("ora-00942") != -1;
					if (ofE16Ur6) {
						try {
							C94N2lg2.rollback();
							log.info("creating pk table");
							C94N2lg2.createStatement().executeUpdate(
									"create table pk_table (eoentity_name varchar(100) not null, pk_value integer)");
							C94N2lg2.createStatement()
									.executeUpdate("alter table pk_table add primary key (eoentity_name)");
							C94N2lg2.commit();
						} catch (SQLException PxKxUkJe) {
							throw new NSForwardException(PxKxUkJe, "could not create pk table");
						}
					} else {
						throw new NSForwardException(J07uQTcL, "Error fetching PK");
					}
				}
			}
		} finally {
			wd7HGFQb.freeConnection(C94N2lg2);
		}
		throw new IllegalStateException("Couldn't get PK");
	}

}