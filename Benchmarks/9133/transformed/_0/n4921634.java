class n4921634 {
	public int update(BusinessObject xWtst4av) throws DAOException {
		int wwOolGfH = 0;
		Item vVkhZ55c = (Item) xWtst4av;
		try {
			PreparedStatement ZldSYSfq = connection.prepareStatement(XMLGetQuery.getQuery("UPDATE_ITEM"));
			ZldSYSfq.setString(1, vVkhZ55c.getDescription());
			ZldSYSfq.setDouble(2, vVkhZ55c.getUnit_price());
			ZldSYSfq.setInt(3, vVkhZ55c.getQuantity());
			ZldSYSfq.setDouble(4, vVkhZ55c.getVat());
			ZldSYSfq.setInt(5, vVkhZ55c.getIdProject());
			if (vVkhZ55c.getIdBill() == 0)
				ZldSYSfq.setNull(6, java.sql.Types.INTEGER);
			else
				ZldSYSfq.setInt(6, vVkhZ55c.getIdBill());
			ZldSYSfq.setInt(7, vVkhZ55c.getIdCurrency());
			ZldSYSfq.setInt(8, vVkhZ55c.getId());
			System.out.println("item => " + vVkhZ55c.getDescription() + " " + vVkhZ55c.getUnit_price() + " "
					+ vVkhZ55c.getQuantity() + " " + vVkhZ55c.getVat() + " " + vVkhZ55c.getIdProject() + " "
					+ vVkhZ55c.getIdBill() + " " + vVkhZ55c.getIdCurrency() + " " + vVkhZ55c.getId());
			wwOolGfH = ZldSYSfq.executeUpdate();
			if (wwOolGfH <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (wwOolGfH > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException Em8ywNGW) {
			Log.write(Em8ywNGW.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException PcWoqvze) {
			Log.write(PcWoqvze.getMessage());
			throw new DAOException("Connection null");
		}
		return wwOolGfH;
	}

}