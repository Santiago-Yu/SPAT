class n5510183{
    public static String getMyGlobalIP() {
        try {
            URL url = new URL(IPSERVER);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String ip = in.readLine();
            in.close();
            con.disconnect();
            return ip;
        } catch (Exception e) {
            return null;
        }
    }

}