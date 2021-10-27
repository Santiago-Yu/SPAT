class n16477574{
    public static ArrayList search(String query) throws Exception {
        ArrayList list = new ArrayList();
        String url = "http://hypem.com/playlist/search/" + query + "/xml/1/list.xspf";
        HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
        XmlNode node = XmlLoader.load(conn.getInputStream());
        XmlNode tracks[] = node.getFirstChild("trackList").getChild("track");
        for (int i = 0; i < tracks.length; i++) {
            String location = decrypt(tracks[i].getFirstChild("location").getText());
            String annotation = tracks[i].getFirstChild("annotation").getText().replaceAll("[\r\n]", "");
            list.add(location);
            System.out.print("found in Hypem: ");
            System.out.print(annotation);
            System.out.print(", ");
            System.out.println(location);
        }
        return list;
    }

}