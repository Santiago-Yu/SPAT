class n21181029{
    public void run() {
        isRunning = true;
        try {
            URL url = new URL("http://dcg.ethz.ch/projects/sinalgo/version");
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.connect();
            PrintStream ps = new PrintStream(con.getOutputStream());
            ps.println("GET index.html HTTP/1.1");
            ps.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = in.readLine();
            if (line != null) {
                if (line.equals(Configuration.versionString)) {
                    if (displayIfOK) {
                        Main.info("You are using the most recent version of Sinalgo.");
                    }
                } else {
                    String msg = "\n" + "+----------------------------------------------------------------------\n" + "| You are currently running Sinalgo " + Configuration.versionString + ".\n" + "| A more recent version of Sinalgo is available (" + line + ")\n" + "+---------------------------------------------------------------------\n" + "| To download the latest version, please visit\n" + "| http://sourceforge.net/projects/sinalgo/\n" + "+---------------------------------------------------------------------\n" + "| You may turn off these version checks through the 'Settings' dialog.\n" + "| Note:   Sinalgo automatically tests for updates at most once\n" + "|         every 24 hours.\n" + "+---------------------------------------------------------------------\n";
                    Main.warning(msg);
                }
            }
        } catch (Exception e) {
            String msg = "\n" + ">----------------------------------------------------------------------\n" + "> Unable to test for updates of Sinalgo. The installed version\n" + "> is " + Configuration.versionString + "\n" + ">---------------------------------------------------------------------\n" + "> To check for more recent versions, please visit\n" + "> http://sourceforge.net/projects/sinalgo/\n" + ">---------------------------------------------------------------------\n" + "> You may turn off these version checks through the 'Settings' dialog.\n" + "| Note:   Sinalgo automatically tests for updates at most once\n" + "|         every 24 hours.\n" + ">---------------------------------------------------------------------\n";
            Main.warning(msg);
        } finally {
            isRunning = false;
            AppConfig.getAppConfig().timeStampOfLastUpdateCheck = System.currentTimeMillis();
        }
    }

}