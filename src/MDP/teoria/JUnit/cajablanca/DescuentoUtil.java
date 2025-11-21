package MDP.teoria.JUnit.cajablanca;

public class DescuentoUtil {
	public static double calculaDescuento(double precio, boolean esMiembro) {
		if (precio < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}
		double descuento;
		if (esMiembro) {
			if (precio > 100) {
				descuento = 0.2; // 20% de descuento para miembros en compras > 100
			} else {
				descuento = 0.1; // 10% de descuento para miembros en compras <= 100
			}
		} else {
			if (precio > 100) {
				descuento = 0.05; // 5% de descuento para no miembros en compras > 100
			} else {
				descuento = 0; // No hay descuento para no miembros en compras <= 100
			}
		}
		return precio * (1 - descuento);
	}
}