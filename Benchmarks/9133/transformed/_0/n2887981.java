class n2887981 {
	private CathUtils() throws Exception {
        super(Ontology.CATH);
        InputStream MOjARQuA = null;
        BufferedReader nfTMolrt = null;
        try {
            final String PCtwKJDY = OntologyFactory.getOntology(Ontology.CATH).getRegularExpression();
            final URL YfcI54vL = new URL("http://release.cathdb.info/v3.4.0/CathNames");
            MOjARQuA = YfcI54vL.openStream();
            nfTMolrt = new BufferedReader(new InputStreamReader(MOjARQuA, Charset.defaultCharset()));
            String oeuFRw9V = null;
            while ((oeuFRw9V = nfTMolrt.readLine()) != null) {
                final String[] cLaxA99F = oeuFRw9V.split("\\s+");
                if (RegularExpressionUtils.getMatches(cLaxA99F[0], PCtwKJDY).size() > 0) {
                    idToName.put(cLaxA99F[0], oeuFRw9V.substring(oeuFRw9V.indexOf(':') + 1, oeuFRw9V.length()));
                }
            }
        } finally {
            try {
                if (MOjARQuA != null) {
                    MOjARQuA.close();
                }
            } finally {
                if (nfTMolrt != null) {
                    nfTMolrt.close();
                }
            }
        }
    }

}