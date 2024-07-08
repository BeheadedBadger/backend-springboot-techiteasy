package nl.novi.techiteasy_spring.repositories;
import nl.novi.techiteasy_spring.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
    boolean existsAuthorityByAuthority(String auth);
}
