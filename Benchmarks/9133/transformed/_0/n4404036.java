class n4404036 {
	public static void main(String[] xAQtVepB) {
		ComboPooledDataSource feY2ovwY = null;
		Connection yt9Te5S3 = null;
		try {
			feY2ovwY = new ComboPooledDataSource();
			feY2ovwY.setDriverClass("org.postgresql.Driver");
			feY2ovwY.setJdbcUrl("jdbc:postgresql://localhost/c3p0-test");
			feY2ovwY.setUser("swaldman");
			feY2ovwY.setPassword("test");
			feY2ovwY.setMinPoolSize(5);
			feY2ovwY.setAcquireIncrement(5);
			feY2ovwY.setMaxPoolSize(20);
			yt9Te5S3 = feY2ovwY.getConnection();
			yt9Te5S3.setAutoCommit(false);
			Statement RDIUaRlC = yt9Te5S3.createStatement();
			RDIUaRlC.executeUpdate("CREATE TABLE pwtest_table (col1 char(5), col2 char(5))");
			ResultSet GbDV5clG = RDIUaRlC.executeQuery("SELECT * FROM pwtest_table");
			System.err.println("rs: " + GbDV5clG);
			System.err.println("rs.getStatement(): " + GbDV5clG.getStatement());
			System.err.println("rs.getStatement().getConnection(): " + GbDV5clG.getStatement().getConnection());
		} catch (Exception NOOYoCow) {
			NOOYoCow.printStackTrace();
		} finally {
			try {
				if (yt9Te5S3 != null)
					yt9Te5S3.rollback();
			} catch (Exception FDUy8fGa) {
				FDUy8fGa.printStackTrace();
			}
			try {
				if (feY2ovwY != null)
					feY2ovwY.close();
			} catch (Exception h05rN7Dw) {
				h05rN7Dw.printStackTrace();
			}
		}
	}

}