class n6871526{
    private boolean cacheUrlFile(String filePath, String realUrl, boolean isOnline) {
        try {
            URL url = new URL(realUrl);
            String encoding = "gbk";
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
            StringBuilder sb = new StringBuilder();
            sb.append(configCenter.getWebRoot()).append(getCacheString(isOnline)).append(filePath);
            fileEditor.createDirectory(sb.toString());
            return fileEditor.saveFile(sb.toString(), in);
        } catch (IOException e) {
        }
        return false;
    }

}