    public static Document ByURL(String urlstr) throws IOException {
        String uri = urlstr;
        URL url = new URL(uri);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        Reader reader = new InputStreamReader(in);
        InputSource is = new InputSourceImpl(reader, uri);
        System.out.println(is.toString());
        Document document = new Document() {

            @Override
            public Node adoptNode(Node source) throws DOMException {
                return null;
            }

            @Override
            public Attr createAttribute(String name) throws DOMException {
                return null;
            }

            @Override
            public Attr createAttributeNS(String namespaceURI, String qualifiedName) throws DOMException {
                return null;
            }

            @Override
            public CDATASection createCDATASection(String data) throws DOMException {
                return null;
            }

            @Override
            public Comment createComment(String data) {
                return null;
            }

            @Override
            public DocumentFragment createDocumentFragment() {
                return null;
            }

            @Override
            public Element createElement(String tagName) throws DOMException {
                return null;
            }

            @Override
            public Element createElementNS(String namespaceURI, String qualifiedName) throws DOMException {
                return null;
            }

            @Override
            public EntityReference createEntityReference(String name) throws DOMException {
                return null;
            }

            @Override
            public ProcessingInstruction createProcessingInstruction(String target, String data) throws DOMException {
                return null;
            }

            @Override
            public Text createTextNode(String data) {
                return null;
            }

            @Override
            public DocumentType getDoctype() {
                return null;
            }

            @Override
            public Element getDocumentElement() {
                return null;
            }

            @Override
            public String getDocumentURI() {
                return null;
            }

            @Override
            public DOMConfiguration getDomConfig() {
                return null;
            }

            @Override
            public Element getElementById(String elementId) {
                return null;
            }

            @Override
            public NodeList getElementsByTagName(String tagname) {
                return null;
            }

            @Override
            public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
                return null;
            }

            @Override
            public DOMImplementation getImplementation() {
                return null;
            }

            @Override
            public String getInputEncoding() {
                return null;
            }

            @Override
            public boolean getStrictErrorChecking() {
                return false;
            }

            @Override
            public String getXmlEncoding() {
                return null;
            }

            @Override
            public boolean getXmlStandalone() {
                return false;
            }

            @Override
            public String getXmlVersion() {
                return null;
            }

            @Override
            public Node importNode(Node importedNode, boolean deep) throws DOMException {
                return null;
            }

            @Override
            public void normalizeDocument() {
            }

            @Override
            public Node renameNode(Node n, String namespaceURI, String qualifiedName) throws DOMException {
                return null;
            }

            @Override
            public void setDocumentURI(String documentURI) {
            }

            @Override
            public void setStrictErrorChecking(boolean strictErrorChecking) {
            }

            @Override
            public void setXmlStandalone(boolean xmlStandalone) throws DOMException {
            }

            @Override
            public void setXmlVersion(String xmlVersion) throws DOMException {
            }

            public Node appendChild(Node arg0) throws DOMException {
                return null;
            }

            public Node cloneNode(boolean arg0) {
                return null;
            }

            public short compareDocumentPosition(Node arg0) throws DOMException {
                return 0;
            }

            public NamedNodeMap getAttributes() {
                return null;
            }

            public String getBaseURI() {
                return null;
            }

            public NodeList getChildNodes() {
                return null;
            }

            public Object getFeature(String arg0, String arg1) {
                return null;
            }

            public Node getFirstChild() {
                return null;
            }

            public Node getLastChild() {
                return null;
            }

            public String getLocalName() {
                return null;
            }

            public String getNamespaceURI() {
                return null;
            }

            public Node getNextSibling() {
                return null;
            }

            public String getNodeName() {
                return null;
            }

            public short getNodeType() {
                return 0;
            }

            public String getNodeValue() throws DOMException {
                return null;
            }

            public Document getOwnerDocument() {
                return null;
            }

            public Node getParentNode() {
                return null;
            }

            public String getPrefix() {
                return null;
            }

            public Node getPreviousSibling() {
                return null;
            }

            public String getTextContent() throws DOMException {
                return null;
            }

            public Object getUserData(String arg0) {
                return null;
            }

            public boolean hasAttributes() {
                return false;
            }

            public boolean hasChildNodes() {
                return false;
            }

            public Node insertBefore(Node arg0, Node arg1) throws DOMException {
                return null;
            }

            public boolean isDefaultNamespace(String arg0) {
                return false;
            }

            public boolean isEqualNode(Node arg0) {
                return false;
            }

            public boolean isSameNode(Node arg0) {
                return false;
            }

            public boolean isSupported(String arg0, String arg1) {
                return false;
            }

            public String lookupNamespaceURI(String arg0) {
                return null;
            }

            public String lookupPrefix(String arg0) {
                return null;
            }

            public void normalize() {
            }

            public Node removeChild(Node arg0) throws DOMException {
                return null;
            }

            public Node replaceChild(Node arg0, Node arg1) throws DOMException {
                return null;
            }

            public void setNodeValue(String arg0) throws DOMException {
            }

            public void setPrefix(String arg0) throws DOMException {
            }

            public void setTextContent(String arg0) throws DOMException {
            }

            public Object setUserData(String arg0, Object arg1, UserDataHandler arg2) {
                return null;
            }
        };
        return document;
    }
