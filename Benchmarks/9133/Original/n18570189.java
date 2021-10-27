class n18570189{
    public ViewedCandidates postViewedCandidates(ViewedCandidates viewedCandidates) throws BookKeeprCommunicationException {
        try {
            synchronized (httpClient) {
                HttpPost req = new HttpPost(remoteHost.getUrl() + "/cand/viewed");
                req.setHeader("Accept-Encoding", "gzip");
                ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
                XMLWriter.write(out, viewedCandidates);
                ByteArrayInputStream in2 = new ByteArrayInputStream(out.toByteArray());
                req.setEntity(new InputStreamEntity(in2, -1));
                HttpResponse resp = httpClient.execute(req);
                if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    try {
                        InputStream in = resp.getEntity().getContent();
                        Header hdr = resp.getFirstHeader("Content-Encoding");
                        String enc = "";
                        if (hdr != null) {
                            enc = resp.getFirstHeader("Content-Encoding").getValue();
                        }
                        if (enc.equals("gzip")) {
                            in = new GZIPInputStream(in);
                        }
                        XMLAble xmlable = XMLReader.read(in);
                        in.close();
                        if (xmlable instanceof ViewedCandidates) {
                            ViewedCandidates p = (ViewedCandidates) xmlable;
                            return p;
                        } else {
                            resp.getEntity().consumeContent();
                            throw new BookKeeprCommunicationException("BookKeepr returned the wrong thing for ViewedCandidates");
                        }
                    } catch (SAXException ex) {
                        Logger.getLogger(BookKeeprConnection.class.getName()).log(Level.WARNING, "Got a malformed message from the bookkeepr", ex);
                        throw new BookKeeprCommunicationException(ex);
                    }
                } else {
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

}