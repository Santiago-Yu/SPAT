class n22018110 {
	private CachedQuery loadQuery(String path) throws CacheException, IOException, XQueryException {
		final long lastModified;
		final URL url;
		final InputStream is;
		try {
			url = getServletContext().getResource(path);
			assert(url != null);
			lastModified = url.openConnection().getLastModified();
			is = url.openStream();
		} catch (IOException e) {
			log(PrintUtils.prettyPrintStackTrace(e, -1));
			throw e;
		}
		_lock.readLock().lock();
		CachedQuery cached = _caches.get(path);
		if (cached == null || cached.loadTimeStamp < lastModified) {
			XQueryParser parser = new XQueryParser(is);
			if (cached == null) {
				cached = new CachedQuery();
			}
			StaticContext staticEnv = parser.getStaticContext();
			final XQueryModule module;
			try {
				URI baseUri = url.toURI();
				staticEnv.setBaseURI(baseUri);
			} catch (URISyntaxException e) {
				log(PrintUtils.prettyPrintStackTrace(e, -1));
			}
			try {
				module = parser.parse();
			} catch (XQueryException e) {
				log(PrintUtils.prettyPrintStackTrace(e, -1));
				_lock.readLock().unlock();
				throw e;
			}
			_lock.readLock().unlock();
			_lock.writeLock().lock();
			cached.queryObject = module;
			cached.staticEnv = staticEnv;
			cached.loadTimeStamp = System.currentTimeMillis();
			_caches.put(path, cached);
			_lock.writeLock().unlock();
			_lock.readLock().lock();
			try {
				module.staticAnalysis(staticEnv);
			} catch (XQueryException e) {
				log(PrintUtils.prettyPrintStackTrace(e, -1));
				_lock.readLock().unlock();
				throw e;
			}
		}
		_lock.readLock().unlock();
		return cached;
	}

}