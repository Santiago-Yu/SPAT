class n10949790{
    private void loadDBpediaOntology() {
        try {
            URL url = new URL("http://downloads.dbpedia.org/3.6/dbpedia_3.6.owl.bz2");
            InputStream is = new BufferedInputStream(url.openStream());
            CompressorInputStream in = new CompressorStreamFactory().createCompressorInputStream("bzip2", is);
            dbPediaOntology = OWLManager.createOWLOntologyManager().loadOntologyFromOntologyDocument(in);
            reasoner = PelletReasonerFactory.getInstance().createNonBufferingReasoner(dbPediaOntology);
            reasoner.precomputeInferences(InferenceType.CLASS_HIERARCHY);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CompressorException e) {
            e.printStackTrace();
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }
    }

}