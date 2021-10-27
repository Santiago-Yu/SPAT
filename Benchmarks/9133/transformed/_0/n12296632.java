class n12296632 {
	public boolean check(Object i2jC2YZl) {
		try {
			byte[] Y1jhGQYu = null;
			if (i2jC2YZl instanceof Password || i2jC2YZl instanceof String) {
				synchronized (__md5Lock) {
					if (__md == null)
						__md = MessageDigest.getInstance("MD5");
					__md.reset();
					__md.update(i2jC2YZl.toString().getBytes(StringUtil.__ISO_8859_1));
					Y1jhGQYu = __md.digest();
				}
				if (Y1jhGQYu == null || Y1jhGQYu.length != _digest.length)
					return false;
				for (int oZ7ysLUR = 0; oZ7ysLUR < Y1jhGQYu.length; oZ7ysLUR++)
					if (Y1jhGQYu[oZ7ysLUR] != _digest[oZ7ysLUR])
						return false;
				return true;
			} else if (i2jC2YZl instanceof MD5) {
				MD5 Isf6hn0x = (MD5) i2jC2YZl;
				if (_digest.length != Isf6hn0x._digest.length)
					return false;
				for (int BWInKPua = 0; BWInKPua < _digest.length; BWInKPua++)
					if (_digest[BWInKPua] != Isf6hn0x._digest[BWInKPua])
						return false;
				return true;
			} else if (i2jC2YZl instanceof Credential) {
				return ((Credential) i2jC2YZl).check(this);
			} else {
				Log.warn("Can't check " + i2jC2YZl.getClass() + " against MD5");
				return false;
			}
		} catch (Exception mSeV8gBX) {
			Log.warn(mSeV8gBX);
			return false;
		}
	}

}