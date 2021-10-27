class n12577738 {
	public boolean check(Object iiV4rgF6) {
		try {
			byte[] l8zi3f7S = null;
			if (iiV4rgF6 instanceof Password || iiV4rgF6 instanceof String) {
				synchronized (__TYPE) {
					if (__md == null)
						__md = MessageDigest.getInstance("MD5");
					__md.reset();
					__md.update(iiV4rgF6.toString().getBytes(StringUtil.__ISO_8859_1));
					l8zi3f7S = __md.digest();
				}
				if (l8zi3f7S == null || l8zi3f7S.length != _digest.length)
					return false;
				for (int VW90nsBO = 0; VW90nsBO < l8zi3f7S.length; VW90nsBO++)
					if (l8zi3f7S[VW90nsBO] != _digest[VW90nsBO])
						return false;
				return true;
			} else if (iiV4rgF6 instanceof MD5) {
				MD5 rW0dbxti = (MD5) iiV4rgF6;
				if (_digest.length != rW0dbxti._digest.length)
					return false;
				for (int GdBKpf63 = 0; GdBKpf63 < _digest.length; GdBKpf63++)
					if (_digest[GdBKpf63] != rW0dbxti._digest[GdBKpf63])
						return false;
				return true;
			} else if (iiV4rgF6 instanceof Credential) {
				return ((Credential) iiV4rgF6).check(this);
			} else {
				log.warn("Can't check " + iiV4rgF6.getClass() + " against MD5");
				return false;
			}
		} catch (Exception W4iHUyy4) {
			log.warn(LogSupport.EXCEPTION, W4iHUyy4);
			return false;
		}
	}

}