    private void retrieveFile(URL url, RSLink link) {
        link.setStatus(RSLink.STATUS_DOWNLOADING);
        HttpURLConnection httpConn = null;
        DataOutputStream outs = null;
        BufferedInputStream bins = null;
        BufferedOutputStream bouts = null;
        try {
            String postData = URLEncoder.encode("mirror", "UTF-8") + "=" + URLEncoder.encode(url.toString(), "UTF-8");
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpConn.setRequestProperty("Content-Length", "" + Integer.toString(postData.getBytes().length));
            httpConn.setRequestProperty("Content-Language", "en-US");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            outs = new DataOutputStream(httpConn.getOutputStream());
            outs.writeBytes(postData);
            outs.flush();
            Pattern mimePattern = Pattern.compile(".+/html.+");
            Matcher matcher = mimePattern.matcher(httpConn.getContentType());
            if (matcher.find()) {
                log("Can not download, maybe all RS slots are busy!");
                return;
            }
            link.setSize(httpConn.getContentLength());
            bins = new BufferedInputStream(httpConn.getInputStream(), 4096);
            bouts = new BufferedOutputStream(new FileOutputStream(link.getFile()), 4096);
            link.setStatus(RSLink.STATUS_DOWNLOADING);
            link.setDown(0);
            byte[] byteBuffer = new byte[4096];
            int count;
            while ((count = bins.read(byteBuffer)) != -1) {
                bouts.write(byteBuffer, 0, count);
                link.setDown(link.getDown() + count);
                if (!Main.start.get()) {
                    link.setStatus(RSLink.STATUS_NOTHING);
                    return;
                }
            }
            link.setStatus(RSLink.STATUS_DONE);
        } catch (IOException ex) {
            log("I/O Exception!");
            link.setStatus(RSLink.STATUS_NOTHING);
        } finally {
            try {
                if (outs != null) outs.close();
                if (bouts != null) bouts.close();
                if (bins != null) bins.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Can not close some connections:\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (httpConn != null) httpConn.disconnect();
        }
    }
