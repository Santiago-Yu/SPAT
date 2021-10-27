    public FileAttribute getAttribute(URL url) throws VFSException {
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setInstanceFollowRedirects(false);
            int response = con.getResponseCode();
            if (response >= 400) {
                return new DefaultFileAttribute(false, 0, null, FileType.NOT_EXISTS);
            }
            boolean redirect = (response >= 300 && response <= 399);
            if (redirect) {
                String location = con.getHeaderField("Location");
                return getAttribute(new URL(url, location));
            }
            return new DefaultFileAttribute(true, con.getContentLength(), new Date(con.getLastModified()), url.toString().endsWith("/") ? FileType.DIRECTORY : FileType.FILE);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new WrongPathException(file.getAbsolutePath());
        } catch (IOException e) {
            throw new VFSIOException("IOException opening " + file.getAbsolutePath(), e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }
