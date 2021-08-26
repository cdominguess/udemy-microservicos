package com.github.cdominguess.calculadora;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@GetMapping("/somar/{valorUm}/{valorDois}")
	public Double somar(@PathVariable String valorUm, @PathVariable String valorDois) throws Exception {
		if (!_isNumero(valorUm) || !_isNumero(valorDois)) {
			throw new Exception();
		}
		
		return _converteDouble(valorUm) + _converteDouble(valorDois);
	}

	private Double _converteDouble(String strNumero) {
		if (strNumero == null) return 0D;
		
		String strAux = strNumero.replace(",", ".");
		if (_isNumero(strAux)) return Double.parseDouble(strAux);
		
		return 0D;
	}

	private boolean _isNumero(String strNumero) {
		if (strNumero == null) return false;
		
		String strAux = strNumero.replace(",", ".");
		
		return strAux.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
