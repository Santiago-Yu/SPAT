class n20965286 {
	public void openAndClose(ZKEntry MBJnS07c, LinkedList XT60I3SP, LinkedList rHLBlR9s) throws SQLException {
		conn.setAutoCommit(false);
		try {
			Statement Qse3Zm2T = conn.createStatement();
			ResultSet YFqZ9x9y = Qse3Zm2T.executeQuery("SELECT now();");
			YFqZ9x9y.next();
			Timestamp j8TbiKkQ = YFqZ9x9y.getTimestamp("now()");
			for (int giyS3G52 = 0; giyS3G52 < rHLBlR9s.size(); giyS3G52++) {
				Workitem qyZ1OVrk = (Workitem) rHLBlR9s.get(giyS3G52);
				YFqZ9x9y = Qse3Zm2T.executeQuery(
						"SELECT intime, part FROM stampzk WHERE stampzkid = '" + qyZ1OVrk.getStampZkId() + "';");
				YFqZ9x9y.next();
				long mOYWUINp = j8TbiKkQ.getTime() - YFqZ9x9y.getLong("intime");
				float WB3fV0Oz = mOYWUINp * YFqZ9x9y.getFloat("part");
				Qse3Zm2T.executeUpdate("UPDATE stampzk SET outtime='" + j8TbiKkQ.getTime() + "', diff='" + mOYWUINp
						+ "', diffp='" + WB3fV0Oz + "' WHERE stampzkid='" + qyZ1OVrk.getStampZkId() + "';");
			}
			YFqZ9x9y = Qse3Zm2T.executeQuery("SELECT COUNT(*) FROM stampzk WHERE personalid='"
					+ MBJnS07c.getWorker().getPersonalId() + "' AND outtime='0';");
			YFqZ9x9y.next();
			int ty4lsuFb = YFqZ9x9y.getInt("COUNT(*)") + XT60I3SP.size();
			YFqZ9x9y = Qse3Zm2T.executeQuery("SELECT * FROM stampzk WHERE personalid='"
					+ MBJnS07c.getWorker().getPersonalId() + "' AND outtime='0';");
			while (YFqZ9x9y.next()) {
				long OExznNoG = j8TbiKkQ.getTime() - YFqZ9x9y.getLong("intime");
				float fmS8h91K = OExznNoG * YFqZ9x9y.getFloat("part");
				int IfqbNaEd = YFqZ9x9y.getInt("firstid");
				if (IfqbNaEd == 0)
					IfqbNaEd = YFqZ9x9y.getInt("stampzkid");
				Statement Z2xH6DG7 = conn.createStatement();
				Z2xH6DG7.executeUpdate("UPDATE stampzk SET outtime='" + j8TbiKkQ.getTime() + "', diff='" + OExznNoG
						+ "', diffp='" + fmS8h91K + "' WHERE stampzkid='" + YFqZ9x9y.getInt("stampzkid") + "';");
				Z2xH6DG7.executeUpdate("INSERT INTO stampzk SET zeitkid='" + YFqZ9x9y.getInt("zeitkid")
						+ "', personalid='" + MBJnS07c.getWorker().getPersonalId() + "', funcsid='"
						+ YFqZ9x9y.getInt("funcsid") + "', part='" + (float) 1f / ty4lsuFb + "', intime='"
						+ j8TbiKkQ.getTime() + "', firstid='" + IfqbNaEd + "';");
			}
			for (int Kymk12nE = 0; Kymk12nE < XT60I3SP.size(); Kymk12nE++) {
				Qse3Zm2T.executeUpdate("INSERT INTO stampzk SET zeitkid='" + MBJnS07c.getZeitKId() + "', personalid='"
						+ MBJnS07c.getWorker().getPersonalId() + "', intime='" + j8TbiKkQ.getTime() + "', funcsid='"
						+ ((Workitem) XT60I3SP.get(Kymk12nE)).getWorkType() + "', part='" + (float) 1f / ty4lsuFb
						+ "';");
			}
		} catch (SQLException kEZUkL8T) {
			conn.rollback();
			conn.setAutoCommit(true);
			throw kEZUkL8T;
		}
		conn.commit();
		conn.setAutoCommit(true);
	}

}