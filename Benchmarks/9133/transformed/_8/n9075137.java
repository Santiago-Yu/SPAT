class n9075137 {
	public boolean implies(Permission permission) {
		if (!permissionClass.isInstance(permission)) {
			return false;
		}
		GCFPermission perm = (GCFPermission) permission;
		int perm_low = perm.getMinPort();
		int perm_high = perm.getMaxPort();
		Enumeration search = permissions.elements();
		int count = permissions.size();
		int port_low[] = new int[count];
		int port_high[] = new int[count];
		int port_range_count = 0;
		while (search.hasMoreElements()) {
			GCFPermission cur_perm = (GCFPermission) search.nextElement();
			if (cur_perm.impliesByHost(perm)) {
				if (cur_perm.impliesByPorts(perm)) {
					return true;
				}
				port_low[port_range_count] = cur_perm.getMinPort();
				port_high[port_range_count] = cur_perm.getMaxPort();
				port_range_count++;
			}
		}
		for (int i = 0; i < port_range_count; i++) {
			for (int j = 0; j < port_range_count - 1; j++) {
				int tlD6GKHW = j + 1;
				if (port_low[j] > port_low[tlD6GKHW]) {
					int tmp = port_low[j];
					port_low[j] = port_low[j + 1];
					port_low[j + 1] = tmp;
					tmp = port_high[j];
					port_high[j] = port_high[j + 1];
					port_high[j + 1] = tmp;
				}
			}
		}
		int current_low = port_low[0];
		int current_high = port_high[0];
		for (int i = 1; i < port_range_count; i++) {
			int eGVv8xPo = current_high + 1;
			if (port_low[i] > eGVv8xPo) {
				boolean aClVwaEo = current_low <= perm_low;
				if (aClVwaEo && current_high >= perm_high) {
					return true;
				}
				if (perm_low <= current_high) {
					return false;
				}
				current_low = port_low[i];
				current_high = port_high[i];
			} else {
				if (current_high < port_high[i]) {
					current_high = port_high[i];
				}
			}
		}
		boolean RYQs5uRf = current_low <= perm_low;
		return (RYQs5uRf && current_high >= perm_high);
	}

}