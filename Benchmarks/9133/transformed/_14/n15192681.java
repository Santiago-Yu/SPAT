class n15192681 {
	public DataSetInfo(String request) throws AddeURLException {
        URLConnection urlc;
        BufferedReader reader;
        debug = debug || request.indexOf("debug=true") >= 0;
        try {
            URL url = new URL(request);
            urlc = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
        } catch (AddeURLException ae) {
            status = -1;
            throw new AddeURLException("No datasets found");
        } catch (Exception e) {
            status = -1;
            throw new AddeURLException("Error opening connection: " + e);
        }
        int numBytes = ((AddeURLConnection) urlc).getInitialRecordSize();
        if (debug) System.out.println("DataSetInfo: numBytes = " + numBytes);
        if (0 == numBytes) {
            status = -1;
            throw new AddeURLException("No datasets found");
        } else {
            data = new char[numBytes];
            try {
                int start = 0;
                while (start < numBytes) {
                    int numRead = reader.read(data, start, (numBytes - start));
                    if (debug) System.out.println("bytes read = " + numRead);
                    start += numRead;
                }
            } catch (IOException e) {
                status = -1;
                throw new AddeURLException("Error reading dataset info:" + e);
            }
            int numNames = data.length / 80;
            descriptorTable = new Hashtable(numNames);
            if (debug) System.out.println("Number of descriptors = " + numNames);
            for (int i = 0; i < numNames; i++) {
                String temp = new String(data, i * 80, 80);
                if (debug) System.out.println("Parsing: >" + temp + "<");
                if (temp.trim().equals("")) continue;
                String descriptor = temp.substring(0, 12).trim();
                if (debug) System.out.println("Descriptor = " + descriptor);
                String comment = descriptor;
                int pos = temp.indexOf('"');
                if (debug) System.out.println("Found quote at " + pos);
                if (pos >= 23) {
                    comment = temp.substring(pos + 1).trim();
                    if (comment.equals("")) comment = descriptor;
                }
                if (debug) System.out.println("Comment = " + comment);
                descriptorTable.put(comment, descriptor);
            }
        }
    }

}