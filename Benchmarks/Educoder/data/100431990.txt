    public Processing getProcess(long processId) throws BookKeeprCommunicationException {
        try {
            synchronized (httpClient) {
                HttpGet req = new HttpGet(remoteHost.getUrl() + "/id/" + Long.toHexString(processId));
                HttpResponse resp = httpClient.execute(req);
                if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    try {
                        XMLAble xmlable = XMLReader.read(resp.getEntity().getContent());
                        if (xmlable instanceof Processing) {
                            Processing p = (Processing) xmlable;
                            return p;
                        } else {
                            throw new BookKeeprCommunicationException("BookKeepr returned the wrong thing for pointingID");
                        }
                    } catch (SAXException ex) {
                        Logger.getLogger(BookKeeprConnection.class.getName()).log(Level.WARNING, "Got a malformed message from the bookkeepr", ex);
                        throw new BookKeeprCommunicationException(ex);
                    }
                } else {
                    resp.getEntity().consumeContent();
                    throw new BookKeeprCommunicationException("Got a " + resp.getStatusLine().getStatusCode() + " from the BookKeepr");
                }
            }
        } catch (HttpException ex) {
            throw new BookKeeprCommunicationException(ex);
        } catch (IOException ex) {
            throw new BookKeeprCommunicationException(ex);
        } catch (URISyntaxException ex) {
            throw new BookKeeprCommunicationException(ex);
        }
    }
