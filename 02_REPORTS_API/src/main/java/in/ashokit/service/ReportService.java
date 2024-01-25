package in.ashokit.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.ashokit.reponse.SearchResponse;
import in.ashokit.request.SearchRequest;

public interface ReportService 
{

	public List<String> getUniquePlanNames();

	public List<String> getUniquePlanStatus();

	public List<SearchResponse> search(SearchRequest request);

	public void generateExcel(HttpServletResponse reponse) throws Exception;

	public void generatePdf(HttpServletResponse reponse) throws Exception, IOException;
}
