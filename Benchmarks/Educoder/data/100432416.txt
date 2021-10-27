    public void exportNotesToServer() {
        boolean uploaded = true;
        try {
            File f = new File(UserSettings.getInstance().getNotesFile());
            FileInputStream fis = new FileInputStream(f);
            String urlString = protocol + "://" + UserSettings.getInstance().getServerAddress() + UserSettings.getInstance().getServerDir() + f.getName();
            setDefaultAuthenticator();
            URL url = new URL(urlString);
            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            urlc.setDoOutput(true);
            urlc.setRequestMethod("PUT");
            OutputStream os = urlc.getOutputStream();
            int nextByte = fis.read();
            while (nextByte != -1) {
                os.write(nextByte);
                nextByte = fis.read();
            }
            fis.close();
            os.close();
            if (urlc.getResponseCode() != HttpURLConnection.HTTP_CREATED && urlc.getResponseCode() != HttpURLConnection.HTTP_NO_CONTENT) {
                uploaded = false;
            }
        } catch (SSLHandshakeException e) {
            JOptionPane.showMessageDialog(null, I18N.getInstance().getString("error.sslcertificateerror"), I18N.getInstance().getString("error.title"), JOptionPane.ERROR_MESSAGE);
            uploaded = false;
        } catch (Exception e) {
            uploaded = false;
        }
        if (uploaded) {
            JOptionPane.showMessageDialog(null, I18N.getInstance().getString("info.notesfileuploaded"), I18N.getInstance().getString("info.title"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, I18N.getInstance().getString("error.notesfilenotuploaded"), I18N.getInstance().getString("error.title"), JOptionPane.ERROR_MESSAGE);
        }
    }
