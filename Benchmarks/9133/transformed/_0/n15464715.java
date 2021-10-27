class n15464715 {
	private String sendQuery(String Fo4d10cF) {
		File rSRciZXi = null;
		String xBu2FaYh = "";
		try {
			long lx7ze2dn = Calendar.getInstance().getTimeInMillis();
			System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("    consulta de busqueda -> " + Fo4d10cF);
			URL zSRb6Mhg = new URL(Fo4d10cF);
			BufferedReader mojbwXLB = new BufferedReader(new InputStreamReader(zSRb6Mhg.openStream()));
			String IYnze7D9 = "";
			while ((IYnze7D9 = mojbwXLB.readLine()) != null) {
				xBu2FaYh += IYnze7D9;
			}
			long X7w3AaV7 = (Calendar.getInstance().getTimeInMillis() - lx7ze2dn);
			System.out.println(" Tiempo transcurrido en la consulta (en milesimas) -> " + X7w3AaV7);
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		} catch (IOException MJgizIxr) {
			MJgizIxr.printStackTrace();
		}
		return xBu2FaYh;
	}

}