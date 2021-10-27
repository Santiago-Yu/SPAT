    private void redirect(TargetApp app, HttpServletRequest request, HttpServletResponse response) throws IOException {
        URL url = new URL(app.getUrl() + request.getRequestURI());
        s_log.debug("Redirecting to " + url);
        URLConnection urlConnection = url.openConnection();
        Map<String, List<String>> fields = urlConnection.getHeaderFields();
        for (String key : fields.keySet()) {
            StringBuffer values = new StringBuffer();
            boolean comma = false;
            for (String value : fields.get(key)) {
                if (comma) {
                    values.append(", ");
                }
                values.append(value);
                comma = true;
            }
            if (key != null) {
                response.setHeader(key, values.toString());
            } else {
                response.setStatus(Integer.parseInt(values.toString().split(" ")[1]));
            }
        }
        InputStream in = urlConnection.getInputStream();
        try {
            ServletOutputStream out = response.getOutputStream();
            byte[] buff = new byte[1024];
            int len;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        } finally {
            in.close();
        }
    }
