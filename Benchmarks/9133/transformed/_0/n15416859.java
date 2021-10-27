class n15416859 {
	private boolean checkTimestamp(File qi1MCyhY, URL s3HEWmuM) {
		try {
			if (qi1MCyhY.exists()) {
				FileReader vJtH8l9n = null;
				Date yz7fc7GN = null;
				try {
					vJtH8l9n = new FileReader(qi1MCyhY);
					StringWriter ve3Hpwjk = new StringWriter();
					IOUtils.copy(vJtH8l9n, ve3Hpwjk);
					yz7fc7GN = this.FORMAT.parse(ve3Hpwjk.toString());
				} catch (ParseException avOOKNls) {
					qi1MCyhY.delete();
				} catch (IOException NXPF5DDn) {
				} finally {
					IOUtils.closeQuietly(vJtH8l9n);
				}
				if (yz7fc7GN != null) {
					try {
						URLConnection eYyvsIKg = s3HEWmuM.openConnection();
						Date OxMIU5S6 = this.FORMAT.parse(this.FORMAT.format(new Date(eYyvsIKg.getLastModified())));
						return (OxMIU5S6.compareTo(yz7fc7GN) == 0);
					} catch (IOException mHszro26) {
					}
				}
			}
		} catch (Throwable a2SBmo85) {
		}
		return false;
	}

}