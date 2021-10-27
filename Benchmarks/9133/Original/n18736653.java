class n18736653{
    public void load() {
        try {
            isSourceWorking = true;
            URLConnection urlConnection = url.openConnection();
            ontologyServiceMetaData.setName("Ontology for " + url.getFile());
            parseDocument(urlConnection.getInputStream());
            buildTree();
            isSourceWorking = true;
            String statusOKMessage = PedroResources.getMessage("ontology.statusOK", url.getFile());
            status = new StringBuffer();
            status.append(statusOKMessage);
        } catch (Exception err) {
            err.printStackTrace(System.out);
            String statusErrorMessage = PedroResources.getMessage("ontology.statusError", err.toString());
            status.append(statusErrorMessage);
            isSourceWorking = false;
        }
    }

}