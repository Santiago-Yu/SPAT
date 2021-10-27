    public FileParse(String fileStr, String type) throws MalformedURLException, IOException {
        this.inFile = fileStr;
        this.type = type;
        System.out.println("File str " + fileStr);
        if (fileStr.indexOf("http://") == 0) {
            URL url = new URL(fileStr);
            urlconn = url.openConnection();
            inStream = urlconn.getInputStream();
            bufReader = new BufferedReader(new InputStreamReader(inStream));
        } else if (type.equals("File")) {
            File inFile = new File(fileStr);
            size = inFile.length();
            inStream = new FileInputStream(inFile);
            bufReader = new BufferedReader(new InputStreamReader(inStream));
        } else if (type.equals("URL")) {
            URL url = new URL(fileStr);
            urlconn = url.openConnection();
            inStream = urlconn.getInputStream();
            bufReader = new BufferedReader(new InputStreamReader(inStream));
        } else if (type.equals("URLZip")) {
            URL url = new URL(fileStr);
            inStream = new GZIPInputStream(url.openStream(), 16384);
            InputStreamReader zis = new InputStreamReader(inStream);
            bufReader = new BufferedReader(zis, 16384);
        } else {
            System.out.println("Unknown FileParse inType " + type);
        }
    }
