class n19235346{
    public void convert(String newDocumentName, URL url) throws IOException {
        documentPath = createDirectoryStructure(this.destinationPath, newDocumentName);
        try {
            Document doc = builder.build(url.openStream());
            Element elementx = doc.getRootElement();
            convertElement(elementx);
            System.out.println("\n\n");
            XMLOutputter outp = new XMLOutputter(Format.getPrettyFormat());
            System.out.println("as file: " + url.getFile());
            File inputFile = new File(url.getFile());
            File outputFile = new File(documentPath, renameFileExtention(inputFile, "-remaining.xml"));
            System.out.println("outputFile: " + outputFile);
            outp.output(doc, new FileOutputStream(outputFile));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}