    public static void main(String[] args) throws Exception {
        int result = 20;
        if (args.length == 1) {
            StringBuffer urlString = new StringBuffer(args[0]);
            if (urlString.lastIndexOf("/") != urlString.length() - 1) {
                urlString.append('/');
            }
            urlString.append("GetConfig.jsp");
            URLConnection conn = new URL(urlString.toString()).openConnection();
            System.out.println(Configuration.readObject(conn.getInputStream()));
            result = 0;
        } else {
            System.err.println("usage: GetConfig <URL>");
        }
        System.exit(result);
    }
