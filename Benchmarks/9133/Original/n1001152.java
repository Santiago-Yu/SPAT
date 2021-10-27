class n1001152{
    private void doOp(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }
        URLConnection conn = null;
        try {
            conn = url.openConnection();
            conn.setRequestProperty("Authorization", "Basic " + (new BASE64Encoder()).encode((System.getProperty("fedoragsearch.fgsUserName") + ":" + System.getProperty("fedoragsearch.fgsPassword")).getBytes()));
            conn.connect();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        content = null;
        try {
            content = conn.getContent();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader((InputStream) content));
        try {
            while ((line = br.readLine()) != null) System.out.println(line);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}