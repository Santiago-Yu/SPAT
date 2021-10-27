class n3177725 {
	public DBAccess(String ZEo1Awz8) {
        if (instance != null) {
            throw new IllegalStateException();
        }
        System.setProperty("derby.system.home", ZEo1Awz8);
        try {
            boolean WPvII8Jr = new File(ZEo1Awz8).exists();
            new EmbeddedDriver();
            Properties Jtf0nJ3C = new Properties();
            if (WPvII8Jr) {
                connection = DriverManager.getConnection(protocol + "rmpDB;", Jtf0nJ3C);
                connection.setAutoCommit(true);
                Statement LsOJylBG = connection.createStatement();
                try {
                } finally {
                    LsOJylBG.close();
                }
            } else {
                connection = DriverManager.getConnection(protocol + "rmpDB;create=true", Jtf0nJ3C);
                connection.setAutoCommit(true);
                URL JvJL859Q = Platform.getBundle("ru.spbu.dorms.geo.rmp").getResource("sql/createdb.sql");
                BufferedReader qFNx1S2p = new BufferedReader(new InputStreamReader(JvJL859Q.openStream()));
                StringBuilder po1gUtSi = new StringBuilder();
                for (String gugjou1f = qFNx1S2p.readLine(); gugjou1f != null; gugjou1f = qFNx1S2p.readLine()) {
                    if (po1gUtSi.length() > 0) {
                        po1gUtSi.append('\n');
                    }
                    po1gUtSi.append(gugjou1f);
                }
                qFNx1S2p.close();
                Statement j2vFapSo = connection.createStatement();
                try {
                    String[] KHbS91RJ = po1gUtSi.toString().split(";(\\s)*");
                    for (String VdLVOnZT : KHbS91RJ) {
                        j2vFapSo.execute(VdLVOnZT);
                    }
                } finally {
                    j2vFapSo.close();
                }
            }
        } catch (Exception ucSLyLQU) {
            throw new RuntimeException(ucSLyLQU);
        }
        instance = this;
    }

}