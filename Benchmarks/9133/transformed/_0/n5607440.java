class n5607440 {
	public void updateShoppingBean(String Hocpz7rv) {
		Connection yYXQfdGI = null;
		PreparedStatement zbdZ8tkx = null;
		PreparedStatement lS153mpK = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			yYXQfdGI = DriverManager.getConnection(this.jdbcURL);
			yYXQfdGI.setAutoCommit(false);
			String NsjekzRC = "INSERT INTO dbComputerShopping.order(name,product_id,quantity,date,status)VALUES(?,?,?,?,?)";
			zbdZ8tkx = yYXQfdGI.prepareStatement(NsjekzRC);
			Date jo5KzmPl = new Date();
			SimpleDateFormat mJSttsGx = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String pWWhp24I = mJSttsGx.format(jo5KzmPl);
			Iterator RUjoY4JG = this.cart.iterator();
			Object[] mCP0ECxC = null;
			while (RUjoY4JG.hasNext()) {
				mCP0ECxC = (Object[]) RUjoY4JG.next();
				ProductBean qTOCCgja = (ProductBean) mCP0ECxC[0];
				int BawkN0ji = (Integer) mCP0ECxC[1];
				zbdZ8tkx.setString(1, Hocpz7rv);
				zbdZ8tkx.setInt(2, qTOCCgja.getId());
				zbdZ8tkx.setInt(3, BawkN0ji);
				zbdZ8tkx.setString(4, pWWhp24I);
				zbdZ8tkx.setString(5, "confirmed");
				zbdZ8tkx.executeUpdate();
			}
			Object[] dETduQpp = null;
			NsjekzRC = "UPDATE components SET quantity=quantity-? WHERE comp_id=?";
			lS153mpK = yYXQfdGI.prepareStatement(NsjekzRC);
			for (Iterator d1J8TPB7 = this.cart.iterator(); d1J8TPB7.hasNext();) {
				dETduQpp = (Object[]) d1J8TPB7.next();
				ProductBean FzPIC1wz = (ProductBean) dETduQpp[0];
				int dIfIFXjK = (Integer) dETduQpp[1];
				ProductListBean VvizGNb5 = new ProductListBean(jdbcURL);
				ArrayList b5At6sgv = VvizGNb5.getComponents(FzPIC1wz.getId());
				for (Iterator KJucGV6R = b5At6sgv.iterator(); KJucGV6R.hasNext();) {
					ComponentBean hvVQhdLu = (ComponentBean) KJucGV6R.next();
					lS153mpK.setInt(1, dIfIFXjK);
					lS153mpK.setInt(2, hvVQhdLu.getId());
					lS153mpK.executeUpdate();
				}
			}
			yYXQfdGI.commit();
		} catch (Exception zetY0TVV) {
			try {
				yYXQfdGI.rollback();
			} catch (SQLException TTzBFxcv) {
			}
		} finally {
			try {
				yYXQfdGI.close();
			} catch (SQLException KIlteclh) {
			}
			try {
				zbdZ8tkx.close();
			} catch (SQLException BWUFHaII) {
			}
			try {
				lS153mpK.close();
			} catch (SQLException wExhPZpl) {
			}
		}
	}

}