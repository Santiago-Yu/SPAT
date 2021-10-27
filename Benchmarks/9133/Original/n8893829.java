class n8893829{
                @Override
                public InputStream getInputStream() {
                    String url = resourceURL_;
                    try {
                        return new URL(url).openStream();
                    } catch (Exception e) {
                    }
                    try {
                        return new FileInputStream("/" + url);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

}