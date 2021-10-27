class n16912326{
    @Override
    public void execute() throws BuildException {
        if (this.toFile == null && this.toDir == null) throw new BuildException("Missing Destination File/Dir");
        if (this.toFile != null && this.toDir != null) throw new BuildException("Both Defined Destination File/Dir");
        if (this.urlStr == null) throw new BuildException("Missing URL");
        URL base = null;
        try {
            if (baseStr != null) base = new URL(this.baseStr + (baseStr.endsWith("/") ? "" : "/"));
        } catch (MalformedURLException e) {
            throw new BuildException(e);
        }
        String tokens[] = this.urlStr.split("[ \t\n]+");
        try {
            for (String nextURL : tokens) {
                nextURL = nextURL.trim();
                if (nextURL.length() == 0) continue;
                URL url = null;
                try {
                    url = new URL(base, nextURL);
                } catch (MalformedURLException e) {
                    throw new BuildException(e);
                }
                File dest = null;
                if (this.toDir != null) {
                    String file = url.getFile();
                    int i = file.lastIndexOf('/');
                    if (i != -1 && i + 1 != file.length()) file = file.substring(i + 1);
                    dest = new File(this.toDir, file);
                } else {
                    dest = this.toFile;
                }
                if (dest.exists()) continue;
                byte buff[] = new byte[2048];
                FileOutputStream out = new FileOutputStream(dest);
                InputStream in = url.openStream();
                int n = 0;
                while ((n = in.read(buff)) != -1) {
                    out.write(buff, 0, n);
                }
                in.close();
                out.flush();
                out.close();
                System.out.println("Downloaded " + url + " to " + dest);
            }
        } catch (IOException e) {
            throw new BuildException(e);
        }
    }

}