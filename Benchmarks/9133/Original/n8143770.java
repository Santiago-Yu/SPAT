class n8143770{
    public void testDatastreamWork3() throws FedoraConnectionException, DigitalObjectManager.DigitalObjectNotFoundException, StoreException, ParseException, IOException {
        String content = "ahsddksjgldskdlfnskl\nlskdfjlsjdf\n";
        String pid = fedoraConnector.newObject();
        assertTrue(fedoraConnector.exists(pid));
        assertTrue(fedoraConnector.isPlanetsObject(pid));
        assertTrue(fedoraConnector.isDataObject(pid));
        assertTrue(fedoraConnector.isWritable(pid));
        try {
            fedoraConnector.getDatastreamString(pid, "CONTENT");
            fail("Datastream should not be there");
        } catch (DigitalObjectManager.DigitalObjectNotFoundException e) {
        }
        fedoraConnector.modifyDatastream(pid, "CONTENT", content, null);
        URL url = fedoraConnector.getDatastreamURL(pid, "CONTENT");
        InputStream stream = url.openStream();
        String storedContent = convertStreamToString(stream);
        assertEquals(content, storedContent);
        fedoraConnector.purgeObject(pid);
    }

}