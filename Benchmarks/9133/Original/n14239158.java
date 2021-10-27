class n14239158{
    public Ontology open(String resource_name) {
        Ontology ontology = null;
        try {
            URL url = null;
            if (resource_name.startsWith("jar")) url = new URL(resource_name); else {
                ClassLoader cl = this.getClass().getClassLoader();
                url = cl.getResource(resource_name);
            }
            InputStream input_stream;
            if (url != null) {
                JarURLConnection jc = (JarURLConnection) url.openConnection();
                input_stream = jc.getInputStream();
            } else input_stream = new FileInputStream(resource_name);
            ObjectInputStream ois = new ObjectInputStream(input_stream);
            ontology = (Ontology) ois.readObject();
            ois.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return ontology;
    }

}