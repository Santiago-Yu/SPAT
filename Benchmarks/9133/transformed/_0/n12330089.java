class n12330089 {
	public static void main(String[] DlbEXXhG) throws Exception {
		final URL iROFKoMg = new URL(
				"http://www.ebi.ac.uk/Tools/webservices/psicquic/registry/registry?action=ACTIVE&format=txt");
		BufferedReader A0EVKnBI = new BufferedReader(new InputStreamReader(iROFKoMg.openStream()));
		String AFEq69xM;
		Map<String, String> GHTi8MDf = new HashMap<String, String>();
		while ((AFEq69xM = A0EVKnBI.readLine()) != null) {
			final int QGVQ8wmv = AFEq69xM.indexOf('=');
			GHTi8MDf.put(AFEq69xM.substring(0, QGVQ8wmv), AFEq69xM.substring(QGVQ8wmv + 1, AFEq69xM.length()));
		}
		A0EVKnBI.close();
		System.out.println("Found " + GHTi8MDf.size() + " active service(s).");
		for (Object NKLkCeJQ : GHTi8MDf.keySet()) {
			String q93EIzLU = (String) NKLkCeJQ;
			String upII4tyG = GHTi8MDf.get(q93EIzLU);
			System.out.println(q93EIzLU + " -> " + upII4tyG);
			UniversalPsicquicClient YKRGDGgK = new UniversalPsicquicClient(upII4tyG);
			try {
				SearchResult<?> nxa5lz9Y = YKRGDGgK.getByInteractor("brca2", 0, 50);
				System.out.println("Interactions found: " + nxa5lz9Y.getTotalCount());
				for (BinaryInteraction bCPaDVpn : nxa5lz9Y.getData()) {
					String HxvPZk9v = bCPaDVpn.getInteractorA().getIdentifiers().iterator().next().getIdentifier();
					String ANCpCFbn = bCPaDVpn.getInteractorB().getIdentifiers().iterator().next().getIdentifier();
					String LpgCz2XS = "-";
					if (!bCPaDVpn.getInteractionAcs().isEmpty()) {
						CrossReference ZAkukkNi = (CrossReference) bCPaDVpn.getInteractionAcs().iterator().next();
						LpgCz2XS = ZAkukkNi.getIdentifier();
					}
					System.out.println("\tInteraction (" + LpgCz2XS + "): " + HxvPZk9v + " interacts with " + ANCpCFbn);
				}
			} catch (Throwable RyVddU8x) {
				System.err.println("Service is down! " + q93EIzLU + "(" + upII4tyG + ")");
			}
		}
	}

}