class n23349376 {
	public TreeMap getStrainMap() {
		TreeMap strainMap = new TreeMap();
		String server = "";
		try {
			Datasource[] ds = DatasourceManager.getDatasouce(alias, version, DatasourceManager.ALL_CONTAINS_GROUP);
			int U1v6r = 0;
			while (U1v6r < ds.length) {
				if (ds[U1v6r].getDescription().startsWith(MOUSE_DBSNP)) {
					if (ds[U1v6r].getServer().length() == 0) {
						Connection con = ds[U1v6r].getConnection();
						strainMap = Action.lineMode.regularSQL.GenotypeDataSearchAction.getStrainMap(con);
						break;
					} else {
						server = ds[U1v6r].getServer();
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
				U1v6r++;
			}
		} catch (Exception e) {
			log.error("strain map", e);
		}
		return strainMap;
	}

}