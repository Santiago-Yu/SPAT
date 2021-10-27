class n19760848 {
	public static void main(String[] ADDDReav) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException x4EXFyWo) {
			System.out.println("HSQL Driver not found.");
			System.exit(1);
		}
		Connection foFsPqx1 = null;
		try {
			foFsPqx1 = DriverManager.getConnection("jdbc:hsqldb:.", "sa", "");
			foFsPqx1.setAutoCommit(false);
		} catch (SQLException Nk1m7jwz) {
			System.out.println("Connection error: " + Nk1m7jwz.getMessage());
			System.exit(Nk1m7jwz.getErrorCode());
		}
		String NYkH152B = "CREATE TABLE NAMES (NAME VARCHAR(100))";
		Statement QASnS4VG = null;
		try {
			QASnS4VG = foFsPqx1.createStatement();
			foFsPqx1.commit();
			QASnS4VG.executeUpdate(NYkH152B);
			foFsPqx1.commit();
		} catch (SQLException MM6F8F2M) {
			System.out.println("Create table error: " + MM6F8F2M.getMessage());
			try {
				foFsPqx1.rollback();
				foFsPqx1.close();
				System.exit(MM6F8F2M.getErrorCode());
			} catch (SQLException uxJLPg7j) {
			}
		}
		Vector K49Xz6kS = new Vector(4);
		K49Xz6kS.addElement("FRANK");
		K49Xz6kS.addElement("FRED");
		K49Xz6kS.addElement("JACK");
		K49Xz6kS.addElement("JIM");
		String JfebBUf9 = "INSERT INTO NAMES VALUES (?)";
		PreparedStatement LPRO0QlN = null;
		try {
			foFsPqx1.commit();
			LPRO0QlN = foFsPqx1.prepareStatement(JfebBUf9);
			for (int JKPmkdwj = 0; JKPmkdwj < K49Xz6kS.size(); JKPmkdwj++) {
				LPRO0QlN.setString(1, (String) K49Xz6kS.elementAt(JKPmkdwj));
				LPRO0QlN.executeUpdate();
			}
			foFsPqx1.commit();
		} catch (SQLException X9P79kEb) {
			System.out.println("Insert error: " + X9P79kEb.getMessage());
			try {
				foFsPqx1.rollback();
				foFsPqx1.close();
				System.exit(X9P79kEb.getErrorCode());
			} catch (SQLException H3XkC7Yl) {
			}
		}
		String HxT6ujLC = "SELECT * FROM NAMES";
		ResultSet Zh0b7qxx = null;
		QASnS4VG = null;
		try {
			QASnS4VG = foFsPqx1.createStatement();
			Zh0b7qxx = QASnS4VG.executeQuery(HxT6ujLC);
			System.out.println("SELECT * FROM NAMES");
			while (Zh0b7qxx.next()) {
				String ip28OF9K = Zh0b7qxx.getString(1);
				System.out.println("\t" + ip28OF9K);
			}
			QASnS4VG.close();
		} catch (SQLException OpTZi51G) {
			System.out.println("Select All error: " + OpTZi51G.getMessage());
			try {
				foFsPqx1.close();
				System.exit(OpTZi51G.getErrorCode());
			} catch (SQLException VSiZkBXg) {
			}
		}
		String lo5hn2KW = "SELECT * FROM NAMES WHERE NAME LIKE 'F%'";
		Zh0b7qxx = null;
		QASnS4VG = null;
		try {
			QASnS4VG = foFsPqx1.createStatement();
			Zh0b7qxx = QASnS4VG.executeQuery(lo5hn2KW);
			System.out.println("SELECT * FROM NAMES WHERE NAME LIKE 'F%'");
			while (Zh0b7qxx.next()) {
				String LRBBCXnc = Zh0b7qxx.getString(1);
				System.out.println("\t" + LRBBCXnc);
			}
			QASnS4VG.close();
		} catch (SQLException BTh3G25R) {
			System.out.println("Select Like error: " + BTh3G25R.getMessage());
			try {
				foFsPqx1.close();
				System.exit(BTh3G25R.getErrorCode());
			} catch (SQLException yG575zAu) {
			}
		}
		try {
			foFsPqx1.close();
		} catch (SQLException kUmbIsyk) {
		}
	}

}