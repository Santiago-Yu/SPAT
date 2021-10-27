    public static Multimap<String, String> getProteins(final Set<String> queries, final int taxon) throws ParserConfigurationException, XPathExpressionException {
        final DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        final XPathExpression xpe = XPathFactory.newInstance().newXPath().compile(__xpath);
        final Multimap<String, String> proteins = HashMultimap.create();
        for (final String query : queries) {
            HttpURLConnection connection = null;
            try {
                final String encoded = URLEncoder.encode(query.trim(), "UTF-8");
                final URL url = new URL(String.format(__urlTempl2, encoded, taxon));
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(__connTimeout);
                connection.setReadTimeout(__readTimeout);
                connection.setRequestProperty("Connection", "close");
                connection.connect();
                final InputStream stream = connection.getInputStream();
                final Document doc = parser.parse(stream);
                final NodeList nodes = (NodeList) xpe.evaluate(doc, XPathConstants.NODESET);
                if (nodes != null) {
                    final int n = nodes.getLength();
                    for (int i = 0; i < n; i++) {
                        final Node node = nodes.item(i);
                        proteins.put(node.getTextContent().trim(), query.trim());
                    }
                }
            } catch (final Exception ex) {
                continue;
            } finally {
                if (connection != null) connection.disconnect();
            }
        }
        return proteins;
    }
