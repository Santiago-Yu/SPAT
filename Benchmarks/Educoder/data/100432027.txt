    public static synchronized BufferedImage loadBufferedJPEGImage(URL url) {
        BufferedImage image = null;
        if (url != null) {
            InputStream in = null;
            try {
                in = url.openStream();
                JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
                image = decoder.decodeAsBufferedImage();
            } catch (Exception e) {
                log.severe("URL: " + url + " - " + e.getMessage());
                image = null;
            } finally {
                try {
                    if (in != null) in.close();
                } catch (IOException ioe) {
                    log.severe("URL: " + url + " - " + ioe.getMessage());
                }
            }
            if (image != null) {
                log.config("Image type : " + image.getType());
                if (image.getWidth() <= 0 || image.getHeight() <= 0) {
                    log.severe("URL: " + url + " =0");
                    image = null;
                }
            }
        }
        return image;
    }
