package br.com.livrobeckend.userapi.repository;

import br.com.livrobeckend.userapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByCpf(String cpf);
    List<Users> queryByNomeLike(String nome);
}
