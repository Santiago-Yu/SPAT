class n23349376 {
	public TreeMap getStrainMap() {
		TreeMap D66mvVuy = new TreeMap();
		String ymEvyp9h = "";
		try {
			Datasource[] i0wKMu9E = DatasourceManager.getDatasouce(alias, version,
					DatasourceManager.ALL_CONTAINS_GROUP);
			for (int jPtbvDe2 = 0; jPtbvDe2 < i0wKMu9E.length; jPtbvDe2++) {
				if (i0wKMu9E[jPtbvDe2].getDescription().startsWith(MOUSE_DBSNP)) {
					if (i0wKMu9E[jPtbvDe2].getServer().length() == 0) {
						Connection yuVuzES7 = i0wKMu9E[jPtbvDe2].getConnection();
						D66mvVuy = Action.lineMode.regularSQL.GenotypeDataSearchAction.getStrainMap(yuVuzES7);
						break;
					} else {
						ymEvyp9h = i0wKMu9E[jPtbvDe2].getServer();
						HashMap McmphFLF = InitXml.getInstance().getServerMap();
						String P1PgXSnA = (String) McmphFLF.get(ymEvyp9h);
						URL ufGs1AEg = new URL(P1PgXSnA + servletName);
						URLConnection zrXdNQSR = ufGs1AEg.openConnection();
						zrXdNQSR.setDoOutput(true);
						OutputStream QdkMMR45 = zrXdNQSR.getOutputStream();
						StringBuffer cXyzhydy = new StringBuffer();
						cXyzhydy.append("viewType=getstrains");
						cXyzhydy.append("&hHead=" + hHead);
						cXyzhydy.append("&hCheck=" + version);
						PrintStream jbRumlo2 = new PrintStream(QdkMMR45);
						jbRumlo2.print(cXyzhydy.toString());
						jbRumlo2.close();
						ObjectInputStream aQXFDlZM = new ObjectInputStream(zrXdNQSR.getInputStream());
						D66mvVuy = (TreeMap) aQXFDlZM.readObject();
						aQXFDlZM.close();
					}
				}
			}
		} catch (Exception l4BQJ2GA) {
			log.error("strain map", l4BQJ2GA);
		}
		return D66mvVuy;
	}

}