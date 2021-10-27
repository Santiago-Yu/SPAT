        @Override
        public void respondGet(HttpServletResponse resp) throws IOException {
            setHeaders(resp);
            final OutputStream os;
            if (willDeflate()) {
                resp.setHeader("Content-Encoding", "gzip");
                os = new GZIPOutputStream(resp.getOutputStream(), bufferSize);
            } else os = resp.getOutputStream();
            transferStreams(url.openStream(), os);
        }
