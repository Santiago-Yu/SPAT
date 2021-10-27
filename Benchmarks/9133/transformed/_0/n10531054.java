class n10531054 {
	public boolean open(String Iwn5kmnM) {
		if (source instanceof String)
			return false;
		else if (Iwn5kmnM == null)
			Iwn5kmnM = "";
		else
			Iwn5kmnM = Iwn5kmnM.toLowerCase();
		boolean BY3g5Tr6 = false, WYn2cwCk = false;
		if (Iwn5kmnM.indexOf("r") >= 0)
			BY3g5Tr6 = true;
		if (Iwn5kmnM.indexOf("w") >= 0)
			WYn2cwCk = true;
		if (!BY3g5Tr6 && !WYn2cwCk)
			BY3g5Tr6 = WYn2cwCk = true;
		try {
			if (BY3g5Tr6 && input == null) {
				if (isDirectory())
					return true;
				else if (reader != null)
					return true;
				else if (source instanceof File)
					input = new FileInputStream((File) source);
				else if (source instanceof Socket)
					input = ((Socket) source).getInputStream();
				else if (source instanceof URL)
					return getUrlInfo(BY3g5Tr6, WYn2cwCk);
				else
					return false;
			}
			if (WYn2cwCk && output == null) {
				if (isDirectory())
					return false;
				else if (writer != null)
					return true;
				else if (source instanceof File)
					output = new FileOutputStream((File) source);
				else if (source instanceof Socket)
					output = ((Socket) source).getOutputStream();
				else if (source instanceof URL)
					return getUrlInfo(BY3g5Tr6, WYn2cwCk);
				else
					return false;
			}
			return true;
		} catch (Exception Vw0fGlUq) {
			return false;
		}
	}

}