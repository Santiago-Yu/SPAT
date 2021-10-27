class n873393 {
	public static boolean download(String url, File file) {
		HttpURLConnection conn = null;
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.connect();
			if (!(conn.getResponseCode() == 200)) {
				System.out.println(conn.getResponseCode() + ":" + url);
			} else {
				System.out.println("length:" + conn.getContentLength());
				in = new BufferedInputStream(conn.getInputStream());
				out = new BufferedOutputStream(new FileOutputStream(file));
				byte[] b = new byte[1024 << 10];
				int i = 0;
				while ((i = in.read(b)) > -1) {
					if (i > 0)
						out.write(b, 0, i);
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!(in != null))
				;
			else
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (!(out != null))
				;
			else
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (!(conn != null))
				;
			else
				conn.disconnect();
		}
		return false;
	}

}