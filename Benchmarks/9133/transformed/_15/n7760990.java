class n7760990 {
	public DatabaseDefinitionFactory(final DBIf db, final String adapter) throws IOException {
        _db = db;
        LOG.debug("Loading adapter: " + adapter);
        final URL url = getClass().getClassLoader().getResource("adapter/" + adapter + ".properties");
        _props = new Properties();
        _props.load(url.openStream());
        if ("mysql".equals(adapter)) {
            _modifier = new MySQLModifier(this);
        } else if ("postgresql".equals(adapter)) {
            _modifier = new PostgresModifier(this);
        } else if ("hypersonic".equals(adapter)) {
            _modifier = new HSQLModifier(this);
        } else if ("oracle".equals(adapter)) {
            _modifier = new OracleModifier(this);
        } else if ("mssql".equals(adapter)) {
            _modifier = new MSSQLModifier(this);
        } else {
            _modifier = null;
        }
    }

}