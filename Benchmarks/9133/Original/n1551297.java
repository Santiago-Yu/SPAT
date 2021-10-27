class n1551297{
    public InputStream getDaoConfig(String connectionType) throws IOException {
        URL url = null;
        if (connectionType.equals(SQL.ORACLE)) {
            url = com.apelon.dts.db.admin.config.MigrateConfig.class.getResource("oracle.xml");
        } else if (connectionType.equals(SQL.SQL2K)) {
            url = com.apelon.dts.db.admin.config.MigrateConfig.class.getResource("sql2k.xml");
        }
        return url.openStream();
    }

}