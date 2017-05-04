package br.com.aldar.web.annotation.impl;

import br.com.aldar.web.annotation.RoleValidator;
import br.com.aldar.web.exception.CustomException;
import br.com.aldar.web.model.Token;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;

@Interceptor
@RoleValidator
public class ValidatorImpl {

    @AroundInvoke
    public Object audita(InvocationContext ic) throws Exception {
        RoleValidator jwtRoleValidatorAnnotation = ic.getMethod().getAnnotation(RoleValidator.class);
        String[] allow = jwtRoleValidatorAnnotation.allow();
        String[] deny = jwtRoleValidatorAnnotation.deny();
        for (Object object : ic.getParameters()) {
            if (object instanceof Token) {
                final Token token = (Token) object;
                if (!Arrays.asList(deny).contains(token.getToken()))
                    throw new CustomException("Usuario nao permitido aqui");
                else if (Arrays.asList(allow).contains(token.getToken()))
                    throw new CustomException("Usuario nao permitido aqui");
            }
        }
        return ic.proceed();
    }
}
