    public static PersistencyParameters parse(String unitName) {
        URL[] persistenceUnits;
        try {
            persistenceUnits = Classpath.search("META-INF/", "persistence.xml");
        } catch (IOException e) {
            throw new Error(e);
        }
        Set classes = new HashSet();
        for (int i = 0; i < persistenceUnits.length; i++) {
            URL url = persistenceUnits[i];
            try {
                nu.xom.Builder b = new nu.xom.Builder(false);
                Document d = b.build(url.openStream());
                Nodes unitNodes = d.getRootElement().query("//p:persistence-unit", new XPathContext("p", "http://java.sun.com/xml/ns/persistence"));
                for (int j = 0; j < unitNodes.size(); j++) {
                    Node unitNode = unitNodes.get(j);
                    Element unitElt = ((Element) unitNode);
                    String uName = unitElt.getAttributeValue("name");
                    if (!uName.equals(unitName)) continue;
                    {
                        PersistencyParameters parameters = new PersistencyParameters();
                        Nodes classNodes = unitElt.query("//p:property", new XPathContext("p", "http://java.sun.com/xml/ns/persistence"));
                        for (int k = 0; k < classNodes.size(); k++) {
                            Node classNode = classNodes.get(k);
                            if (!(classNode instanceof Element)) continue;
                            Element classElt = (Element) classNode;
                            String elementName = classElt.getAttribute("name").getValue();
                            if (elementName.equals("eclipselink.jdbc.url")) {
                                String elementValue = classElt.getAttribute("value").getValue();
                                parameters.setJdbcUrl(elementValue);
                            } else if (elementName.equals("eclipselink.jdbc.user")) {
                                String elementValue = classElt.getAttribute("value").getValue();
                                parameters.setDBUserName(elementValue);
                            } else if (elementName.equals("eclipselink.jdbc.password")) {
                                String elementValue = classElt.getAttribute("value").getValue();
                                parameters.setDBPassword(elementValue);
                            } else if (elementName.equals("eclipselink.jdbc.driver")) {
                                String elementValue = classElt.getAttribute("value").getValue();
                                parameters.setDBDriverClassName(elementValue);
                            }
                        }
                        return parameters;
                    }
                }
            } catch (Exception x) {
                x.printStackTrace();
                throw new Error(x);
            }
        }
        return null;
    }
