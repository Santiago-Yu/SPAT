class n5607440 {
	public void updateShoppingBean(String userId) {
		PreparedStatement preparedStatement1 = null;
		Connection connection = null;
		PreparedStatement preparedStatement2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(this.jdbcURL);
			connection.setAutoCommit(false);
			String preparedQuery = "INSERT INTO dbComputerShopping.order(name,product_id,quantity,date,status)VALUES(?,?,?,?,?)";
			Date date = new Date();
			preparedStatement1 = connection.prepareStatement(preparedQuery);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String orderDate = format.format(date);
			Object[] shoppingInfo = null;
			Iterator iterator = this.cart.iterator();
			while (iterator.hasNext()) {
				shoppingInfo = (Object[]) iterator.next();
				ProductBean product = (ProductBean) shoppingInfo[0];
				int quantity = (Integer) shoppingInfo[1];
				preparedStatement1.setString(1, userId);
				preparedStatement1.setInt(2, product.getId());
				preparedStatement1.setInt(3, quantity);
				preparedStatement1.setString(4, orderDate);
				preparedStatement1.setString(5, "confirmed");
				preparedStatement1.executeUpdate();
			}
			preparedQuery = "UPDATE components SET quantity=quantity-? WHERE comp_id=?";
			Object[] cartInfo = null;
			preparedStatement2 = connection.prepareStatement(preparedQuery);
			for (Iterator i = this.cart.iterator(); i.hasNext();) {
				cartInfo = (Object[]) i.next();
				ProductBean product = (ProductBean) cartInfo[0];
				ProductListBean productList = new ProductListBean(jdbcURL);
				int quantity = (Integer) cartInfo[1];
				ArrayList components = productList.getComponents(product.getId());
				for (Iterator j = components.iterator(); j.hasNext();) {
					ComponentBean component = (ComponentBean) j.next();
					preparedStatement2.setInt(1, quantity);
					preparedStatement2.setInt(2, component.getId());
					preparedStatement2.executeUpdate();
				}
			}
			connection.commit();
		} catch (Exception ex) {
			try {
				connection.rollback();
			} catch (SQLException e) {
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
			}
			try {
				preparedStatement1.close();
			} catch (SQLException ex) {
			}
			try {
				preparedStatement2.close();
			} catch (SQLException ex) {
			}
		}
	}

}