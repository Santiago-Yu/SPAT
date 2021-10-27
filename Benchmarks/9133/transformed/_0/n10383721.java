class n10383721 {
	@SuppressWarnings("unchecked")
	private ReaderFeed processEntrys(String m2t70ETL, String LSLI5OQo)
			throws UnsupportedEncodingException, IOException, JDOMException {
		String ZDlcdZgP = "processEntrys@" + m2t70ETL + "_" + LSLI5OQo;
		if (cache.containsKey(ZDlcdZgP)) {
			return (ReaderFeed) cache.get(ZDlcdZgP);
		}
		List<Post> aR0x7GIB = new ArrayList<Post>();
		URL zSFs5e6Y = new URL(m2t70ETL);
		HttpURLConnection YiHFGC2L = (HttpURLConnection) zSFs5e6Y.openConnection();
		YiHFGC2L.setRequestMethod("GET");
		YiHFGC2L.setRequestProperty("Cookie", "SID=" + sid);
		BufferedReader HU9dhEAt = new BufferedReader(new InputStreamReader(YiHFGC2L.getInputStream(), "UTF-8"));
		SAXBuilder Fw3EYCOq = new SAXBuilder(false);
		Document NeUJeoxY = Fw3EYCOq.build(HU9dhEAt);
		Element l8i0zvwq = NeUJeoxY.getRootElement();
		Namespace PdRqXKxr = l8i0zvwq.getNamespace("gr");
		Namespace pjjPxuY5 = l8i0zvwq.getNamespace();
		String K04hScip = l8i0zvwq.getChildText("continuation", PdRqXKxr);
		String zfv4VkMV = l8i0zvwq.getChildText("title", pjjPxuY5);
		String qO2cHVjn = l8i0zvwq.getChildText("subtitle", pjjPxuY5);
		List<Element> IrasWepC = l8i0zvwq.getChildren("entry", pjjPxuY5);
		DateFormat NAzYZIsR = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		for (Element tJtKDIgz : IrasWepC) {
			Post rHSYR368 = new Post();
			rHSYR368.setTitle(tJtKDIgz.getChildText("title", pjjPxuY5));
			try {
				rHSYR368.setDate(NAzYZIsR.parse(tJtKDIgz.getChildText("published", pjjPxuY5)));
			} catch (ParseException rgRJLVEE) {
			}
			rHSYR368.setUrl(tJtKDIgz.getChild("link", pjjPxuY5).getAttributeValue("href"));
			rHSYR368.setSauthor(tJtKDIgz.getChild("author", pjjPxuY5).getChildText("name", pjjPxuY5));
			String QFAPLEgB = tJtKDIgz.getChildText("content", pjjPxuY5);
			if (StringUtils.isEmpty(QFAPLEgB)) {
				QFAPLEgB = tJtKDIgz.getChildText("description", pjjPxuY5);
			}
			if (StringUtils.isEmpty(QFAPLEgB)) {
				QFAPLEgB = tJtKDIgz.getChildText("summary", pjjPxuY5);
			}
			rHSYR368.setContent(QFAPLEgB);
			aR0x7GIB.add(rHSYR368);
		}
		ReaderFeed ZnYuPWfv = new ReaderFeed();
		ZnYuPWfv.setTitle(zfv4VkMV);
		ZnYuPWfv.setSubTitle(qO2cHVjn);
		ZnYuPWfv.setFlag(K04hScip);
		ZnYuPWfv.setPostList(aR0x7GIB);
		cache.put(ZDlcdZgP, ZnYuPWfv);
		return ZnYuPWfv;
	}

}