class n5021577 {
	public static boolean copyDataToNewTable(EboContext WFRPsoNH, String Gi5JTeS8, String CSiaf6qt, String K6vIuRGp,
			boolean t0WgfKlI, int DbTKfWWd) throws boRuntimeException {
		Gi5JTeS8 = Gi5JTeS8.toUpperCase();
		CSiaf6qt = CSiaf6qt.toUpperCase();
		Connection pKOZoWsh = null;
		Connection uWbOwEoH = null;
		boolean ZZibhMyB = false;
		try {
			boolean hslR9h0y = false;
			boolean Y129iMws = false;
			final InitialContext KXSybfAq = new InitialContext();
			pKOZoWsh = WFRPsoNH.getConnectionData();
			uWbOwEoH = WFRPsoNH.getConnectionDef();
			PreparedStatement i9rqzVA9 = pKOZoWsh
					.prepareStatement("SELECT TABLE_NAME FROM USER_TABLES WHERE TABLE_NAME=?");
			i9rqzVA9.setString(1, Gi5JTeS8);
			ResultSet vHA3zpGj = i9rqzVA9.executeQuery();
			if (vHA3zpGj.next()) {
				hslR9h0y = true;
			}
			vHA3zpGj.close();
			i9rqzVA9.setString(1, CSiaf6qt);
			vHA3zpGj = i9rqzVA9.executeQuery();
			if (vHA3zpGj.next()) {
				Y129iMws = true;
			}
			if (!Y129iMws) {
				vHA3zpGj.close();
				i9rqzVA9.close();
				i9rqzVA9 = pKOZoWsh.prepareStatement("SELECT VIEW_NAME FROM USER_VIEWS WHERE VIEW_NAME=?");
				i9rqzVA9.setString(1, CSiaf6qt);
				vHA3zpGj = i9rqzVA9.executeQuery();
				if (vHA3zpGj.next()) {
					CallableStatement wYwXfugM = pKOZoWsh.prepareCall("DROP VIEW " + CSiaf6qt);
					wYwXfugM.execute();
					wYwXfugM.close();
				}
			}
			vHA3zpGj.close();
			i9rqzVA9.close();
			if (hslR9h0y && !Y129iMws) {
				if (t0WgfKlI) {
					logger.finest(LoggerMessageLocalizer.getMessage("CREATING_AND_COPY_DATA_FROM") + " [" + Gi5JTeS8
							+ "] " + LoggerMessageLocalizer.getMessage("TO") + " [" + CSiaf6qt + "]");
				}
				CallableStatement k2rVvJ0P = pKOZoWsh
						.prepareCall("CREATE TABLE " + CSiaf6qt + " AS SELECT * FROM " + Gi5JTeS8 + " "
								+ (((K6vIuRGp != null) && (K6vIuRGp.length() > 0)) ? (" WHERE " + K6vIuRGp) : ""));
				k2rVvJ0P.execute();
				k2rVvJ0P.close();
				if (t0WgfKlI) {
					logger.finest(LoggerMessageLocalizer.getMessage("UPDATING_NGTDIC"));
				}
				pKOZoWsh.commit();
				ZZibhMyB = true;
			} else if (hslR9h0y && Y129iMws) {
				if (t0WgfKlI) {
					logger.finest(LoggerMessageLocalizer.getMessage("COPY_DATA_FROM") + " [" + Gi5JTeS8 + "] "
							+ LoggerMessageLocalizer.getMessage("TO") + "  [" + CSiaf6qt + "]");
				}
				PreparedStatement baHAqoE5 = pKOZoWsh
						.prepareStatement("SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ? ");
				baHAqoE5.setString(1, CSiaf6qt);
				ResultSet dllomwvH = baHAqoE5.executeQuery();
				StringBuffer gPHxhdBs = new StringBuffer();
				PreparedStatement Kv98uGeP = pKOZoWsh.prepareStatement(
						"SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ? and COLUMN_NAME=?");
				while (dllomwvH.next()) {
					Kv98uGeP.setString(1, Gi5JTeS8);
					Kv98uGeP.setString(2, dllomwvH.getString(1));
					ResultSet E3OC58wb = Kv98uGeP.executeQuery();
					if (E3OC58wb.next()) {
						if (gPHxhdBs.length() > 0) {
							gPHxhdBs.append(',');
						}
						gPHxhdBs.append('"').append(dllomwvH.getString(1)).append('"');
					}
					E3OC58wb.close();
				}
				Kv98uGeP.close();
				dllomwvH.close();
				baHAqoE5.close();
				CallableStatement oqPvW7Po;
				int kVdFaCWP = 0;
				if ((DbTKfWWd == 0) || (DbTKfWWd == 1)) {
					oqPvW7Po = pKOZoWsh.prepareCall("INSERT INTO " + CSiaf6qt + "( " + gPHxhdBs.toString()
							+ " ) ( SELECT " + gPHxhdBs.toString() + " FROM " + Gi5JTeS8 + " "
							+ (((K6vIuRGp != null) && (K6vIuRGp.length() > 0)) ? (" WHERE " + K6vIuRGp) : "") + ")");
					kVdFaCWP = oqPvW7Po.executeUpdate();
					oqPvW7Po.close();
					if (t0WgfKlI) {
						logger.finest(LoggerMessageLocalizer.getMessage("DONE") + " [" + kVdFaCWP + "] "
								+ LoggerMessageLocalizer.getMessage("RECORDS_COPIED"));
					}
				}
				pKOZoWsh.commit();
				ZZibhMyB = true;
			}
		} catch (Exception lllB48P5) {
			try {
				pKOZoWsh.rollback();
			} catch (Exception LGqZSgor) {
				throw new boRuntimeException("boBuildDB.moveTable", "BO-1304", LGqZSgor);
			}
			throw new boRuntimeException("boBuildDB.moveTable", "BO-1304", lllB48P5);
		} finally {
			try {
				pKOZoWsh.close();
			} catch (Exception YYHPfXkM) {
			}
			try {
				uWbOwEoH.close();
			} catch (Exception hL2e7QTo) {
			}
		}
		return ZZibhMyB;
	}

}