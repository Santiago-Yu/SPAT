class n16491858{
    public boolean openConnection(String url, Properties props) throws SQLException {
        try {
            Class.forName(RunConfig.getInstance().getDriverNameJDBC());
            if (url == null) url = RunConfig.getInstance().getConnectionUrlJDBC();
            connection = DriverManager.getConnection(url, props);
            if (statementTable == null) statementTable = new Hashtable<String, PreparedStatement>();
            if (resultTable == null) resultTable = new Hashtable<String, ResultSet>();
            clearStatus();
            return true;
        } catch (Exception e) {
            setStatus(e);
            return false;
        }
    }

}