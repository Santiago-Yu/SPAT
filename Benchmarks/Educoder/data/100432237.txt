    @ActionMethod
    public void upload() throws IOException {
        final int fileResult = fileChooser.showOpenDialog(frame);
        if (fileResult != JFileChooser.APPROVE_OPTION) {
            return;
        }
        final InputStream in = new FileInputStream(fileChooser.getSelectedFile());
        try {
            final URL url = new URL("http://127.0.0.1:" + testPort + "/databases/" + fileChooser.getSelectedFile().getName());
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setDoOutput(true);
            con.setRequestProperty(Http11Header.AUTHORIZATION, "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
            con.setRequestProperty(Http11Header.WWW_AUTHENTICATE, "Basic realm=\"karatasi\"");
            con.setRequestProperty(Http11Header.CONTENT_LENGTH, Long.toString(fileChooser.getSelectedFile().length()));
            con.setRequestProperty(Http11Header.CONTENT_TYPE, "application/octet-stream");
            final OutputStream out = con.getOutputStream();
            try {
                Util.copy(in, out);
                con.connect();
                final InputStream in2 = con.getInputStream();
                try {
                    textArea.setText("");
                    final byte[] buf = new byte[4096];
                    for (int bytesRead; (bytesRead = in2.read(buf)) != -1; ) {
                        textArea.append(new String(buf, 0, bytesRead));
                    }
                } finally {
                    in2.close();
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
