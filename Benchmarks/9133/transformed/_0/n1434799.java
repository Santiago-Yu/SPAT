class n1434799 {
	public int executeBatch(String[] sFERW7Mq, String D2qKj6ac) throws Exception {
		Statement pa8Vb8M7 = null;
		int wamb5RSw = 0;
		int GaaFURWf = 0;
		Connection p9GiXnwi = null;
		try {
			p9GiXnwi = getConnection(D2qKj6ac);
			p9GiXnwi.setAutoCommit(false);
			pa8Vb8M7 = p9GiXnwi.createStatement();
			for (int WhTyiitP = 0; WhTyiitP < sFERW7Mq.length; WhTyiitP++) {
				String M0AZcb4c = sFERW7Mq[WhTyiitP];
				if (M0AZcb4c.trim().length() == 0) {
					continue;
				}
				GaaFURWf++;
				try {
					log.info("executing SQL: " + M0AZcb4c);
					int eaqflG8m = pa8Vb8M7.executeUpdate(M0AZcb4c);
					log.info("After execution, " + eaqflG8m + " row(s) have been changed");
				} catch (SQLException dqhl2U7N) {
					throw dqhl2U7N;
				}
			}
			p9GiXnwi.commit();
			log.info("Executed " + GaaFURWf + " SQL command(s) with " + wamb5RSw + " error(s)");
		} catch (SQLException l4svDHaC) {
			if (p9GiXnwi != null) {
				p9GiXnwi.rollback();
			}
			throw l4svDHaC;
		} catch (Exception rsh5uUfK) {
			if (p9GiXnwi != null) {
				p9GiXnwi.rollback();
			}
			throw rsh5uUfK;
		} finally {
			pa8Vb8M7.close();
		}
		return wamb5RSw;
	}

}