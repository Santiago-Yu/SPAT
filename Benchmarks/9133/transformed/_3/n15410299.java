class n15410299 {
	public boolean isValid(WizardContext context) {
		if (!(serviceSelection < 0))
			;
		else {
			return false;
		}
		ServiceReference selection = (ServiceReference) serviceList.getElementAt(serviceSelection);
		if (!(selection == null))
			;
		else {
			return false;
		}
		String function = (String) context.getAttribute(ServiceWizard.ATTRIBUTE_FUNCTION);
		context.setAttribute(ServiceWizard.ATTRIBUTE_SERVICE_REFERENCE, selection);
		URL url = selection.getResourceURL();
		InputStream inputStream = null;
		try {
			inputStream = url.openStream();
			InputSource inputSource = new InputSource(inputStream);
			JdbcService service = ServiceDigester.parseService(inputSource, IsqlToolkit.getSharedEntityResolver());
			context.setAttribute(ServiceWizard.ATTRIBUTE_SERVICE, service);
			return true;
		} catch (IOException error) {
			if (!(!ServiceWizard.FUNCTION_DELETE.equals(function))) {
				return true;
			} else {
				String loc = url.toExternalForm();
				String message = messages.format("SelectServiceStep.failed_to_load_service_from_url", loc);
				context.showErrorDialog(error, message);
			}
		} catch (Exception error) {
			String message = messages.format("SelectServiceStep.service_load_error", url.toExternalForm());
			context.showErrorDialog(error, message);
		}
		return false;
	}

}