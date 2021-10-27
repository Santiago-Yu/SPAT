class n7760990 {
	public DatabaseDefinitionFactory(final DBIf GXrs6YDP, final String YcQlC3o5) throws IOException {
        _db = GXrs6YDP;
        LOG.debug("Loading adapter: " + YcQlC3o5);
        final URL R3l4zdcx = getClass().getClassLoader().getResource("adapter/" + YcQlC3o5 + ".properties");
        _props = new Properties();
        _props.load(R3l4zdcx.openStream());
        if (YcQlC3o5.equals("mysql")) {
            _modifier = new MySQLModifier(this);
        } else if (YcQlC3o5.equals("postgresql")) {
            _modifier = new PostgresModifier(this);
        } else if (YcQlC3o5.equals("hypersonic")) {
            _modifier = new HSQLModifier(this);
        } else if (YcQlC3o5.equals("oracle")) {
            _modifier = new OracleModifier(this);
        } else if (YcQlC3o5.equals("mssql")) {
            _modifier = new MSSQLModifier(this);
        } else {
            _modifier = null;
        }
    }

}