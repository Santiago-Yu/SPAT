    public static StreamSource getStreamSource(Item item, XQueryContext context) throws XPathException, MalformedURLException, IOException {
        StreamSource streamSource = new StreamSource();
        if (item.getType() == Type.JAVA_OBJECT) {
            LOG.debug("Streaming Java object");
            Object obj = ((JavaObjectValue) item).getObject();
            if (!(obj instanceof File)) {
                throw new XPathException("Passed java object should be a File");
            }
            File inputFile = (File) obj;
            InputStream is = new FileInputStream(inputFile);
            streamSource.setInputStream(is);
            streamSource.setSystemId(inputFile.toURI().toURL().toString());
        } else if (item.getType() == Type.ANY_URI) {
            LOG.debug("Streaming xs:anyURI");
            String url = item.getStringValue();
            if (url.startsWith("/")) {
                url = "xmldb:exist://" + url;
            }
            InputStream is = new URL(url).openStream();
            streamSource.setInputStream(is);
            streamSource.setSystemId(url);
        } else if (item.getType() == Type.ELEMENT || item.getType() == Type.DOCUMENT) {
            LOG.debug("Streaming element or document node");
            if (item instanceof NodeProxy) {
                NodeProxy np = (NodeProxy) item;
                String url = "xmldb:exist://" + np.getDocument().getBaseURI();
                LOG.debug("Document detected, adding URL " + url);
                streamSource.setSystemId(url);
            }
            Serializer serializer = context.getBroker().newSerializer();
            NodeValue node = (NodeValue) item;
            InputStream is = new NodeInputStream(serializer, node);
            streamSource.setInputStream(is);
        } else if (item.getType() == Type.BASE64_BINARY || item.getType() == Type.HEX_BINARY) {
            LOG.debug("Streaming base64 binary");
            BinaryValue binary = (BinaryValue) item;
            byte[] data = (byte[]) binary.toJavaObject(byte[].class);
            InputStream is = new ByteArrayInputStream(data);
            streamSource.setInputStream(is);
            if (item instanceof Base64BinaryDocument) {
                Base64BinaryDocument b64doc = (Base64BinaryDocument) item;
                String url = "xmldb:exist://" + b64doc.getUrl();
                LOG.debug("Base64BinaryDocument detected, adding URL " + url);
                streamSource.setSystemId(url);
            }
        } else {
            LOG.error("Wrong item type " + Type.getTypeName(item.getType()));
            throw new XPathException("wrong item type " + Type.getTypeName(item.getType()));
        }
        return streamSource;
    }
