class n15810440 {
	public static void addRecipe(String e60s8A8o, String VhcjbRs1, int PMzhdEyQ, String[][] L3OPBbFI) throws Exception {
		PreparedStatement OCSNk94X = null;
		PreparedStatement GIvSWkGK = null;
		ResultSet PzROcyt4 = null;
		int MbsXpKeR = -1;
		try {
			OCSNk94X = conn.prepareStatement("INSERT INTO recipes (name, instructions, category_id) VALUES (?, ?, ?)");
			OCSNk94X.setString(1, e60s8A8o);
			OCSNk94X.setString(2, VhcjbRs1);
			OCSNk94X.setInt(3, PMzhdEyQ);
			if (OCSNk94X.executeUpdate() > 0) {
				GIvSWkGK = conn.prepareStatement(
						"SELECT recipe_id FROM recipes WHERE name = ? AND instructions = ? AND category_id = ?");
				GIvSWkGK.setString(1, e60s8A8o);
				GIvSWkGK.setString(2, VhcjbRs1);
				GIvSWkGK.setInt(3, PMzhdEyQ);
				PzROcyt4 = GIvSWkGK.executeQuery();
				if (PzROcyt4.next()) {
					int uTT7ppRM = PzROcyt4.getInt(1);
					System.out.println("Lis?t??n ainesosat");
					String[] MU1NZbR5;
					for (int ify7Ny5f = 0; ify7Ny5f < L3OPBbFI.length; ++ify7Ny5f) {
						MU1NZbR5 = L3OPBbFI[ify7Ny5f];
						addIngredient(uTT7ppRM, MU1NZbR5[0], MU1NZbR5[1], Integer.parseInt(MU1NZbR5[2]),
								Integer.parseInt(MU1NZbR5[3]));
					}
					MbsXpKeR = uTT7ppRM;
				} else {
					MbsXpKeR = -1;
				}
			} else {
				MbsXpKeR = -1;
			}
			conn.commit();
		} catch (Exception dZ7fWXh9) {
			conn.rollback();
			throw new Exception("Reseptin lis?ys ep?onnistui. Poikkeus: " + dZ7fWXh9.getMessage());
		}
	}

}