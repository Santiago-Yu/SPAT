class n15464749 {
	@Override
	protected String doWget(final URL url, final boolean post, final boolean ignore, final String... post_data)
			throws Exception {
		String msg = "";
		InputStream in = null;
		OutputStream out = null;
		String data = null;
		try {
			final URLConnection urlcon = url.openConnection();
			if (post) {
				boolean key = false;
				for (final String s : post_data) {
					msg += URLEncoder.encode(s, "UTF-8");
					if (key = !key) {
						msg += "=";
					} else {
						msg += "&";
					}
				}
				urlcon.setDoOutput(true);
				out = urlcon.getOutputStream();
				out.write(msg.getBytes());
			}
			in = urlcon.getInputStream();
			data = ignore ? null : "";
			int len;
			final byte[] buffer = new byte[1023];
			for (; (len = in.read(buffer)) >= 0;) {
				if (!ignore) {
					data += new String(buffer, 0, len);
				}
			}
			if (LogHelper.isLogLevelEnabled(LogLevel.DEBUG, DefaultCommunicationHelper.class)) {
				LogHelper.log(DefaultCommunicationHelper.class, LogLevel.DEBUG,
						"WGET= URL[" + url.toString() + "?" + msg + "] RETURN[" + data + "]");
			}
			return data;
		} catch (final Exception ex) {
			LogHelper.log(DefaultCommunicationHelper.class, LogLevel.WARN, "An error occurred while submitting " + msg
					+ " request to " + url.toString() + " with the following data: " + data, ex);
			throw ex;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (final Exception e) {
					LogHelper.log(DefaultCommunicationHelper.class, LogLevel.DEBUG,
							"An error occurred while closing an input stream", e);
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (final Exception e) {
					LogHelper.log(DefaultCommunicationHelper.class, LogLevel.DEBUG,
							"An error occurred while closing an output stream", e);
				}
			}
		}
	}

}