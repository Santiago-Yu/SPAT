class n12791062{
    public static boolean isUrlAvailable(String url) {
        boolean flag = true;
        try {
            URLConnection conn = (new URL(url)).openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.connect();
            if (conn.getDate() == 0) {
                flag = false;
            }
        } catch (IOException e) {
            log.error(e);
            flag = false;
        }
        return flag;
    }

}