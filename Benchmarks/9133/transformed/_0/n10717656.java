class n10717656 {
	public void run() {
		StringBuffer OAR9M0mQ;
		String EUjGc9kZ;
		Element M1PFWx2y;
		setBold(monitor.getReading());
		setBold(monitor.getReadingStatus());
		monitor.getReadingStatus().setText("      Working");
		HttpMethod hoKBqPVt = null;
		OAR9M0mQ = new StringBuffer();
		File dsmrk8mN = new File(url);
		if (dsmrk8mN.exists()) {
			try {
				InputStream vR4KDsHZ = new FileInputStream(dsmrk8mN);
				int kcVXIze0;
				while ((kcVXIze0 = vR4KDsHZ.read()) != -1) {
					OAR9M0mQ.append((char) kcVXIze0);
				}
				vR4KDsHZ.close();
			} catch (IOException ohEY6cmi) {
				System.out.println("Loading Monitor Failed, error while reading XML file from local file");
				ohEY6cmi.printStackTrace(System.err);
				return;
			}
		} else {
			try {
				HttpClient wxvYfFR4 = new HttpClient();
				hoKBqPVt = new GetMethod(url);
				int D7AELzku = wxvYfFR4.executeMethod(hoKBqPVt);
				if (D7AELzku == 200) {
					InputStream sEh1MDwW = hoKBqPVt.getResponseBodyAsStream();
					int bBx0O0do;
					while ((bBx0O0do = sEh1MDwW.read()) != -1) {
						OAR9M0mQ.append((char) bBx0O0do);
					}
					sEh1MDwW.close();
				} else {
					if (hoKBqPVt != null) {
						hoKBqPVt.releaseConnection();
					}
					System.out.println("Loading Monitor Failed. Incorrect response from HTTP Server " + D7AELzku);
					return;
				}
			} catch (IOException gGeWObQf) {
				if (hoKBqPVt != null) {
					hoKBqPVt.releaseConnection();
				}
				System.out.println("Loading Monitor Failed, error while reading XML file from HTTP Server");
				gGeWObQf.printStackTrace(System.err);
				return;
			}
		}
		setPlain(monitor.getReading());
		setPlain(monitor.getReadingStatus());
		monitor.getReadingStatus().setText("      Done");
		setBold(monitor.getValidating());
		setBold(monitor.getValidatingStatus());
		monitor.getValidatingStatus().setText("      Working");
		DocumentBuilderFactoryImpl NAbGDa1T = new DocumentBuilderFactoryImpl();
		try {
			DocumentBuilder wPtEV6SL = NAbGDa1T.newDocumentBuilder();
			Document gcxkhxUC = wPtEV6SL.parse(new ByteArrayInputStream(OAR9M0mQ.toString().getBytes()));
			if (hoKBqPVt != null) {
				hoKBqPVt.releaseConnection();
			}
			Element NcMlL8kz = gcxkhxUC.getDocumentElement();
			NodeList tdtbYSCV = NcMlL8kz.getElementsByTagName("resource");
			for (int tg8douut = 0; tg8douut < tdtbYSCV.getLength(); tg8douut++) {
				Element ZOnHQWJE = (Element) tdtbYSCV.item(tg8douut);
				resources.add(new URL(ZOnHQWJE.getAttribute("url")));
			}
			NodeList AP8pq70D = NcMlL8kz.getElementsByTagName("jmxserver");
			for (int QFeAxnrY = 0; QFeAxnrY < AP8pq70D.getLength(); QFeAxnrY++) {
				Element VEXBKtRO = (Element) AP8pq70D.item(QFeAxnrY);
				String HzLZSsfC = VEXBKtRO.getAttribute("name");
				String Q4zTAzKo = VEXBKtRO.getAttribute("url");
				if (Q4zTAzKo.indexOf("${host}") != -1) {
					HostDialog OF7bCsZh = new HostDialog(Config.getHosts());
					String JwYmxxup = OF7bCsZh.showDialog();
					if (JwYmxxup == null) {
						System.out.println("Host can not be null, unable to create panel.");
						return;
					}
					Q4zTAzKo = Q4zTAzKo.replaceAll("\\$\\{host\\}", JwYmxxup);
					Config.addHost(JwYmxxup);
				}
				JMXServiceURL Kbt13oHa = new JMXServiceURL(Q4zTAzKo);
				JmxServerGraph j0LeawJ7 = new JmxServerGraph(HzLZSsfC, Kbt13oHa, new JmxWorker(false));
				servers.put(HzLZSsfC, j0LeawJ7);
				NodeList MRPb6B9j = VEXBKtRO.getElementsByTagName("listener");
				for (int uVtPodfq = 0; uVtPodfq < MRPb6B9j.getLength(); uVtPodfq++) {
					Element v513plFm = (Element) MRPb6B9j.item(uVtPodfq);
					String jzuLKTKo = v513plFm.getAttribute("taskname");
					MBean sdSNFHYH = new MBean(v513plFm.getAttribute("mbean"), null);
					String KtnBerQ9 = v513plFm.getAttribute("filterType");
					TaskNotificationListener vSTpyjdv = new TaskNotificationListener();
					NotificationFilterSupport kEHsDzZQ = new NotificationFilterSupport();
					if (KtnBerQ9 == null || "".equals(KtnBerQ9)) {
						kEHsDzZQ = null;
					} else {
						kEHsDzZQ.enableType(KtnBerQ9);
					}
					Task J7UkMEfo = new Task(-1, Task.LISTEN, j0LeawJ7);
					J7UkMEfo.setMbean(sdSNFHYH);
					J7UkMEfo.setListener(vSTpyjdv);
					J7UkMEfo.setFilter(kEHsDzZQ);
					j0LeawJ7.getWorker().addTask(J7UkMEfo);
					if (tasks.get(jzuLKTKo) != null) {
						System.out.println("Task " + jzuLKTKo + " already exists.");
						return;
					}
					List<Task> Zr73wk2J = new ArrayList<Task>();
					Zr73wk2J.add(J7UkMEfo);
					tasks.put(jzuLKTKo, Zr73wk2J);
				}
				NodeList vmqnCkr0 = VEXBKtRO.getElementsByTagName("attribute");
				for (int Mg2aPJao = 0; Mg2aPJao < vmqnCkr0.getLength(); Mg2aPJao++) {
					Element RF0TDYyP = (Element) vmqnCkr0.item(Mg2aPJao);
					String i2viECNs = RF0TDYyP.getAttribute("taskname");
					MBean F8R2lMHV = new MBean(RF0TDYyP.getAttribute("mbean"), null);
					String h8xNRNav = RF0TDYyP.getAttribute("attributename");
					String g7KsOfYs = RF0TDYyP.getAttribute("frequency");
					String lNbKuWJZ = RF0TDYyP.getAttribute("onEvent");
					if (g7KsOfYs.equalsIgnoreCase("onchange")) {
						TaskNotificationListener FcFLjy5r = new TaskNotificationListener();
						AttributeChangeNotificationFilter HSQGKhBt = new AttributeChangeNotificationFilter();
						HSQGKhBt.enableAttribute(h8xNRNav);
						Task x9LPf393 = new Task(-1, Task.LISTEN, j0LeawJ7);
						MBeanAttribute hbux9t0s = new MBeanAttribute(F8R2lMHV, h8xNRNav);
						x9LPf393.setAttribute(hbux9t0s);
						x9LPf393.setMbean(F8R2lMHV);
						x9LPf393.setListener(FcFLjy5r);
						x9LPf393.setFilter(HSQGKhBt);
						j0LeawJ7.getWorker().addTask(x9LPf393);
						if (tasks.get(i2viECNs) != null) {
							System.out.println("Task " + i2viECNs + " already exists.");
							return;
						}
						Task QfquEvJS = new Task(-1, Task.GET_ATTRIBUTE, j0LeawJ7);
						QfquEvJS.setAttribute(hbux9t0s);
						QfquEvJS.setMbean(F8R2lMHV);
						j0LeawJ7.getWorker().addTask(QfquEvJS);
						List<Task> RC6AtEh4 = new ArrayList<Task>();
						RC6AtEh4.add(x9LPf393);
						RC6AtEh4.add(QfquEvJS);
						tasks.put(i2viECNs, RC6AtEh4);
					} else {
						int TrgYomzw = Integer.parseInt(g7KsOfYs);
						Task ODzLJlrs = new Task(TrgYomzw, Task.GET_ATTRIBUTE, j0LeawJ7);
						MBeanAttribute CoWaiEe3 = new MBeanAttribute(F8R2lMHV, h8xNRNav);
						ODzLJlrs.setAttribute(CoWaiEe3);
						ODzLJlrs.setMbean(F8R2lMHV);
						if (tasks.get(i2viECNs) != null) {
							System.out.println("Task " + i2viECNs + " already exists.");
							return;
						}
						List<Task> y1J6tleJ = new ArrayList<Task>();
						y1J6tleJ.add(ODzLJlrs);
						tasks.put(i2viECNs, y1J6tleJ);
						TaskNotificationListener GNejMB43 = null;
						if (lNbKuWJZ != null && !"".equals(lNbKuWJZ)) {
							Task Qy9Dh94G = tasks.get(lNbKuWJZ).get(0);
							if (Qy9Dh94G == null) {
								System.out.println(lNbKuWJZ + " was not found.");
								return;
							} else {
								GNejMB43 = (TaskNotificationListener) Qy9Dh94G.getListener();
							}
						}
						if (GNejMB43 == null) {
							j0LeawJ7.getWorker().addTask(ODzLJlrs);
						} else {
							GNejMB43.addTask(ODzLJlrs);
						}
					}
				}
			}
			NodeList oQb7FPQm = NcMlL8kz.getElementsByTagName("gui");
			M1PFWx2y = (Element) oQb7FPQm.item(0);
			EUjGc9kZ = M1PFWx2y.getAttribute("name");
			if (MonitorServer.contains(EUjGc9kZ)) {
				JOptionPane.showMessageDialog(null, "This panel is already open, stoping creating of panel.",
						"Panel already exists", JOptionPane.ERROR_MESSAGE);
				return;
			}
			for (int CSO9FBfP = 0; CSO9FBfP < monitor.getTab().getTabCount(); CSO9FBfP++) {
				if (monitor.getTab().getComponent(CSO9FBfP).equals(monitor)) {
					monitor.getTab().setTitleAt(CSO9FBfP, EUjGc9kZ);
					break;
				}
			}
			NodeList DBlhn6QB = NcMlL8kz.getElementsByTagName("binding");
			for (int WPJuxL8z = 0; WPJuxL8z < DBlhn6QB.getLength(); WPJuxL8z++) {
				Element qQrxIi8r = (Element) DBlhn6QB.item(WPJuxL8z);
				String hE7vVUpF = qQrxIi8r.getAttribute("guiname");
				String CsQdXKUd = qQrxIi8r.getAttribute("method");
				String Sq6z4jkD = qQrxIi8r.getAttribute("taskname");
				String esPJkXKq = qQrxIi8r.getAttribute("formater");
				BindingContainer CHuFiDaX;
				if (esPJkXKq == null || (esPJkXKq != null && esPJkXKq.equals(""))) {
					CHuFiDaX = new BindingContainer(hE7vVUpF, CsQdXKUd, Sq6z4jkD);
				} else {
					CHuFiDaX = new BindingContainer(hE7vVUpF, CsQdXKUd, Sq6z4jkD, esPJkXKq);
				}
				bindings.add(CHuFiDaX);
			}
		} catch (Exception lUFESYbK) {
			System.err.println("Exception message: " + lUFESYbK.getMessage());
			System.out.println("Loading Monitor Failed, couldnt parse XML file.");
			lUFESYbK.printStackTrace(System.err);
			return;
		}
		setPlain(monitor.getValidating());
		setPlain(monitor.getValidatingStatus());
		monitor.getValidatingStatus().setText("      Done");
		setBold(monitor.getDownload());
		setBold(monitor.getDownloadStatus());
		monitor.getDownloadStatus().setText("      Working");
		List<File> PQ3m3W7p = new ArrayList<File>();
		File nSkm6AaR = new File(Config.getCacheDir());
		if (!nSkm6AaR.exists()) {
			nSkm6AaR.mkdir();
		}
		for (URL o9RFdXls : resources) {
			try {
				HttpClient vIdIxUZ2 = new HttpClient();
				HttpMethod KdiS0Asx = new GetMethod(o9RFdXls.toString());
				int FcgD3jyJ = vIdIxUZ2.executeMethod(KdiS0Asx);
				if (FcgD3jyJ == 200) {
					int rIEMVfzh = o9RFdXls.toString().lastIndexOf("/") + 1;
					File oWS4NvYD = new File(Config.getCacheDir() + o9RFdXls.toString().substring(rIEMVfzh));
					FileOutputStream oU0qUolG = new FileOutputStream(oWS4NvYD);
					InputStream vUcJiKRS = KdiS0Asx.getResponseBodyAsStream();
					int KFU9NS4h = 0;
					while ((KFU9NS4h = vUcJiKRS.read()) != -1) {
						oU0qUolG.write(KFU9NS4h);
					}
					System.out.println(oWS4NvYD.getName() + " downloaded.");
					KdiS0Asx.releaseConnection();
					if (oWS4NvYD.getName().endsWith(".jar")) {
						PQ3m3W7p.add(oWS4NvYD);
					}
				} else {
					KdiS0Asx.releaseConnection();
					System.out.println("Loading Monitor Failed. Unable to get resource " + url);
					return;
				}
			} catch (IOException OCdADrwD) {
				System.out.println("Loading Monitor Failed, error while reading resource file from HTTP Server");
				OCdADrwD.printStackTrace(System.err);
				return;
			}
		}
		URL[] K7uAaBma = new URL[PQ3m3W7p.size()];
		try {
			for (int Xup39cDh = 0; Xup39cDh < PQ3m3W7p.size(); Xup39cDh++) {
				File zHaCNApS = PQ3m3W7p.get(Xup39cDh);
				File mRKftJGt = new File(Config.getCacheDir() + "/" + System.currentTimeMillis() + zHaCNApS.getName());
				FileInputStream NyxoJbuf = new FileInputStream(zHaCNApS);
				FileOutputStream m67ZJNGS = new FileOutputStream(mRKftJGt);
				int i6OB9rQx = 0;
				byte[] MNlMeMzE = new byte[1024];
				while ((i6OB9rQx = NyxoJbuf.read(MNlMeMzE, 0, 1024)) > -1) {
					m67ZJNGS.write(MNlMeMzE, 0, i6OB9rQx);
				}
				m67ZJNGS.close();
				m67ZJNGS.close();
				NyxoJbuf.close();
				K7uAaBma[Xup39cDh] = new URL("file:" + mRKftJGt.getAbsolutePath());
			}
		} catch (Exception e2QtvdYQ) {
			System.out.println("Unable to load jar files.");
			e2QtvdYQ.printStackTrace();
		}
		URLClassLoader qDrEfVPR = new URLClassLoader(K7uAaBma);
		engine.setClassLoader(qDrEfVPR);
		setPlain(monitor.getDownload());
		setPlain(monitor.getDownloadStatus());
		monitor.getDownloadStatus().setText("      Done");
		setBold(monitor.getGui());
		setBold(monitor.getGuiStatus());
		monitor.getGuiStatus().setText("      Working");
		Container JtOuCxpc;
		try {
			String vAbhBwLS = OAR9M0mQ.toString();
			int KkWgDPqq = vAbhBwLS.indexOf("<gui");
			KkWgDPqq = vAbhBwLS.indexOf('>', KkWgDPqq) + 1;
			int OIjG8CpH = vAbhBwLS.indexOf("</gui>");
			JtOuCxpc = engine.render(new StringReader(vAbhBwLS.substring(KkWgDPqq, OIjG8CpH)));
		} catch (Exception MJjZl3Nt) {
			MJjZl3Nt.printStackTrace(System.err);
			System.err.println("Exception msg: " + MJjZl3Nt.getMessage());
			System.out.println("Loading Monitor Failed, error creating gui.");
			return;
		}
		for (BindingContainer w7NKbHUz : bindings) {
			for (Task ZtxAgXGD : tasks.get(w7NKbHUz.getTask())) {
				if (ZtxAgXGD != null) {
					Object li76M7Z5 = engine.find(w7NKbHUz.getComponent());
					if (li76M7Z5 != null) {
						if (ZtxAgXGD.getTaskType() == Task.LISTEN
								&& ZtxAgXGD.getFilter() instanceof AttributeChangeNotificationFilter) {
							TaskNotificationListener B35MlYwN = (TaskNotificationListener) ZtxAgXGD.getListener();
							if (w7NKbHUz.getFormater() == null) {
								B35MlYwN.addResultListener(new Binding(li76M7Z5, w7NKbHUz.getMethod()));
							} else {
								B35MlYwN.addResultListener(
										new Binding(li76M7Z5, w7NKbHUz.getMethod(), w7NKbHUz.getFormater(), qDrEfVPR));
							}
						} else {
							if (w7NKbHUz.getFormater() == null) {
								ZtxAgXGD.addResultListener(new Binding(li76M7Z5, w7NKbHUz.getMethod()));
							} else {
								ZtxAgXGD.addResultListener(
										new Binding(li76M7Z5, w7NKbHUz.getMethod(), w7NKbHUz.getFormater(), qDrEfVPR));
							}
						}
					} else {
						System.out.println("Refering to gui name, " + w7NKbHUz.getComponent()
								+ ", that doesnt exist. Unable to create monitor.");
						return;
					}
				} else {
					System.out.println("Refering to task name, " + w7NKbHUz.getTask()
							+ ", that doesnt exist. Unable to create monitor.");
					return;
				}
			}
		}
		for (int I5baSws1 = 0; I5baSws1 < monitor.getTab().getTabCount(); I5baSws1++) {
			if (monitor.getTab().getComponent(I5baSws1).equals(monitor)) {
				monitor.getTab().setComponentAt(I5baSws1, new MonitorContainerPanel(JtOuCxpc, this));
				break;
			}
		}
		System.out.println("Connecting to server(s).");
		Enumeration<JmxServerGraph> B9sHIhSq = servers.elements();
		List<JmxWorker> Kn0x9QAN = new ArrayList<JmxWorker>();
		while (B9sHIhSq.hasMoreElements()) {
			JmxWorker UgGEnAmD = B9sHIhSq.nextElement().getWorker();
			UgGEnAmD.setRunning(true);
			UgGEnAmD.start();
			Kn0x9QAN.add(UgGEnAmD);
		}
		MonitorServer.add(EUjGc9kZ, Kn0x9QAN);
		Config.addUrl(url);
	}

}