class n21860376{
    public boolean checkConnection() {
        int tries = 3;
        for (int i = 0; i < tries; i++) {
            try {
                final URL url = new URL(wsURL);
                final URLConnection conn = url.openConnection();
                conn.setReadTimeout(3000);
                conn.getContent();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(ExternalSalesHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrdersSync.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}