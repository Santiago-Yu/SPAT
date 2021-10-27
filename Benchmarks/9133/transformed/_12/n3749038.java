class n3749038 {
	public MapInfo getMap(double latitude, double longitude, double wanted_mapblast_scale, int image_width,
			int image_height, String file_path_wo_extension, ProgressListener progress_listener) throws IOException {
		try {
			if (web_request_ == null) {
				web_request_ = new HttpRequester(HOST_NAME);
			}
			int zoom_index = getZoomLevelIndex(wanted_mapblast_scale);
			int google_zoom_level = GOOGLE_ZOOM_LEVELS[zoom_index];
			double mapblast_scale = POSSIBLE_GOOGLE_SCALES[zoom_index];
			Tile tile = new Tile(latitude, longitude, google_zoom_level);
			SimplePoint coords = tile.getTileLatLong();
			SimplePoint google_xy = tile.getTileCoord();
			MapInfo map_info = new MapInfo();
			map_info.setLatitude(coords.getX());
			map_info.setLongitude(coords.getY());
			map_info.setScale((float) mapblast_scale);
			map_info.setWidth(256);
			map_info.setHeight(256);
			map_info.setFilename(file_path_wo_extension + "png");
			Object[] params = new Object[] { new Integer(google_xy.getX()), new Integer(google_xy.getY()),
					new Integer(google_zoom_level) };
			MessageFormat message_format = new MessageFormat(GOOGLE_MAPS_URL, Locale.US);
			String url_string = message_format.format(params);
			URL url = new URL(url_string);
			if (Debug.DEBUG)
				Debug.println("map_download", "loading map from url: " + url);
			URLConnection connection = url.openConnection();
			if (resources_.getBoolean(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_USE)) {
				String proxy_userid = resources_.getString(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_USERNAME),
						proxy_password = resources_
								.getString(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_PASSWORD);
				String auth_string = proxy_userid + ":" + proxy_password;
				auth_string = "Basic " + new sun.misc.BASE64Encoder().encode(auth_string.getBytes());
				connection.setRequestProperty("Proxy-Authorization", auth_string);
			}
			connection.connect();
			String mime_type = connection.getContentType().toLowerCase();
			if (!mime_type.startsWith("image")) {
				if (mime_type.startsWith("text")) {
					HTMLViewerFrame viewer = new HTMLViewerFrame(url);
					viewer.setSize(640, 480);
					viewer.setTitle("ERROR on loading url: " + url);
					viewer.setVisible(true);
					throw new IOException("Invalid mime type (expected 'image/*'): received " + mime_type
							+ "\nPage is displayed in HTML frame.");
				}
				throw new IOException("Invalid mime type (expected 'image/*'): received " + mime_type);
			}
			int content_length = connection.getContentLength();
			if (content_length < 0)
				progress_listener.actionStart(PROGRESS_LISTENER_ID, 0, Integer.MIN_VALUE);
			else
				progress_listener.actionStart(PROGRESS_LISTENER_ID, 0, content_length);
			String extension = mime_type.substring(mime_type.indexOf('/') + 1);
			String filename = file_path_wo_extension + extension;
			FileOutputStream out = new FileOutputStream(filename);
			byte[] buffer = new byte[BUFFER_SIZE];
			BufferedInputStream in = new BufferedInputStream(connection.getInputStream(), BUFFER_SIZE);
			int sum_bytes = 0, num_bytes = 0;
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
			String message = nrhe.getMessage() + ":\n" + resources_
					.getString(DownloadMouseModeLayer.KEY_LOCALIZE_MESSAGE_DOWNLOAD_ERROR_NO_ROUTE_TO_HOST_MESSAGE);
			throw new IOException(message);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			progress_listener.actionEnd(PROGRESS_LISTENER_ID);
			String message = fnfe.getMessage() + ":\n" + resources_
					.getString(DownloadMouseModeLayer.KEY_LOCALIZE_MESSAGE_DOWNLOAD_ERROR_FILE_NOT_FOUND_MESSAGE);
			throw new IOException(message);
		} catch (Exception e) {
			progress_listener.actionEnd(PROGRESS_LISTENER_ID);
			e.printStackTrace();
			String message = e.getMessage();
			if (message == null) {
				Throwable cause = e.getCause();
				if (cause != null)
					message = cause.getMessage();
			}
			throw new IOException(message);
		}
	}

}