class n20194293{
    public static void main(String[] argArray) {
        if (argArray.length == 0) {
            System.out.println("Usage: java  -jar doc-analyzer.jar  url | file");
        }
        List<URL> urlList = new LinkedList<URL>();
        for (String urlStr : argArray) {
            if (!(urlStr.startsWith("http") || urlStr.startsWith("file"))) {
                if (urlStr.indexOf("*") > -1) {
                    if (urlStr.indexOf("**") > -1) {
                    }
                    continue;
                } else {
                    if (!urlStr.startsWith("/")) {
                        File workDir = new File(System.getProperty("user.dir"));
                        urlStr = workDir.getPath() + "/" + urlStr;
                    }
                    urlStr = "file:" + urlStr;
                }
            }
            try {
                URL url = new URL(urlStr);
                urlList.add(url);
            } catch (MalformedURLException murle) {
                System.err.println(murle);
            }
        }
        for (URL url : urlList) {
            try {
                Document doc = builder.build(url.openStream());
                Element element = doc.getRootElement();
                Map<String, Long> numberOfElementMap = countElement(element);
                System.out.println("Overview of tags in '" + url + "':");
                for (String elementName : new TreeSet<String>(numberOfElementMap.keySet())) {
                    System.out.println("  " + elementName + ": " + numberOfElementMap.get(elementName));
                }
            } catch (JDOMException jdome) {
                System.err.println(jdome.getMessage());
            } catch (IOException ioe) {
                System.err.println(ioe.getMessage());
            }
        }
    }

}