package com.tienda.ropa.security;

import com.tienda.ropa.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Configuracion extends WebSecurityConfigurerAdapter {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    public void global (AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());

        auth.inMemoryAuthentication() //autenticación: agregar nuevos usuarios
                .withUser("admin@admin")
                .password("{noop}123")
                .roles("ADMIN","USER");
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/*","/css/*","/img/*").permitAll().and().authorizeRequests()
                .antMatchers("/producto/listar")
                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER", "ADMIN")
                .and().formLogin().loginPage("/login")
                .loginProcessingUrl("/logincheck")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/?error=error")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .permitAll()
                .and()
                .csrf().disable();

    }

}
