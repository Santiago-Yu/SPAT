    private void parse() throws Exception {
        BufferedReader br = null;
        InputStream httpStream = null;
        URL fileURL = new URL(url);
        URLConnection urlConnection = fileURL.openConnection();
        httpStream = urlConnection.getInputStream();
        br = new BufferedReader(new InputStreamReader(httpStream, "UTF-8"));
        String ligne;
        String post;
        String date;
        String titre;
        String resume;
        String url2DL;
        while ((ligne = br.readLine()) != null) {
            if (ligne.indexOf("div class=\"post\" id=\"post") != -1) {
                post = null;
                date = null;
                titre = null;
                try {
                    post = ligne.substring(ligne.indexOf("post-") + 5, ligne.indexOf("\"", ligne.indexOf("post-")));
                    ligne = br.readLine();
                    date = ligne.substring(ligne.indexOf("<div class=\"date\"><span>") + 24);
                    date = date.replaceAll("</span>", "").replaceAll("</div>", "").trim();
                    log.info("Post   : " + post + " du " + date);
                    ligne = br.readLine();
                    ligne = br.readLine();
                    titre = ligne.substring(ligne.indexOf(">", ligne.indexOf("title")) + 1, ligne.indexOf("</a>"));
                    titre = titre.replaceAll("&#8217;", "'").replaceAll("&#8220;", "\"").replaceAll("&#8221;", "\"");
                    url2DL = ligne.substring(ligne.indexOf("<a href=\"") + 9, ligne.indexOf("/\"")).trim();
                    url2DL = url2DL.replace("mega-films.net", "mega-protect.com") + ".php";
                    log.info("Titre  : " + titre);
                    log.info("To DL  : " + url2DL);
                    ligne = br.readLine();
                    ligne = br.readLine();
                    ligne = br.readLine();
                    ligne = br.readLine();
                    ligne = br.readLine();
                    ligne = br.readLine();
                    ligne = br.readLine();
                    resume = ligne.substring(ligne.indexOf("<em>") + 4, ligne.indexOf("</em>"));
                    resume = resume.replaceAll("&#8217;", "'").replaceAll("&#8220;", "\"").replaceAll("&#8221;", "\"");
                    log.info("Resume : " + resume);
                } catch (Exception e) {
                    log.error("ERREUR : Le film n'a pas pu etre parse...");
                }
                log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            }
        }
    }
