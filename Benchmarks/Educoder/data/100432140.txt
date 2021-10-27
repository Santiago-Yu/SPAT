    public static String getFileContentFromPlugin(String path) {
        URL url = getURLFromPlugin(path);
        StringBuffer sb = new StringBuffer();
        try {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sb.append(line + "\n");
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return sb.toString();
    }
