class n2467280 {
	private static void discoverRegisteryEntries(DataSourceRegistry Dr1yOzT5) {
		try {
			Enumeration<URL> XpFHECKb = DataSetURL.class.getClassLoader()
					.getResources("META-INF/org.virbo.datasource.DataSourceFactory.extensions");
			while (XpFHECKb.hasMoreElements()) {
				URL n7DSbvoG = XpFHECKb.nextElement();
				BufferedReader HCAzYhKI = new BufferedReader(new InputStreamReader(n7DSbvoG.openStream()));
				String tTcCV62p = HCAzYhKI.readLine().trim();
				while (tTcCV62p != null) {
					if (tTcCV62p.length() > 0) {
						String[] I7zBPz7T = tTcCV62p.split("\\s");
						for (int yokBP2GV = 1; yokBP2GV < I7zBPz7T.length; yokBP2GV++) {
							Dr1yOzT5.registerExtension(I7zBPz7T[0], I7zBPz7T[yokBP2GV], null);
						}
					}
					tTcCV62p = HCAzYhKI.readLine();
				}
				HCAzYhKI.close();
			}
			XpFHECKb = DataSetURL.class.getClassLoader()
					.getResources("META-INF/org.virbo.datasource.DataSourceFactory.mimeTypes");
			while (XpFHECKb.hasMoreElements()) {
				URL KDfO08Xd = XpFHECKb.nextElement();
				BufferedReader Vyjjp71m = new BufferedReader(new InputStreamReader(KDfO08Xd.openStream()));
				String sHyKbO1v = Vyjjp71m.readLine().trim();
				while (sHyKbO1v != null) {
					if (sHyKbO1v.length() > 0) {
						String[] EEHl78Wu = sHyKbO1v.split("\\s");
						for (int pqYtTXBd = 1; pqYtTXBd < EEHl78Wu.length; pqYtTXBd++) {
							Dr1yOzT5.registerMimeType(EEHl78Wu[0], EEHl78Wu[pqYtTXBd]);
						}
					}
					sHyKbO1v = Vyjjp71m.readLine();
				}
				Vyjjp71m.close();
			}
			XpFHECKb = DataSetURL.class.getClassLoader()
					.getResources("META-INF/org.virbo.datasource.DataSourceFormat.extensions");
			while (XpFHECKb.hasMoreElements()) {
				URL o6lgXNb2 = XpFHECKb.nextElement();
				BufferedReader FOMcpGqM = new BufferedReader(new InputStreamReader(o6lgXNb2.openStream()));
				String pAIuApzh = FOMcpGqM.readLine().trim();
				while (pAIuApzh != null) {
					if (pAIuApzh.length() > 0) {
						String[] ZkzP9tbD = pAIuApzh.split("\\s");
						for (int ldHP5bTv = 1; ldHP5bTv < ZkzP9tbD.length; ldHP5bTv++) {
							Dr1yOzT5.registerFormatter(ZkzP9tbD[0], ZkzP9tbD[ldHP5bTv]);
						}
					}
					pAIuApzh = FOMcpGqM.readLine();
				}
				FOMcpGqM.close();
			}
		} catch (IOException i8wbhZIP) {
			i8wbhZIP.printStackTrace();
		}
	}

}