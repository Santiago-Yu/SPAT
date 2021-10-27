class n1039796 {
	public static void insert(Connection HKMDcDOt, MLPApprox lO4OWnx5, int v61zon4T, String LGHQ1nRu, int[] A3OxdM5j,
			int P4omESLE, Date os8ZgQwk, Date dmmDUkZI) throws SQLException {
		try {
			PreparedStatement Yl7bCYU8 = HKMDcDOt.prepareStatement(insertNet, PreparedStatement.RETURN_GENERATED_KEYS);
			ArrayList<Integer> aKeQBkOO = new ArrayList<Integer>(A3OxdM5j.length);
			for (int YCXcWsJ0 = 0; YCXcWsJ0 < A3OxdM5j.length; YCXcWsJ0++)
				aKeQBkOO.add(A3OxdM5j[YCXcWsJ0]);
			Yl7bCYU8.setObject(1, lO4OWnx5);
			Yl7bCYU8.setInt(2, v61zon4T);
			Yl7bCYU8.setObject(3, aKeQBkOO);
			Yl7bCYU8.setInt(4, P4omESLE);
			Yl7bCYU8.setDate(5, os8ZgQwk);
			Yl7bCYU8.setDate(6, dmmDUkZI);
			Yl7bCYU8.setString(7, LGHQ1nRu);
			Yl7bCYU8.executeUpdate();
			ResultSet rfRVvKW5 = Yl7bCYU8.getGeneratedKeys();
			if (rfRVvKW5.next()) {
				int JIelyrrr = rfRVvKW5.getInt(1);
				for (int qpyImuDq = 0; qpyImuDq < A3OxdM5j.length; qpyImuDq++) {
					PreparedStatement m84k5z5D = HKMDcDOt.prepareStatement(insertNetIndex);
					m84k5z5D.setInt(1, A3OxdM5j[qpyImuDq]);
					m84k5z5D.setInt(2, JIelyrrr);
					m84k5z5D.executeUpdate();
				}
			}
		} catch (SQLException qaYGb9it) {
			qaYGb9it.printStackTrace();
			try {
				HKMDcDOt.rollback();
			} catch (SQLException jC4w7JsO) {
				jC4w7JsO.printStackTrace();
				throw jC4w7JsO;
			}
			throw qaYGb9it;
		}
	}

}