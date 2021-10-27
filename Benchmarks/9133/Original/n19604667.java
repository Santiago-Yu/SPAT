class n19604667{
    public String saveFile(URL url) {
        String newUrlToReturn = url.toString();
        try {
            String directory = Util.appendDirPath(targetDirectory, OBJ_REPOSITORY);
            String category = url.openConnection().getContentType();
            category = category.substring(0, category.indexOf("/"));
            String fileUrl = Util.transformUrlToPath(url.toString());
            directory = Util.appendDirPath(directory, category);
            directory = Util.appendDirPath(directory, fileUrl);
            String objectFileName = url.toString().substring(url.toString().lastIndexOf('/') + 1);
            BufferedInputStream in = new java.io.BufferedInputStream(url.openStream());
            File dir = new File(directory);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(Util.appendDirPath(dir.getPath(), objectFileName));
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                bout.write(data, 0, count);
            }
            bout.close();
            fos.close();
            in.close();
            newUrlToReturn = Util.getRelativePath(file.getAbsolutePath(), targetDirectory);
        } catch (IOException e) {
            return newUrlToReturn;
        }
        return newUrlToReturn;
    }

}