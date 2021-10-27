class n23411499{
    public void playSIDFromURL(String name) {
        player.reset();
        player.setStatus("Loading song: " + name);
        URL url;
        try {
            if (name.startsWith("http")) {
                url = new URL(name);
            } else {
                url = getResource(name);
            }
            if (player.readSID(url.openConnection().getInputStream())) {
                player.playSID();
            }
        } catch (IOException ioe) {
            System.out.println("Could not load: ");
            ioe.printStackTrace();
            player.setStatus("Could not load SID: " + ioe.getMessage());
        }
    }

}