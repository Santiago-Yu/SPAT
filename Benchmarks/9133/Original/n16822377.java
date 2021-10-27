class n16822377{
    public String buscarArchivos(String nUsuario) {
        String responce = "";
        String request = conf.Conf.buscarArchivo;
        OutputStreamWriter wr = null;
        BufferedReader rd = null;
        try {
            URL url = new URL(request);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write("nUsuario=" + nUsuario);
            wr.flush();
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                responce += line;
            }
        } catch (Exception e) {
        }
        return responce;
    }

}