class n14758866 {
	public synchronized InputStream getResourceAsStream(String name) {
		BufferedInputStream in = null;
		InputStream inputStream = null;
		BufferedOutputStream out = null;
		try {
			URL url = getResource(name);
			String remoteName = url.toExternalForm();
			String localName = (String) cacheHashtable.get(remoteName);
			String host = url.getHost();
			if (localName != null) {
				System.out.println("Retrieving \"" + localName + "\"...");
				return new FileInputStream(localName);
			}
			String prot = url.getProtocol();
			int port = url.getPort();
			File cacheFile = new File(cacheDir, prot + File.separator + host + File.separator + "port"
					+ (port == -1 ? "" : Integer.toString(port)) + File.separator + name);
			cacheFile = new File(cacheFile.getCanonicalPath());
			localName = cacheFile.getCanonicalPath();
			System.out.println("Comparing \"" + localName + "\"...");
			URLConnection urlConnection = url.openConnection();
			if (cacheFile.exists()) {
				urlConnection.setIfModifiedSince(cacheFile.lastModified());
			}
			if (urlConnection instanceof HttpURLConnection) {
				HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setFollowRedirects(true);
				httpURLConnection.setRequestMethod("GET");
				int responseCode = httpURLConnection.getResponseCode();
				System.out.println(httpURLConnection.getResponseMessage() + ", " + httpURLConnection.getContentLength()
						+ " bytes" + ", " + new Date(httpURLConnection.getDate()) + ", "
						+ new Date(httpURLConnection.getLastModified()));
				if (responseCode != HttpURLConnection.HTTP_OK) {
					return null;
				}
			}
			inputStream = urlConnection.getInputStream();
			if (inputStream == null)
				return null;
			if (cacheFile.exists()) {
				long lastModified = urlConnection.getLastModified();
				if ((lastModified > 0) && (lastModified < cacheFile.lastModified())) {
					inputStream.close();
					cacheHashtable.put(remoteName, localName);
					System.out.println("Retrieving \"" + localName + "\"...");
					return new FileInputStream(cacheFile);
				}
			}
			File parentFile = new File(cacheFile.getParent());
			parentFile.mkdirs();
			localName = cacheFile.getCanonicalPath();
			System.out.println("CACHING \"" + localName + "\"...");
			out = new BufferedOutputStream(new FileOutputStream(cacheFile));
			in = new BufferedInputStream(inputStream);
			int i;
			while ((i = in.read()) > -1)
				out.write(i);
			out.close();
			in.close();
			cacheHashtable.put(remoteName, localName);
			System.out.println("Retrieving \"" + localName + "\"...");
			return new FileInputStream(localName);
		} catch (Exception ex) {
			try {
				inputStream.close();
			} catch (Exception ex1) {
			}
			try {
				in.close();
			} catch (Exception ex1) {
			}
			try {
				out.close();
			} catch (Exception ex1) {
			}
			ex.printStackTrace();
			return null;
		}
	}

}