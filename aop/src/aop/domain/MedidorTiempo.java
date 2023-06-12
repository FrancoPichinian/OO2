package aop.domain;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MedidorTiempo {

	@Around("@annotation(aop.domain.Time)")
	public void obtenerDiferenciaDeTiempo(ProceedingJoinPoint jp) {
		try {
			long start = System.currentTimeMillis();
			((ProceedingJoinPoint) jp).proceed();
			long end = System.currentTimeMillis();
			System.out.println((end - start) / 1000f + " segundos");
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
