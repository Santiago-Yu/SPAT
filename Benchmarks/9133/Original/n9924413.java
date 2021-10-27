class n9924413{
    private void startOpening(final URL url) {
        final WebAccessor wa = this;
        openerThread = new Thread() {

            public void run() {
                iStream = null;
                try {
                    tryProxy = false;
                    URLConnection connection = url.openConnection();
                    if (connection instanceof HttpURLConnection) {
                        HttpURLConnection htc = (HttpURLConnection) connection;
                        contentLength = htc.getContentLength();
                    }
                    InputStream i = connection.getInputStream();
                    iStream = new LoggedInputStream(i, wa);
                } catch (ConnectException x) {
                    tryProxy = true;
                    exception = x;
                } catch (Exception x) {
                    exception = x;
                } finally {
                    if (dialog != null) {
                        Thread.yield();
                        dialog.setVisible(false);
                    }
                }
            }
        };
        openerThread.start();
    }

}