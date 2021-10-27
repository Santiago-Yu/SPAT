class n18214578{
    public void openJadFile(URL url) {
        try {
            setStatusBar("Loading...");
            jad.clear();
            jad.load(url.openStream());
            loadFromJad(url);
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot found " + url.getPath());
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            System.err.println("Cannot open jad " + url.getPath());
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            System.err.println("Cannot open jad " + url.getPath());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Cannot open jad " + url.getPath());
        }
    }

}