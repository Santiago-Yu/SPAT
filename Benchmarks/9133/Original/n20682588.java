class n20682588{
    public MapInfo getMap(double latitude, double longitude, double wanted_mapblast_scale, int image_width, int image_height, String file_path_wo_extension, ProgressListener progress_listener) throws IOException {
        try {
            double mapserver_scale = getDownloadScale(wanted_mapblast_scale);
            URL url = new URL(getUrl(latitude, longitude, mapserver_scale, image_width, image_height));
            if (Debug.DEBUG) Debug.println("map_download", "loading map from url: " + url);
            URLConnection connection = url.openConnection();
            if (resources_.getBoolean(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_USE)) {
                String proxy_userid = resources_.getString(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_USERNAME);
                String proxy_password = resources_.getString(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_PASSWORD);
                String auth_string = proxy_userid + ":" + proxy_password;
                auth_string = "Basic " + new sun.misc.BASE64Encoder().encode(auth_string.getBytes());
                connection.setRequestProperty("Proxy-Authorization", auth_string);
            }
            connection = setRequestProperties(connection);
            connection.connect();
            String mime_type = connection.getContentType().toLowerCase();
            if (!mime_type.startsWith("image")) {
                if (mime_type.startsWith("text")) {
                    HTMLViewerFrame viewer = new HTMLViewerFrame(url);
                    viewer.setSize(640, 480);
                    viewer.setTitle("ERROR on loading url: " + url);
                    viewer.setVisible(true);
                    throw new IOException("Invalid mime type (expected 'image/*'): received " + mime_type + "\nPage is displayed in HTML frame.");
                }
                throw new IOException("Invalid mime type (expected 'image/*'): received " + mime_type);
            }
            int content_length = connection.getContentLength();
            if (content_length < 0) progress_listener.actionStart(PROGRESS_LISTENER_ID, 0, Integer.MIN_VALUE); else progress_listener.actionStart(PROGRESS_LISTENER_ID, 0, content_length);
            String extension = mime_type.substring(mime_type.indexOf('/') + 1);
            String filename = file_path_wo_extension + extension;
            MapInfo map_info = new MapInfo();
            map_info.setLatitude(latitude);
            map_info.setLongitude(longitude);
            map_info.setScale((float) getCorrectedMapblastScale(wanted_mapblast_scale));
            map_info.setWidth(image_width);
            map_info.setHeight(image_height);
            map_info.setFilename(filename);
            FileOutputStream out = new FileOutputStream(filename);
            byte[] buffer = new byte[BUFFER_SIZE];
            BufferedInputStream in = new BufferedInputStream(connection.getInputStream(), BUFFER_SIZE);
            int sum_bytes = 0;
            int num_bytes = 0;
            while ((num_bytes = in.read(buffer)) != -1) {
                out.write(buffer, 0, num_bytes);
                sum_bytes += num_bytes;
                progress_listener.actionProgress(PROGRESS_LISTENER_ID, sum_bytes);
            }
            progress_listener.actionEnd(PROGRESS_LISTENER_ID);
            in.close();
            out.close();
            return (map_info);
        } catch (NoRouteToHostException nrhe) {
            nrhe.printStackTrace();
            progress_listener.actionEnd(PROGRESS_LISTENER_ID);
            String message = nrhe.getMessage() + ":\n" + resources_.getString(DownloadMouseModeLayer.KEY_LOCALIZE_MESSAGE_DOWNLOAD_ERROR_NO_ROUTE_TO_HOST_MESSAGE);
            throw new IOException(message);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            progress_listener.actionEnd(PROGRESS_LISTENER_ID);
            String message = fnfe.getMessage() + ":\n" + resources_.getString(DownloadMouseModeLayer.KEY_LOCALIZE_MESSAGE_DOWNLOAD_ERROR_FILE_NOT_FOUND_MESSAGE);
            throw new IOException(message);
        } catch (Exception e) {
            progress_listener.actionEnd(PROGRESS_LISTENER_ID);
            e.printStackTrace();
            String message = e.getMessage();
            if (message == null) {
                Throwable cause = e.getCause();
                if (cause != null) message = cause.getMessage();
            }
            throw new IOException(message);
        }
    }

}