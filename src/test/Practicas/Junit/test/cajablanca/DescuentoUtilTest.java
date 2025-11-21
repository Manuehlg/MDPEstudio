package test.Practicas.Junit.test.cajablanca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import MDP.teoria.JUnit.cajablanca.*;

public class DescuentoUtilTest {

	@Test
	public void testPrecioNegativo() {
		// Caso donde el precio es negativo, debería lanzar una excepción
		assertThrows(IllegalArgumentException.class, () -> DescuentoUtil.calculaDescuento(-10, true));
	}

	@Test
	public void testMiembroPrecioMayor100() {
		// Caso donde el cliente es miembro y el precio es mayor a 100
		assertEquals(90, DescuentoUtil.calculaDescuento(100, true), 0.01); // 20% de descuento en 100
	}

	@Test
	public void testMiembroPrecioMenorOIgual100() {
		// Caso donde el cliente es miembro y el precio es <= 100
		assertEquals(90, DescuentoUtil.calculaDescuento(100, true), 0.01); // 10% de descuento en 100
	}

	@Test
	public void testNoMiembroPrecioMayor100() {
		// Caso donde el cliente no es miembro y el precio es mayor a 100
		assertEquals(100
				, DescuentoUtil.calculaDescuento(100, false), 0.01); // 5% de descuento en 100
	}

	@Test
	public void testNoMiembroPrecioMenorOIgual100() {
		// Caso donde el cliente no es miembro y el precio es <= 100
		assertEquals(100, DescuentoUtil.calculaDescuento(100, false), 0.01); // No hay descuento
	}
}
