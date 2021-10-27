class n5621040{
    public MeetingScript getScript(Integer id) {
        MeetingScript script = null;
        try {
            URL url = new URL(SCRIPT_URL + "?script=" + id);
            ObjectInputStream ois = new ObjectInputStream(url.openStream());
            script = (MeetingScript) ois.readObject();
            ois.close();
            System.out.println("got script");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return script;
    }

}