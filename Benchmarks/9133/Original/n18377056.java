class n18377056{
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://obs-he-lm:8888/XCATDR3/getproduct?obsid=0113060201&dtype=flatfiles&prd=P0113060201M2S003STSPLT8004.PDF");
        URLConnection conn = url.openConnection();
        Map<String, List<String>> map = conn.getHeaderFields();
        JSONObject jso = new JSONObject();
        for (Entry<String, List<String>> s : map.entrySet()) {
            System.out.println(s.getKey());
            for (String v : s.getValue()) {
                System.out.println("   " + v);
            }
            jso.put(s.getKey(), s.getValue().get(0));
        }
        conn.getInputStream().close();
        System.out.println(jso.toJSONString());
    }

}