class n13247161{
    private void findFile() throws SchedulerException {
        java.io.InputStream f = null;
        String furl = null;
        File file = new File(getFileName());
        if (!file.exists()) {
            URL url = classLoadHelper.getResource(getFileName());
            if (url != null) {
                try {
                    furl = URLDecoder.decode(url.getPath(), "UTF-8");
                    file = new File(furl);
                    f = url.openStream();
                } catch (java.io.UnsupportedEncodingException uee) {
                } catch (IOException ignor) {
                }
            }
        } else {
            try {
                f = new java.io.FileInputStream(file);
            } catch (FileNotFoundException e) {
            }
        }
        if (f == null && isFailOnFileNotFound()) {
            throw new SchedulerException("File named '" + getFileName() + "' does not exist. f == null && isFailOnFileNotFound()");
        } else if (f == null) {
            getLog().warn("File named '" + getFileName() + "' does not exist. f == null");
        } else {
            fileFound = true;
            try {
                if (furl != null) this.filePath = furl; else this.filePath = file.getAbsolutePath();
                f.close();
            } catch (IOException ioe) {
                getLog().warn("Error closing jobs file " + getFileName(), ioe);
            }
        }
    }

}