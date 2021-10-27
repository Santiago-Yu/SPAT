class n12718571{
    private ArrayList loadHTML(URL url) {
        ArrayList res = new ArrayList();
        try {
            URLConnection myCon = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(myCon.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                res.add(inputLine);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("url> " + url);
        }
        return res;
    }

}