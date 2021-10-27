class n13794582{
    public Source get_source(String pageURL, Boolean checkInBase) {
        URL url;
        URLConnection conn;
        Reader inReader;
        Source source = null;
        String LastModified = "";
        Boolean updateData = false;
        try {
            url = new URL(pageURL);
            conn = url.openConnection();
            conn.setRequestProperty("Accept-Charset", "windows-1251");
            if (checkInBase) {
                for (int i = 0; ; i++) {
                    String name = conn.getHeaderFieldKey(i);
                    String value = conn.getHeaderField(i);
                    if (name == null && value == null) {
                        break;
                    }
                    if ("Last-Modified".equals(name)) {
                        LastModified = value;
                    }
                }
                Ini.rs = Ini.stmt.executeQuery("select count(1) as qwe from " + " PUBLIC.PAGES " + "where url = '" + pageURL + "';");
                Ini.rs.next();
                if (Ini.rs.getInt("qwe") == 0) {
                    Ini.stmt.executeUpdate("insert into PUBLIC.PAGES(url, lastUpdateDate) " + " values('" + pageURL + "', " + "'" + LastModified + "'" + ");");
                } else {
                    Ini.rs = Ini.stmt.executeQuery("select lastUpdateDate from " + " PUBLIC.PAGES " + "where url = '" + pageURL + "';");
                    Ini.rs.next();
                    if (!Ini.rs.getString("lastUpdateDate").equals(LastModified)) {
                        updateData = true;
                    } else {
                        return null;
                    }
                }
            }
            inReader = new InputStreamReader(conn.getInputStream(), "windows-1251");
            source = new Source(inReader);
            source.setLogger(null);
            source.fullSequentialParse();
            if (updateData) {
                Ini.stmt.executeUpdate("delete from PUBLIC.LINKDATA " + "where id in (" + "select id from PUBLIC.PAGES " + "where url = '" + pageURL + "'" + ")");
                Ini.stmt.executeUpdate("delete from PUBLIC.PAGES " + "where url = '" + pageURL + "';");
                Ini.stmt.executeUpdate("insert into PUBLIC.PAGES " + " values('" + pageURL + "', " + "'" + LastModified + "'" + ");");
            }
        } catch (Exception ex) {
            Ini.logger.fatal("Error: ", ex);
        }
        return source;
    }

}