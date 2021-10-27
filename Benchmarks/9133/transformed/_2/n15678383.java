class n15678383 {
	public void run() {
		videoId = videoId.trim();
		System.out.println("fetching video");
		String requestUrl = "http://www.youtube.com/get_video_info?&video_id=" + videoId;
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = rd.readLine();
			int from = line.indexOf("&token=") + 7;
			int to = line.indexOf("&thumbnail_url=");
			String id = line.substring(from, to);
			String tmp = "http://www.youtube.com/get_video?video_id=" + videoId + "&t=" + id;
			url = new URL(tmp);
			conn = (HttpURLConnection) url.openConnection();
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			rd.readLine();
			tmp = conn.getURL().toString();
			url = new URL(tmp);
			conn = (HttpURLConnection) url.openConnection();
			InputStream is;
			OutputStream outStream;
			URLConnection uCon;
			byte[] buf;
			int ByteRead, ByteWritten = 0;
			url = new URL(tmp);
			outStream = new BufferedOutputStream(new FileOutputStream(videoId + ".flv"));
			uCon = url.openConnection();
			is = uCon.getInputStream();
			buf = new byte[1024];
			for (; (ByteRead = is.read(buf)) != -1;) {
				outStream.write(buf, 0, ByteRead);
				ByteWritten += ByteRead;
			}
			is.close();
			outStream.close();
			System.out.println(videoUrl + " is ready");
		} catch (Exception e) {
			System.out.println("Could not find flv-url " + videoId + "! " + e.getMessage());
		} finally {
			ready = true;
		}
	}

}