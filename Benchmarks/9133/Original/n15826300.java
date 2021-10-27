class n15826300{
    public static Map<String, List<String>> getResponseHeader(String address) {
        System.out.println(address);
        URLConnection conn = null;
        Map<String, List<String>> responseHeader = null;
        try {
            URL url = new URL(address);
            conn = url.openConnection();
            responseHeader = conn.getHeaderFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseHeader;
    }

}