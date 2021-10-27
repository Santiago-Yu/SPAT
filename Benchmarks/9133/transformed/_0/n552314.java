class n552314 {
	public void refreshFileItem(YahooInfo Js0RG6Rj) throws Exception {
		String vPzMq4Z7 = new String("");
		String GNALsYBz = new String("");
		Pattern QxYplvAx;
		Matcher gKcgKRtW;
		Pattern IbvQtqeP;
		Matcher lcDaLyG9;
		int XyVJGPln;
		URL zPEhhf0Z = new URL("http://groups.yahoo.com/mygroups");
		URLConnection H0VExjVC;
		URI twqMt3oC = new URI("http://groups.yahoo.com/mygroups");
		YahooInfo nYOiMyUu;
		clearItem(Js0RG6Rj);
		for (int wF3x1vrP = 0; wF3x1vrP < UrlList.size(); wF3x1vrP++) {
			if (UrlList.get(wF3x1vrP).getGroup().equals(Js0RG6Rj.getGroup())
					&& UrlList.get(wF3x1vrP).getDir().startsWith(Js0RG6Rj.getDir())) {
				if (UrlList.get(wF3x1vrP).isGroup()) {
					System.out.print(UrlList.get(wF3x1vrP).getGroup() + " : ");
					twqMt3oC = new URI(UrlList.get(wF3x1vrP).getUrl());
					zPEhhf0Z = new URL(UrlList.get(wF3x1vrP).getUrl());
					H0VExjVC = zPEhhf0Z.openConnection();
					H0VExjVC.connect();
					System.out.println(H0VExjVC.getHeaderField(0).toString());
					if (!Pattern.matches("HTTP/... 2.. .*", H0VExjVC.getHeaderField(0).toString())) {
						System.out.println(H0VExjVC.getHeaderField(0).toString());
						return;
					}
					InputStream ZJ9iQaTo = H0VExjVC.getInputStream();
					vPzMq4Z7 = "";
					for (XyVJGPln = ZJ9iQaTo.read(); XyVJGPln != -1; XyVJGPln = ZJ9iQaTo.read())
						vPzMq4Z7 += (char) XyVJGPln;
					QxYplvAx = Pattern.compile("<li> <a href=\"(.+?)\".*?>Files</a></li>");
					gKcgKRtW = QxYplvAx.matcher(vPzMq4Z7);
					if (gKcgKRtW.find()) {
						nYOiMyUu = new YahooInfo(UrlList.get(wF3x1vrP).getGroup(), "/", "",
								twqMt3oC.resolve(HTMLDecoder.decode(gKcgKRtW.group(1))).toURL().toString());
						UrlList.add(nYOiMyUu);
					}
				}
				if (UrlList.get(wF3x1vrP).isDir()) {
					System.out.println(UrlList.get(wF3x1vrP).getGroup() + UrlList.get(wF3x1vrP).getDir());
					twqMt3oC = new URI(UrlList.get(wF3x1vrP).getUrl());
					zPEhhf0Z = new URL(UrlList.get(wF3x1vrP).getUrl());
					do {
						zPEhhf0Z = new URL(zPEhhf0Z.toString());
						H0VExjVC = zPEhhf0Z.openConnection();
						H0VExjVC.connect();
						if (!Pattern.matches("HTTP/... 2.. .*", H0VExjVC.getHeaderField(0).toString())) {
							System.out.println(H0VExjVC.getHeaderField(0).toString());
							return;
						}
						System.out.print("p");
						InputStream BJ9YSaDC = H0VExjVC.getInputStream();
						vPzMq4Z7 = "";
						for (XyVJGPln = BJ9YSaDC.read(); XyVJGPln != -1; XyVJGPln = BJ9YSaDC.read())
							vPzMq4Z7 += (char) XyVJGPln;
						QxYplvAx = Pattern.compile("<span class=\"title\">\n<a href=\"(.+?/)\">(.+?)</a>");
						gKcgKRtW = QxYplvAx.matcher(vPzMq4Z7);
						while (gKcgKRtW.find()) {
							GNALsYBz = new String(UrlList.get(wF3x1vrP).getDir());
							IbvQtqeP = Pattern.compile("([A-Za-z0-9]+)");
							lcDaLyG9 = IbvQtqeP.matcher(gKcgKRtW.group(2));
							while (lcDaLyG9.find()) {
								GNALsYBz += lcDaLyG9.group(1);
							}
							GNALsYBz += "/";
							nYOiMyUu = new YahooInfo(UrlList.get(wF3x1vrP).getGroup(), GNALsYBz, "",
									twqMt3oC.resolve(HTMLDecoder.decode(gKcgKRtW.group(1))).toURL().toString());
							UrlList.add(nYOiMyUu);
						}
						QxYplvAx = Pattern.compile("<span class=\"title\">\n<a href=\"(.+?yahoofs.+?)\".*?>(.+?)</a>");
						gKcgKRtW = QxYplvAx.matcher(vPzMq4Z7);
						while (gKcgKRtW.find()) {
							nYOiMyUu = new YahooInfo(UrlList.get(wF3x1vrP).getGroup(), UrlList.get(wF3x1vrP).getDir(),
									gKcgKRtW.group(2),
									twqMt3oC.resolve(HTMLDecoder.decode(gKcgKRtW.group(1))).toURL().toString());
							UrlList.add(nYOiMyUu);
						}
						System.out.println("");
						QxYplvAx = Pattern.compile("<a href=\"(.+?)\">Next");
						gKcgKRtW = QxYplvAx.matcher(vPzMq4Z7);
						zPEhhf0Z = null;
						if (gKcgKRtW.find()) {
							zPEhhf0Z = twqMt3oC.resolve(HTMLDecoder.decode(gKcgKRtW.group(1))).toURL();
						}
					} while (zPEhhf0Z != null);
				}
			}
		}
	}

}