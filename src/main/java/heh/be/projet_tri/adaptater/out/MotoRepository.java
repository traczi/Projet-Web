package heh.be.projet_tri.adaptater.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<MotoJpaEntity, Long> {

}