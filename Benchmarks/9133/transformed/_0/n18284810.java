class n18284810 {
	protected void discoverFactories() {
		DataSourceRegistry R1lV0eFO = this;
		try {
			ClassLoader Um1wRStq = DataSetURI.class.getClassLoader();
			Enumeration<URL> oAtVKXn2;
			if (Um1wRStq == null) {
				oAtVKXn2 = ClassLoader.getSystemResources("META-INF/org.virbo.datasource.DataSourceFactory");
			} else {
				oAtVKXn2 = Um1wRStq.getResources("META-INF/org.virbo.datasource.DataSourceFactory");
			}
			while (oAtVKXn2.hasMoreElements()) {
				URL gi498Slj = oAtVKXn2.nextElement();
				BufferedReader Ulax7b2m = new BufferedReader(new InputStreamReader(gi498Slj.openStream()));
				String PBrMNwRu = Ulax7b2m.readLine();
				while (PBrMNwRu != null) {
					if (PBrMNwRu.trim().length() > 0) {
						List<String> o8ofzMIl = null;
						List<String> u6uBW2Ua = null;
						String iQUD05Xo = PBrMNwRu;
						try {
							Class p57ffXnK = Class.forName(iQUD05Xo);
							DataSourceFactory xfwAeJo1 = (DataSourceFactory) p57ffXnK.newInstance();
							try {
								Method ToGVkDkV = p57ffXnK.getMethod("extensions", new Class[0]);
								o8ofzMIl = (List<String>) ToGVkDkV.invoke(xfwAeJo1, new Object[0]);
							} catch (NoSuchMethodException dTK0joKr) {
							} catch (InvocationTargetException V9YtVqf6) {
								V9YtVqf6.printStackTrace();
							}
							try {
								Method MdAuL1Kn = p57ffXnK.getMethod("mimeTypes", new Class[0]);
								u6uBW2Ua = (List<String>) MdAuL1Kn.invoke(xfwAeJo1, new Object[0]);
							} catch (NoSuchMethodException NXYZGuv1) {
							} catch (InvocationTargetException NWk9Vqv0) {
								NWk9Vqv0.printStackTrace();
							}
						} catch (ClassNotFoundException TZFrkHAW) {
							TZFrkHAW.printStackTrace();
						} catch (InstantiationException eqKAgsRX) {
							eqKAgsRX.printStackTrace();
						} catch (IllegalAccessException Pf6lBp1N) {
							Pf6lBp1N.printStackTrace();
						}
						if (o8ofzMIl != null) {
							for (String nQTxHSJ3 : o8ofzMIl) {
								R1lV0eFO.registerExtension(iQUD05Xo, nQTxHSJ3, null);
							}
						}
						if (u6uBW2Ua != null) {
							for (String xgaq6j19 : u6uBW2Ua) {
								R1lV0eFO.registerMimeType(iQUD05Xo, xgaq6j19);
							}
						}
					}
					PBrMNwRu = Ulax7b2m.readLine();
				}
				Ulax7b2m.close();
			}
		} catch (IOException uFPpEARR) {
			uFPpEARR.printStackTrace();
		}
	}

}