class n2860973 {
	public void executeQuery(Connection JPklHrmp, String O13squn6) {
		action = null;
		updateCount = 0;
		resultsAvailable = false;
		metaAvailable = false;
		planAvailable = false;
		if (JPklHrmp == null) {
			ide.setStatus("not connected");
			return;
		}
		cleanUp();
		try {
			ide.setStatus("Executing query");
			stmt = JPklHrmp.createStatement();
			if (O13squn6.toLowerCase().startsWith("select")) {
				result = stmt.executeQuery(O13squn6);
				resultsAvailable = true;
				action = "select";
			} else if (O13squn6.toLowerCase().startsWith("update")) {
				updateCount = stmt.executeUpdate(O13squn6);
				action = "update";
			} else if (O13squn6.toLowerCase().startsWith("delete")) {
				updateCount = stmt.executeUpdate(O13squn6);
				action = "delete";
			} else if (O13squn6.toLowerCase().startsWith("insert")) {
				updateCount = stmt.executeUpdate(O13squn6);
				action = "insert";
			} else if (O13squn6.toLowerCase().startsWith("commit")) {
				JPklHrmp.commit();
				action = "commit";
			} else if (O13squn6.toLowerCase().startsWith("rollback")) {
				JPklHrmp.rollback();
				action = "rollback";
			} else if (O13squn6.toLowerCase().startsWith("create")) {
				updateCount = stmt.executeUpdate(O13squn6);
				action = "create";
			} else if (O13squn6.toLowerCase().startsWith("drop")) {
				updateCount = stmt.executeUpdate(O13squn6);
				action = "drop";
			} else if (O13squn6.toLowerCase().startsWith("desc ")) {
				String JThUT4uG = O13squn6.substring(O13squn6.indexOf(' '), O13squn6.length());
				O13squn6 = "select * from (" + JThUT4uG + ") where rownum < 1";
				descQuery(JPklHrmp, O13squn6);
			} else if (O13squn6.toLowerCase().startsWith("explain plan for ")) {
				explainQuery(JPklHrmp, O13squn6);
			} else {
				result = stmt.executeQuery(O13squn6);
				resultsAvailable = true;
				action = "select";
			}
			ide.setStatus("executed query");
		} catch (Exception v6ubgje7) {
			ide.setStatus(v6ubgje7.getMessage());
		}
	}

}