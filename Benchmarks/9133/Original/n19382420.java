class n19382420{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ejb.bprocess.OAIPMH.AutoHarvesterSession ahSession = home.create();
            java.util.Vector vector = new java.util.Vector(1, 1);
            Integer libraryId = new Integer(1);
            String xmlstr = "";
            String str = "";
            String arr[] = new String[2];
            String[] subarr = new String[4];
            String mdPrefix = "", mdPrefixValue = "";
            String from = "", fromValue = "";
            String until = "", untilValue = "";
            String set = "", setValue = "";
            String oai_pmhRequest = request.getParameter("verb");
            String oai_pmhQuery = request.getQueryString();
            String urlStr = "";
            urlStr = "http://" + request.getServerName() + ":" + request.getServerPort() + "/newgenlibctxt/HarvestServlet";
            String attribute = oai_pmhQuery;
            String arguments = attribute.substring(attribute.indexOf("?") + 1);
            StringTokenizer st = new StringTokenizer(arguments, "&");
            int i = 0;
            int j = 0;
            int z = 0;
            int count = 0;
            String type = "";
            while (st.hasMoreTokens()) {
                arr[i] = st.nextToken();
                StringTokenizer subst = new StringTokenizer(arr[i], "=");
                while (subst.hasMoreTokens()) {
                    subarr[j] = subst.nextToken();
                    j++;
                }
                i++;
                count++;
            }
            int mdfCount = 0, fromCount = 0, untilCount = 0, setCount = 0;
            ListRecords lr = new ListRecords();
            for (int k = 0; k < j; k += 2) {
                if (subarr[k].equals("from")) {
                    from = "from";
                    fromCount++;
                    fromValue = subarr[k + 1];
                    fromValue = lr.validateDate(fromValue);
                } else if (subarr[k].equals("until")) {
                    until = "until";
                    untilCount++;
                    untilValue = subarr[k + 1];
                    untilValue = lr.validateDate(untilValue);
                }
            }
            if (fromValue.equals("") && untilCount == 1) {
                fromValue = lr.validateDate("0001-01-01");
            } else if (untilValue.equals("") && fromCount == 1) {
                String a = (new Resdate()).getDate();
                untilValue = a.substring(0, a.indexOf("T"));
            }
            System.out.println("This is fromValue:" + fromValue);
            System.out.println("This is untilValue:" + untilValue);
            vector = ahSession.getHarvestLibrary(null, libraryId);
            String harlibraryId = "";
            if (vector.size() > 0) {
                for (int k = 0; k < vector.size(); k = k + 3) {
                    harlibraryId = vector.elementAt(k).toString();
                    String harvesturl = vector.elementAt(k + 1).toString();
                    String status = vector.elementAt(k + 2).toString();
                    if (status.equals("A")) {
                        String oai_pmhRequest1 = request.getParameter("verb");
                        String oai_pmhQuery1 = request.getQueryString();
                        urlStr = "http://" + harvesturl + ":8080/newgenlibctxt/oai2.0?verb=ListRecords&metadataPrefix=marc21&from=" + fromValue + "&until=" + untilValue + "";
                        boolean resExists = true;
                        for (int n = 0; resExists == true; n++) {
                            java.net.URL url = new java.net.URL(urlStr);
                            java.net.URLConnection urlCon = url.openConnection();
                            urlCon.setDoInput(true);
                            urlCon.connect();
                            InputStream is = urlCon.getInputStream();
                            System.out.println("input" + is.available());
                            org.jdom.input.SAXBuilder sb = new org.jdom.input.SAXBuilder();
                            org.jdom.Document doc = sb.build(is);
                            xmlstr = (new org.jdom.output.XMLOutputter()).outputString(doc);
                            System.out.println("xmlStr:" + xmlstr);
                            doc = null;
                            sb = null;
                            java.util.Vector vec = new java.util.Vector();
                            vec = ahSession.autoInitialHarvest(null, xmlstr, harlibraryId);
                            String resT = doc.getRootElement().getChildText("resumptionToken", doc.getRootElement().getNamespace());
                            if (!(resT == null)) {
                                urlStr = "http://" + harvesturl + ":8080/newgenlibctxt/oai2.0?verb=ListRecords&resumptionToken=" + resT;
                            } else {
                                resExists = false;
                            }
                        }
                    } else if (status.equals("B")) {
                        java.io.File file = new java.io.File(harvesturl);
                        java.io.File[] file1 = file.listFiles();
                        for (int b = 0; b < file1.length; b++) {
                            File file2 = (File) file1[b];
                            System.out.println("File2:" + file2);
                            long lastmodifed = file2.lastModified();
                            StringTokenizer st1 = new StringTokenizer(fromValue, "-");
                            String dar[] = new String[3];
                            java.util.Calendar c1 = java.util.Calendar.getInstance();
                            int g = 0;
                            while (st1.hasMoreElements()) {
                                dar[g] = st1.nextToken();
                                g++;
                            }
                            c1.set(Integer.parseInt(dar[0]), Integer.parseInt(dar[1]), Integer.parseInt(dar[2]));
                            StringTokenizer st2 = new StringTokenizer(untilValue, "-");
                            String dar1[] = new String[3];
                            java.util.Calendar c2 = java.util.Calendar.getInstance();
                            int d = 0;
                            while (st2.hasMoreElements()) {
                                dar1[d] = st2.nextToken();
                                d++;
                            }
                            c2.set(Integer.parseInt(dar1[0]), Integer.parseInt(dar1[1]), Integer.parseInt(dar1[2]));
                            java.util.Calendar c3 = java.util.Calendar.getInstance();
                            c3.setTimeInMillis(lastmodifed);
                            c3.set(java.util.Calendar.HOUR, 0);
                            c3.set(java.util.Calendar.AM_PM, java.util.Calendar.AM);
                            c3.set(java.util.Calendar.MINUTE, 0);
                            c3.set(java.util.Calendar.SECOND, 0);
                            c3.set(java.util.Calendar.MILLISECOND, 0);
                            java.util.Date d1 = c1.getTime();
                            java.util.Date d2 = c2.getTime();
                            java.util.Date d3 = c3.getTime();
                            System.out.println("This is d1:" + d1);
                            System.out.println("This is d2:" + d2);
                            System.out.println("This is d3:" + d3);
                            if (d3.after(d1) && d3.before(d2)) {
                                org.jdom.input.SAXBuilder sb1 = new org.jdom.input.SAXBuilder();
                                org.jdom.Document doc1 = sb1.build(new java.io.FileInputStream(file2));
                                xmlstr = (new org.jdom.output.XMLOutputter()).outputString(doc1);
                                java.util.Vector vec = new java.util.Vector();
                                vec = ahSession.autoInitialHarvest(null, xmlstr, harlibraryId);
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}