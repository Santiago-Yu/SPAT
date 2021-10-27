class n15410299 {
	public boolean isValid(WizardContext OYrjRTKM) {
		if (serviceSelection < 0) {
			return false;
		}
		ServiceReference Qc8cBBtc = (ServiceReference) serviceList.getElementAt(serviceSelection);
		if (Qc8cBBtc == null) {
			return false;
		}
		String AigO3U8g = (String) OYrjRTKM.getAttribute(ServiceWizard.ATTRIBUTE_FUNCTION);
		OYrjRTKM.setAttribute(ServiceWizard.ATTRIBUTE_SERVICE_REFERENCE, Qc8cBBtc);
		URL WFhBVWnQ = Qc8cBBtc.getResourceURL();
		InputStream fRrivteQ = null;
		try {
			fRrivteQ = WFhBVWnQ.openStream();
			InputSource wHp9SWxD = new InputSource(fRrivteQ);
			JdbcService YB0sUteG = ServiceDigester.parseService(wHp9SWxD, IsqlToolkit.getSharedEntityResolver());
			OYrjRTKM.setAttribute(ServiceWizard.ATTRIBUTE_SERVICE, YB0sUteG);
			return true;
		} catch (IOException ynvQ60T3) {
			if (!ServiceWizard.FUNCTION_DELETE.equals(AigO3U8g)) {
				String Z7NT83nb = WFhBVWnQ.toExternalForm();
				String ziKjfZhm = messages.format("SelectServiceStep.failed_to_load_service_from_url", Z7NT83nb);
				OYrjRTKM.showErrorDialog(ynvQ60T3, ziKjfZhm);
			} else {
				return true;
			}
		} catch (Exception EV1sX7by) {
			String n44Tjqqf = messages.format("SelectServiceStep.service_load_error", WFhBVWnQ.toExternalForm());
			OYrjRTKM.showErrorDialog(EV1sX7by, n44Tjqqf);
		}
		return false;
	}

}