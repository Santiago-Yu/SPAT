class n20856551 {
	public synchronized void checkout() throws SQLException, InterruptedException {
		Connection OLrwHMjt = this.session.open();
		OLrwHMjt.setAutoCommit(false);
		String d0S0B6Jk = DB2SQLStatements.shopping_cart_getAll(this.customer_id);
		Statement kMZ76TzP = OLrwHMjt.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet j0hhPI0A = kMZ76TzP.executeQuery(d0S0B6Jk);
		j0hhPI0A.last();
		int KmjEkiSK = j0hhPI0A.getRow();
		j0hhPI0A.beforeFirst();
		ShoppingCartItem[] paCeDRW7 = new ShoppingCartItem[KmjEkiSK];
		int InB0UfY0 = 0;
		while (j0hhPI0A.next()) {
			paCeDRW7[InB0UfY0] = new ShoppingCartItem();
			paCeDRW7[InB0UfY0].setCustomer_id(j0hhPI0A.getInt("customer_id"));
			paCeDRW7[InB0UfY0].setDate_start(j0hhPI0A.getDate("date_start"));
			paCeDRW7[InB0UfY0].setDate_stop(j0hhPI0A.getDate("date_stop"));
			paCeDRW7[InB0UfY0].setRoom_type_id(j0hhPI0A.getInt("room_type_id"));
			paCeDRW7[InB0UfY0].setNumtaken(j0hhPI0A.getInt("numtaken"));
			paCeDRW7[InB0UfY0].setTotal_price(j0hhPI0A.getInt("total_price"));
			InB0UfY0++;
		}
		this.wait(4000);
		try {
			for (int vCtKLbY5 = 0; vCtKLbY5 < KmjEkiSK; vCtKLbY5++) {
				d0S0B6Jk = DB2SQLStatements.room_date_update(paCeDRW7[vCtKLbY5]);
				kMZ76TzP = OLrwHMjt.createStatement();
				kMZ76TzP.executeUpdate(d0S0B6Jk);
			}
		} catch (SQLException enYJi1wy) {
			enYJi1wy.printStackTrace();
			OLrwHMjt.rollback();
		}
		for (int DRHnCjFD = 0; DRHnCjFD < KmjEkiSK; DRHnCjFD++) {
			System.out.println(DRHnCjFD);
			d0S0B6Jk = DB2SQLStatements.booked_insert(paCeDRW7[DRHnCjFD], 2);
			kMZ76TzP = OLrwHMjt.createStatement();
			kMZ76TzP.executeUpdate(d0S0B6Jk);
		}
		d0S0B6Jk = DB2SQLStatements.shopping_cart_deleteAll(this.customer_id);
		kMZ76TzP = OLrwHMjt.createStatement();
		kMZ76TzP.executeUpdate(d0S0B6Jk);
		OLrwHMjt.commit();
		this.session.close(OLrwHMjt);
	}

}