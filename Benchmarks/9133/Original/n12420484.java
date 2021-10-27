class n12420484{
    public static void sendData(final HashMap<String, String> data) {
        YProgressWindowRepeat y = new YProgressWindowRepeat(I18N.t("Send Data to yaams.de"));
        try {
            final StringBuffer send = new StringBuffer("1=1");
            for (final String key : data.keySet()) {
                send.append("&");
                send.append(key);
                send.append("=");
                send.append(URLEncoder.encode(data.get(key), "UTF-8"));
            }
            final URL url = new URL("http://www.rpg-studio.de/libraries/abttools/yaamsFeedback.php");
            final URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            final OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(send.toString());
            wr.flush();
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            final StringBuffer erg = new StringBuffer("");
            while ((line = rd.readLine()) != null) {
                erg.append(line);
            }
            JOptionPane.showMessageDialog(null, erg.toString(), I18N.t("Feedback"), JOptionPane.INFORMATION_MESSAGE);
            wr.close();
            rd.close();
        } catch (final Throwable t) {
            YException.error("Can not send feedback to http://www.rpg-studio.de/libraries/abttools/yaamsFeedback.php", t);
        }
        y.close();
    }

}