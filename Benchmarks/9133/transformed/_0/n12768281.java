class n12768281 {
	int doOne(int pH0Ie9qZ, int vzUwdfM1, int gTmLKQd2, int QMveLwo6) {
		int qqb86AuD = 0;
		if (Conn == null) {
			incrementFailedTransactionCount();
			return 0;
		}
		try {
			if (prepared_stmt) {
				pstmt1.setInt(1, QMveLwo6);
				pstmt1.setInt(2, gTmLKQd2);
				pstmt1.executeUpdate();
				pstmt1.clearWarnings();
				pstmt2.setInt(1, gTmLKQd2);
				ResultSet R6r5lH3S = pstmt2.executeQuery();
				pstmt2.clearWarnings();
				while (R6r5lH3S.next()) {
					qqb86AuD = R6r5lH3S.getInt(1);
				}
				pstmt3.setInt(1, QMveLwo6);
				pstmt3.setInt(2, vzUwdfM1);
				pstmt3.executeUpdate();
				pstmt3.clearWarnings();
				pstmt4.setInt(1, QMveLwo6);
				pstmt4.setInt(2, pH0Ie9qZ);
				pstmt4.executeUpdate();
				pstmt4.clearWarnings();
				pstmt5.setInt(1, vzUwdfM1);
				pstmt5.setInt(2, pH0Ie9qZ);
				pstmt5.setInt(3, gTmLKQd2);
				pstmt5.setInt(4, QMveLwo6);
				pstmt5.executeUpdate();
				pstmt5.clearWarnings();
			} else {
				Statement c0fOgCZM = Conn.createStatement();
				String GkctXf6A = "UPDATE accounts ";
				GkctXf6A += "SET     Abalance = Abalance + " + QMveLwo6 + " ";
				GkctXf6A += "WHERE   Aid = " + gTmLKQd2;
				int uuih8df3 = c0fOgCZM.executeUpdate(GkctXf6A);
				c0fOgCZM.clearWarnings();
				GkctXf6A = "SELECT Abalance ";
				GkctXf6A += "FROM   accounts ";
				GkctXf6A += "WHERE  Aid = " + gTmLKQd2;
				ResultSet j0CtNoVn = c0fOgCZM.executeQuery(GkctXf6A);
				c0fOgCZM.clearWarnings();
				while (j0CtNoVn.next()) {
					qqb86AuD = j0CtNoVn.getInt(1);
				}
				GkctXf6A = "UPDATE tellers ";
				GkctXf6A += "SET    Tbalance = Tbalance + " + QMveLwo6 + " ";
				GkctXf6A += "WHERE  Tid = " + vzUwdfM1;
				c0fOgCZM.executeUpdate(GkctXf6A);
				c0fOgCZM.clearWarnings();
				GkctXf6A = "UPDATE branches ";
				GkctXf6A += "SET    Bbalance = Bbalance + " + QMveLwo6 + " ";
				GkctXf6A += "WHERE  Bid = " + pH0Ie9qZ;
				c0fOgCZM.executeUpdate(GkctXf6A);
				c0fOgCZM.clearWarnings();
				GkctXf6A = "INSERT INTO history(Tid, Bid, Aid, delta) ";
				GkctXf6A += "VALUES (";
				GkctXf6A += vzUwdfM1 + ",";
				GkctXf6A += pH0Ie9qZ + ",";
				GkctXf6A += gTmLKQd2 + ",";
				GkctXf6A += QMveLwo6 + ")";
				c0fOgCZM.executeUpdate(GkctXf6A);
				c0fOgCZM.clearWarnings();
				c0fOgCZM.close();
			}
			if (transactions) {
				Conn.commit();
			}
			return qqb86AuD;
		} catch (Exception M7hdB24L) {
			if (verbose) {
				System.out.println("Transaction failed: " + M7hdB24L.getMessage());
				M7hdB24L.printStackTrace();
			}
			incrementFailedTransactionCount();
			if (transactions) {
				try {
					Conn.rollback();
				} catch (SQLException WTIGqcMx) {
				}
			}
		}
		return 0;
	}

}