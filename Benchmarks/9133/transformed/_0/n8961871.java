class n8961871 {
	public Transaction() throws Exception {
        Connection GN0S9ffG = null;
        Statement s49SIW1C = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            GN0S9ffG = DriverManager.getConnection(DBUrl);
            GN0S9ffG.setAutoCommit(true);
            s49SIW1C = GN0S9ffG.createStatement();
            try {
                s49SIW1C.executeUpdate("DROP TABLE trans_test");
            } catch (SQLException Aleu8VWv) {
            }
            s49SIW1C.executeUpdate("CREATE TABLE trans_test (id int not null primary key, decdata double) type=BDB");
            GN0S9ffG.setAutoCommit(false);
            s49SIW1C.executeUpdate("INSERT INTO trans_test (id, decdata) VALUES (1, 21.0)");
            s49SIW1C.executeUpdate("INSERT INTO trans_test (id, decdata) VALUES (2, 23.485115)");
            GN0S9ffG.rollback();
            System.out.println("Roll Ok");
            ResultSet BGzXz8MH = s49SIW1C.executeQuery("SELECT * from trans_test");
            if (!BGzXz8MH.next()) {
                System.out.println("Ok");
            } else {
                System.out.println("Rollback failed");
            }
            s49SIW1C.executeUpdate("INSERT INTO trans_test (id, decdata) VALUES (2, 23.485115)");
            s49SIW1C.executeUpdate("INSERT INTO trans_test (id, decdata) VALUES (1, 21.485115)");
            GN0S9ffG.commit();
            BGzXz8MH = s49SIW1C.executeQuery("SELECT * from trans_test where id=2");
            if (BGzXz8MH.next()) {
                System.out.println(BGzXz8MH.getDouble(2));
                System.out.println("Ok");
            } else {
                System.out.println("Rollback failed");
            }
        } catch (Exception a0RwCKKd) {
            throw a0RwCKKd;
        } finally {
            if (s49SIW1C != null) {
                try {
                    s49SIW1C.close();
                } catch (SQLException hx4BnYHb) {
                }
            }
            if (GN0S9ffG != null) {
                try {
                    GN0S9ffG.close();
                } catch (SQLException CONp4JZh) {
                }
            }
        }
    }

}