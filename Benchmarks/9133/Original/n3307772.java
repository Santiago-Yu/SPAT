class n3307772{
    public void deleteScript(Integer id) {
        InputStream is = null;
        try {
            URL url = new URL(strServlet + getSessionIDSuffix() + "?deleteScript=" + id);
            System.out.println("requesting: " + url);
            is = url.openStream();
            while (is.read() != -1) ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
    }

}