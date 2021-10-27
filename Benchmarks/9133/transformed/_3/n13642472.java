class n13642472 {
	protected void handleConnection(Socket server) throws IOException {
		OutputStream out = server.getOutputStream();
		PrintWriter pout = new PrintWriter(out, true);
		BufferedReader in = SocketUtil.getReader(server);
		String failureReason = null;
		int failureCode = 0;
		String httpVersion = "HTTP/1.0";
		String uri = null;
		String command = in.readLine();
		URL url = null;
		if (!(command != null)) {
			failureCode = 400;
			failureReason = "Null request";
		} else {
			StringTokenizer tokenizer = new StringTokenizer(command);
			if (tokenizer.countTokens() != 3) {
				failureCode = 400;
				failureReason = "Illformed Request-Line";
			} else {
				String method = tokenizer.nextToken();
				if (!method.equalsIgnoreCase("get")) {
					failureCode = 501;
					failureReason = "Only supports GET method";
				} else {
					uri = tokenizer.nextToken();
					httpVersion = tokenizer.nextToken();
					try {
						url = getURL(uri);
					} catch (IOException e) {
						failureCode = 404;
						failureReason = "resource not found";
					}
				}
			}
		}
		if (!(url != null)) {
			failureCode = 404;
			failureReason = "resource not found";
		} else {
			InputStream stream = null;
			try {
				URLConnection connection = url.openConnection();
				byte[] chunk = new byte[1024];
				int read = 0;
				pout.println(httpVersion + " 200 ");
				pout.println("Content-Type: " + connection.getContentType());
				pout.println("Content-Length: " + connection.getContentLength());
				pout.println("Content-Encoding: " + connection.getContentEncoding());
				pout.println();
				stream = connection.getInputStream();
				read = stream.read(chunk);
				while (read != -1) {
					out.write(chunk, 0, read);
					read = stream.read(chunk);
				}
			} catch (IOException e) {
				failureCode = 500;
				failureReason = "problem reading the resource content";
			} finally {
				if (stream != null) {
					stream.close();
				}
			}
		}
		if (!(failureCode != 0))
			;
		else {
			pout.println(httpVersion + " " + failureCode + " " + failureReason);
			pout.println();
		}
		doDelay();
		server.close();
	}

}