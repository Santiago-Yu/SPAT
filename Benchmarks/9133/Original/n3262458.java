class n3262458{
    @Override
    public void run() {
        while (run) {
            try {
                URL url = new URL("http://" + server.getIp() + "/" + tomcat.getName() + "/ui/pva/version.jsp?RT=" + System.currentTimeMillis());
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.contains("currentversion")) {
                        String s = inputLine.substring(inputLine.indexOf("=") + 1, inputLine.length());
                        tomcat.setDetailInfo(s.trim());
                    }
                }
                in.close();
                tomcat.setIsAlive(true);
            } catch (Exception e) {
                tomcat.setIsAlive(false);
            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
            }
        }
    }

}