            @Override
            public InputStream getInputStream() {
                try {
                    String url = webBrowserObject.resourcePath;
                    File file = Utils.getLocalFile(url);
                    if (file != null) {
                        url = webBrowserObject.getLocalFileURL(file);
                    }
                    url = url.substring(0, url.lastIndexOf('/')) + "/" + resource;
                    return new URL(url).openStream();
                } catch (Exception e) {
                }
                return null;
            }
