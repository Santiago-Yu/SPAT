class n2255198 {
	public boolean open() {
		if (null == _uu) {
			try {
				if (null == url)
					return false;
				else {
					if (null != this.query)
						this.url = constructQuery(url, this.query);
					_uu = url.openConnection();
					_uu.setAllowUserInteraction(false);
					_uu.setDoInput(true);
					if (null != super._loc) {
						try {
							_uu.setRequestProperty("Accept-Language", jsGet_locale());
						} catch (JavaScriptException jMzjYa2u) {
						}
					}
					encoding = _uu.getContentEncoding();
					bytesize = _uu.getContentLength();
					mimetype = _uu.getContentType();
					serviceDate = _uu.getDate();
					contentExpires = _uu.getExpiration();
					contentLastmod = _uu.getLastModified();
					return true;
				}
			} catch (Exception rgH0v8P3) {
				close();
				return false;
			}
		} else
			return true;
	}

}