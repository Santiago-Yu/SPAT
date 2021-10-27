class n10057850 {
	public BasicTraceImpl() {
        out = System.out;
        traceEnable = new HashMap();
        URL url = Hive.getURL("trace.cfg");
        if (url != null) try {
            InputStream input = url.openStream();
            String line;
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            for (line = in.readLine(); line != null; line = in.readLine()) {
                int i = line.indexOf("=");
                if (i > 0) {
                    String name = line.substring(0, i).trim();
                    String value = line.substring(i + 1).trim();
                    traceEnable.put(name, Boolean.valueOf(value).booleanValue() ? ((Object) (Boolean.TRUE)) : ((Object) (Boolean.FALSE)));
                }
            }
            input.close();
        } catch (IOException io) {
            System.out.println(io);
        }
        TRACE = getEnable(THIS);
    }

}