class n15416859 {
	private boolean checkTimestamp(File timestamp, URL url) {
		try {
			if (timestamp.exists()) {
				Date dateLocal = null;
				FileReader reader = null;
				try {
					StringWriter tmp = new StringWriter();
					reader = new FileReader(timestamp);
					IOUtils.copy(reader, tmp);
					dateLocal = this.FORMAT.parse(tmp.toString());
				} catch (ParseException e) {
					timestamp.delete();
				} catch (IOException e) {
				} finally {
					IOUtils.closeQuietly(reader);
				}
				if (dateLocal != null) {
					try {
						URLConnection conn = url.openConnection();
						Date date = this.FORMAT.parse(this.FORMAT.format(new Date(conn.getLastModified())));
						return (date.compareTo(dateLocal) == 0);
					} catch (IOException e) {
					}
				}
			}
		} catch (Throwable t) {
		}
		return false;
	}

}