/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wad.domain.Writer;

/**
 *
 * @author mmohamud
 */
@Repository
public interface WriterRepository extends JpaRepository<Writer, Long>{
    Writer findBykayttajatunnus(String kayttajatunnus);
}
