class n2313678{
        protected boolean exists(String filename) {
            try {
                URL url = new URL(base, filename);
                URLConnection conn = url.openConnection();
                conn.connect();
                conn.getInputStream().close();
                return true;
            } catch (IOException ex) {
                return false;
            }
        }

}