class n23232384{
    public static void main(String[] args) {
        URL url = Thread.currentThread().getContextClassLoader().getResource("org/jeditor/resources/jeditor.properties");
        try {
            PropertyResourceBundle prb = new PropertyResourceBundle(url.openStream());
            String version = prb.getString("version");
            String date = prb.getString("date");
            System.out.println("jEditor version " + version + " build on " + date);
            System.out.println("Distributed under GPL license");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}