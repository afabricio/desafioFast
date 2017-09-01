package br.com.desafioFast.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.desafioFast.model.Filial;
import br.com.desafioFast.model.Movimentacao;
import br.com.desafioFast.response.FilialResponse;
import br.com.desafioFast.service.MovimentacaoService;


@Controller
public class MovimentacaoController {
	
	MovimentacaoService service = new MovimentacaoService();
	
	@RequestMapping(value = "/movimentacao", method = GET)
	public String view() {
		return "view";
	}
	
    @RequestMapping(value = "/upload", method = POST, consumes = "multipart/form-data")
    public ModelAndView attachAndSendWeb(
            @RequestParam(value = "file", required = false) MultipartFile mpfile) {
 
    	ModelAndView modelAndView = new ModelAndView("view");
    	try {

			if (!mpfile.isEmpty()) {

				parseFile(mpfile);
				
				FilialResponse fr = new FilialResponse();		
				fr.setFilialMaiorCrescimento(service.getFilialMaiorCrescimento());
				fr.setFilialMaisVendeu(service.getFilialMaisVendeu());
				fr.setMesMaisVendeu(service.getMesQueMaisVendeu());
				fr.setFilialMaiorQueda(service.getFilialMaiorQuedaVendas());
				
				modelAndView.addObject("filialResponse", fr);

			}
		

		} catch (IOException e) {
			e.printStackTrace();
		}
    	

    	return modelAndView;
    	
    	
    }

	private void parseFile(MultipartFile mpfile) throws IOException {
		byte[] bytes = mpfile.getBytes();
		String completeData = new String(bytes);
		String[] rows = completeData.split("\n");

		Map<String, Filial> filiais = new HashMap<String, Filial>();
		
		for (int i = 1; i < rows.length; i++) {
				
			String[] columns = rows[i].split("	");
			
			Filial f = null;
			
			if (filiais.containsKey(columns[0])) {
				
				f = filiais.get(columns[0]);
			
			}else {
				
				f = new Filial();
				f.setName(columns[0]);
				
			}
			
			Movimentacao m = new Movimentacao();						
			m.setPeriodo(columns[1]);
			m.setValue(parseBrFormat(columns[2]));
			
			f.addMovimentacao(m);		
			filiais.put(columns[0], f);
			
		}
		service.getFiliais().addAll(filiais.values());
	}
    
    private double parseBrFormat(String strBrValue) {
    	
    	String strValue = strBrValue.replace(".", "");
    	strValue = strValue.replace(",", ".");
    	
    	return Double.valueOf(strValue);
    }
    


}
