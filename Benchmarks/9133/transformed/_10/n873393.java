class n873393 {
	public static boolean download(String url, File file) {
		BufferedInputStream in = null;
		HttpURLConnection conn = null;
		BufferedOutputStream out = null;
		try {
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.connect();
			if (conn.getResponseCode() == 200) {
				System.out.println("length:" + conn.getContentLength());
				out = new BufferedOutputStream(new FileOutputStream(file));
				in = new BufferedInputStream(conn.getInputStream());
				int i = 0;
				byte[] b = new byte[1024 << 10];
				while ((i = in.read(b)) > -1) {
					if (i > 0)
						out.write(b, 0, i);
				}
				return true;
			} else {
				System.out.println(conn.getResponseCode() + ":" + url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (conn != null)
				conn.disconnect();
		}
		return false;
	}

}