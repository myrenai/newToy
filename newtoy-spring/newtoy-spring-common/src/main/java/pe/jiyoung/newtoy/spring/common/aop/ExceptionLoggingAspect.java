package pe.jiyoung.newtoy.spring.common.aop;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.jiyoung.newtoy.spring.common.exception.BusinessException;
import pe.jiyoung.newtoy.spring.common.exception.ExceptionAttribute;
import pe.jiyoung.newtoy.spring.common.exception.TechnicalException;
import pe.jiyoung.newtoy.spring.common.model.out.ResponseWrapper;
@Aspect
public class ExceptionLoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionLoggingAspect.class);
    private final ExceptionAttribute defaultExceptionAttr = new ExceptionAttribute();

    @Around("execution(* **.controller.**.*.*(..))")
    public Object aroundControllerLevel(final ProceedingJoinPoint pjp) throws Throwable {

        final Object[] args = pjp.getArgs();
        try {
            return pjp.proceed();
        } catch (final BusinessException e) {

            LOGGER.error("[CTRL] method : " + pjp.getSignature().getDeclaringType().getSimpleName() + "."
                    + pjp.getSignature().getName(), e);

            final ResponseWrapper<BusinessException> result = new ResponseWrapper<BusinessException>();
            ((HttpServletResponse) args[1]).setStatus(510);

            return result;
        }
    }

    public Object aroundManagerLevel(final ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (final TechnicalException e) {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("[MGR] method : " + pjp.getSignature().getDeclaringType().getSimpleName() + "."
                        + pjp.getSignature().getName(), e);
            }
            throw new BusinessException(this.defaultExceptionAttr, e);
        } catch (final BusinessException e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("[MGR] Rethrow method : " + pjp.getSignature().getDeclaringType().getSimpleName() + "."
                        + pjp.getSignature().getName(), e);
            }
            throw e;
        }
    }

    public Object aroundRawLevel(final ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (final RuntimeException e) {
            if (e instanceof TechnicalException) {
                throw e;
            }
            LOGGER.error("[RAW] method : " + pjp.getSignature().getDeclaringType().getSimpleName() + "."
                    + pjp.getSignature().getName(), e);
            throw new TechnicalException(e);
        } catch (final Exception e) {
            LOGGER.error("[RAW] method : " + pjp.getSignature().getDeclaringType().getSimpleName() + "."
                    + pjp.getSignature().getName(), e);
            throw new TechnicalException(e);
        }
    }

}
