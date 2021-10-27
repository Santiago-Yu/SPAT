class n4981115{
    private String fazHttpRequest(String u) {
        StringBuilder str = new StringBuilder();
        URL url = null;
        URLConnection urlC = null;
        try {
            url = new URL(u.toString());
            urlC = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlC.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                str.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("[fazHttpRequest]" + e);
        }
        return (str.length() > 0) ? str.toString() : null;
    }

}