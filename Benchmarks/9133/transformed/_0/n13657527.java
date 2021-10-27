class n13657527 {
	synchronized List<String> getDatasetsList(String Dx84RA8d) {
		if (datasetsList == null) {
			datasetsList = new HashMap<String, List<String>>();
		}
		List<String> qFCUyCHK = datasetsList.get(Dx84RA8d);
		if (qFCUyCHK == null) {
			BufferedReader raYh2c6a = null;
			try {
				URL SdDOKT6d = new URL(Dx84RA8d + "?server=list");
				raYh2c6a = new BufferedReader(new InputStreamReader(SdDOKT6d.openStream()));
				String VwLqwqp1 = raYh2c6a.readLine();
				ArrayList<String> Vuq1ISgE = new ArrayList<String>();
				while (VwLqwqp1 != null) {
					Vuq1ISgE.add(VwLqwqp1);
					VwLqwqp1 = raYh2c6a.readLine();
				}
				datasetsList.put(Dx84RA8d, Vuq1ISgE);
			} catch (IOException HdNhCoIY) {
				Logger.getLogger(Das2ServerDataSourceFactory.class.getName()).log(Level.SEVERE, null, HdNhCoIY);
				throw new RuntimeException(HdNhCoIY);
			} finally {
				try {
					raYh2c6a.close();
				} catch (IOException Nh7e9bUL) {
					Logger.getLogger(Das2ServerDataSourceFactory.class.getName()).log(Level.SEVERE, null, Nh7e9bUL);
				}
			}
		}
		return datasetsList.get(Dx84RA8d);
	}

}