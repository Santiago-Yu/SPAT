class n3806532 {
	public Resource createNew(String YFHisLbk, InputStream p2z1DBLH, Long DTFx8zFq, String y2CurMhA)
			throws IOException {
		File YGFwjOFh = new File(this.getRealFile(), YFHisLbk);
		LOGGER.debug("PUT?? - real file: " + this.getRealFile() + ",name: " + YFHisLbk);
		if (isOwner) {
			if (!".request".equals(YFHisLbk) && !".tokens".equals(YFHisLbk)) {
				FileOutputStream mvwhoiXs = null;
				try {
					mvwhoiXs = new FileOutputStream(YGFwjOFh);
					IOUtils.copy(p2z1DBLH, mvwhoiXs);
				} finally {
					IOUtils.closeQuietly(mvwhoiXs);
				}
			} else {
				if (ServerConfiguration.isDynamicSEL()) {
				} else {
				}
				FileOutputStream UsLQdJzz = null;
				try {
					UsLQdJzz = new FileOutputStream(YGFwjOFh);
					IOUtils.copy(p2z1DBLH, UsLQdJzz);
				} finally {
					IOUtils.closeQuietly(UsLQdJzz);
				}
			}
			return factory.resolveFile(this.host, YGFwjOFh);
		} else {
			LOGGER.error("User isn't owner of this folder");
			return null;
		}
	}

}