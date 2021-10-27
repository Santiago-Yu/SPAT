    public void googleImageSearch(String search, String start) {
        try {
            String u = "http://images.google.com/images?q=" + search + start;
            if (u.contains(" ")) {
                u = u.replace(" ", "+");
            }
            URL url = new URL(u);
            HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
            httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
            BufferedReader readIn = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            googleImages.clear();
            String text = "";
            String lin = "";
            while ((lin = readIn.readLine()) != null) {
                text += lin;
            }
            readIn.close();
            if (text.contains("\n")) {
                text = text.replace("\n", "");
            }
            String[] array = text.split("\\Qhref=\"/imgres?imgurl=\\E");
            for (String s : array) {
                if (s.startsWith("http://") || s.startsWith("https://") && s.contains("&amp;")) {
                    String s1 = s.substring(0, s.indexOf("&amp;"));
                    googleImages.add(s1);
                }
            }
        } catch (Exception ex4) {
            MusicBoxView.showErrorDialog(ex4);
        }
        MusicBoxView.jButton7.setEnabled(true);
        ImageIcon icon;
        try {
            icon = new ImageIcon(new URL(googleImages.elementAt(MusicBoxView.googleImageLocation)));
            ImageIcon ico = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            MusicBoxView.albumArtLabel.setIcon(ico);
        } catch (MalformedURLException ex1) {
            MusicBoxView.showErrorDialog(ex1);
        }
    }
