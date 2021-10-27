class n13642472 {
	protected void handleConnection(Socket server) throws IOException {
		OutputStream out = server.getOutputStream();
		BufferedReader in = SocketUtil.getReader(server);
		PrintWriter pout = new PrintWriter(out, true);
		int failureCode = 0;
		String failureReason = null;
		String httpVersion = "HTTP/1.0";
		String uri = null;
		URL url = null;
		String command = in.readLine();
		if (command != null) {
			StringTokenizer tokenizer = new StringTokenizer(command);
			if (tokenizer.countTokens() != 3) {
				failureReason = "Illformed Request-Line";
				failureCode = 400;
			} else {
				String method = tokenizer.nextToken();
				if (!method.equalsIgnoreCase("get")) {
					failureReason = "Only supports GET method";
					failureCode = 501;
				} else {
					uri = tokenizer.nextToken();
					httpVersion = tokenizer.nextToken();
					try {
						url = getURL(uri);
					} catch (IOException e) {
						failureReason = "resource not found";
						failureCode = 404;
					}
				}
			}
		} else {
			failureReason = "Null request";
			failureCode = 400;
		}
		if (url != null) {
			InputStream stream = null;
			try {
				byte[] chunk = new byte[1024];
				URLConnection connection = url.openConnection();
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
				failureReason = "problem reading the resource content";
				failureCode = 500;
			} finally {
				if (stream != null) {
					stream.close();
				}
			}
		} else {
			failureReason = "resource not found";
			failureCode = 404;
		}
		if (failureCode != 0) {
			pout.println(httpVersion + " " + failureCode + " " + failureReason);
			pout.println();
		}
		doDelay();
		server.close();
	}

}