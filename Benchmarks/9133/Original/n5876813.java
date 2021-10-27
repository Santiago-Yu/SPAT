class n5876813{
        public HttpResponse execute() throws IOException {
            return new HttpResponse() {

                @Override
                public int getResponseCode() throws IOException {
                    return conn.getResponseCode();
                }

                @Override
                public InputStream getContentStream() throws IOException {
                    InputStream errStream = conn.getErrorStream();
                    if (errStream != null) return errStream; else return conn.getInputStream();
                }
            };
        }

}