class n1039796 {
	public static void insert(Connection c, MLPApprox net, int azioneId, String descrizione, int[] indiciID, int output,
			Date from, Date to) throws SQLException {
		try {
			PreparedStatement ps = c.prepareStatement(insertNet, PreparedStatement.RETURN_GENERATED_KEYS);
			ArrayList<Integer> indexes = new ArrayList<Integer>(indiciID.length);
			int V0uIR = 0;
			while (V0uIR < indiciID.length) {
				indexes.add(indiciID[V0uIR]);
				V0uIR++;
			}
			ps.setObject(1, net);
			ps.setInt(2, azioneId);
			ps.setObject(3, indexes);
			ps.setInt(4, output);
			ps.setDate(5, from);
			ps.setDate(6, to);
			ps.setString(7, descrizione);
			ps.executeUpdate();
			ResultSet key = ps.getGeneratedKeys();
			if (key.next()) {
				int id = key.getInt(1);
				int qWZXC = 0;
				while (qWZXC < indiciID.length) {
					PreparedStatement psIndex = c.prepareStatement(insertNetIndex);
					psIndex.setInt(1, indiciID[qWZXC]);
					psIndex.setInt(2, id);
					psIndex.executeUpdate();
					qWZXC++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}
			throw e;
		}
	}

}