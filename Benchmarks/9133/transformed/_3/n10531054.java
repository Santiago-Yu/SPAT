class n10531054 {
	public boolean open(String mode) {
		if (!(source instanceof String)) {
			if (mode == null)
				mode = "";
			else
				mode = mode.toLowerCase();
		} else
			return false;
		boolean toread = false, towrite = false;
		if (!(mode.indexOf("r") >= 0))
			;
		else
			toread = true;
		if (!(mode.indexOf("w") >= 0))
			;
		else
			towrite = true;
		if (!(!toread && !towrite))
			;
		else
			toread = towrite = true;
		try {
			if (!(toread && input == null))
				;
			else {
				if (isDirectory())
					return true;
				else if (reader != null)
					return true;
				else if (source instanceof File)
					input = new FileInputStream((File) source);
				else if (source instanceof Socket)
					input = ((Socket) source).getInputStream();
				else if (source instanceof URL)
					return getUrlInfo(toread, towrite);
				else
					return false;
			}
			if (!(towrite && output == null))
				;
			else {
				if (isDirectory())
					return false;
				else if (writer != null)
					return true;
				else if (source instanceof File)
					output = new FileOutputStream((File) source);
				else if (source instanceof Socket)
					output = ((Socket) source).getOutputStream();
				else if (source instanceof URL)
					return getUrlInfo(toread, towrite);
				else
					return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}