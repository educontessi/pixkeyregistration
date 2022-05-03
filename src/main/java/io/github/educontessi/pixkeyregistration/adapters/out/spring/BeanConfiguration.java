package io.github.educontessi.pixkeyregistration.adapters.out.spring;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.service.ChavePixService;
import io.github.educontessi.pixkeyregistration.adapters.out.persistence.service.validation.ValidacoesPortImpl;
import io.github.educontessi.pixkeyregistration.core.usecase.ChavePixUseCaseImpl;
import io.github.educontessi.pixkeyregistration.core.validation.ChavePixValidacoes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ChavePixUseCaseImpl chavePixUseCaseImpl(ChavePixService service) {
        return new ChavePixUseCaseImpl(service, new ChavePixValidacoes(new ValidacoesPortImpl()));
    }
}
