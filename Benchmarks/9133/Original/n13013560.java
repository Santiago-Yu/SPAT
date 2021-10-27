class n13013560{
    public static Node carregaModeloJME(String caminho) {
        try {
            URL urlModelo = ModelUtils.class.getClassLoader().getResource(caminho);
            BufferedInputStream leitorBinario = new BufferedInputStream(urlModelo.openStream());
            Node modelo = (Node) BinaryImporter.getInstance().load(leitorBinario);
            modelo.setModelBound(new BoundingBox());
            modelo.updateModelBound();
            return modelo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}