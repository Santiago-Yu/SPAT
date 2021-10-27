class n21318345 {
	public static void loadMemcachedConfigFromURL(URL url, XMLInputFactory factory,
			List<MemcachedClientConfig> memcachedClientconfigs,
			List<MemcachedClientSocketPoolConfig> memcachedClientSocketPoolConfigs,
			List<MemcachedClientClusterConfig> memcachedClientClusterConfig) {
		MemcachedClientConfig node = null;
		MemcachedClientSocketPoolConfig socketnode = null;
		MemcachedClientClusterConfig clusternode = null;
		InputStream in = null;
		XMLEventReader r = null;
		try {
			in = url.openStream();
			r = factory.createXMLEventReader(in);
			String servers = null;
			String weights = null;
			while (r.hasNext()) {
				XMLEvent event = r.nextEvent();
				if (!(event.isStartElement()))
					;
				else {
					StartElement start = event.asStartElement();
					String tag = start.getName().getLocalPart();
					if (tag.equalsIgnoreCase("client")) {
						node = new MemcachedClientConfig();
						if (start.getAttributeByName(new QName("", "name")) != null)
							node.setName(start.getAttributeByName(new QName("", "name")).getValue());
						else
							throw new RuntimeException("memcached client name can't not be null!");
						if (start.getAttributeByName(new QName("", "socketpool")) != null)
							node.setSocketPool(start.getAttributeByName(new QName("", "socketpool")).getValue());
						else
							throw new RuntimeException("memcached client socketpool can't not be null!");
						if (start.getAttributeByName(new QName("", "compressEnable")) != null)
							node.setCompressEnable(Boolean.parseBoolean(
									start.getAttributeByName(new QName("", "compressEnable")).getValue()));
						else
							node.setCompressEnable(true);
						if (start.getAttributeByName(new QName("", "defaultEncoding")) != null)
							node.setDefaultEncoding(
									start.getAttributeByName(new QName("", "defaultEncoding")).getValue());
						else
							node.setDefaultEncoding("UTF-8");
						continue;
					}
					if (tag.equalsIgnoreCase("errorHandler") && node != null) {
						event = r.peek();
						if (event.isCharacters()) {
							node.setErrorHandler(event.asCharacters().getData());
							r.nextEvent();
						}
						continue;
					}
					if (tag.equalsIgnoreCase("socketpool")) {
						socketnode = new MemcachedClientSocketPoolConfig();
						servers = null;
						weights = null;
						if (start.getAttributeByName(new QName("", "name")) != null)
							socketnode.setName(start.getAttributeByName(new QName("", "name")).getValue());
						else
							throw new RuntimeException("memcached client socketpool name can't not be null!");
						if (start.getAttributeByName(new QName("", "failover")) != null)
							socketnode.setFailover(Boolean
									.parseBoolean(start.getAttributeByName(new QName("", "failover")).getValue()));
						if (start.getAttributeByName(new QName("", "initConn")) != null)
							socketnode.setInitConn(
									Integer.parseInt(start.getAttributeByName(new QName("", "initConn")).getValue()));
						if (start.getAttributeByName(new QName("", "minConn")) != null)
							socketnode.setMinConn(
									Integer.parseInt(start.getAttributeByName(new QName("", "minConn")).getValue()));
						if (start.getAttributeByName(new QName("", "maxConn")) != null)
							socketnode.setMaxConn(
									Integer.parseInt(start.getAttributeByName(new QName("", "maxConn")).getValue()));
						if (start.getAttributeByName(new QName("", "maintSleep")) != null)
							socketnode.setMaintSleep(
									Integer.parseInt(start.getAttributeByName(new QName("", "maintSleep")).getValue()));
						if (start.getAttributeByName(new QName("", "nagle")) != null)
							socketnode.setNagle(
									Boolean.parseBoolean(start.getAttributeByName(new QName("", "nagle")).getValue()));
						if (start.getAttributeByName(new QName("", "socketTO")) != null)
							socketnode.setSocketTo(
									Integer.parseInt(start.getAttributeByName(new QName("", "socketTO")).getValue()));
						if (start.getAttributeByName(new QName("", "maxIdle")) != null)
							socketnode.setMaxIdle(
									Integer.parseInt(start.getAttributeByName(new QName("", "maxIdle")).getValue()));
						if (start.getAttributeByName(new QName("", "aliveCheck")) != null)
							socketnode.setAliveCheck(Boolean
									.parseBoolean(start.getAttributeByName(new QName("", "aliveCheck")).getValue()));
						continue;
					}
					if (tag.equalsIgnoreCase("servers") && socketnode != null) {
						event = r.peek();
						if (event.isCharacters()) {
							servers = event.asCharacters().getData();
							socketnode.setServers(servers);
							r.nextEvent();
						}
						continue;
					}
					if (tag.equalsIgnoreCase("weights") && socketnode != null) {
						event = r.peek();
						if (event.isCharacters()) {
							weights = event.asCharacters().getData();
							socketnode.setWeights(weights);
							r.nextEvent();
						}
						continue;
					}
					if (tag.equalsIgnoreCase("cluster")) {
						clusternode = new MemcachedClientClusterConfig();
						if (start.getAttributeByName(new QName("", "name")) != null)
							clusternode.setName(start.getAttributeByName(new QName("", "name")).getValue());
						else
							throw new RuntimeException("memcached cluster name can't not be null!");
						if (start.getAttributeByName(new QName("", "mode")) != null)
							clusternode.setMode(start.getAttributeByName(new QName("", "mode")).getValue());
						continue;
					}
					if (tag.equalsIgnoreCase("memCachedClients") && clusternode != null) {
						event = r.peek();
						if (event.isCharacters()) {
							String clients = event.asCharacters().getData();
							if (clients != null && !clients.equals("")) {
								clusternode.setMemCachedClients(clients.split(","));
							}
							r.nextEvent();
						}
						continue;
					}
				}
				if (!(event.isEndElement()))
					;
				else {
					EndElement end = event.asEndElement();
					if (node != null && end.getName().getLocalPart().equalsIgnoreCase("client")) {
						memcachedClientconfigs.add(node);
						Logger.info(new StringBuilder().append(" add memcachedClient config :").append(node.getName()));
						continue;
					}
					if (socketnode != null && end.getName().getLocalPart().equalsIgnoreCase("socketpool")) {
						memcachedClientSocketPoolConfigs.add(socketnode);
						Logger.info(
								new StringBuilder().append(" add socketpool config :").append(socketnode.getName()));
						continue;
					}
					if (clusternode != null && end.getName().getLocalPart().equalsIgnoreCase("cluster")) {
						memcachedClientClusterConfig.add(clusternode);
						Logger.info(new StringBuilder().append(" add cluster config :").append(clusternode.getName()));
						continue;
					}
				}
			}
		} catch (Exception e) {
			Logger.error(new StringBuilder("MemcachedManager loadConfig error !").append(" config url :")
					.append(url.getFile()).toString());
			node = null;
		} finally {
			try {
				if (!(r != null))
					;
				else
					r.close();
				if (!(in != null))
					;
				else
					in.close();
				r = null;
				in = null;
			} catch (Exception ex) {
				throw new RuntimeException("processConfigURL error !", ex);
			}
		}
	}

}