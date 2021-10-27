    private String getFullScreenUrl() {
        progressDown.setIndeterminate(true);
        System.out.println("Har: " + ytUrl);
        String u = ytUrl;
        URLConnection conn = null;
        String line = null;
        String data = "";
        String fullUrl = "";
        try {
            URL url = new URL(u);
            conn = url.openConnection();
            conn.setDoOutput(true);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                if (line.contains("fullscreenUrl")) {
                    data = line.trim();
                }
            }
            rd.close();
            System.out.println(data);
            int start = 0;
            String[] lines = data.split("&");
            String[] tmp = null;
            String video_id = null;
            String t = null;
            String title = null;
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].startsWith("video_id=")) {
                    tmp = lines[i].split("=");
                    video_id = tmp[1];
                }
                if (lines[i].startsWith("t=")) {
                    tmp = lines[i].split("=");
                    t = tmp[1];
                }
                if (lines[i].startsWith("title=")) {
                    tmp = lines[i].split("=");
                    title = tmp[1].substring(0, (tmp[1].length() - 2));
                }
                System.out.println(lines[i]);
            }
            System.out.println("So we got...");
            System.out.println("video_id: " + video_id);
            System.out.println("t: " + t);
            System.out.println("title: " + title);
            ytTitle = title;
            fullUrl = "http://www.youtube.com/get_video.php?video_id=" + video_id + "&t=" + t;
        } catch (Exception e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
        progressDown.setIndeterminate(false);
        return fullUrl;
    }
