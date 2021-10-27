class n22442259{
    private static String extractFirstLine(String urlToFile) {
        try {
            URL url = new URL(urlToFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            return br.readLine();
        } catch (Exception e) {
            return null;
        }
    }

}