package org.perscholas.recipies.daos;

import java.sql.Blob;
import java.util.Optional;

import org.perscholas.recipies.model.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    @Query("from Profile p where p.user.username = ?1")
    Optional<Profile> findByUsername(String username);
    
    //@Query(value="select p.photo from profile p where p.id=?1", nativeQuery=true)
    public Optional<Profile> getPhotoById(int id);
}