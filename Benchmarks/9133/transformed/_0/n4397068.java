class n4397068 {
	protected synchronized Long putModel(String k4UgkBS1, String DcIZBR7P, String pKNCPWmg, TupleBinding UNa5Ndhe,
			LocatableModel JRggow76) {
		try {
			if (JRggow76.getId() != null && !"".equals(JRggow76.getId())) {
				ps7.setInt(1, Integer.parseInt(JRggow76.getId()));
				ps7.execute();
				ps6.setInt(1, Integer.parseInt(JRggow76.getId()));
				ps6.execute();
			}
			if (persistenceMethod == PostgreSQLStore.BYTEA) {
				ps1.setString(1, JRggow76.getContig());
				ps1.setInt(2, JRggow76.getStartPosition());
				ps1.setInt(3, JRggow76.getStopPosition());
				ps1.setString(4, pKNCPWmg);
				DatabaseEntry UaZQMUN3 = new DatabaseEntry();
				UNa5Ndhe.objectToEntry(JRggow76, UaZQMUN3);
				ps1.setBytes(5, UaZQMUN3.getData());
				ps1.executeUpdate();
			} else if (persistenceMethod == PostgreSQLStore.OID || persistenceMethod == PostgreSQLStore.FIELDS) {
				ps1b.setString(1, JRggow76.getContig());
				ps1b.setInt(2, JRggow76.getStartPosition());
				ps1b.setInt(3, JRggow76.getStopPosition());
				ps1b.setString(4, pKNCPWmg);
				DatabaseEntry QbU42uWu = new DatabaseEntry();
				UNa5Ndhe.objectToEntry(JRggow76, QbU42uWu);
				int X76Kq5Yp = lobj.create(LargeObjectManager.READ | LargeObjectManager.WRITE);
				LargeObject TRv7Fiax = lobj.open(X76Kq5Yp, LargeObjectManager.WRITE);
				TRv7Fiax.write(QbU42uWu.getData());
				TRv7Fiax.close();
				ps1b.setInt(5, X76Kq5Yp);
				ps1b.executeUpdate();
			}
			ResultSet eA4wpD7u = null;
			PreparedStatement RZlEB3uD = conn
					.prepareStatement("select currval('" + k4UgkBS1 + "_" + k4UgkBS1 + "_id_seq')");
			eA4wpD7u = RZlEB3uD.executeQuery();
			int K9x3EdSA = -1;
			if (eA4wpD7u != null) {
				if (eA4wpD7u.next()) {
					K9x3EdSA = eA4wpD7u.getInt(1);
				}
			}
			eA4wpD7u.close();
			RZlEB3uD.close();
			for (String KxV5lga3 : JRggow76.getTags().keySet()) {
				int jCFTdb9U = -1;
				if (tags.get(KxV5lga3) != null) {
					jCFTdb9U = tags.get(KxV5lga3);
				} else {
					ps2.setString(1, KxV5lga3);
					eA4wpD7u = ps2.executeQuery();
					if (eA4wpD7u != null) {
						while (eA4wpD7u.next()) {
							jCFTdb9U = eA4wpD7u.getInt(1);
						}
					}
					eA4wpD7u.close();
				}
				if (jCFTdb9U < 0) {
					ps3.setString(1, KxV5lga3);
					ps3.setString(2, JRggow76.getTags().get(KxV5lga3));
					ps3.executeUpdate();
					eA4wpD7u = ps4.executeQuery();
					if (eA4wpD7u != null) {
						if (eA4wpD7u.next()) {
							jCFTdb9U = eA4wpD7u.getInt(1);
							tags.put(KxV5lga3, jCFTdb9U);
						}
					}
					eA4wpD7u.close();
				}
				ps5.setInt(1, jCFTdb9U);
				ps5.executeUpdate();
			}
			conn.commit();
			return (new Long(K9x3EdSA));
		} catch (SQLException V16rDJ1S) {
			try {
				conn.rollback();
			} catch (SQLException iOTqdy1s) {
				iOTqdy1s.printStackTrace();
			}
			V16rDJ1S.printStackTrace();
			System.err.println(V16rDJ1S.getMessage());
		} catch (Exception WLe41iao) {
			try {
				conn.rollback();
			} catch (SQLException V2a0kyv4) {
				V2a0kyv4.printStackTrace();
			}
			WLe41iao.printStackTrace();
			System.err.println(WLe41iao.getMessage());
		}
		return (null);
	}

}