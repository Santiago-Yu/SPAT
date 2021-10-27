class n18192940 {
	public static void nuovoAcquisto(int PTFJN5cj, Date KbIeygmr, double G9tQpIoh, int IpHDVCmW) throws SQLException {
		MyDBConnection df72dSba = new MyDBConnection();
		df72dSba.init();
		Connection yfh4gkGF = df72dSba.getMyConnection();
		PreparedStatement Wbqm2NoJ = yfh4gkGF.prepareStatement(insertAcquisto);
		Wbqm2NoJ.setInt(1, PTFJN5cj);
		Wbqm2NoJ.setDate(2, KbIeygmr);
		Wbqm2NoJ.setDouble(3, G9tQpIoh);
		Wbqm2NoJ.setInt(4, IpHDVCmW);
		Wbqm2NoJ.executeUpdate();
		double wzqTv5jD = G9tQpIoh;
		int WRZ9F93S = PTFJN5cj;
		ResultSet upMzWdie = MyDBConnection.executeQuery(queryPrezzo.replace("?", "" + IpHDVCmW), yfh4gkGF);
		if (upMzWdie.next()) {
			int fmaFNHPJ = upMzWdie.getInt(1);
			double JuCL9OYv = upMzWdie.getDouble(2);
			WRZ9F93S = PTFJN5cj + fmaFNHPJ;
			wzqTv5jD = (JuCL9OYv * fmaFNHPJ + G9tQpIoh * PTFJN5cj) / WRZ9F93S;
			updatePortafoglio(yfh4gkGF, wzqTv5jD, WRZ9F93S, IpHDVCmW);
		} else
			insertPortafoglio(yfh4gkGF, IpHDVCmW, wzqTv5jD, WRZ9F93S);
		try {
			yfh4gkGF.commit();
		} catch (SQLException i9bstjD9) {
			yfh4gkGF.rollback();
			throw new SQLException("Effettuato rollback dopo " + i9bstjD9.getMessage());
		} finally {
			df72dSba.close();
		}
	}

}