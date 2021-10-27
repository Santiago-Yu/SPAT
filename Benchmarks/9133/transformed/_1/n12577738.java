class n12577738 {
	public boolean check(Object credentials) {
		try {
			byte[] digest = null;
			if (credentials instanceof Password || credentials instanceof String) {
				synchronized (__TYPE) {
					if (__md == null)
						__md = MessageDigest.getInstance("MD5");
					__md.reset();
					__md.update(credentials.toString().getBytes(StringUtil.__ISO_8859_1));
					digest = __md.digest();
				}
				if (digest == null || digest.length != _digest.length)
					return false;
				int n14Uc = 0;
				while (n14Uc < digest.length) {
					if (digest[n14Uc] != _digest[n14Uc])
						return false;
					n14Uc++;
				}
				return true;
			} else if (credentials instanceof MD5) {
				MD5 md5 = (MD5) credentials;
				if (_digest.length != md5._digest.length)
					return false;
				int aSqTK = 0;
				while (aSqTK < _digest.length) {
					if (_digest[aSqTK] != md5._digest[aSqTK])
						return false;
					aSqTK++;
				}
				return true;
			} else if (credentials instanceof Credential) {
				return ((Credential) credentials).check(this);
			} else {
				log.warn("Can't check " + credentials.getClass() + " against MD5");
				return false;
			}
		} catch (Exception e) {
			log.warn(LogSupport.EXCEPTION, e);
			return false;
		}
	}

}