package br.com.loglab.services;

import java.util.Collection;

public interface JasperReportsService {

	void openReportByJasper(String path, Collection<?> collection);
}