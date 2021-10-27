class n2996859 {
	public void run() {
		StringBuffer s9fpDzkJ;
		String iPTbiFu2;
		Element JbfCnpIW;
		setBold(monitor.getReading());
		setBold(monitor.getReadingStatus());
		monitor.getReadingStatus().setText("      Working");
		HttpMethod ocAgIMbf = null;
		s9fpDzkJ = new StringBuffer();
		File YG2Euyqo = new File(url);
		if (YG2Euyqo.exists()) {
			try {
				InputStream qSiOBBQt = new FileInputStream(YG2Euyqo);
				int Ae466J0K;
				while ((Ae466J0K = qSiOBBQt.read()) != -1) {
					s9fpDzkJ.append((char) Ae466J0K);
				}
				qSiOBBQt.close();
			} catch (IOException HKwNNSCq) {
				System.out.println("Loading Monitor Failed, error while reading XML file from local file");
				HKwNNSCq.printStackTrace(System.err);
				return;
			}
		} else {
			try {
				HttpClient J4nsJrEd = new HttpClient();
				ocAgIMbf = new GetMethod(url);
				int qA5mRtSf = J4nsJrEd.executeMethod(ocAgIMbf);
				if (qA5mRtSf == 200) {
					InputStream IhmzAho7 = ocAgIMbf.getResponseBodyAsStream();
					int IbpLFAeG;
					while ((IbpLFAeG = IhmzAho7.read()) != -1) {
						s9fpDzkJ.append((char) IbpLFAeG);
					}
					IhmzAho7.close();
				} else {
					if (ocAgIMbf != null) {
						ocAgIMbf.releaseConnection();
					}
					System.out.println("Loading Monitor Failed. Incorrect response from HTTP Server " + qA5mRtSf);
					return;
				}
			} catch (IOException NXcUspAw) {
				if (ocAgIMbf != null) {
					ocAgIMbf.releaseConnection();
				}
				System.out.println("Loading Monitor Failed, error while reading XML file from HTTP Server");
				NXcUspAw.printStackTrace(System.err);
				return;
			}
		}
		setPlain(monitor.getReading());
		setPlain(monitor.getReadingStatus());
		monitor.getReadingStatus().setText("      Done");
		setBold(monitor.getValidating());
		setBold(monitor.getValidatingStatus());
		monitor.getValidatingStatus().setText("      Working");
		DocumentBuilderFactoryImpl iFavrg5Q = new DocumentBuilderFactoryImpl();
		try {
			DocumentBuilder t1qI5mZL = iFavrg5Q.newDocumentBuilder();
			Document gpM9khAO = t1qI5mZL.parse(new ByteArrayInputStream(s9fpDzkJ.toString().getBytes()));
			if (ocAgIMbf != null) {
				ocAgIMbf.releaseConnection();
			}
			Element Db1BbBGt = gpM9khAO.getDocumentElement();
			NodeList fVxLX5cP = Db1BbBGt.getElementsByTagName("resource");
			for (int ure8QvPr = 0; ure8QvPr < fVxLX5cP.getLength(); ure8QvPr++) {
				Element PTm82hL5 = (Element) fVxLX5cP.item(ure8QvPr);
				resources.add(new URL(PTm82hL5.getAttribute("url")));
			}
			NodeList Zg5HdKrD = Db1BbBGt.getElementsByTagName("jmxserver");
			for (int iPlC4Lr9 = 0; iPlC4Lr9 < Zg5HdKrD.getLength(); iPlC4Lr9++) {
				Element PrNDexjd = (Element) Zg5HdKrD.item(iPlC4Lr9);
				String R5hHsWxI = PrNDexjd.getAttribute("name");
				String PyzfJ689 = PrNDexjd.getAttribute("url");
				String Aa7ivrBR = PrNDexjd.getAttribute("auth");
				if (PyzfJ689.indexOf("${host}") != -1) {
					HostDialog vhvb4njM = new HostDialog(Config.getHosts());
					String FMxauWSb = vhvb4njM.showDialog();
					if (FMxauWSb == null) {
						System.out.println("Host can not be null, unable to create panel.");
						return;
					}
					PyzfJ689 = PyzfJ689.replaceAll("\\$\\{host\\}", FMxauWSb);
					Config.addHost(FMxauWSb);
				}
				JMXServiceURL LwZF2Epi = new JMXServiceURL(PyzfJ689);
				JmxServerGraph YjCEuE69 = new JmxServerGraph(R5hHsWxI, LwZF2Epi, new JmxWorker(false));
				if (Aa7ivrBR != null && Aa7ivrBR.equalsIgnoreCase("true")) {
					LoginTrueService xwjdtQxF = new LoginTrueService();
					JXLoginPanel.Status tWLBTXHs = JXLoginPanel.showLoginDialog(null, xwjdtQxF);
					if (tWLBTXHs != JXLoginPanel.Status.SUCCEEDED) {
						return;
					}
					YjCEuE69.setUsername(xwjdtQxF.getName());
					YjCEuE69.setPassword(xwjdtQxF.getPassword());
				}
				servers.put(R5hHsWxI, YjCEuE69);
				NodeList WSyXVhpd = PrNDexjd.getElementsByTagName("listener");
				for (int nnLwSpzu = 0; nnLwSpzu < WSyXVhpd.getLength(); nnLwSpzu++) {
					Element YShWuvvk = (Element) WSyXVhpd.item(nnLwSpzu);
					String AdtR8u3n = YShWuvvk.getAttribute("taskname");
					MBean w69iNOeF = new MBean(YShWuvvk.getAttribute("mbean"), null);
					String fpys5yqu = YShWuvvk.getAttribute("filterType");
					TaskNotificationListener Jagec3H4 = new TaskNotificationListener();
					NotificationFilterSupport Gwsdi1m8 = new NotificationFilterSupport();
					if (fpys5yqu == null || "".equals(fpys5yqu)) {
						Gwsdi1m8 = null;
					} else {
						Gwsdi1m8.enableType(fpys5yqu);
					}
					Task bIn0vRgP = new Task(-1, Task.LISTEN, YjCEuE69);
					bIn0vRgP.setMbean(w69iNOeF);
					bIn0vRgP.setListener(Jagec3H4);
					bIn0vRgP.setFilter(Gwsdi1m8);
					YjCEuE69.getWorker().addTask(bIn0vRgP);
					if (tasks.get(AdtR8u3n) != null) {
						System.out.println("Task " + AdtR8u3n + " already exists.");
						return;
					}
					List<Task> ziQP2qGL = new ArrayList<Task>();
					ziQP2qGL.add(bIn0vRgP);
					tasks.put(AdtR8u3n, ziQP2qGL);
				}
				NodeList jrhbPyOX = PrNDexjd.getElementsByTagName("attribute");
				for (int KBHLoRWt = 0; KBHLoRWt < jrhbPyOX.getLength(); KBHLoRWt++) {
					Element PdH7The7 = (Element) jrhbPyOX.item(KBHLoRWt);
					String d5YjBzVH = PdH7The7.getAttribute("taskname");
					MBean kiktFpAe = new MBean(PdH7The7.getAttribute("mbean"), null);
					String CdB1xSO0 = PdH7The7.getAttribute("attributename");
					String BP9c1ZeQ = PdH7The7.getAttribute("frequency");
					String bAGEo5D7 = PdH7The7.getAttribute("onEvent");
					if (BP9c1ZeQ.equalsIgnoreCase("onchange")) {
						TaskNotificationListener j6cKVVkz = new TaskNotificationListener();
						AttributeChangeNotificationFilter XJTbMmqT = new AttributeChangeNotificationFilter();
						XJTbMmqT.enableAttribute(CdB1xSO0);
						Task LYUJQ9lg = new Task(-1, Task.LISTEN, YjCEuE69);
						MBeanAttribute iqDikUkv = new MBeanAttribute(kiktFpAe, CdB1xSO0);
						LYUJQ9lg.setAttribute(iqDikUkv);
						LYUJQ9lg.setMbean(kiktFpAe);
						LYUJQ9lg.setListener(j6cKVVkz);
						LYUJQ9lg.setFilter(XJTbMmqT);
						YjCEuE69.getWorker().addTask(LYUJQ9lg);
						if (tasks.get(d5YjBzVH) != null) {
							System.out.println("Task " + d5YjBzVH + " already exists.");
							return;
						}
						Task nDnZFR0Y = new Task(-1, Task.GET_ATTRIBUTE, YjCEuE69);
						nDnZFR0Y.setAttribute(iqDikUkv);
						nDnZFR0Y.setMbean(kiktFpAe);
						YjCEuE69.getWorker().addTask(nDnZFR0Y);
						List<Task> gk7mQho5 = new ArrayList<Task>();
						gk7mQho5.add(LYUJQ9lg);
						gk7mQho5.add(nDnZFR0Y);
						tasks.put(d5YjBzVH, gk7mQho5);
					} else {
						int CWEra5la = Integer.parseInt(BP9c1ZeQ);
						Task z4uxpNeh = new Task(CWEra5la, Task.GET_ATTRIBUTE, YjCEuE69);
						MBeanAttribute RrRyETq8 = new MBeanAttribute(kiktFpAe, CdB1xSO0);
						z4uxpNeh.setAttribute(RrRyETq8);
						z4uxpNeh.setMbean(kiktFpAe);
						if (tasks.get(d5YjBzVH) != null) {
							System.out.println("Task " + d5YjBzVH + " already exists.");
							return;
						}
						List<Task> ZqOnCJaC = new ArrayList<Task>();
						ZqOnCJaC.add(z4uxpNeh);
						tasks.put(d5YjBzVH, ZqOnCJaC);
						TaskNotificationListener b4DeecmS = null;
						if (bAGEo5D7 != null && !"".equals(bAGEo5D7)) {
							Task Sr7jlBdv = tasks.get(bAGEo5D7).get(0);
							if (Sr7jlBdv == null) {
								System.out.println(bAGEo5D7 + " was not found.");
								return;
							} else {
								b4DeecmS = (TaskNotificationListener) Sr7jlBdv.getListener();
							}
						}
						if (b4DeecmS == null) {
							YjCEuE69.getWorker().addTask(z4uxpNeh);
						} else {
							b4DeecmS.addTask(z4uxpNeh);
						}
					}
				}
			}
			NodeList T0t3kZ1P = Db1BbBGt.getElementsByTagName("gui");
			JbfCnpIW = (Element) T0t3kZ1P.item(0);
			iPTbiFu2 = JbfCnpIW.getAttribute("name");
			if (MonitorServer.contains(iPTbiFu2)) {
				JOptionPane.showMessageDialog(null, "This panel is already open, stoping creating of panel.",
						"Panel already exists", JOptionPane.ERROR_MESSAGE);
				return;
			}
			for (int ux3RboYK = 0; ux3RboYK < monitor.getTab().getTabCount(); ux3RboYK++) {
				if (monitor.getTab().getComponent(ux3RboYK).equals(monitor)) {
					monitor.getTab().setTitleAt(ux3RboYK, iPTbiFu2);
					break;
				}
			}
			NodeList ZNQwa6h9 = Db1BbBGt.getElementsByTagName("binding");
			for (int Q4ZjdDD8 = 0; Q4ZjdDD8 < ZNQwa6h9.getLength(); Q4ZjdDD8++) {
				Element QLBAM8XY = (Element) ZNQwa6h9.item(Q4ZjdDD8);
				String hRCfTwiA = QLBAM8XY.getAttribute("guiname");
				String xgShlT7r = QLBAM8XY.getAttribute("method");
				String wPpHJAW2 = QLBAM8XY.getAttribute("taskname");
				String n3p9aWYU = QLBAM8XY.getAttribute("formater");
				BindingContainer uCEgk1NI;
				if (n3p9aWYU == null || (n3p9aWYU != null && n3p9aWYU.equals(""))) {
					uCEgk1NI = new BindingContainer(hRCfTwiA, xgShlT7r, wPpHJAW2);
				} else {
					uCEgk1NI = new BindingContainer(hRCfTwiA, xgShlT7r, wPpHJAW2, n3p9aWYU);
				}
				bindings.add(uCEgk1NI);
			}
		} catch (Exception y0caFRfy) {
			System.err.println("Exception message: " + y0caFRfy.getMessage());
			System.out.println("Loading Monitor Failed, couldnt parse XML file.");
			y0caFRfy.printStackTrace(System.err);
			return;
		}
		setPlain(monitor.getValidating());
		setPlain(monitor.getValidatingStatus());
		monitor.getValidatingStatus().setText("      Done");
		setBold(monitor.getDownload());
		setBold(monitor.getDownloadStatus());
		monitor.getDownloadStatus().setText("      Working");
		List<File> MS3EiKaN = new ArrayList<File>();
		File zxjTqwyc = new File(Config.getCacheDir());
		if (!zxjTqwyc.exists()) {
			zxjTqwyc.mkdir();
		}
		for (URL xZlauX8b : resources) {
			try {
				HttpClient ngcewf1m = new HttpClient();
				HttpMethod pZ5lnoi1 = new GetMethod(xZlauX8b.toString());
				int yuB4ThoP = ngcewf1m.executeMethod(pZ5lnoi1);
				if (yuB4ThoP == 200) {
					int ypnf4BVq = xZlauX8b.toString().lastIndexOf("/") + 1;
					File iSOoiQkb = new File(Config.getCacheDir() + xZlauX8b.toString().substring(ypnf4BVq));
					FileOutputStream RH0RWExY = new FileOutputStream(iSOoiQkb);
					InputStream at9lnI2N = pZ5lnoi1.getResponseBodyAsStream();
					int UjlFnIHS = 0;
					while ((UjlFnIHS = at9lnI2N.read()) != -1) {
						RH0RWExY.write(UjlFnIHS);
					}
					System.out.println(iSOoiQkb.getName() + " downloaded.");
					pZ5lnoi1.releaseConnection();
					if (iSOoiQkb.getName().endsWith(".jar")) {
						MS3EiKaN.add(iSOoiQkb);
					}
				} else {
					pZ5lnoi1.releaseConnection();
					System.out.println("Loading Monitor Failed. Unable to get resource " + url);
					return;
				}
			} catch (IOException ffj5SCc5) {
				System.out.println("Loading Monitor Failed, error while reading resource file " + "from HTTP Server");
				ffj5SCc5.printStackTrace(System.err);
				return;
			}
		}
		URL[] TvFcZOhv = new URL[MS3EiKaN.size()];
		try {
			for (int bAfyi4lN = 0; bAfyi4lN < MS3EiKaN.size(); bAfyi4lN++) {
				File NyvDxE7l = MS3EiKaN.get(bAfyi4lN);
				File lr3WzEdd = new File(Config.getCacheDir() + "/" + System.currentTimeMillis() + NyvDxE7l.getName());
				FileInputStream F3UJ5v33 = new FileInputStream(NyvDxE7l);
				FileOutputStream JRh7ApVG = new FileOutputStream(lr3WzEdd);
				int IaWzIeMQ = 0;
				byte[] eMaM8yA0 = new byte[1024];
				while ((IaWzIeMQ = F3UJ5v33.read(eMaM8yA0, 0, 1024)) > -1) {
					JRh7ApVG.write(eMaM8yA0, 0, IaWzIeMQ);
				}
				JRh7ApVG.close();
				JRh7ApVG.close();
				F3UJ5v33.close();
				TvFcZOhv[bAfyi4lN] = new URL("file:" + lr3WzEdd.getAbsolutePath());
			}
		} catch (Exception wgHZvItO) {
			System.out.println("Unable to load jar files.");
			wgHZvItO.printStackTrace();
		}
		URLClassLoader CPC1ru75 = new URLClassLoader(TvFcZOhv);
		engine.setClassLoader(CPC1ru75);
		setPlain(monitor.getDownload());
		setPlain(monitor.getDownloadStatus());
		monitor.getDownloadStatus().setText("      Done");
		setBold(monitor.getGui());
		setBold(monitor.getGuiStatus());
		monitor.getGuiStatus().setText("      Working");
		Container UzsgdpWo;
		try {
			String xuNIlNlM = s9fpDzkJ.toString();
			int kGGmEFjQ = xuNIlNlM.indexOf("<gui");
			kGGmEFjQ = xuNIlNlM.indexOf('>', kGGmEFjQ) + 1;
			int KTWBI8Os = xuNIlNlM.indexOf("</gui>");
			UzsgdpWo = engine.render(new StringReader(xuNIlNlM.substring(kGGmEFjQ, KTWBI8Os)));
		} catch (Exception SL6p13cf) {
			SL6p13cf.printStackTrace(System.err);
			System.err.println("Exception msg: " + SL6p13cf.getMessage());
			System.out.println("Loading Monitor Failed, error creating gui.");
			return;
		}
		for (BindingContainer u70bPTDm : bindings) {
			List<Task> qf5kXeNd = tasks.get(u70bPTDm.getTask());
			if (qf5kXeNd == null) {
				System.out.println("Task with name " + u70bPTDm.getTask() + " doesnt exist.");
			} else {
				for (Task pbLLcooM : qf5kXeNd) {
					if (pbLLcooM != null) {
						Object ln4JuuPj = engine.find(u70bPTDm.getComponent());
						if (ln4JuuPj != null) {
							if (pbLLcooM.getTaskType() == Task.LISTEN
									&& pbLLcooM.getFilter() instanceof AttributeChangeNotificationFilter) {
								TaskNotificationListener cToC9eTS = (TaskNotificationListener) pbLLcooM.getListener();
								if (u70bPTDm.getFormater() == null) {
									cToC9eTS.addResultListener(new Binding(ln4JuuPj, u70bPTDm.getMethod()));
								} else {
									cToC9eTS.addResultListener(new Binding(ln4JuuPj, u70bPTDm.getMethod(),
											u70bPTDm.getFormater(), CPC1ru75));
								}
							} else {
								if (u70bPTDm.getFormater() == null) {
									pbLLcooM.addResultListener(new Binding(ln4JuuPj, u70bPTDm.getMethod()));
								} else {
									pbLLcooM.addResultListener(new Binding(ln4JuuPj, u70bPTDm.getMethod(),
											u70bPTDm.getFormater(), CPC1ru75));
								}
							}
						} else {
							System.out.println("Refering to gui name, " + u70bPTDm.getComponent()
									+ ", that doesnt exist. Unable to create monitor.");
							return;
						}
					} else {
						System.out.println("Refering to task name, " + u70bPTDm.getTask()
								+ ", that doesnt exist. Unable to create monitor.");
						return;
					}
				}
			}
		}
		for (int pq9Nk4Wx = 0; pq9Nk4Wx < monitor.getTab().getTabCount(); pq9Nk4Wx++) {
			if (monitor.getTab().getComponent(pq9Nk4Wx).equals(monitor)) {
				monitor.getTab().setComponentAt(pq9Nk4Wx, new MonitorContainerPanel(UzsgdpWo, this));
				break;
			}
		}
		System.out.println("Connecting to server(s).");
		Enumeration kFZSTIat = servers.keys();
		List<JmxWorker> vTcaNYWI = new ArrayList<JmxWorker>();
		while (kFZSTIat.hasMoreElements()) {
			JmxWorker C7Yb254o = servers.get(kFZSTIat.nextElement()).getWorker();
			C7Yb254o.setRunning(true);
			C7Yb254o.start();
			vTcaNYWI.add(C7Yb254o);
		}
		MonitorServer.add(iPTbiFu2, vTcaNYWI);
		Config.addUrl(url);
	}

}