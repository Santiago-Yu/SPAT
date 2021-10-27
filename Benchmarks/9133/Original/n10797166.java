class n10797166{
    public static String readFromUrl(String url) {
        URL url_ = null;
        URLConnection uc = null;
        BufferedReader in = null;
        StringBuilder str = new StringBuilder();
        try {
            url_ = new URL(url);
            uc = url_.openConnection();
            in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) str.append(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

}