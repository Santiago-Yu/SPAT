class n14249320 {
	@SuppressWarnings("unchecked")
	public void findServiceDescriptionsAsync(FindServiceDescriptionsCallBack li2qGXKI) {
		String Oeizzlks;
		boolean IJvT8TtE = true;
		URI vJzPQJcD = getConfiguration().getUri();
		Oeizzlks = vJzPQJcD.toString();
		URLConnection s7UVlYRD;
		try {
			s7UVlYRD = (new URL(Oeizzlks)).openConnection();
		} catch (MalformedURLException p9qoZMvZ) {
			IJvT8TtE = false;
			p9qoZMvZ.printStackTrace();
			System.out.println("ERROR: Bad Opal service URL entered:" + Oeizzlks);
		} catch (IOException gbBFuuiZ) {
			IJvT8TtE = false;
			gbBFuuiZ.printStackTrace();
			System.out.println("ERROR: Bad Opal service URL entered:" + Oeizzlks);
		}
		if (vJzPQJcD != null && IJvT8TtE == true) {
			System.out.println("URL entered: " + vJzPQJcD);
			Oeizzlks = vJzPQJcD.toString();
			List<ServiceDescription> QVQVuiCI = new ArrayList<ServiceDescription>();
			try {
				URL skXjBOiM = new URL(Oeizzlks);
				URLConnection ck5WHc8Q;
				DataInputStream mwihHyG2;
				try {
					ck5WHc8Q = skXjBOiM.openConnection();
					ck5WHc8Q.setDoInput(true);
					ck5WHc8Q.setUseCaches(false);
					mwihHyG2 = new DataInputStream(ck5WHc8Q.getInputStream());
					String eL3UaFwT;
					int y3J0SN7q = 0;
					int Z2qNmpFn;
					int AQH64n79;
					String z58Zoh15;
					String Q38h9ed4;
					while ((eL3UaFwT = mwihHyG2.readLine()) != null) {
						if (eL3UaFwT.contains("?wsdl")) {
							y3J0SN7q = eL3UaFwT.indexOf("\"") + 1;
							Z2qNmpFn = eL3UaFwT.indexOf("?");
							eL3UaFwT = eL3UaFwT.substring(y3J0SN7q, Z2qNmpFn);
							if (eL3UaFwT.startsWith("http"))
								eL3UaFwT = eL3UaFwT.substring(7);
							AQH64n79 = eL3UaFwT.lastIndexOf('/');
							z58Zoh15 = eL3UaFwT.substring(AQH64n79 + 1);
							Q38h9ed4 = eL3UaFwT.substring(0, AQH64n79);
							Q38h9ed4 = Q38h9ed4.replace('/', '_');
							if (!z58Zoh15.equals("Version") && !z58Zoh15.equals("AdminService")) {
								ExampleServiceDesc K2zbqzY4 = new ExampleServiceDesc();
								eL3UaFwT = z58Zoh15 + "_from_" + Q38h9ed4;
								K2zbqzY4.setExampleString(eL3UaFwT);
								K2zbqzY4.setExampleUri(URI.create(Oeizzlks));
								QVQVuiCI.add(K2zbqzY4);
							}
						}
					}
					mwihHyG2.close();
				} catch (IOException FbfP9iTS) {
					FbfP9iTS.printStackTrace();
				}
			} catch (MalformedURLException rIuUNJaN) {
				rIuUNJaN.printStackTrace();
			}
			li2qGXKI.partialResults(QVQVuiCI);
			li2qGXKI.finished();
		}
	}

}