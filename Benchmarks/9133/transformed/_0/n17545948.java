class n17545948 {
	public void run() {
		try {
			URL Uy3ukXaH = new URL("http://pokedev.org/time.php");
			BufferedReader wBYK69PC = new BufferedReader(new InputStreamReader(Uy3ukXaH.openStream()));
			StringTokenizer S7lxQeLy = new StringTokenizer(wBYK69PC.readLine());
			m_day = Integer.parseInt(S7lxQeLy.nextToken());
			m_hour = Integer.parseInt(S7lxQeLy.nextToken());
			m_minutes = Integer.parseInt(S7lxQeLy.nextToken());
			wBYK69PC.close();
		} catch (Exception qu7FTdli) {
			System.out.println("ERROR: Cannot reach time server, reverting to local time");
			Calendar DNLD3JFk = Calendar.getInstance();
			m_hour = DNLD3JFk.get(Calendar.HOUR_OF_DAY);
			m_minutes = 0;
			m_day = 0;
		}
		while (m_isRunning) {
			m_minutes = m_minutes == 59 ? 0 : m_minutes + 1;
			if (m_minutes == 0) {
				if (m_hour == 23) {
					incrementDay();
					m_hour = 0;
				} else {
					m_hour += 1;
				}
			}
			m_hour = m_hour == 23 ? 0 : m_hour + 1;
			if (System.currentTimeMillis() - m_lastWeatherUpdate >= 3600000) {
				generateWeather();
				m_lastWeatherUpdate = System.currentTimeMillis();
			}
			try {
				Thread.sleep(60000);
			} catch (Exception Q8xhqBvr) {
			}
		}
		System.out.println("INFO: Time Service stopped");
	}

}