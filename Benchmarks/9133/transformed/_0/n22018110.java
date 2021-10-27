class n22018110 {
	private CachedQuery loadQuery(String Qeb9zAPm) throws CacheException, IOException, XQueryException {
		final URL hrmZaLkm;
		final long uvqY9mWt;
		final InputStream MgmmBN4N;
		try {
			hrmZaLkm = getServletContext().getResource(Qeb9zAPm);
			assert(hrmZaLkm != null);
			uvqY9mWt = hrmZaLkm.openConnection().getLastModified();
			MgmmBN4N = hrmZaLkm.openStream();
		} catch (IOException Avlb4C2o) {
			log(PrintUtils.prettyPrintStackTrace(Avlb4C2o, -1));
			throw Avlb4C2o;
		}
		_lock.readLock().lock();
		CachedQuery qrwdbDJ8 = _caches.get(Qeb9zAPm);
		if (qrwdbDJ8 == null || qrwdbDJ8.loadTimeStamp < uvqY9mWt) {
			if (qrwdbDJ8 == null) {
				qrwdbDJ8 = new CachedQuery();
			}
			XQueryParser gIMLZJDM = new XQueryParser(MgmmBN4N);
			StaticContext wpy8l5cV = gIMLZJDM.getStaticContext();
			try {
				URI tZ46SsUf = hrmZaLkm.toURI();
				wpy8l5cV.setBaseURI(tZ46SsUf);
			} catch (URISyntaxException yl50mPWI) {
				log(PrintUtils.prettyPrintStackTrace(yl50mPWI, -1));
			}
			final XQueryModule FXgSvRYm;
			try {
				FXgSvRYm = gIMLZJDM.parse();
			} catch (XQueryException mmcbphjW) {
				log(PrintUtils.prettyPrintStackTrace(mmcbphjW, -1));
				_lock.readLock().unlock();
				throw mmcbphjW;
			}
			_lock.readLock().unlock();
			_lock.writeLock().lock();
			qrwdbDJ8.queryObject = FXgSvRYm;
			qrwdbDJ8.staticEnv = wpy8l5cV;
			qrwdbDJ8.loadTimeStamp = System.currentTimeMillis();
			_caches.put(Qeb9zAPm, qrwdbDJ8);
			_lock.writeLock().unlock();
			_lock.readLock().lock();
			try {
				FXgSvRYm.staticAnalysis(wpy8l5cV);
			} catch (XQueryException NUImm0wR) {
				log(PrintUtils.prettyPrintStackTrace(NUImm0wR, -1));
				_lock.readLock().unlock();
				throw NUImm0wR;
			}
		}
		_lock.readLock().unlock();
		return qrwdbDJ8;
	}

}