class n693631 {
	public static void adminUpdate(int P2EEWyvB, double BFgDZTcM, String xYAimWxO, String XsBZng5E) {
		Connection J7bcRUl1 = null;
		try {
			tmpAdmin++;
			String akVpzcrF = "$tmp_admin" + tmpAdmin;
			J7bcRUl1 = getConnection();
			PreparedStatement s43VUuxl = J7bcRUl1.prepareStatement("CREATE TEMPORARY TABLE " + akVpzcrF
					+ " TYPE=HEAP SELECT o_id FROM orders ORDER BY o_date DESC LIMIT 10000");
			s43VUuxl.executeUpdate();
			s43VUuxl.close();
			PreparedStatement UsM2bWxW = J7bcRUl1.prepareStatement(
					"SELECT ol2.ol_i_id, SUM(ol2.ol_qty) AS sum_ol FROM order_line ol, order_line ol2, " + akVpzcrF
							+ " t "
							+ "WHERE ol.ol_o_id = t.o_id AND ol.ol_i_id = ? AND ol2.ol_o_id = t.o_id AND ol2.ol_i_id <> ? "
							+ "GROUP BY ol2.ol_i_id ORDER BY sum_ol DESC LIMIT 0,5");
			UsM2bWxW.setInt(1, P2EEWyvB);
			UsM2bWxW.setInt(2, P2EEWyvB);
			ResultSet O3EEMyBU = UsM2bWxW.executeQuery();
			int[] TaQElYDJ = new int[5];
			int giKnxdIP = 0;
			int onTiQiAr = 0;
			while (O3EEMyBU.next()) {
				onTiQiAr = O3EEMyBU.getInt(1);
				TaQElYDJ[giKnxdIP] = onTiQiAr;
				giKnxdIP++;
			}
			for (int rjTn4tuu = giKnxdIP; rjTn4tuu < 5; rjTn4tuu++) {
				onTiQiAr++;
				TaQElYDJ[rjTn4tuu] = onTiQiAr;
			}
			O3EEMyBU.close();
			UsM2bWxW.close();
			PreparedStatement G6LzDwR5 = J7bcRUl1.prepareStatement("DROP TABLE " + akVpzcrF);
			G6LzDwR5.executeUpdate();
			G6LzDwR5.close();
			PreparedStatement QPtsWX7L = J7bcRUl1.prepareStatement(
					"UPDATE item SET i_cost = ?, i_image = ?, i_thumbnail = ?, i_pub_date = CURRENT_DATE(), "
							+ " i_related1 = ?, i_related2 = ?, i_related3 = ?, i_related4 = ?, i_related5 = ? WHERE i_id = ?");
			QPtsWX7L.setDouble(1, BFgDZTcM);
			QPtsWX7L.setString(2, xYAimWxO);
			QPtsWX7L.setString(3, XsBZng5E);
			QPtsWX7L.setInt(4, TaQElYDJ[0]);
			QPtsWX7L.setInt(5, TaQElYDJ[1]);
			QPtsWX7L.setInt(6, TaQElYDJ[2]);
			QPtsWX7L.setInt(7, TaQElYDJ[3]);
			QPtsWX7L.setInt(8, TaQElYDJ[4]);
			QPtsWX7L.setInt(9, P2EEWyvB);
			QPtsWX7L.executeUpdate();
			J7bcRUl1.commit();
			QPtsWX7L.close();
			returnConnection(J7bcRUl1);
		} catch (java.lang.Exception biaXEpab) {
			try {
				J7bcRUl1.rollback();
				biaXEpab.printStackTrace();
			} catch (Exception b9w6TP5b) {
				System.err.println("Transaction rollback failed.");
			}
		}
	}

}