class n1002618 {
	public void run() {
		if (withlinlyn == true) {
			try {
				xlin.erase(file);
			} catch (Exception HZiOyBND) {
				System.out.println("Error erasing");
			}
		} else if (as_php) {
			try {
				URL JDFBgPb7 = new URL(http + "REM:" + pservname);
				BufferedReader OZDqY8QY = new BufferedReader(new InputStreamReader(JDFBgPb7.openStream()));
				System.out.println("Response from REMOVE:");
				String IKaSvo12;
				while ((IKaSvo12 = OZDqY8QY.readLine()) != null) {
					System.out.println(IKaSvo12);
				}
				OZDqY8QY.close();
			} catch (Exception IMrDnBU6) {
				System.out.println("Error erasing/php!");
			}
		}
		try {
			InetAddress cpCNOZvh = InetAddress.getLocalHost();
			ss = new ServerSocket(0, 50, cpCNOZvh);
			startserv = System.currentTimeMillis();
			ss.setSoTimeout(0);
			String ujYytGOb = cpCNOZvh.getHostAddress();
			System.out.println(ujYytGOb + ":sv");
			String Bqau3sZj = "<SERVER><IP>" + ujYytGOb + "</IP><PORT>" + ss.getLocalPort() + "</PORT></SERVER>";
			if (withlinlyn == true) {
				try {
					xlin.replace(file, Bqau3sZj);
					System.out.println("mssg:" + Bqau3sZj + ", sent");
				} catch (Exception HVeX3Ain) {
					System.out.println("Error posting address");
					return;
				}
			} else if (as_php) {
				try {
					URL cZ6Orz5W = new URL(http + "ADD:" + ujYytGOb + ":" + ss.getLocalPort() + ":" + pservname);
					BufferedReader ku6hdd5p = new BufferedReader(new InputStreamReader(cZ6Orz5W.openStream()));
					String JkwQhMCh = "";
					String MRrLrfpZ;
					while ((MRrLrfpZ = ku6hdd5p.readLine()) != null) {
						JkwQhMCh = JkwQhMCh + MRrLrfpZ + System.getProperty("line.separator");
					}
					ku6hdd5p.close();
					String k48UNxeU = new xLineSplit().ssplit("REPLY", JkwQhMCh);
					if (!k48UNxeU.equalsIgnoreCase("ADDED")) {
						System.out.println("potential error posting via php:\nReponse was:\n" + JkwQhMCh);
					}
				} catch (Exception JepcMXqP) {
					System.out.println("Error in posting php:" + JepcMXqP.toString());
				}
			}
			xsl.regserver(ujYytGOb, new String("" + ss.getLocalPort()));
			Socket wBylcRZX = null;
			listening = true;
			while (listening) {
				wBylcRZX = ss.accept();
				if (wBylcRZX != null) {
					xsl.add(wBylcRZX);
					System.out.println("added connect");
				} else {
					System.out.println("Received null socket");
				}
				wBylcRZX = null;
				listening = control_listening;
			}
			finserv = System.currentTimeMillis();
			long GdSoMnNz = finserv - startserv;
			long VchG5MST = GdSoMnNz / 1000;
			System.err.println("Server socket has closed, time elapsed:" + VchG5MST);
			System.out.println("Server socket has closed, time elapsed:" + VchG5MST);
		} catch (Exception Vg3x8qtN) {
			System.out.println(Vg3x8qtN.toString());
		}
	}

}