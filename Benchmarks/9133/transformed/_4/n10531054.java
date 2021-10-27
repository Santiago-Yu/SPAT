class n10531054 {
	public boolean open(String mode) {
		if (source instanceof String)
			return false;
		else
			mode = (mode == null) ? "" : mode.toLowerCase();
		boolean toread = false, towrite = false;
		toread = (mode.indexOf("r") >= 0) ? true : toread;
		towrite = (mode.indexOf("w") >= 0) ? true : towrite;
		toread = (!toread && !towrite) ? towrite = true : toread;
		try {
			if (toread && input == null) {
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
			if (towrite && output == null) {
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