class n17817568 {
	public Reader getGETReader_bak(URL url) {
		if (Navigator.isVerbose())
			System.out.println("Web3DService.getGETReader caching " + url);
		Reader reader = null;
		URLConnection urlc;
		int contentLength = -1;
		try {
			urlc = url.openConnection();
			urlc.setReadTimeout(Navigator.TIME_OUT);
			if (getEncoding() != null) {
				urlc.setRequestProperty("Authorization", "Basic " + getEncoding());
			}
			urlc.connect();
			String content_type = urlc.getContentType();
			if (content_type == null || content_type.equalsIgnoreCase("x-world/x-vrml")
					|| content_type.equalsIgnoreCase("model/vrml")
					|| content_type.equalsIgnoreCase("model/vrml;charset=ISO-8859-1")) {
				InputStream is = urlc.getInputStream();
				contentLength = urlc.getContentLength();
				DataInputStream d = new DataInputStream(is);
				byte[] content = new byte[contentLength];
				if (d != null) {
					d.readFully(content, 0, contentLength);
				}
				is.close();
				d.close();
				ByteArrayInputStream bais = new ByteArrayInputStream(content);
				reader = new InputStreamReader(bais);
			} else if (content_type.equalsIgnoreCase("model/vrml.gzip")) {
				InputStream is = urlc.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				StringBuffer sb = new StringBuffer();
				GZIPInputStream gis = new GZIPInputStream(bis);
				char chars[] = new char[10240];
				BufferedReader zipReader = new BufferedReader(new InputStreamReader(gis));
				contentLength = 0;
				int len = 0;
				while ((len = zipReader.read(chars, 0, chars.length)) >= 0) {
					sb.append(chars, 0, len);
					contentLength += len;
				}
				chars = null;
				gis.close();
				zipReader.close();
				bis.close();
				is.close();
				reader = new StringReader(sb.toString());
			} else if (content_type.equalsIgnoreCase("model/vrml.encrypted")) {
				StringBuffer sb = new StringBuffer();
				InputStream is = urlc.getInputStream();
				Cipher pbeCipher = createCipher();
				if (pbeCipher != null) {
					CipherInputStream cis = new CipherInputStream(is, pbeCipher);
					char chars[] = new char[1024];
					BufferedReader bufReader = new BufferedReader(new InputStreamReader(cis));
					contentLength = 0;
					int len = 0;
					while ((len = bufReader.read(chars, 0, chars.length)) >= 0) {
						sb.append(chars, 0, len);
						contentLength += len;
					}
					chars = null;
					cis.close();
					bufReader.close();
					reader = new StringReader(sb.toString());
				}
			} else if (content_type.equalsIgnoreCase("model/vrml.gzip.encrypted")) {
				StringBuffer sb = new StringBuffer();
				InputStream is = urlc.getInputStream();
				Cipher pbeCipher = createCipher();
				if (pbeCipher != null) {
					CipherInputStream cis = new CipherInputStream(is, pbeCipher);
					GZIPInputStream gis = new GZIPInputStream(cis);
					char chars[] = new char[1024];
					BufferedReader bufReader = new BufferedReader(new InputStreamReader(gis));
					contentLength = 0;
					int len = 0;
					while ((len = bufReader.read(chars, 0, chars.length)) >= 0) {
						sb.append(chars, 0, len);
						contentLength += len;
					}
					chars = null;
					bufReader.close();
					gis.close();
					cis.close();
					reader = new StringReader(sb.toString());
				}
			} else if (content_type.equalsIgnoreCase("text/html;charset=utf-8")) {
				System.out.println("text/html;charset=utf-8");
			} else {
				System.err.println("ContentNegotiator.startLoading unsupported MIME type: " + content_type);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reader;
	}

}