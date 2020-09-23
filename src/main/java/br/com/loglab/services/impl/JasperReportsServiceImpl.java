package br.com.loglab.services.impl;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.loglab.exception.RegraNegocioException;
import br.com.loglab.services.JasperReportsService;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class JasperReportsServiceImpl implements JasperReportsService {
	@Override
	public void openReportByJasper(String path, Collection<?> collection) {
		try {
			File diretorio = new File("src/main/resources/relatorio/prints");
			
			if (!diretorio.exists()) {
				diretorio.mkdir();
			}
			
			LocalDateTime dataHoraAtual = LocalDateTime.now();
			DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
			
			JasperReport report = JasperCompileManager.compileReport(path);
			
			JasperPrint print = JasperFillManager.fillReport(
													report,
													null,
													new JRBeanCollectionDataSource(collection));
			
			String nomeRelatorio = "/unidade_saude_" + formatoDataHora.format(dataHoraAtual) + ".pdf";
			
			JasperExportManager.exportReportToPdfFile(print, diretorio + nomeRelatorio);
		} catch(Exception e) {
			throw new RegraNegocioException("Não foi possível exportar o relatório => " + e.getMessage());
		}
	}
}
