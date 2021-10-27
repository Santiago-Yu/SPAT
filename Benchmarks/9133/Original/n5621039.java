class n5621039{
    public ScriptInfoList getScriptList() {
        ScriptInfoList scripts = null;
        try {
            URL url = new URL(SCRIPT_URL + "?customer=" + customerID);
            ObjectInputStream ois = new ObjectInputStream(url.openStream());
            scripts = (ScriptInfoList) ois.readObject();
            ois.close();
            System.out.println("got script list");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scripts;
    }

}