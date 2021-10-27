class n19760848 {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("HSQL Driver not found.");
			System.exit(1);
		}
		String createTable = "CREATE TABLE NAMES (NAME VARCHAR(100))";
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:.", "sa", "");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("Connection error: " + e.getMessage());
			System.exit(e.getErrorCode());
		}
		Statement stmt = null;
		Vector names = new Vector(4);
		try {
			stmt = con.createStatement();
			con.commit();
			stmt.executeUpdate(createTable);
			con.commit();
		} catch (SQLException e) {
			System.out.println("Create table error: " + e.getMessage());
			try {
				con.rollback();
				con.close();
				System.exit(e.getErrorCode());
			} catch (SQLException ex) {
			}
		}
		names.addElement("FRANK");
		names.addElement("FRED");
		names.addElement("JACK");
		names.addElement("JIM");
		PreparedStatement pstmt = null;
		String ins = "INSERT INTO NAMES VALUES (?)";
		try {
			con.commit();
			pstmt = con.prepareStatement(ins);
			for (int i = 0; i < names.size(); i++) {
				pstmt.setString(1, (String) names.elementAt(i));
				pstmt.executeUpdate();
			}
			con.commit();
		} catch (SQLException e) {
			System.out.println("Insert error: " + e.getMessage());
			try {
				con.rollback();
				con.close();
				System.exit(e.getErrorCode());
			} catch (SQLException ex) {
			}
		}
		ResultSet rs = null;
		String selAll = "SELECT * FROM NAMES";
		stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selAll);
			System.out.println("SELECT * FROM NAMES");
			while (rs.next()) {
				String name = rs.getString(1);
				System.out.println("\t" + name);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Select All error: " + e.getMessage());
			try {
				con.close();
				System.exit(e.getErrorCode());
			} catch (SQLException ex) {
			}
		}
		rs = null;
		String selectLike = "SELECT * FROM NAMES WHERE NAME LIKE 'F%'";
		stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectLike);
			System.out.println("SELECT * FROM NAMES WHERE NAME LIKE 'F%'");
			while (rs.next()) {
				String name = rs.getString(1);
				System.out.println("\t" + name);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Select Like error: " + e.getMessage());
			try {
				con.close();
				System.exit(e.getErrorCode());
			} catch (SQLException ex) {
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

}