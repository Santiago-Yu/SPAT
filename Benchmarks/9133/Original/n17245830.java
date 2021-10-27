class n17245830{
    private static String readURL(URL url) {
        String s = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null) {
                s += str;
            }
            in.close();
        } catch (Exception e) {
            s = null;
        }
        return s;
    }

}