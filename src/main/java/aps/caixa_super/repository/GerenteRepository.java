package aps.caixa_super.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aps.caixa_super.model.Gerente;
import org.springframework.security.core.userdetails.UserDetails;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
    UserDetails findByLogin(String login);
}
