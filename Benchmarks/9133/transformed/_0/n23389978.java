class n23389978 {
	public static void importDocumentLines(Connection iFdPQggv, String R4iMz8yQ, String MgR2nZq9) throws SQLException {
		boolean jGfvh77r = iFdPQggv.getAutoCommit();
		String WSzTSalk = "select ProductID,Description,PricePerUnit,Quantity,DiscountPCT,VATPCT,TotalNoVATPrice,TotalPrice from tbl_DocumentItem where DocumentID=?";
		String JgSaDGgK = "insert into tbl_DocumentItem (ProductID,Description,PricePerUnit,Quantity,DiscountPCT,VATPCT,TotalNoVATPrice,TotalPrice,DocumentID) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement EejZcyek = null;
		PreparedStatement UB7GFzdE = null;
		try {
			EejZcyek = iFdPQggv.prepareStatement(WSzTSalk);
			UB7GFzdE = iFdPQggv.prepareStatement(JgSaDGgK);
			iFdPQggv.setAutoCommit(false);
			EejZcyek.setString(1, R4iMz8yQ);
			ResultSet oUkutSYy = EejZcyek.executeQuery();
			while (oUkutSYy.next()) {
				UB7GFzdE.setInt(1, oUkutSYy.getInt(1));
				UB7GFzdE.setString(2, oUkutSYy.getString(2));
				UB7GFzdE.setDouble(3, oUkutSYy.getDouble(3));
				UB7GFzdE.setDouble(4, oUkutSYy.getDouble(4));
				UB7GFzdE.setDouble(5, oUkutSYy.getDouble(5));
				UB7GFzdE.setDouble(6, oUkutSYy.getDouble(6));
				UB7GFzdE.setDouble(7, oUkutSYy.getDouble(7));
				UB7GFzdE.setDouble(8, oUkutSYy.getDouble(8));
				UB7GFzdE.setString(9, MgR2nZq9);
				UB7GFzdE.executeUpdate();
			}
			oUkutSYy.close();
			iFdPQggv.commit();
		} catch (SQLException i1zd6sua) {
			iFdPQggv.rollback();
		} finally {
			iFdPQggv.setAutoCommit(jGfvh77r);
			if (EejZcyek != null)
				EejZcyek.close();
			if (UB7GFzdE != null)
				UB7GFzdE.close();
		}
	}

}