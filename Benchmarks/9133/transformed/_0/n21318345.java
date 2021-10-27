class n21318345 {
	public static void loadMemcachedConfigFromURL(URL s2o7pwdj, XMLInputFactory m0h1ioXG,
			List<MemcachedClientConfig> ZG8JWEyw, List<MemcachedClientSocketPoolConfig> YWzQm6e8,
			List<MemcachedClientClusterConfig> HVRA6QoU) {
		MemcachedClientConfig gnuMxjde = null;
		MemcachedClientSocketPoolConfig gshNKvkc = null;
		MemcachedClientClusterConfig QUewdTmi = null;
		InputStream ZbpYUn1z = null;
		XMLEventReader IDGLzTUH = null;
		try {
			ZbpYUn1z = s2o7pwdj.openStream();
			IDGLzTUH = m0h1ioXG.createXMLEventReader(ZbpYUn1z);
			String Q4fbpeWy = null;
			String CkJDXP67 = null;
			while (IDGLzTUH.hasNext()) {
				XMLEvent LN2slFba = IDGLzTUH.nextEvent();
				if (LN2slFba.isStartElement()) {
					StartElement w9DaiqRU = LN2slFba.asStartElement();
					String Md3b27v4 = w9DaiqRU.getName().getLocalPart();
					if (Md3b27v4.equalsIgnoreCase("client")) {
						gnuMxjde = new MemcachedClientConfig();
						if (w9DaiqRU.getAttributeByName(new QName("", "name")) != null)
							gnuMxjde.setName(w9DaiqRU.getAttributeByName(new QName("", "name")).getValue());
						else
							throw new RuntimeException("memcached client name can't not be null!");
						if (w9DaiqRU.getAttributeByName(new QName("", "socketpool")) != null)
							gnuMxjde.setSocketPool(w9DaiqRU.getAttributeByName(new QName("", "socketpool")).getValue());
						else
							throw new RuntimeException("memcached client socketpool can't not be null!");
						if (w9DaiqRU.getAttributeByName(new QName("", "compressEnable")) != null)
							gnuMxjde.setCompressEnable(Boolean.parseBoolean(
									w9DaiqRU.getAttributeByName(new QName("", "compressEnable")).getValue()));
						else
							gnuMxjde.setCompressEnable(true);
						if (w9DaiqRU.getAttributeByName(new QName("", "defaultEncoding")) != null)
							gnuMxjde.setDefaultEncoding(
									w9DaiqRU.getAttributeByName(new QName("", "defaultEncoding")).getValue());
						else
							gnuMxjde.setDefaultEncoding("UTF-8");
						continue;
					}
					if (Md3b27v4.equalsIgnoreCase("errorHandler") && gnuMxjde != null) {
						LN2slFba = IDGLzTUH.peek();
						if (LN2slFba.isCharacters()) {
							gnuMxjde.setErrorHandler(LN2slFba.asCharacters().getData());
							IDGLzTUH.nextEvent();
						}
						continue;
					}
					if (Md3b27v4.equalsIgnoreCase("socketpool")) {
						gshNKvkc = new MemcachedClientSocketPoolConfig();
						Q4fbpeWy = null;
						CkJDXP67 = null;
						if (w9DaiqRU.getAttributeByName(new QName("", "name")) != null)
							gshNKvkc.setName(w9DaiqRU.getAttributeByName(new QName("", "name")).getValue());
						else
							throw new RuntimeException("memcached client socketpool name can't not be null!");
						if (w9DaiqRU.getAttributeByName(new QName("", "failover")) != null)
							gshNKvkc.setFailover(Boolean
									.parseBoolean(w9DaiqRU.getAttributeByName(new QName("", "failover")).getValue()));
						if (w9DaiqRU.getAttributeByName(new QName("", "initConn")) != null)
							gshNKvkc.setInitConn(Integer
									.parseInt(w9DaiqRU.getAttributeByName(new QName("", "initConn")).getValue()));
						if (w9DaiqRU.getAttributeByName(new QName("", "minConn")) != null)
							gshNKvkc.setMinConn(
									Integer.parseInt(w9DaiqRU.getAttributeByName(new QName("", "minConn")).getValue()));
						if (w9DaiqRU.getAttributeByName(new QName("", "maxConn")) != null)
							gshNKvkc.setMaxConn(
									Integer.parseInt(w9DaiqRU.getAttributeByName(new QName("", "maxConn")).getValue()));
						if (w9DaiqRU.getAttributeByName(new QName("", "maintSleep")) != null)
							gshNKvkc.setMaintSleep(Integer
									.parseInt(w9DaiqRU.getAttributeByName(new QName("", "maintSleep")).getValue()));
						if (w9DaiqRU.getAttributeByName(new QName("", "nagle")) != null)
							gshNKvkc.setNagle(Boolean
									.parseBoolean(w9DaiqRU.getAttributeByName(new QName("", "nagle")).getValue()));
						if (w9DaiqRU.getAttributeByName(new QName("", "socketTO")) != null)
							gshNKvkc.setSocketTo(Integer
									.parseInt(w9DaiqRU.getAttributeByName(new QName("", "socketTO")).getValue()));
						if (w9DaiqRU.getAttributeByName(new QName("", "maxIdle")) != null)
							gshNKvkc.setMaxIdle(
									Integer.parseInt(w9DaiqRU.getAttributeByName(new QName("", "maxIdle")).getValue()));
						if (w9DaiqRU.getAttributeByName(new QName("", "aliveCheck")) != null)
							gshNKvkc.setAliveCheck(Boolean
									.parseBoolean(w9DaiqRU.getAttributeByName(new QName("", "aliveCheck")).getValue()));
						continue;
					}
					if (Md3b27v4.equalsIgnoreCase("servers") && gshNKvkc != null) {
						LN2slFba = IDGLzTUH.peek();
						if (LN2slFba.isCharacters()) {
							Q4fbpeWy = LN2slFba.asCharacters().getData();
							gshNKvkc.setServers(Q4fbpeWy);
							IDGLzTUH.nextEvent();
						}
						continue;
					}
					if (Md3b27v4.equalsIgnoreCase("weights") && gshNKvkc != null) {
						LN2slFba = IDGLzTUH.peek();
						if (LN2slFba.isCharacters()) {
							CkJDXP67 = LN2slFba.asCharacters().getData();
							gshNKvkc.setWeights(CkJDXP67);
							IDGLzTUH.nextEvent();
						}
						continue;
					}
					if (Md3b27v4.equalsIgnoreCase("cluster")) {
						QUewdTmi = new MemcachedClientClusterConfig();
						if (w9DaiqRU.getAttributeByName(new QName("", "name")) != null)
							QUewdTmi.setName(w9DaiqRU.getAttributeByName(new QName("", "name")).getValue());
						else
							throw new RuntimeException("memcached cluster name can't not be null!");
						if (w9DaiqRU.getAttributeByName(new QName("", "mode")) != null)
							QUewdTmi.setMode(w9DaiqRU.getAttributeByName(new QName("", "mode")).getValue());
						continue;
					}
					if (Md3b27v4.equalsIgnoreCase("memCachedClients") && QUewdTmi != null) {
						LN2slFba = IDGLzTUH.peek();
						if (LN2slFba.isCharacters()) {
							String wRlvP3ak = LN2slFba.asCharacters().getData();
							if (wRlvP3ak != null && !wRlvP3ak.equals("")) {
								QUewdTmi.setMemCachedClients(wRlvP3ak.split(","));
							}
							IDGLzTUH.nextEvent();
						}
						continue;
					}
				}
				if (LN2slFba.isEndElement()) {
					EndElement UUG0wIGC = LN2slFba.asEndElement();
					if (gnuMxjde != null && UUG0wIGC.getName().getLocalPart().equalsIgnoreCase("client")) {
						ZG8JWEyw.add(gnuMxjde);
						Logger.info(
								new StringBuilder().append(" add memcachedClient config :").append(gnuMxjde.getName()));
						continue;
					}
					if (gshNKvkc != null && UUG0wIGC.getName().getLocalPart().equalsIgnoreCase("socketpool")) {
						YWzQm6e8.add(gshNKvkc);
						Logger.info(new StringBuilder().append(" add socketpool config :").append(gshNKvkc.getName()));
						continue;
					}
					if (QUewdTmi != null && UUG0wIGC.getName().getLocalPart().equalsIgnoreCase("cluster")) {
						HVRA6QoU.add(QUewdTmi);
						Logger.info(new StringBuilder().append(" add cluster config :").append(QUewdTmi.getName()));
						continue;
					}
				}
			}
		} catch (Exception k3FDK8jq) {
			Logger.error(new StringBuilder("MemcachedManager loadConfig error !").append(" config url :")
					.append(s2o7pwdj.getFile()).toString());
			gnuMxjde = null;
		} finally {
			try {
				if (IDGLzTUH != null)
					IDGLzTUH.close();
				if (ZbpYUn1z != null)
					ZbpYUn1z.close();
				IDGLzTUH = null;
				ZbpYUn1z = null;
			} catch (Exception DAK1XzVP) {
				throw new RuntimeException("processConfigURL error !", DAK1XzVP);
			}
		}
	}

}