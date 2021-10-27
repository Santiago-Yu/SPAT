class n23349376{
    public TreeMap getStrainMap() {
        TreeMap strainMap = new TreeMap();
        String server = "";
        try {
            Datasource[] ds = DatasourceManager.getDatasouce(alias, version, DatasourceManager.ALL_CONTAINS_GROUP);
            for (int i = 0; i < ds.length; i++) {
                if (ds[i].getDescription().startsWith(MOUSE_DBSNP)) {
                    if (ds[i].getServer().length() == 0) {
                        Connection con = ds[i].getConnection();
                        strainMap = Action.lineMode.regularSQL.GenotypeDataSearchAction.getStrainMap(con);
                        break;
                    } else {
                        server = ds[i].getServer();
                        HashMap serverUrlMap = InitXml.getInstance().getServerMap();
                        String serverUrl = (String) serverUrlMap.get(server);
                        URL url = new URL(serverUrl + servletName);
                        URLConnection uc = url.openConnection();
                        uc.setDoOutput(true);
                        OutputStream os = uc.getOutputStream();
                        StringBuffer buf = new StringBuffer();
                        buf.append("viewType=getstrains");
                        buf.append("&hHead=" + hHead);
                        buf.append("&hCheck=" + version);
                        PrintStream ps = new PrintStream(os);
                        ps.print(buf.toString());
                        ps.close();
                        ObjectInputStream ois = new ObjectInputStream(uc.getInputStream());
                        strainMap = (TreeMap) ois.readObject();
                        ois.close();
                    }
                }
            }
        } catch (Exception e) {
            log.error("strain map", e);
        }
        return strainMap;
    }

}