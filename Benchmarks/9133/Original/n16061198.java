class n16061198{
    public void download(String target) {
        try {
            if (url == null) return;
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "Internet Explorer");
            conn.setReadTimeout(10000);
            conn.connect();
            httpReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            java.io.BufferedWriter out = new BufferedWriter(new FileWriter(target, false));
            String str = httpReader.readLine();
            while (str != null) {
                out.write(str);
                str = httpReader.readLine();
            }
            out.close();
            System.out.println("file download successfully: " + url.getHost() + url.getPath());
            System.out.println("saved to: " + target);
        } catch (Exception e) {
            System.out.println("file download failed: " + url.getHost() + url.getPath());
            e.printStackTrace();
        }
    }

}