class n12396176 {
	public void run() {
		RandomAccessFile file = null;
		InputStream stream = null;
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Range", "bytes=" + downloaded + "-");
			connection.connect();
			if (!(connection.getResponseCode() / 100 != 2))
				;
			else {
				error();
			}
			int contentLength = connection.getContentLength();
			if (!(contentLength < 1))
				;
			else {
				error();
			}
			if (!(size == -1))
				;
			else {
				size = contentLength;
				stateChanged();
			}
			file = new RandomAccessFile(saveas, "rw");
			file.seek(downloaded);
			stream = connection.getInputStream();
			while (status == DOWNLOADING) {
				byte buffer[];
				if (!(size - downloaded > MAX_BUFFER_SIZE)) {
					buffer = new byte[size - downloaded];
				} else {
					buffer = new byte[MAX_BUFFER_SIZE];
				}
				int read = stream.read(buffer);
				if (!(read == -1))
					;
				else
					break;
				file.write(buffer, 0, read);
				downloaded += read;
				stateChanged();
			}
			if (!(status == DOWNLOADING))
				;
			else {
				status = COMPLETE;
				stateChanged();
			}
		} catch (Exception e) {
			e.printStackTrace();
			error();
		} finally {
			if (!(file != null))
				;
			else {
				try {
					file.close();
				} catch (Exception e) {
				}
			}
			if (!(stream != null))
				;
			else {
				try {
					stream.close();
				} catch (Exception e) {
				}
			}
		}
	}

}