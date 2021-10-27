class n8352857{
    public void sendMessage(Message m) throws IOException {
        URL url = new URL(strURL);
        urlcon = (HttpURLConnection) url.openConnection();
        urlcon.setUseCaches(false);
        urlcon.setDefaultUseCaches(false);
        urlcon.setDoOutput(true);
        urlcon.setDoInput(true);
        urlcon.setRequestProperty("Content-type", "application/octet-stream");
        urlcon.setAllowUserInteraction(false);
        HttpURLConnection.setDefaultAllowUserInteraction(false);
        urlcon.setRequestMethod("POST");
        ObjectOutputStream oos = new ObjectOutputStream(urlcon.getOutputStream());
        oos.writeObject(m);
        oos.flush();
        oos.close();
    }

}