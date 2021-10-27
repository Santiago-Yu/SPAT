class n12687609{
    public boolean isWebServerAvaliable(String url) {
        long inicial = new Date().getTime();
        HttpURLConnection connection = null;
        try {
            URL urlBase = urlBase = new URL(url);
            getLog().info("Verificando se WebServer esta no ar: " + urlBase.toString());
            connection = (HttpURLConnection) urlBase.openConnection();
            connection.connect();
        } catch (Exception e) {
            return false;
        } finally {
            try {
                getLog().info("Resposta do WebServer: " + connection.getResponseCode());
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            long tfinal = new Date().getTime();
            getLog().info("Tempo esperado: " + ((tfinal - inicial) / 1000) + " segundos!");
        }
        return true;
    }

}