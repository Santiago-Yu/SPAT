    public void runWeb(String beginURL, String contextRoot, String pageURI) {
        if (bDebug) System.out.println("WEB Path");
        List<String> vtURLs = new ArrayList<String>();
        List<String> vtRobots = getRobots(beginURL, contextRoot);
        vtURLs.add("/" + contextRoot + "/" + pageURI);
        Indexer indexer = null;
        IndexDocument indexDoc = null;
        try {
            indexer = new Indexer("/tmp/tmp/index");
            for (String sxURL : vtURLs) {
                if (bDebug) System.out.println("\n\n*** INDEXING " + sxURL);
                if (bDebug) System.out.println("Have - " + sxURL);
                boolean bIndexPage = true;
                if (vtRobots != null) {
                    for (String sxRobotURL : vtRobots) {
                        if (bDebug) System.out.println("Comparing to - " + sxRobotURL);
                        if (sxURL.startsWith(sxRobotURL)) {
                            if (bDebug) System.out.println("Found URL - " + sxRobotURL + " - " + sxURL);
                            bIndexPage = false;
                            break;
                        }
                    }
                } else {
                    bIndexPage = true;
                }
                sxURL = beginURL + sxURL;
                ParserDelegator pd = new ParserDelegator();
                CallbackHandler cb = new CallbackHandler(vtURLs, bIndexPage, contextRoot);
                try {
                    URLConnection urlConn = new URL(sxURL).openConnection();
                    urlConn.setUseCaches(false);
                    Date modDate = new Date(urlConn.getLastModified());
                    if (bDebug) System.out.println("\nMatch - " + sxURL + " - Modified Date - " + modDate);
                    BufferedReader bfReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                    pd.parse(bfReader, cb, true);
                    if (bIndexPage) {
                        if (bDebug) System.out.println("Adding Index - " + sxURL + "\nContent:" + cb.getText() + "\nSummary:" + cb.getSummary() + "\nTitle:" + cb.getTitle());
                        indexDoc = new IndexDocument();
                        indexDoc.setUID(sxURL + modDate.toString());
                        indexDoc.setPageURL(sxURL);
                        indexDoc.setModifiedDate(modDate.toString());
                        indexDoc.setContents(cb.getText());
                        indexDoc.setTitle(cb.getTitle());
                        indexDoc.setSummary(cb.getSummary());
                        indexer.addDocument(indexDoc);
                    }
                } catch (Exception ee) {
                    PetstoreUtil.getLogger().log(Level.SEVERE, "Inner Exception" + ee);
                }
            }
        } catch (Exception e) {
            PetstoreUtil.getLogger().log(Level.SEVERE, "Outer Exception" + e);
        } finally {
            try {
                if (indexer != null) {
                    indexer.close();
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }
