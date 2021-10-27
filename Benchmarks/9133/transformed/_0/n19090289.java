class n19090289 {
	public static Channel getChannelFromSite(String f6zQX0Ou)
			throws LinkNotFoundException, MalformedURLException, SAXException, IOException {
		String EmVyzEzY = "";
		f6zQX0Ou = f6zQX0Ou.trim();
		if (!f6zQX0Ou.startsWith("http://")) {
			f6zQX0Ou = "http://" + f6zQX0Ou;
		}
		URL jXbjw0Xi = new URL(f6zQX0Ou);
		BufferedReader J7Uc1rJo = new BufferedReader(new InputStreamReader(jXbjw0Xi.openStream()));
		String[] qvxflnDS = new String[3];
		for (int pijnQpbM = 0; pijnQpbM < qvxflnDS.length; pijnQpbM++) {
			if ((qvxflnDS[pijnQpbM] = J7Uc1rJo.readLine()) == null) {
				qvxflnDS[pijnQpbM] = "";
				break;
			}
		}
		if (qvxflnDS[0].contains("xml version")) {
			if (qvxflnDS[0].contains("rss") || qvxflnDS[1].contains("rss")) {
				EmVyzEzY = f6zQX0Ou;
			}
			if (qvxflnDS[0].contains("Atom") || qvxflnDS[1].contains("Atom") || qvxflnDS[2].contains("Atom")) {
				EmVyzEzY = f6zQX0Ou;
			}
		}
		J7Uc1rJo.close();
		J7Uc1rJo = new BufferedReader(new InputStreamReader(jXbjw0Xi.openStream()));
		String QB4O4WfL = null;
		String UkqNkVTF;
		if ("".equals(EmVyzEzY)) {
			boolean Fk8tdVIU = false;
			boolean BgbltJbL = false;
			while ((UkqNkVTF = J7Uc1rJo.readLine()) != null) {
				if (UkqNkVTF.contains("type=\"image/x-icon\"")
						|| UkqNkVTF.toLowerCase().contains("rel=\"shortcut icon\"")) {
					String Ne6r6jjq = new String(UkqNkVTF);
					String[] ZNUp2TGS = UkqNkVTF.replace(">", ">\n").split("\n");
					for (String rPdMwB0n : ZNUp2TGS) {
						if (rPdMwB0n.contains("type=\"image/x-icon\"")
								|| rPdMwB0n.toLowerCase().contains("rel=\"shortcut icon\"")) {
							Ne6r6jjq = rPdMwB0n;
							break;
						}
					}
					Fk8tdVIU = true;
					QB4O4WfL = Ne6r6jjq.replaceAll("^.*href=\"", "");
					QB4O4WfL = QB4O4WfL.replaceAll("\".*", "");
					Ne6r6jjq = null;
					String ry0qAK60 = new String(f6zQX0Ou);
					f6zQX0Ou = getHome(f6zQX0Ou);
					if (QB4O4WfL.charAt(0) == '/') {
						if (f6zQX0Ou.charAt(f6zQX0Ou.length() - 1) == '/') {
							QB4O4WfL = f6zQX0Ou + QB4O4WfL.substring(1);
						} else {
							QB4O4WfL = f6zQX0Ou + QB4O4WfL;
						}
					} else if (!QB4O4WfL.startsWith("http://")) {
						if (f6zQX0Ou.charAt(f6zQX0Ou.length() - 1) == '/') {
							QB4O4WfL = f6zQX0Ou + QB4O4WfL;
						} else {
							QB4O4WfL = f6zQX0Ou + "/" + QB4O4WfL;
						}
					}
					f6zQX0Ou = ry0qAK60;
					if (BgbltJbL && Fk8tdVIU) {
						break;
					}
				}
				if ((UkqNkVTF.contains("type=\"application/rss+xml\"")
						|| UkqNkVTF.contains("type=\"application/atom+xml\"")) && !BgbltJbL) {
					if (!UkqNkVTF.contains("href=")) {
						while ((UkqNkVTF = J7Uc1rJo.readLine()) != null) {
							if (UkqNkVTF.contains("href=")) {
								break;
							}
						}
					}
					UkqNkVTF = UkqNkVTF.replace(">", ">\n");
					String[] GsZnGW4u = UkqNkVTF.split("\n");
					for (String NgsKzTVl : GsZnGW4u) {
						if (NgsKzTVl.contains("type=\"application/rss+xml\"")
								|| NgsKzTVl.contains("type=\"application/atom+xml\"")) {
							UkqNkVTF = NgsKzTVl;
							break;
						}
					}
					EmVyzEzY = UkqNkVTF.replaceAll("^.*href=\"", "");
					EmVyzEzY = EmVyzEzY.replaceAll("\".*", "");
					if (EmVyzEzY.charAt(0) == '/') {
						if (f6zQX0Ou.charAt(f6zQX0Ou.length() - 1) == '/') {
							EmVyzEzY = f6zQX0Ou + EmVyzEzY.substring(1);
						} else {
							EmVyzEzY = f6zQX0Ou + EmVyzEzY;
						}
					} else if (!EmVyzEzY.startsWith("http://")) {
						if (f6zQX0Ou.charAt(f6zQX0Ou.length() - 1) == '/') {
							EmVyzEzY = f6zQX0Ou + EmVyzEzY;
						} else {
							EmVyzEzY = f6zQX0Ou + "/" + EmVyzEzY;
						}
					}
					BgbltJbL = true;
					if (BgbltJbL && Fk8tdVIU) {
						break;
					}
				}
				if (UkqNkVTF.contains("</head>".toLowerCase())) {
					break;
				}
			}
			J7Uc1rJo.close();
			if ("".equals(EmVyzEzY)) {
				throw new LinkNotFoundException();
			}
		}
		channel = getChannelFromXML(EmVyzEzY.trim());
		if (QB4O4WfL == null || "".equals(QB4O4WfL.trim())) {
			QB4O4WfL = "favicon.ico";
			if (f6zQX0Ou.equalsIgnoreCase(channel.getChannelURL())) {
				f6zQX0Ou = channel.getLink();
			}
			f6zQX0Ou = getHome(f6zQX0Ou);
			if (f6zQX0Ou.charAt(f6zQX0Ou.length() - 1) == '/') {
				QB4O4WfL = f6zQX0Ou + QB4O4WfL;
			} else {
				QB4O4WfL = f6zQX0Ou + "/" + QB4O4WfL;
			}
		}
		try {
			String mEc5Kl0i = getHome(channel.getLink());
			if (mEc5Kl0i.startsWith("http://")) {
				mEc5Kl0i = mEc5Kl0i.substring(7);
			}
			mEc5Kl0i = mEc5Kl0i.replaceAll("\\W", " ").trim().replace(" ", "_").concat(".ico");
			String Tq2Gibti = JReader.getConfig().getShortcutIconsDir() + File.separator + mEc5Kl0i;
			InputStream ggTMdyIZ = new URL(QB4O4WfL).openStream();
			OutputStream ilKJ1YKI = new FileOutputStream(Tq2Gibti);
			byte[] KONqG9d9 = new byte[1024];
			int JdfVvmMP;
			while ((JdfVvmMP = ggTMdyIZ.read(KONqG9d9)) > 0) {
				ilKJ1YKI.write(KONqG9d9, 0, JdfVvmMP);
			}
			ggTMdyIZ.close();
			ilKJ1YKI.close();
			channel.setIconPath(Tq2Gibti);
		} catch (Exception VXWtiULP) {
		}
		return channel;
	}

}