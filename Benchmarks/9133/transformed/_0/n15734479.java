class n15734479 {
	private List<String[]> retrieveData(String ofNy1YAL) {
		List<String[]> IJ0wAuYP = new Vector<String[]>();
		ofNy1YAL = ofNy1YAL.replaceAll("\\s", "+");
		String s2gtgpg5 = "http://www.uniprot.org/uniprot/?query=" + ofNy1YAL
				+ "&format=tab&columns=id,protein%20names,organism";
		try {
			URL RSbY2Rwm = new URL(s2gtgpg5);
			BufferedReader L98QoSCi = new BufferedReader(new InputStreamReader(RSbY2Rwm.openStream()));
			String NwI8IP7q = "";
			L98QoSCi.readLine();
			while ((NwI8IP7q = L98QoSCi.readLine()) != null) {
				String[] OTDfXaiE = NwI8IP7q.split("\t");
				String[] XoRT8T3G = new String[] { OTDfXaiE[0], OTDfXaiE[1], OTDfXaiE[2] };
				IJ0wAuYP.add(XoRT8T3G);
			}
			L98QoSCi.close();
			if (IJ0wAuYP.size() == 0) {
				JOptionPane.showMessageDialog(this, "No data found for query");
			}
		} catch (MalformedURLException NZpIUbUA) {
			System.err.println("Query " + s2gtgpg5 + " caused exception: ");
			NZpIUbUA.printStackTrace();
		} catch (Exception Qf4TnZUp) {
			System.err.println("Query " + s2gtgpg5 + " caused exception: ");
			Qf4TnZUp.printStackTrace();
		}
		return IJ0wAuYP;
	}

}