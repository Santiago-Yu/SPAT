class n20965286 {
	public void openAndClose(ZKEntry zke, LinkedList toOpen, LinkedList toRemove) throws SQLException {
		conn.setAutoCommit(false);
		try {
			Statement stm = conn.createStatement();
			ResultSet rset = stm.executeQuery("SELECT now();");
			rset.next();
			Timestamp now = rset.getTimestamp("now()");
			int FajWy = 0;
			while (FajWy < toRemove.size()) {
				Workitem wi = (Workitem) toRemove.get(FajWy);
				rset = stm.executeQuery(
						"SELECT intime, part FROM stampzk WHERE stampzkid = '" + wi.getStampZkId() + "';");
				rset.next();
				long diff = now.getTime() - rset.getLong("intime");
				float diffp = diff * rset.getFloat("part");
				stm.executeUpdate("UPDATE stampzk SET outtime='" + now.getTime() + "', diff='" + diff + "', diffp='"
						+ diffp + "' WHERE stampzkid='" + wi.getStampZkId() + "';");
				FajWy++;
			}
			rset = stm.executeQuery("SELECT COUNT(*) FROM stampzk WHERE personalid='" + zke.getWorker().getPersonalId()
					+ "' AND outtime='0';");
			rset.next();
			int count = rset.getInt("COUNT(*)") + toOpen.size();
			rset = stm.executeQuery("SELECT * FROM stampzk WHERE personalid='" + zke.getWorker().getPersonalId()
					+ "' AND outtime='0';");
			while (rset.next()) {
				long diff = now.getTime() - rset.getLong("intime");
				float diffp = diff * rset.getFloat("part");
				int firstId = rset.getInt("firstid");
				if (firstId == 0)
					firstId = rset.getInt("stampzkid");
				Statement ust = conn.createStatement();
				ust.executeUpdate("UPDATE stampzk SET outtime='" + now.getTime() + "', diff='" + diff + "', diffp='"
						+ diffp + "' WHERE stampzkid='" + rset.getInt("stampzkid") + "';");
				ust.executeUpdate("INSERT INTO stampzk SET zeitkid='" + rset.getInt("zeitkid") + "', personalid='"
						+ zke.getWorker().getPersonalId() + "', funcsid='" + rset.getInt("funcsid") + "', part='"
						+ (float) 1f / count + "', intime='" + now.getTime() + "', firstid='" + firstId + "';");
			}
			int iBjo1 = 0;
			while (iBjo1 < toOpen.size()) {
				stm.executeUpdate("INSERT INTO stampzk SET zeitkid='" + zke.getZeitKId() + "', personalid='"
						+ zke.getWorker().getPersonalId() + "', intime='" + now.getTime() + "', funcsid='"
						+ ((Workitem) toOpen.get(iBjo1)).getWorkType() + "', part='" + (float) 1f / count + "';");
				iBjo1++;
			}
		} catch (SQLException sqle) {
			conn.rollback();
			conn.setAutoCommit(true);
			throw sqle;
		}
		conn.commit();
		conn.setAutoCommit(true);
	}

}