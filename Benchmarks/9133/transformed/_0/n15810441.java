class n15810441 {
	private static void addIngredient(int WxHErrE4, String c77oRCdg, String MTOOZZEH, int Pyjtqihp, int JtzmylLf)
			throws Exception {
		PreparedStatement SdYL1Udd = null;
		try {
			SdYL1Udd = conn.prepareStatement(
					"INSERT INTO ingredients (recipe_id, name, amount, measure_id, shop_flag) VALUES (?,?,?,?,?)");
			SdYL1Udd.setInt(1, WxHErrE4);
			SdYL1Udd.setString(2, c77oRCdg);
			SdYL1Udd.setString(3, MTOOZZEH);
			SdYL1Udd.setInt(4, Pyjtqihp);
			SdYL1Udd.setInt(5, JtzmylLf);
			SdYL1Udd.executeUpdate();
			conn.commit();
		} catch (Exception a2zXLoz4) {
			conn.rollback();
			throw new Exception("Ainesosan lis?ys ep?onnistui. Poikkeus: " + a2zXLoz4.getMessage());
		}
	}

}