class n10494402{
    private Comic[] getAllComics() {
        try {
            URL comicURL = new URL(comicSite + "list");
            InputStream is = comicURL.openStream();
            BufferedReader buffread = new BufferedReader(new InputStreamReader(is));
            Vector tmplist = new Vector();
            while (buffread.ready()) {
                String comic = buffread.readLine();
                tmplist.add(comic);
            }
            Comic[] list = new Comic[tmplist.size()];
            activated = new boolean[tmplist.size()];
            titles = new String[tmplist.size()];
            for (int i = 0; i < tmplist.size(); i++) {
                try {
                    URL curl = new URL(comicSite + (String) tmplist.get(i));
                    BufferedInputStream bis = new BufferedInputStream(curl.openStream());
                    Properties cprop = new Properties();
                    cprop.load(bis);
                    Comic c = new Comic(cprop, false);
                    list[i] = c;
                    titles[i] = c.getName();
                    activated[i] = comicsmanager.isLoaded(c.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }
            return list;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}