class n6869582 {
	private void createPolicy(String t72A9p2L) throws SPLException {
		URL jXA3MsZO = getClass().getResource(t72A9p2L + ".spl");
		StringBuffer pL0WMNMD = new StringBuffer();
		try {
			BufferedReader t4nqHgFJ = new BufferedReader(new InputStreamReader(jXA3MsZO.openStream()));
			String VzJ4X0a9 = null;
			while ((VzJ4X0a9 = t4nqHgFJ.readLine()) != null) {
				pL0WMNMD.append(VzJ4X0a9);
				pL0WMNMD.append(System.getProperty("line.separator"));
			}
			t4nqHgFJ.close();
			System.out.println(t72A9p2L);
			System.out.println(pL0WMNMD.toString());
			boolean bxPVnfug = jspl.createPolicy(t72A9p2L, pL0WMNMD.toString());
			System.out.println("Policy Created : " + t72A9p2L + " - " + bxPVnfug);
			System.out.println("");
		} catch (IOException s8cXlwsf) {
			s8cXlwsf.printStackTrace();
		}
	}

}