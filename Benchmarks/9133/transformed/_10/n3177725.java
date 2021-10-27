class n3177725 {
	public DBAccess(String pathToDb) {
        if (instance != null) {
            throw new IllegalStateException();
        }
        System.setProperty("derby.system.home", pathToDb);
        try {
            new EmbeddedDriver();
            boolean exists = new File(pathToDb).exists();
            Properties props = new Properties();
            if (exists) {
                connection = DriverManager.getConnection(protocol + "rmpDB;", props);
                connection.setAutoCommit(true);
                Statement statement = connection.createStatement();
                try {
                } finally {
                    statement.close();
                }
            } else {
                connection = DriverManager.getConnection(protocol + "rmpDB;create=true", props);
                connection.setAutoCommit(true);
                URL url = Platform.getBundle("ru.spbu.dorms.geo.rmp").getResource("sql/createdb.sql");
                StringBuilder query = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                    if (query.length() > 0) {
                        query.append('\n');
                    }
                    query.append(s);
                }
                reader.close();
                Statement statement = connection.createStatement();
                try {
                    String[] statements = query.toString().split(";(\\s)*");
                    for (String s : statements) {
                        statement.execute(s);
                    }
                } finally {
                    statement.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        instance = this;
    }

}