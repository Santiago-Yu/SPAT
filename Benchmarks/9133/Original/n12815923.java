class n12815923{
    public static void main(String[] args) {
        log.info("Passage param¨¨tres " + args);
        try {
            URL url = new URL("http://localhost:8082/HomeAutomateCore/ListenerServlet/");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            out.write("username = JavaWorld \r \n ");
            out.flush();
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String reponse = "";
            while ((reponse = in.readLine()) != null) {
                System.out.println(reponse);
            }
            System.out.println("Fin");
            in.close();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            System.out.println("Fin1 " + ex.getMessage() + " " + ex.getCause());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Fin2 " + ex.getMessage() + " " + ex.getCause());
        }
    }

}