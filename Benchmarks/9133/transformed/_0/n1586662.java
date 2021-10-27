class n1586662 {
	int doOne(int D03o0bCj, int BtM84ZCz, int fSXdxTVi, int GXjcf1YF) {
		int bdb8UcaN = 0;
		if (Conn == null) {
			bench.incrementFailedTransactionCount();
			return 0;
		}
		try {
			if (Benchmark.prepared_stmt) {
				pstmt1.setInt(1, GXjcf1YF);
				pstmt1.setInt(2, fSXdxTVi);
				pstmt1.executeUpdate();
				pstmt1.clearWarnings();
				pstmt2.setInt(1, fSXdxTVi);
				ResultSet RtAoq5bp = pstmt2.executeQuery();
				pstmt2.clearWarnings();
				while (RtAoq5bp.next()) {
					bdb8UcaN = RtAoq5bp.getInt(1);
				}
				pstmt3.setInt(1, GXjcf1YF);
				pstmt3.setInt(2, BtM84ZCz);
				pstmt3.executeUpdate();
				pstmt3.clearWarnings();
				pstmt4.setInt(1, GXjcf1YF);
				pstmt4.setInt(2, D03o0bCj);
				pstmt4.executeUpdate();
				pstmt4.clearWarnings();
				pstmt5.setInt(1, BtM84ZCz);
				pstmt5.setInt(2, D03o0bCj);
				pstmt5.setInt(3, fSXdxTVi);
				pstmt5.setInt(4, GXjcf1YF);
				pstmt5.executeUpdate();
				pstmt5.clearWarnings();
			} else {
				Statement G6vlqz7A = Conn.createStatement();
				String k1TjVSq6 = "UPDATE accounts";
				k1TjVSq6 += " SET Abalance = Abalance + " + GXjcf1YF;
				k1TjVSq6 += " WHERE Aid = " + fSXdxTVi;
				int iyhq4xma = G6vlqz7A.executeUpdate(k1TjVSq6);
				G6vlqz7A.clearWarnings();
				k1TjVSq6 = "SELECT Abalance";
				k1TjVSq6 += " FROM accounts";
				k1TjVSq6 += " WHERE Aid = " + fSXdxTVi;
				ResultSet uNjsr6sF = G6vlqz7A.executeQuery(k1TjVSq6);
				G6vlqz7A.clearWarnings();
				while (uNjsr6sF.next()) {
					bdb8UcaN = uNjsr6sF.getInt(1);
				}
				k1TjVSq6 = "UPDATE tellers";
				k1TjVSq6 += " SET Tbalance = Tbalance + " + GXjcf1YF;
				k1TjVSq6 += " WHERE Tid = " + BtM84ZCz;
				G6vlqz7A.executeUpdate(k1TjVSq6);
				G6vlqz7A.clearWarnings();
				k1TjVSq6 = "UPDATE branches";
				k1TjVSq6 += " SET Bbalance = Bbalance + " + GXjcf1YF;
				k1TjVSq6 += " WHERE Bid = " + D03o0bCj;
				G6vlqz7A.executeUpdate(k1TjVSq6);
				G6vlqz7A.clearWarnings();
				k1TjVSq6 = "INSERT INTO history(Tid, Bid, Aid, delta)";
				k1TjVSq6 += " VALUES (";
				k1TjVSq6 += BtM84ZCz + ",";
				k1TjVSq6 += D03o0bCj + ",";
				k1TjVSq6 += fSXdxTVi + ",";
				k1TjVSq6 += GXjcf1YF + ")";
				G6vlqz7A.executeUpdate(k1TjVSq6);
				G6vlqz7A.clearWarnings();
				G6vlqz7A.close();
			}
			if (Benchmark.transactions) {
				Conn.commit();
			}
			return bdb8UcaN;
		} catch (java.lang.Exception n3HWgExE) {
			if (Benchmark.verbose) {
				System.out.println("Transaction failed: " + n3HWgExE.getMessage());
				n3HWgExE.printStackTrace();
			}
			bench.incrementFailedTransactionCount();
			if (Benchmark.transactions) {
				try {
					Conn.rollback();
				} catch (SQLException qsNsxr0G) {
				}
			}
		}
		return 0;
	}

}