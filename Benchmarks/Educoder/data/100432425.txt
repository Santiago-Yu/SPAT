    public static GameRecord[] get(String url, float lat, float lon, int count) {
        try {
            HttpURLConnection req = (HttpURLConnection) new URL(url).openConnection();
            req.setRequestMethod("GET");
            req.setRequestProperty(GameRecord.GAME_LATITUDE_HEADER, df.format(lat));
            req.setRequestProperty(GameRecord.GAME_LONGITUDE_HEADER, df.format(lon));
            req.setRequestProperty("X-GameQueryCount", String.valueOf(count));
            req.connect();
            if (req.getResponseCode() == HttpURLConnection.HTTP_OK) {
                List<GameRecord> gl = new ArrayList<GameRecord>();
                BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.startsWith("#")) {
                        gl.add(GameRecord.decode(line));
                    }
                }
                return gl.toArray(new GameRecord[gl.size()]);
            } else {
                System.out.println(req.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
