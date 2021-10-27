class n7760990 {
	public DatabaseDefinitionFactory(final DBIf db, final String adapter) throws IOException {
        _db = db;
        LOG.debug("Loading adapter: " + adapter);
        _props = new Properties();
        final URL url = getClass().getClassLoader().getResource("adapter/" + adapter + ".properties");
        _props.load(url.openStream());
        if (adapter.equals("mysql")) {
            _modifier = new MySQLModifier(this);
        } else if (adapter.equals("postgresql")) {
            _modifier = new PostgresModifier(this);
        } else if (adapter.equals("hypersonic")) {
            _modifier = new HSQLModifier(this);
        } else if (adapter.equals("oracle")) {
            _modifier = new OracleModifier(this);
        } else if (adapter.equals("mssql")) {
            _modifier = new MSSQLModifier(this);
        } else {
            _modifier = null;
        }
    }

}